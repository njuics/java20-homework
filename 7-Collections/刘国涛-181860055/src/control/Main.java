package control;
import java.util.ArrayList;
import java.util.Random;

import model.*;
public class Main {
    private static int CalabashNum = 20;
    private static Random rand = new Random();
    public static void main(String[] args){
        CalabashGroup group = new CalabashGroup();
        String[] nameList = "z,x,c,v,b,n,m,a,s,d,f,g,h,j,k,l,q,w,e,r,t,y,u,i,o,p".split(",");
        for(int i=0;i<CalabashNum;i++){
            group.insert(new Calabash(nameList[i],rand.nextInt(2)==0));
        }

        group.print();
        group.sort(0);group.print();
        group.sort(1);group.print();
        group.sort(2);group.print();

        ArrayList<CalabashGroup> boysAndGirls = group.divideByGender();
        boysAndGirls.get(0).print();
        boysAndGirls.get(1).print();
    }
}


