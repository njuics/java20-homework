package client;

import game.MainController;
import game.ScreenController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements Runnable{

    String name;
    Socket socket;
    String address;
    int port;

    boolean mouseDetect = false;

    private DataInputStream dis;
    private DataOutputStream dos;
    private PrintStream ps;

    public Client(String _name, String _address, int _port){
        name = _name;
        address = _address;
        port = _port;

        new Thread(this).start();
    }


    public Client(){
        this("客户端", "1.1.1.1", 10800);
    }

    public void run(){
        try {
            socket=new Socket(address, port);

            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());

            ScreenController.getInstance().activate("Game");
            MainController.getInstance().gameStart();



        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            disconnect();

        }


    }

    public void disconnect(){
        try {
            socket.close();

            dis.close();
            dos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
