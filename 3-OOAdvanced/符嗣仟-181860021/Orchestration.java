package com.company;

public class Orchestration extends World {
    //继承World类,利用grandpa进行排序
    static Grandpa papa;
    static {
        papa = new Grandpa();
    }

    @Override
    public void Sort(){
        papa.GrandpaSort(huluwas);
    }

    public void run(){
        System.out.println("Orchesration world:");
        ShuffleArrays();
        Report();
        Sort();
        Report();
    }
}
