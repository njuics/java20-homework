import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.Random;
import java.io.File;


public class LineUp {
    private  static int model=1;//为1表示使用orchestration思想，为2表示使用choreography思想
    private  static HuLuWa [] huLuWa =new HuLuWa[7];
    private  static int sortModel=2;//使用的排序算法，1为冒泡排序，2为快速排序

    public static void shuffle(){
        boolean used[]=new boolean[7];
        for(int i=0;i<7;i++)used[i]=false;
        Random r=new Random();
        int count=0;
        while(count<7){
            int tempPosition=r.nextInt(7);
            if(!used[tempPosition]){
                used[tempPosition]=true;
                huLuWa[count].setPosition(tempPosition);
                count++;
            }
        }
    }

    public static void sort(){
        for(int i=0;i<7;i++){
            if(huLuWa[i].getPosition()!=i){//如果葫芦娃的排行与自己在队列中的位置不一致，则与自己正确位置上的葫芦娃交换位置
                int index=-1;
                for(int j=0;j<7;j++){
                    if(huLuWa[j].getPosition()==i){
                        index=j;
                        break;
                    }
                }
                huLuWa[i].swap(huLuWa[index]);
            }
        }
    }
    public static void outPut(){
        for(int i=0;i<7;i++){
            int tempPosition=huLuWa[i].getPosition();
            switch (tempPosition){
                case 0:System.out.print("老大 ");break;
                case 1:System.out.print("老二 ");break;
                case 2:System.out.print("老三 ");break;
                case 3:System.out.print("老四 ");break;
                case 4:System.out.print("老五 ");break;
                case 5:System.out.print("老六 ");break;
                case 6:System.out.print("老七 ");break;
                default:System.out.println("error in rank!");break;
            }
        }
        System.out.println("");
    }

    public static void main(String[]args){
        for(int i=0;i<7;i++) huLuWa[i]=new HuLuWa(i+1);
        if(model==1) {
            GrandFather grandFather = new GrandFather(huLuWa);
            grandFather.shuffle();
            outPut();
            grandFather.sort(sortModel);
        }
        else{
            shuffle();
            outPut();
            sort();
        }
        outPut();
    }
}
