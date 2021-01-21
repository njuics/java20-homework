package advancedjava.finalproj.game.handler;

import advancedjava.finalproj.connection.helper.Receiver;
import advancedjava.finalproj.game.Location;
import advancedjava.finalproj.game.creature.HuluBro;
import advancedjava.finalproj.game.creature.Monster;
import advancedjava.finalproj.game.message.*;
import advancedjava.finalproj.logger.LogDir;
import advancedjava.finalproj.logger.Logger;
import advancedjava.finalproj.stage.GameStage;
import advancedjava.finalproj.connection.client.Client;
import advancedjava.finalproj.game.CampEnum;
import advancedjava.finalproj.game.DirectionEnum;
import advancedjava.finalproj.game.creature.Creature;
import advancedjava.finalproj.stage.HistoryStage;
import advancedjava.finalproj.stage.LogInStage;

import javafx.application.Platform;
import javafx.scene.control.Alert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class GameHandler
{
    private static final int broRotateAnagle = 270;
    private static final int monsterRotateAngle = 90;
    private static final int BATTLE_FIELD_WIDTH = 10;
    private static final int BATTLE_FIELD_HEIGHT = 7;

    boolean isGameOver;
    boolean isGameLoad;
    InetAddress addr;
    Random rand;
    Client client;
    CampEnum camp;
    Creature[][] battleField;
    Set<Creature> aliveCreatures;
    ConcurrentLinkedQueue<Message> recvChannel;
    GameStage gameStage;
    LogInStage logInStage;
    HistoryStage historyStage;

    public GameHandler(InetAddress addr)
    {
        this.addr = addr;
        this.recvChannel = new ConcurrentLinkedQueue<>();
        this.isGameOver = true;
        aliveCreatures = new HashSet<>();
        rand = new Random();
        this.isGameLoad = false;
        this.logInStage = new LogInStage(this);
        this.historyStage = new HistoryStage(this);
    }

    public int getBattleFieldWidth()
    {
        return battleField.length;
    }

    public int getBattleFieldHeight()
    {
        return battleField[0].length - 2;
    }

    public void initBattleField(Creature[][] battleField)
    {
        int fieldHeight = getBattleFieldHeight();
        int fieldWidth = getBattleFieldWidth();
        for (int i = 1; i <= fieldHeight; i++)
        {
            battleField[0][i] = HuluBro.getInstance(rand);
            battleField[fieldWidth - 1][i] = Monster.getInstance(rand);
        }
    }

    private void flushGameStage()
    {
        gameStage = new GameStage(this, BATTLE_FIELD_WIDTH, BATTLE_FIELD_HEIGHT);
    }

    private void flushBattleField()
    {
        battleField = new Creature[BATTLE_FIELD_WIDTH][BATTLE_FIELD_HEIGHT + 2];
        initBattleField(battleField);
    }

    public void start()
    {
        logInStage.show();
    }

    //1. Handle Functions
    //1.1 handle ui functions
    public void handleGameStart()
    {
        flushGameStage();
        gameStage.show();
        logInStage.close();
        isGameOver = false;

        //try to open a new Client
        try
        {
            client = new Client(addr);
        }
        catch (IOException e)
        {
            System.out.println(e);
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Warning");
            alert.setHeaderText("连接失败!");
            alert.setContentText("可能是因为以下原因:\n1. 服务器未开启\n2. 当前端口已被占用");
            alert.showAndWait();
            logInStage.show();
            gameStage.close();
            return;
        }

        //Start Game
        new Thread(() ->
        {
            Logger logger = new Logger();
            Message msg;
            while (!isGameOver)
            {
                msg = client.recvMsg();
                if (msg != null)
                {
                    process(msg);
                    logger.writeLine(msg.toString());
                }
            }
            client.close();
            logger.close();
            //Output Test Information
            System.out.println("Controller Exit");
        }).start();
    }

    public void handleGameLoad(String logAddr)
    {
        flushGameStage();
        gameStage.show();
        historyStage.close();
        isGameOver = false;
        //Output Test Information
        System.out.println(LogDir.LOGDIR_ADDR + "/" + logAddr);
        //try to open a new Client
        BufferedReader in;
        Receiver receiver;
        try
        {
            in = new BufferedReader(new FileReader(LogDir.LOGDIR_ADDR + "/" + logAddr));
        }
        catch (IOException e)
        {
            System.out.println(e);
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Warning");
            alert.setHeaderText("读取失败!");
            alert.setContentText("可能是因为以下原因:\n1. 历史文件不存在\n2. 文件格式错误");
            alert.showAndWait();
            logInStage.show();
            gameStage.close();
            return;
        }
        receiver = new Receiver(in);
        client = new Client(receiver);

        //Start Game
        new Thread(() ->
        {
            isGameLoad = true;
            Message msg;
            while (!isGameOver)
            {
                msg = client.recvMsg();
                if (msg != null)
                {
                    process(msg);
                }
                //休眠一会
                try
                {
                    Thread.sleep(100);
                }
                catch (InterruptedException e)
                {
                    System.out.println(e);
                    e.printStackTrace();
                }
            }
            client.close();
            isGameLoad = false;
            //Output Test Information
            System.out.println("Controller Exit");
        }).start();
    }

    public void showLoginStage()
    {
        logInStage.show();
    }

    public void closeLoginStage()
    {
        logInStage.close();
    }

    public void showHistoryStage()
    {
        historyStage.flush();
        historyStage.show();
    }

    public void closeHistoryStage()
    {
        historyStage.close();
    }

    public void handleGameOver()
    {
        if (isGameLoad)
        {
            isGameOver = true;
            return;
        }
        Message msg = (new Message(camp, MessageType.GAME_OVER,
                new GameOverMessage(camp, OverReasonEnum.EXIT).toString()));
        client.sendMsg(msg);
    }

    //1.2 handle message functions
    public void handleChosen(Location loc)
    {
        int x = loc.getX(), y = loc.getY();
        Creature target = battleField[x][y];
        String targetStatus = "";
        if (target != null) targetStatus = "生命值:" + target.getHp() + "\n" +
                "攻击力:" + target.getDamage() + "\n" +
                "防御力:" + target.getDefense();
        if (target.isDead()) targetStatus = "Dead";
        gameStage.setStateLabel(targetStatus);
        if (target.isDefensive()) gameStage.setDefendBtnText("解除");
        else gameStage.setDefendBtnText("防御");
    }

    public void handleMove(Location loc, DirectionEnum direction)
    {
        if (isGameLoad) return;

        //防御状态无法移动
        Creature target = battleField[loc.getX()][loc.getY()];
        if (target == null || target.getCamp() != this.camp || target.isDead() || target.isDefensive()) return;
        Message msg = (new Message(camp, MessageType.MOVE,
                new MoveMessage(loc, direction).toString()));
        client.sendMsg(msg);
    }

    public void handleAttack(Location loc)
    {
        if (isGameLoad) return;

        //防御状态无法攻击
        Creature target = battleField[loc.getX()][loc.getY()];
        if (target == null || target.getCamp() != this.camp || target.isDead() || target.isDefensive()) return;
        Message msg = new Message(camp, MessageType.ATTACK,
                new AttackMessage(loc).toString());
        client.sendMsg(msg);
    }

    public void handleDefense(Location loc)
    {
        if (isGameLoad) return;

        Creature target = battleField[loc.getX()][loc.getY()];
        if (target == null || target.getCamp() != this.camp || target.isDead()) return;
        //状态转换
        if (target.isDefensive())
            gameStage.setDefendBtnText("防御");
        else
            gameStage.setDefendBtnText("解除");
        Message msg = new Message(camp, MessageType.DEFENSE,
                new DefenseMessage(loc).toString());
        client.sendMsg(msg);
    }

    public void handleGiveUp()
    {
        if (isGameLoad) return;
        Message msg = (new Message(camp, MessageType.GAME_OVER,
                new GameOverMessage(camp, OverReasonEnum.GIVE_UP).toString()));
        client.sendMsg(msg);

    }

    //2. Process Functions
    private void process(Message msg)
    {
        //Output Test Information
        System.out.println("Process Msg" + msg);

        Platform.runLater(new Runnable()
        {
            @Override
            public void run()
            {
                switch (msg.type)
                {
                case START:
                    processStartMsg(StartMessage.parseStartMessage(msg.content));
                    break;
                case MOVE:
                    processMoveMsg(MoveMessage.parseMoveMessage(msg.content));
                    break;
                case ATTACK:
                    processAttackMsg(AttackMessage.parseAttackMessage(msg.content));
                    break;
                case DEFENSE:
                    processDefenseMsg(DefenseMessage.parseDefenseMessage(msg.content));
                    break;
                case GAME_OVER:
                    //关闭自己的线程
                    isGameOver = true;
                    processGameOverMsg(GameOverMessage.parseGameOverMessage(msg.content));
                    break;
                default:
                    break;
                }
            }
        });
    }

    private void processStartMsg(StartMessage msg)
    {
        this.camp = msg.camp;
        rand.setSeed(msg.seed);
        flushBattleField();
        this.gameStage.setCampLabel(camp.toString());
        int fieldHeight = getBattleFieldHeight();

        switch (camp)
        {
        case HULUBRO:
            for (int i = 1; i <= fieldHeight; i++)
                aliveCreatures.add(battleField[0][i]);
            break;
        case MONSTER:
            int fieldWidth = getBattleFieldWidth();
            for (int i = 1; i <= fieldHeight; i++)
                aliveCreatures.add(battleField[fieldWidth - 1][i]);
            break;
        }
    }

    public void processMoveMsg(MoveMessage moveMsg)
    {
        DirectionEnum direction = moveMsg.direction;
        Location srcLoc = moveMsg.loc;
        Creature mover = battleField[srcLoc.getX()][srcLoc.getY()];
        if (mover.isDead()) return;
        int x = srcLoc.getX() + direction.getOffsetX();
        int y = srcLoc.getY() + direction.getOffsetY();
        if (x < 0 || x >= getBattleFieldWidth())
        {
            return;
        }
        if (y < 1 || y > getBattleFieldHeight())
        {
            return;
        }
        if (battleField[x][y] != null)
        {
            return;
        }
        Location destLoc = new Location(x, y);
        battleField[destLoc.getX()][destLoc.getY()] = mover;
        battleField[srcLoc.getX()][srcLoc.getY()] = null;
        gameStage.move(srcLoc, destLoc);
    }

    private void processAttackMsg(AttackMessage msg)
    {
        Location attackerLoc = msg.loc;
        Creature attacker = battleField[attackerLoc.getX()][attackerLoc.getY()];
        String gifAddr = attacker.getCamp() == CampEnum.HULUBRO ?
                "/action_attack_bro.gif" : "/action_attack_monster .gif";
        gameStage.setStatusGif(msg.loc, gifAddr);
        if (attacker != null)
        {
            int range = (int) attacker.getDamageRange();
            int xbegin = (attackerLoc.getX() - range) > 0 ? (attackerLoc.getX() - range) : 0;
            int xend = (attackerLoc.getX() + range) < (getBattleFieldWidth() - 1) ? (attackerLoc.getX() + range) : (getBattleFieldWidth() - 1);
            int ybegin = (attackerLoc.getY() - range) > 1 ? (attackerLoc.getY() - range) : 1;
            int yend = (attackerLoc.getY() + range) < getBattleFieldHeight() ? (attackerLoc.getY() + range) : getBattleFieldHeight();
            for (int i = xbegin; i <= xend; i++)
                for (int j = ybegin; j <= yend; j++)
                {
                    Creature target = battleField[i][j];
                    if (target != null && target != attacker &&
                            target.getCamp() != attacker.getCamp() && (!target.isDead()))
                    {
                        Location loc = new Location(i, j);
                        attacker.attack(target, rand);
                        if (target.isDead())
                        {
                            switch (target.getCamp())
                            {
                            case HULUBRO:
                                gameStage.rotateLabel(loc, broRotateAnagle);
                                break;
                            case MONSTER:
                                gameStage.rotateLabel(loc, monsterRotateAngle);
                                break;
                            }
                            gameStage.clearStatusGif(new Location(i, j));
                            if (target.getCamp() == this.camp) aliveCreatures.remove(target);
                        }
                    }
                }
            if (aliveCreatures.isEmpty())
            {
                GameOverMessage gameOverMessage = new GameOverMessage(this.camp, OverReasonEnum.LOSE);
                client.sendMsg(new Message(this.camp, MessageType.GAME_OVER, gameOverMessage.toString()));
            }
        }
    }

    private void processDefenseMsg(DefenseMessage msg)
    {
        Location targetLoc = msg.loc;
        Creature target = battleField[targetLoc.getX()][targetLoc.getY()];
        if (target != null)
        {
            if (target.isDefensive())
            {
                target.takeDownDefense();
                gameStage.clearStatusGif(msg.loc);
            }
            else
            {
                target.defense();
                String gifAddr = target.getCamp() == CampEnum.HULUBRO ?
                        "/action_defend_bro.gif" : "/action_defend_monster.gif";
                gameStage.setStatusGif(msg.loc, gifAddr);
            }
        }
    }

    private void processGameOverMsg(GameOverMessage msg)
    {
        //自己退出的
        if (msg.loserCamp == camp && msg.reason == OverReasonEnum.EXIT)
        {
            return;
        }

        //Show a Dialog
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Game Over");

        if (msg.loserCamp == camp)
        {
            alert.setHeaderText("You Lose...");
            alert.setContentText("Because you " + msg.reason.toString() + ",your enemy win this game..");
        }
        else
        {
            alert.setHeaderText("You Win!");
            alert.setContentText("Because your enmy " + msg.reason.toString() + ",you win this game!");
        }
        alert.showAndWait();
        logInStage.show();
        gameStage.close();
    }
}
