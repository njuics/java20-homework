import java.util.*;

public class CalabashSort {
    public static void main(String[] args){
        ArrayList<Calabash> list = new ArrayList<>();
        for(int i=1;i<=7;i++)
            list.add(new Calabash(i));

        SortMethod1 Method = new SortMethod1();

        shuffleAndRepos(list);
        System.out.println("before selfSort:");
        for(int i=0;i<7;i++)
            System.out.print(list.get(i).calabashName+" ");
        Method.selfSort(list);
        System.out.println("\nAfter selfSort:");
        for(int i=0;i<7;i++)
            System.out.print(list.get(i).calabashName+" ");
        
        shuffleAndRepos(list);
        System.out.println("\nbefore grandpaSort:");
        for(int i=0;i<7;i++)
            System.out.print(list.get(i).calabashName+" ");
        Method.grandpaSort(list);
        System.out.println("\nAfter grandpaSort:");
        for(int i=0;i<7;i++)
            System.out.print(list.get(i).calabashName+" ");
    }

    public static void shuffleAndRepos(ArrayList<Calabash> list){
        Collections.shuffle(list);
        for(int i=0;i<7;i++)
            list.get(i).pos=i;
    }
}
