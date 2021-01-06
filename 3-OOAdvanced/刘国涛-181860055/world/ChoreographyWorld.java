package world;
import java.util.Comparator;

import model.*;
import util.*;
public class ChoreographyWorld extends World {
    private GrandFather grandFather = new GrandFather();
    private Calabash[] calabashs;
    private static Comparator<Calabash> choreographyCompareMethod = new Comparator<Calabash>(){
        @Override
        public int compare(Calabash a,Calabash b){
            return a.compareTo(b);
        }
    };
    private static SortStrategy sortStrategy = new BubbleSortStrategy();
    @Override
    public final void run(){
        System.out.println("Choreography World run");
        calabashs = grandFather.plantCalabash();
        randomShuffle(calabashs);
        
        for(Calabash calabash:calabashs)
            calabash.reportNum();
        System.out.println();
        // change sort strategy 
        sortStrategy = new QuickSortStrategy();

        sortStrategy.sort(calabashs, choreographyCompareMethod);
        for(Calabash calabash:calabashs)
            calabash.reportNum();


        
    }
}
