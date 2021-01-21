package com.company;

public class Orchestration extends World {
    //继承World类,利用grandpa进行排序
    Grandpa papa;
    void run(){
        System.out.println("Orchesration world:");
        papa = new Grandpa();
        ShuffleArrays();
        Report();
        papa.GrandpaSort(huluwas);
        Report();
    }
}
