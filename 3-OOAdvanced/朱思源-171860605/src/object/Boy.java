package object;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import map.Queue;

public class Boy extends Creature{

    static int num;
    private final String color;
    private final int rank;
    private int position;
    private Queue que;

    static{
        num=0;
    }

    public Boy(String name, String color, int rank) {
        super(name);
        this.color=color;
        this.rank=rank-1;
    }

    public void gotoQueue(Queue que)
    {
        this.que=que;
        List<Integer> positions=new ArrayList<>();
        for(int i=0;i<que.array.length;i++)
        {
            if(que.isEmpty(i)){
                positions.add(i);
            }
        }
        Random random=new Random();
        position=positions.get(random.nextInt(positions.size()));
        que.addBoy(this,position);
    }

    public void changePos(Boy b){
        System.out.println(name+" listens to the grandpa and wants to change position with "+b.getName());
        que.swap(position,b.position);
    }

    public int getRank() {
        return rank;
    }

    public void setPosition(int pos){
        position=pos;
    }

    public void findPos()
    {
        if(position!=rank){
            System.out.println(name+" wants to change position with "+que.array[rank].getName());
            que.swap(position,rank);
        }
    }

    @Override
    public void info()
    {
        System.out.println(name+" has entered the queue.");
    }
}
