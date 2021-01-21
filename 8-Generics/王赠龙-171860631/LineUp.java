import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import java.io.IOException;
import java.io.File;
import Package.JavaCreature.HuLuWa;
import Package.JavaCreature.GrandFather;
import Package.MyComparator.*;

public class LineUp {
    private  static final int model;//为1表示使用orchestration思想，为2表示使用choreography思想
    //private  static HuLuWa [] huLuWa;
    private  static ArrayList<HuLuWa> huLuWa;//使用泛型确定类型仅为HuLuWa
    private  static GrandFather grandFather;
    private  static final int sortModel;//使用的排序算法，1为冒泡排序，2为快速排序
    private  static int nameOrderModel=1;//用于确定按字典序的正序还是反序，0为正序，1为反序
    static{
        model=2;
        huLuWa =new ArrayList<HuLuWa>();
        sortModel=2;
    }

    public static void shuffle(){
        boolean used[]=new boolean[huLuWa.size()];
        for(int i=0;i<huLuWa.size();i++)used[i]=false;
        Random r=new Random();
        int count=0;
        while(count<huLuWa.size()){
            int tempPosition=r.nextInt(7);
            if(!used[tempPosition]){
                used[tempPosition]=true;

                //huLuWa[count].setPosition(tempPosition);
                huLuWa.get(count).setPosition(tempPosition);
                count++;
            }
        }
    }

    public static void sort(){
        /*
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
        }*/
        for(int i=0;i<huLuWa.size();i++){
            if(huLuWa.get(i).getPosition()!=i){//如果葫芦娃的排行与自己在队列中的位置不一致，则与自己正确位置上的葫芦娃交换位置
                int index=-1;
                for(int j=0;j<huLuWa.size();j++){
                    if(huLuWa.get(j).getPosition()==i){
                        index=j;
                        break;
                    }
                }
                huLuWa.get(i).swap(huLuWa.get(index));
            }
        }
    }
    public static void outPut(){
        /*
        for(int i=0;i<huLuWa.size();i++){
            int tempPosition=huLuWa.get(i).getPosition();
            huLuWa.get(tempPosition).numberOff();
        }
        System.out.println("");*/
        for(int i=0;i<huLuWa.size();i++){
            huLuWa.get(i).numberOff();
        }
        System.out.println("");
    }

    public static void main(String[]args){

        //作业一、二要求的产生葫芦娃的方式
        /*
        huLuWa.add(new HuLuWa(1,"TheFirst",1));
        huLuWa.add(new HuLuWa(2,"TheSecond",1));
        huLuWa.add(new HuLuWa(3,"TheThird",1));
        huLuWa.add(new HuLuWa(4,"TheFourth",1));
        huLuWa.add(new HuLuWa(5,"TheFifth",1));
        huLuWa.add(new HuLuWa(6,"TheSixth",1));
        huLuWa.add(new HuLuWa(7,"TheSeventh",1));*/

        int huLuWaNum=15;
        for(int i=0;i<huLuWaNum;i++){
            //随机生成排行
            Random r1=new Random();
            int tempRank=r1.nextInt(7);
            //根据排行产生姓名
            String tempName;
            switch(tempRank){
                case 0:tempName=new String("TheFirst");break;
                case 1:tempName=new String("TheSecond");break;
                case 2:tempName=new String("TheThird");break;
                case 3:tempName=new String("TheFourth");break;
                case 4:tempName=new String("TheFifth");break;
                case 5:tempName=new String("TheSixth");break;
                case 6:tempName=new String("TheSeventh");break;
                default:tempName=null;
            }
            //随机生成性别
            Random r2=new Random();
            int tempGender=r1.nextInt(2);

            huLuWa.add(new HuLuWa(tempRank,tempName,tempGender));
        }

        ArrayList<HuLuWa> maleHuLuWa=new ArrayList<HuLuWa>();
        ArrayList<HuLuWa> femaleHuLuWa=new ArrayList<HuLuWa>();
        for(HuLuWa e:huLuWa){
            if(e.getGender()==0)femaleHuLuWa.add(e);
            else maleHuLuWa.add(e);
        }

        /*作业一与作业二用到的排序方法
        if(model==1) {
            grandFather = new GrandFather(huLuWa);
            grandFather.shuffle();
            outPut();
            grandFather.sort(sortModel);
        }
        else{
            shuffle();
            outPut();
            sort();
        }*/

        //作业七直接使用Collections.sort()方法
        System.out.println("全部排序前：");
        outPut();
        if(nameOrderModel==0) {
            Collections.sort(huLuWa, new OrderCreatureComparator());
            Collections.sort(maleHuLuWa, new OrderCreatureComparator());
            Collections.sort(femaleHuLuWa, new OrderCreatureComparator());
        }
        else{
            Collections.sort(huLuWa, new ReversedOrderCreatureComparator());
            Collections.sort(maleHuLuWa, new ReversedOrderCreatureComparator());
            Collections.sort(femaleHuLuWa, new ReversedOrderCreatureComparator());
        }
        System.out.println("全部排序后");
        outPut();

        System.out.println("男葫芦娃排序后");
        for(HuLuWa e:maleHuLuWa){
            System.out.print(e.getName()+" ");
        }
        System.out.println("");

        System.out.println("女葫芦娃排序后");
        for(HuLuWa e:femaleHuLuWa){
            System.out.print(e.getName()+" ");
        }
        System.out.println("");
    }
}
