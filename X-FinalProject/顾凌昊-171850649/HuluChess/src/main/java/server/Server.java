package server;

import game.MainController;
import game.ScreenController;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server implements Runnable{

    private int port;
    private ServerSocket serverSocket;
    private Socket socket;

    private String name;
    private DataInputStream dis;
    private DataOutputStream dos;

    public Server() throws IOException {

        this("服务器",10800);
    }

    public Server(String _name, int _port) {
        name = _name;
        port = _port;

        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("服务器已启动！ip："+ InetAddress.getLocalHost());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        new Thread(this).start();

    }

    public void run(){

        try {
            socket = serverSocket.accept();
            System.out.println("客户端已连接！");

            ScreenController.getInstance().activate("Game");
            MainController.getInstance().gameStart();


            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            disconnect();
        }

    }

    public void disconnect(){
        try {
            socket.close();
            serverSocket.close();
            dos.close();
            dis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
