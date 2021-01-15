package cn.edu.xiaoyu;

import java.util.*;

public class CalabashSort {
    public static final String[] name={"老大","老二","老三","老四","老五","老六","老七"};
    public static final int NUM=7;
    public static void main(String[] args){

        ArrayList<Calabash> list = new ArrayList<>();
        for(int i=1;i<=NUM;i++)
            list.add(new Calabash(name[i-1],i));

        SortMethod Method = new SortMethod1();
        Grandpa g=new Grandpa("爷爷");

        shuffleAndRepos(list);
        System.out.println("before selfSort:");
        for(int i=0;i<NUM;i++)
            list.get(i).reportName();
        System.out.println("");

        Method.choreography(list);
        System.out.println("\nAfter selfSort:");
        for(int i=0;i<NUM;i++)
            list.get(i).reportName();
        System.out.println("");
        
        shuffleAndRepos(list);
        System.out.println("\nbefore grandpaSort:");
        for(int i=0;i<NUM;i++)
            list.get(i).reportName();
        System.out.println("");

        Method.orchestration(g,list);
        System.out.println("\nAfter grandpaSort:");
        for(int i=0;i<NUM;i++)
            list.get(i).reportName();
    }

    private static void shuffleAndRepos(ArrayList<Calabash> list){
        Collections.shuffle(list);
        for(int i=0;i<NUM;i++)
            list.get(i).pos=i;
    }
}
