package com.company;

public class Main {
    public static void main(String[] args) {
        Orchestration os = new Orchestration();
        Choreography ch = new Choreography();
        os.run();
        ch.run();
    }

}
