package com.company;

public class Choreography extends World {
    @Override
    public void Sort() {
        int len = huluwas.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len-i-1; j++) {
                if (huluwas[j].compare(huluwas[j + 1])) {
                    swap(huluwas, j, j + 1);
                }
            }
        }
    }
    void run(){
        System.out.println("choreography world:");
        ShuffleArrays();
        Report();
        Sort();
        Report();
    }
}
