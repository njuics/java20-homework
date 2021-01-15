package BattleControl;

import Creature.Type;

public class GameState implements BattleConfig{
    private boolean isStarted=false;
    private boolean isPaused=false;
    private boolean isReviewed=false;
    private boolean isGameOver=false;
    private int justiceCreatureNum=JUSTICE_CREATURE_NUM;
    private int evilCreatureNum=EVIL_CREATURE_NUM;
    private Type winner=null;//为0则葫芦娃获胜，为1则妖精获胜
    public void setIsStarted(boolean isStarted){
        this.isStarted=isStarted;
    }
    public boolean getIsStart(){
        return isStarted;
    }
    public void setIsPaused(boolean isPaused){
        this.isPaused=isPaused;
    }
    public boolean getIsPaused(){
        return isPaused;
    }
    public void setIsReviewed(boolean isReviewed){
        this.isReviewed=isReviewed;
    }
    public boolean getIsReviewed(){
        return isReviewed;
    }
    public void setWinner(Type winner){
        this.winner=winner;
    }
    public Type getWinner(){
        return winner;
    }
    public boolean isNotLaunched(){
        return (!isStarted)&&(!isReviewed);
    }
    public int getJusticeCreatureNum(){
        return justiceCreatureNum;
    }
    public void setJusticeCreatureNum(int tempNum){
        justiceCreatureNum=tempNum;
        if(justiceCreatureNum<=0){
                isStarted=false;//游戏结束
                isGameOver=true;
                winner=Type.EVIL;
               // this.notifyAll();
        }
    }
    public int getEvilCreatureNum(){
        return evilCreatureNum;
    }
    public void setEvilCreatureNum(int tempNum){
        evilCreatureNum=tempNum;
        if(evilCreatureNum<=0){
                isStarted=false;//游戏结束
                isGameOver=true;
                winner=Type.JUSTICE;
                //this.notifyAll();
        }
    }
    public void setGameOver(boolean gameOver){
        isGameOver=gameOver;
    }
    public boolean getGameOver(){
        return isGameOver;
    }
}
