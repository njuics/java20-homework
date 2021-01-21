package cn.edu.nju.wuyuxin;

import java.util.Random;
public class BoyQueue{
    public CalabashBoy[] queue;
    public BoyQueue(){
        queue = new CalabashBoy[7];
        for(int i=0;i<7;i++){
            queue[i] = new CalabashBoy(i+1);
        }
    }
    public void shuffle(){
        Random rand = new Random();
        for(int i=0;i<7;i++){
            int rand_pos = rand.nextInt(7);
            queue[i].swap(queue[rand_pos]);
        }
    }
    public void show(){
        for(CalabashBoy boy: queue){
            boy.print();
        }
        System.out.println("");
    }

    
    public int findBoy(int index){
        for(int i=0;i<queue.length;i++){
            if(queue[i].getNo()==index)
                return i;
        }
        return -1;
    }

    public void sort(BaseSort sortMethod,int sortMode){ //sortMode: 1-choreography,2-orchestration
        if(sortMode==1)
            sortMethod.choreography(this);
        else if(sortMode==2){
            Grandpa grandpa = new Grandpa();
            sortMethod.orchestration(grandpa, this);
        }
    }
}