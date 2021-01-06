package cn.edu.nju.java;
import java.util.ArrayList;
import java.util.Random;
public class World {
    public ArrayList<CalabashBrothers> brothers;
    public GrandFather grandfather;
    public SortCommand command;
    Random random;
    World()
    {
        brothers=new ArrayList<>();
        CalabashBrothers Eldest =new CalabashBrothers("老大 ",0);
        CalabashBrothers Second =new CalabashBrothers("老二 ",1);
        CalabashBrothers Third =new CalabashBrothers("老三 ",2);
        CalabashBrothers Fourth =new CalabashBrothers("老四 ", 3);
        CalabashBrothers Fifth =new CalabashBrothers("老五 ",4);
        CalabashBrothers Sixth =new CalabashBrothers("老六 ",5);
        CalabashBrothers Seventh =new CalabashBrothers("老七 ",6);
        brothers.add(Eldest);
        brothers.add(Second);
        brothers.add(Third);
        brothers.add(Fourth);
        brothers.add(Fifth);
        brothers.add(Sixth);
        brothers.add(Seventh);
        command = new SortCommand();
        grandfather=new GrandFather();
        random=new Random();
    }

    void print_list()
    {
        for(int i=0;i<7;i++)
        {
            System.out.print(brothers.get(i).get_name());
        }
        System.out.print("\n");
    }
    public void RandomList()
    {
        for (int i=0;i<20;i++)
        {
            int ran=random.nextInt(7);
            ran=ran%7;
           brothers.get(ran).swap(brothers,ran,(ran+1)%7);
        }

    }
    public static void main(String[] args) {

        World Keyword=new World();
        Keyword.RandomList();
        System.out.print("Before orchestration:"+"\n");
        Keyword.print_list();
        Keyword.command.choreography(Keyword.brothers);
        System.out.print("After orchestration:"+"\n");
        Keyword.print_list();
        Keyword.RandomList();
        System.out.print("Before choreography:"+"\n");
        Keyword.print_list();
        Keyword.command.orchestration(Keyword.grandfather,Keyword.brothers);
        System.out.print("After choreography:"+"\n");
        Keyword.print_list();
    }
}