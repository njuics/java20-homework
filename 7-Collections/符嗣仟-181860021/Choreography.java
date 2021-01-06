import java.util.*;
public class Choreography extends World {
    CalabashCompartor cp_p = new CalabashCompartor(0);
    CalabashCompartor cp_n = new CalabashCompartor(1);
    CalabashCompartor cp_r = new CalabashCompartor(2);
    
    public void sort(CalabashList kids,int type) {
        switch (type){
            case 0:{
            //正序
                kids.sort(cp_p);
                break;
            }
            case 1:{
            //反序
                kids.sort(cp_n);
                break;
            }
            default:{
            //乱序
                kids.sort(cp_r);
            break;
            }
        }
    }
    public void divide_sort(){
        CalabashList boys = new CalabashList();
        CalabashList girls = new CalabashList();
        for(Calabash c:huluwas){
            if(c.sex==Sexual.MALE){
                boys.add(c);
            }
            else{
                girls.add(c);
            }
        }
        //TODO: sort boys
        System.out.println("----Boys Sort----");
        System.out.println("Before:");
        for(Calabash c:boys){
            c.NumberOff();
        }
        System.out.println(" ");
        sort(boys,2);
        System.out.println("After:");
        for(Calabash c:boys){
            c.NumberOff();
        }
        System.out.println(" ");
        //TODO:sort girls
        System.out.println("----Girls Sort----");
        System.out.println("Before:");
        for(Calabash c:girls){
            c.NumberOff();
        }
        System.out.println(" ");
        sort(girls,2);
        System.out.println("After:");
        for(Calabash c:girls){
            c.NumberOff();
        }
        System.out.println(" ");
    }
    void run(){
        System.out.println("choreography world:");

        System.out.println("----all sort positive----");
        System.out.println("Before:");
        for(Calabash c:huluwas){c.NumberOff();}
        System.out.println(" ");
        System.out.println("After:");
        sort(huluwas, 0);
        for(Calabash c:huluwas){c.NumberOff();}
        System.out.println(" ");

        System.out.println("----all sort negative----");
        System.out.println("After:");
        sort(huluwas, 1);
        for(Calabash c:huluwas){c.NumberOff();}
        System.out.println(" ");

        System.out.println("----all sort random----");
        System.out.println("After:");
        sort(huluwas, 2);
        for(Calabash c:huluwas){c.NumberOff();}
        System.out.println(" ");
        divide_sort();        
    }
}
