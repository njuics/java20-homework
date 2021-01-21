package control;

import java.util.ArrayList;
import java.util.Random;

import model.*;
import factory.*;
public class Main {
    private static int CalabashNum = 20;
    private static Random rand = new Random();
    public static void main(String[] args){
        CalabashGroup group = new CalabashGroup();
        CalabashFactory calabashFactory = new CalabashFactory();
        String[] nameList = "z,x,c,v,b,n,m,a,s,d,f,g,h,j,k,l,q,w,e,r,t,y,u,i,o,p".split(",");
        String[] kindList = {"Calabash","StrongCalabash","FireCalabash","WaterCalabash"};
        String[] params = new String[3];
        for(int i=0;i<CalabashNum;i++){
            params[0] = kindList[rand.nextInt(kindList.length)];
            params[1] = nameList[i];
            params[2] = rand.nextInt(2)==0?"male":"female";
            group.insert(calabashFactory.create(params));
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


