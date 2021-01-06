package huluwa.Client;

import huluwa.Game;
import huluwa.Render;
import javafx.application.Application;

public class PlayerClient {
    private NetClient nc = new NetClient(this);
    public boolean goodReady = false, badReady = false;
    private boolean goodOrBad;
    private Game game;
    private Render render;

    public void main(String[] args) {
        PlayerClient pc = new PlayerClient();
        pc.startTheThread(); // 自己启动一个线程
        pc.connectToServer(); // 连接服务器
        this.game = new Game(goodOrBad, pc);
        this.render = new Render(this.game);
        Application.launch(render.getClass());
    }
    
    private void startTheThread(){
        new Thread(new GameThread()).start();
    }

    private void connectToServer(){
        String serverIP = "127.0.0.1";
        nc.connect(serverIP);
    }

    class GameThread implements Runnable {
        public void run() {
            while(true) {
                //TODO轮到自己操作生物
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean getGoodBad(){
        return this.goodOrBad;
    }

    public void setGoodBad(boolean flag){
        this.goodOrBad = flag;
    }

    public Render getRender(){
        return this.render;
    }

    public NetClient getNC(){
        return this.nc;
    }

    public Game getGame(){
        return this.game;
    }
    
    public void gameOver(){
        
    }

}
