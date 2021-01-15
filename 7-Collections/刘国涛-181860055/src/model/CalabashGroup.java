package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;


public class CalabashGroup {
    private ArrayList<Calabash> group = new ArrayList<Calabash>();
    private static Random random = new Random();
    static private Comparator<Calabash> PositiveOrderCompareStrategy =  new Comparator<Calabash>(){
        @Override
        public int compare(Calabash a,Calabash b){
            return a.getName().compareTo(b.getName());
        }
    };
    static private Comparator<Calabash> ReverseOrderCompareStrategy =  new Comparator<Calabash>(){
        @Override
        public int compare(Calabash a,Calabash b){
            return b.getName().compareTo(a.getName());
        }
    };
    static private Comparator<Calabash> RandomOrderCompareStrategy =  new Comparator<Calabash>(){
        @Override
        public int compare(Calabash a,Calabash b){
            return random.nextInt(3)-2;
        }
    };
    public void insert(Calabash calabash){
        this.group.add(calabash);
    }
    public ArrayList<CalabashGroup> divideByGender(){
        CalabashGroup boys = new CalabashGroup();
        CalabashGroup girls = new CalabashGroup();
        for(Calabash calabash:group){
            if(calabash.getGender()){
                boys.insert(calabash);
            }
            else{
                girls.insert(calabash);
            }
        }
        ArrayList<CalabashGroup> boysAndGirls = new ArrayList<CalabashGroup>();
        boysAndGirls.add(boys);
        boysAndGirls.add(girls);
        return boysAndGirls;
    } 
    public void print(){
        for(Calabash calabash:group){
            calabash.reportName();
        }
        System.out.println("");;
    }

    public void sort(int method){
        if(method == 0){
            this.group.sort(PositiveOrderCompareStrategy);
        }
        else if(method == 1){
            this.group.sort(ReverseOrderCompareStrategy);
        }
        else{
            this.group.sort(RandomOrderCompareStrategy);
        }
    }
}
