package nju.zjl.cvs.game;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.Stream;

import nju.zjl.cvs.game.Constants.Camp;

public class GameController implements Runnable {
    public GameController(ItemManager items, Operator operator, Consumer<Camp> gameEnd){
        this.items = items;
        this.operator = operator;
        this.gameEnd = gameEnd;
    }

    @Override
    public void run() {
        while(!isGameOver() && !gameOver){
            try{
                TimeUnit.MILLISECONDS.sleep(1000 / Constants.FPS);
            }catch(InterruptedException exception){
                exception.printStackTrace();
            }
            times++;
            update();
        }
        try{
            TimeUnit.MILLISECONDS.sleep(1000 / Constants.FPS);
        }catch(InterruptedException exception){
            exception.printStackTrace();
        }
        gameEnd.accept(items.getCreatures()[0].getCamp());
    }

    public void terminate(){
        gameOver = true;
    }

    protected void update(){
        while(times > 0){
            if(logicTimer <= 0){
                Operation[] ops = operator.getLogicFrames(logicFrame);
                if(ops == null){
                    return;
                }
                for(Operation op : ops){
                    Creature c = items.getCreatureById(op.executor);
                    if(c != null){
                        c.setInst(op.inst);
                    }
                }
                logicFrame++;
                logicTimer = Constants.FPS / 10;
            }
            Stream.of(items.getCreatures()).forEach(c -> c.update(items));
            Stream.of(items.getAffectors()).forEach(a -> a.update(items));
            times--;
            logicTimer--;
        }
    }

    protected boolean isGameOver(){
        Creature[] creatures = items.getCreatures();
        Camp camp = creatures[0].getCamp();
        return Stream.of(creatures).allMatch(c -> c.getCamp() == camp); 
    }

    protected boolean gameOver = false;
    protected int logicTimer = Constants.FPS / 10;
    protected int logicFrame = 0;
    protected int times = 0;
    protected ItemManager items;
    protected Operator operator;
    protected Consumer<Camp> gameEnd;
}
