package map;

import object.*;

public class Queue {
    public int len;
    public Boy[] array;
    public int[] info;

    public Queue(int len)
    {
        this.len=len;
        array=new Boy[len];
        info=new int[len];
        for(int i=0;i<len;i++){
            info[i]=0;
        }
    }

    public boolean addBoy(Boy b,int pos)
    {
        if(info[pos]==0)
        {
            array[pos]=b;
            info[pos]=1;
            return true;
        }
        else return false;
    }

    public boolean isEmpty(int pos)
    {
        if(info[pos]==0){
            return true;
        }
        else {
            return false;
        }
    }

    public void swap(int pos1, int pos2){
        System.out.println(array[pos1].getName()+" changes position with "+array[pos2].getName()+", and the queue is:");
        Boy tmp=array[pos1];
        array[pos1]=array[pos2];
        array[pos2]=tmp;
        array[pos1].setPosition(pos1);
        array[pos2].setPosition(pos2);
        this.show();
    }

    public void show(){
        for(int i=0;i<len;i++){
            if(i!=len-1){
                array[i].reportName();
                System.out.print(" ");
            }
            else {
                array[i].reportName();
                System.out.println();
            }
        }
    }

    public int prevRank(int pos){
        if(pos-1>=0) {
            return array[pos-1].getRank();
        }
        else return -1;
    }

    public int nextRank(int pos){
        if(pos+1<len){
            return array[pos+1].getRank();
        }
        else return -1;
    }

}
