package Package.JavaCreature;
import java.util.ArrayList;
import java.util.Random;

public class GrandFather{
    //private  HuLuWa [] huLuWa =new HuLuWa[7];
    private ArrayList<HuLuWa> huLuWa;

    public GrandFather( ArrayList<HuLuWa> tempHuLuWa){
        for(int i=0;i<7;i++){
            huLuWa=tempHuLuWa;
        }
    }

    private void setHuLuWaPosition(int index,int tempPosition){//要求排行为index的葫芦娃移动到队列的tempPosition位置
        huLuWa.get(index).setPosition(tempPosition);
    }

    private int getHuLuWaPosition(int index){//要求排行为index的葫芦娃报告自己在队列中的位置
        return huLuWa.get(index).getPosition();
    }
    public void shuffle(){//爷爷随机打乱葫芦娃的排序
        boolean used[]=new boolean[7];
        for(int i=0;i<7;i++)used[i]=false;
        Random r=new Random();
        int count=0;
        while(count<7){
            int tempPosition=r.nextInt(7);
            if(!used[tempPosition]){
                used[tempPosition]=true;
                setHuLuWaPosition(count,tempPosition);
                count++;
            }
        }
    }

    /*爷爷使用不同的排序算法对葫芦娃排序*/
    private void bubbleSort(){
        int i, j;
        for (j = 0; j < huLuWa.size() - 1; j++) {
            for (i = 0; i < huLuWa.size() - 1 - j; i++) {
                //int tempPosition1=huLuWa[i].getPosition();
                int tempPosition1=getHuLuWaPosition(i);
               // int tempPosition2=huLuWa[i+1].getPosition();
                int tempPosition2=getHuLuWaPosition(i+1);
                if (tempPosition1 > tempPosition2) {
                    //  huLuWa[i].setPosition(tempPosition2);
                    //  huLuWa[i+1].setPosition(tempPosition1);
                    setHuLuWaPosition(i,tempPosition2);
                    setHuLuWaPosition(i+1,tempPosition1);
                }
            }
        }
    }
    private int partition(int i,int j){
        //int key=huLuWa[i].getPosition();
        int key=getHuLuWaPosition(i);
        while(i<j){
            while((i<j)&&(getHuLuWaPosition(j)>=key)){
                j--;
            }
            if(i<j){
                //huLuWa[i].setPosition(huLuWa[j].getPosition());
                setHuLuWaPosition(i,getHuLuWaPosition(j));
            }
            while((i<j)&&(getHuLuWaPosition(i)<=key)){
                i++;
            }
            if(i<j){
                //huLuWa[j].setPosition(huLuWa[i].getPosition());
                setHuLuWaPosition(j,getHuLuWaPosition(i));
            }
        }
        //huLuWa[i].setPosition(key);
        setHuLuWaPosition(i,key);
        return i;
    }

    private void quickSort(int low,int high){
        if(low<high){
            int pos=partition(low,high);
            quickSort(low,pos-1);
            quickSort(pos+1,high);
        }
    }
    public void sort(int sortModel){//根据sortModel的不同选择不同的排序算法
        if(sortModel==1)bubbleSort();
        else quickSort(0,huLuWa.size()-1);
    }

}
