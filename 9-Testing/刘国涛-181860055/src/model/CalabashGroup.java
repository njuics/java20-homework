package model;

import java.util.ArrayList;
import order.*;

public class CalabashGroup {
    private ArrayList<Calabash> group = new ArrayList<Calabash>();

    public void insert(Calabash calabash){
        this.group.add(calabash);
    }
    
    public ArrayList<CalabashGroup> divideByGender(){
        sort(0);
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
            this.group.sort(new ascStrategy<Calabash>());
        }
        else if(method == 1){
            this.group.sort(new desStrategy<Calabash>());
        }
        else{
            this.group.sort(new ranStrategy<Calabash>());
        }
    }

    public ArrayList<Calabash> getGroup(){      
        return group;
    }
}
