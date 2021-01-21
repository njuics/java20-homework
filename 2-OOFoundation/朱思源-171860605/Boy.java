import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Boy{

    private final String name;
    private final String color;
    private final int rank;
    private int position;
    private Queue que;

    Boy(String name, String color, int rank) {
        this.name=name;
        this.color=color;
        this.rank=rank-1;
    }

    void gotoQueue(Queue que)
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

    void findPos()
    {
        if(position!=rank){
            System.out.println(name+" wants to change position with "+que.array[rank].getName());
            que.swap(position,rank);
        }
    }

    void changePos(Boy b){
        System.out.println(name+" listens to the grandpa and wants to change position with "+b.getName());
        que.swap(position,b.position);
    }

    void reportName() {
        System.out.print(name);
    }


    int getRank() {
        return rank;
    }

    String getName()
    {
        return name;
    }

    void setPosition(int pos){
        position=pos;
    }
}
