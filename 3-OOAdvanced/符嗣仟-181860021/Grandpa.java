package com.company;
import java.util.Arrays;

public class Grandpa {

    public void swap(Calabash[] grandsons, int pos1, int pos2){
        Calabash tmp = grandsons[pos1];
        grandsons[pos1] = grandsons[pos2];
        grandsons[pos2] = tmp;
    }

    public void GrandpaSort(Calabash[] grandsons){
        //通过爷爷指挥进行排队
        int len = grandsons.length;
        for(int i=0;i<len;i++) {
            for(int j=0;j<len-i-1;j++){
                if(grandsons[j].pos>grandsons[j+1].pos){
                    swap(grandsons,j,j+1);
                }
            }
        }
    }

}
