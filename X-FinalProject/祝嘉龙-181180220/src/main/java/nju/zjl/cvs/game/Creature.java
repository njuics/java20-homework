package nju.zjl.cvs.game;

import java.util.LinkedList;
import java.util.stream.IntStream;

import javafx.scene.canvas.GraphicsContext;
import nju.zjl.cvs.game.Constants.Camp;


public class Creature implements Drawable {
    public Creature(Camp camp, int pos, int maxHp, int atk, int atkRange, int maxAtkCD, BulletSupplier bullet, String imgName){
        this.id = identifier++;
        this.camp = camp;
        this.pos = pos;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.atk = atk;
        this.atkRange = atkRange;
        this.inst = Instruction.newNullInst();
        this.moveCD = 0;
        this.atkCD = 0;
        this.maxAtkCD = maxAtkCD;
        this.movePath = null;
        this.bullet = bullet;
        this.imgName = imgName;
    }

    @Override
    public void draw(GraphicsContext gc){
        int ltx = (pos % Constants.COLUMNS) * Constants.GRIDWIDTH;
        int lty = (pos / Constants.COLUMNS) * Constants.GRIDHEIGHT;
        gc.drawImage(Constants.getImage(imgName), ltx + 10, lty + 15);
        gc.setFill(Constants.getColor("red"));
        gc.fillRect(ltx + 10, lty + 5, (Constants.GRIDWIDTH - 20) * hp / maxHp, 5);
        gc.setStroke(Constants.getColor("black"));
        gc.strokeRect(ltx + 10, lty + 5, Constants.GRIDWIDTH - 20, 5);
    }

    public void update(ItemManager items){
        moveCD -= 1;
        atkCD -= 1;
        switch(inst.action){
            case NULL:
                autoAttack(items);
                break;
            case MOVE:
                moveTo(inst.pos, items, 0);
                break;
            case ATTACK:
                attack(inst.target, items);
                break;
            default:
                break;
        }
    }

    public boolean hurt(int damage){
        hp -= damage;
        return hp <= 0;
    }

    public int getId(){
        return id;
    }

    public int getPos(){
        return pos;
    }

    public Camp getCamp(){
        return camp;
    }

    public void setInst(Instruction inst){
        this.inst = inst;
    }

    protected void moveTo(int dest, ItemManager items, int pathType){
        if(moveCD > 0){
            return;
        }
        if( movePath == null || //has not yet compute path 
            movePath.peekLast() != dest || //dest has changed
            items.getCreatureByPos(movePath.peekFirst()) != null //map has changed, next hop was peroccupied 
            ){
            if(!computePath(dest, items.getIntCreatureMap(), pathType)){
                return;
            }
        }
        int next = movePath.pollFirst();
        items.moveCreature(pos, next);
        pos = next;
        moveCD = Constants.CREATUREMOVECD;
        if(movePath.isEmpty()){ //reach the dest, remove the instruction
            movePath = null;
            if(inst.action == Instruction.Action.MOVE){
                inst = Instruction.newNullInst();
            }
        }
    }

    protected boolean computePath(int dest, int[] map, int pathType){
        int[] path;
        if(pathType == 0){
            path = Algorithms.findPath(map, Constants.COLUMNS, pos, dest);
        }
        else{
            path = Algorithms.findAtkPath(map, Constants.COLUMNS, pos, dest, atkRange);
        }
        if(path.length == 0 || path.length == 1){ //cannot move to dest, instruction was illeagal, drop it
            movePath = null;
            inst = Instruction.newNullInst();
            return false;
        }
        movePath = new LinkedList<>();
        IntStream.of(path).
            boxed().
            forEach(movePath::add);
        movePath.pollFirst();
        return true;
    }

    protected void attack(int target, ItemManager items){
        Creature ct = items.getCreatureById(target);
        if(ct == null){ //target was already dead, drop instruction
            inst = Instruction.newNullInst();
            return;
        }
        int tPos = ct.getPos();
        int dis = Math.max(Math.abs(pos / Constants.COLUMNS - tPos / Constants.COLUMNS), Math.abs(pos % Constants.COLUMNS - tPos % Constants.COLUMNS));
        if(dis > atkRange){ //out of attack range, first try to move towards it
            moveTo(tPos, items, 1);
            return;
        }
        if(atkCD > 0){
            return;
        }
        int[] ret = Constants.creaturePos2BulletPos(pos);
        items.addAffector(bullet.get(ret[0], ret[1], target, atk));
        atkCD = maxAtkCD;
    }

    protected void autoAttack(ItemManager items){
        if(atkCD > 0){
            return;
        }
        int x = pos / Constants.COLUMNS - atkRange;
        int y = pos % Constants.COLUMNS - atkRange;
        for(int i = 0; i < 2 * atkRange + 1; i++){
            for(int j = 0; j < 2 * atkRange + 1; j++){
                if(x + i < 0 || x + i >= Constants.ROWS || y + j < 0 || y + j >= Constants.COLUMNS){
                    continue;
                }
                Creature ct = items.getCreatureByPos((x + i) * Constants.COLUMNS + y + j);
                if(ct == null || ct.getCamp() == camp){
                    continue;
                }
                int[] ret = Constants.creaturePos2BulletPos(pos);
                items.addAffector(bullet.get(ret[0], ret[1], ct.getId(), atk));
                atkCD = maxAtkCD;
                return;
            }
        }
    }
    
    public static void resetIdentifier(){
        identifier = 0;
    }

    private static int identifier = 0;

    protected int id;
    protected Camp camp;
    protected int pos;

    protected Instruction inst;

    protected int hp;
    protected int maxHp;

    protected int moveCD;
    protected LinkedList<Integer> movePath;

    protected int atk;
    protected int atkCD;
    protected int maxAtkCD;
    protected int atkRange;

    protected BulletSupplier bullet;

    protected String imgName;
}
