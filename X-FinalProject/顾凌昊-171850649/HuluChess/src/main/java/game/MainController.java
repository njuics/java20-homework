package game;

import client.Client;
import javafx.application.Platform;
import server.Server;

public class MainController{

    private static MainController instance;

    private Client client;
    private Server server;

    public static MainController getInstance(){
        if(instance == null){
            instance = new MainController();
        }
        return instance;
    }

    public enum GameState {GAME_MENU, GAME_START, GAME_OVER, GAME_CONNECT};
    public GameState mGameState = GameState.GAME_MENU;


    public void exit(){
        Platform.exit();
    }

    public void enterRoom(String _name, String _address, int _port){

        mGameState = GameState.GAME_CONNECT;
        client = new Client(_name, _address, _port);

    }

    public void createRoom(String _name, int _port){

        mGameState = GameState.GAME_CONNECT;
        server = new Server(_name, _port);
    }

    public void exitRoom(){

        if(client != null){
            client.disconnect();
            client = null;
        }
        if(server != null){
            server.disconnect();
            server = null;
        }

        mGameState = GameState.GAME_MENU;

    }

    public void gameStart(){

        mGameState = GameState.GAME_START;

    }

    public void gameOver(){
        mGameState = GameState.GAME_OVER;
    }

    public void disconnect(){
        mGameState = GameState.GAME_MENU;
    }




}
