package com.company;
import java.util.Arrays;
import java.util.Random;

public class World {
    int NUMS_OF_HULUWA = 7;
    Calabash []huluwas;
    World(){
        String[] names = {"大娃","二娃","三娃","四娃","五娃","六娃","七娃"};
        huluwas = new Calabash[7];
        for(int i=0;i<NUMS_OF_HULUWA;i++){
            huluwas[i] = new Calabash(names[i],i);
        }
        //初始化葫芦娃数组
    }
    void swap(Calabash[] huluwas,int pos1,int pos2){
        Calabash tmp = huluwas[pos1];
        huluwas[pos1] = huluwas[pos2];
        huluwas[pos2] = tmp;
    }
    void ShuffleArrays(){
        //对葫芦娃进行随机排序
        System.out.println("打乱葫芦娃顺序");
        int len = huluwas.length;
        Random rand = new Random();
        for(int i= len;i>0;i--){
            int randId = rand.nextInt(i);
            swap(huluwas,randId,i-1);
        }

    }
    void Report(){
        for(int i=0;i<NUMS_OF_HULUWA;i++){
            huluwas[i].NumberOff();
        }
        System.out.println(" ");
    }
}
