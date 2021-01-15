import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;


enum Gender{
    male(0),female(1);
    private int value;
    Gender(int v){
        value = v;
    }
    @Override
    public String toString(){
        return value==0?"male":"female";
    }
}

class CalabashBoy implements Comparable<CalabashBoy>{
    private String name;
    private Gender gender;

    CalabashBoy(){
        this.name = genName();
        this.gender = genGender();
    }

    String getName(){
        return this.name;
    }

    Gender getGender(){
        return this.gender;
    }

    @Override
    public int compareTo(CalabashBoy b){
        return this.name.compareTo(b.getName());
    }

    @Override
    public String toString(){
        return this.name+" "+this.gender.toString();
    }

    private String genName(){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        int length=random.nextInt(10) + 5;
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    private Gender genGender(){
        Random random=new Random();
        return random.nextInt(2)==0?Gender.male:Gender.female;
    }
}

class posiCmp implements Comparator<CalabashBoy>{
    @Override
    public int compare(CalabashBoy a,CalabashBoy b){
        return a.getName().compareTo(b.getName());
    }
}

class negaCmp implements Comparator<CalabashBoy>{
    @Override
    public int compare(CalabashBoy a,CalabashBoy b){
        return b.getName().compareTo(a.getName());
    }
}

class randCmp implements Comparator<CalabashBoy>{
    @Override
    public int compare(CalabashBoy a,CalabashBoy b){
        Random random = new Random();
        return random.nextInt();
    }
}

class CalabashBoyCollection implements Iterable<CalabashBoy>{
    ArrayList<CalabashBoy> CBList = new ArrayList<CalabashBoy>();
    int numOfCB;

    public CalabashBoyCollection(int n){
        numOfCB = n;
        for(int i=0;i<n;i++)
            CBList.add(new CalabashBoy());
    }

    public CalabashBoyCollection(){
        numOfCB = 0;
    }

    public void insert(CalabashBoy c){
        numOfCB++;
        CBList.add(c);
    }

    public CalabashBoyCollection divideByGender(Gender gender){
        CalabashBoyCollection ret = new CalabashBoyCollection();
        Iterator<CalabashBoy> it=CBList.iterator();
        while(it.hasNext()){
            CalabashBoy c = it.next();
            if(c.getGender()==gender)
                ret.insert(c);
        }
        return ret;
    }

    public void forPrint(){
        Iterator<CalabashBoy> it=CBList.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    public void sort(){
        System.out.println("sort by comparator");
        System.out.println("positive:");
        Collections.sort(CBList,new posiCmp());
        forPrint();
        System.out.println();

        System.out.println("negative");
        Collections.sort(CBList,new negaCmp());
        forPrint();
        System.out.println();

        System.out.println("random");
        Collections.sort(CBList,new randCmp());
        forPrint();
        System.out.println();

        System.out.println("sort by comparable");
        System.out.println("positive:");
        Collections.sort(CBList);
        forPrint();
        System.out.println();

        System.out.println("negative");
        Collections.sort(CBList,Collections.reverseOrder());
        forPrint();
        System.out.println();

        System.out.println("random");
        Collections.shuffle(CBList);
        forPrint();
        System.out.println();
    }
}

public class CalabashBoysSort {
    public static void main(String[] args) {
        CalabashBoyCollection CBC = new CalabashBoyCollection(10);
        CBC.sort();

        System.out.println("male");
        CalabashBoyCollection CBCmale = CBC.divideByGender(Gender.male);
        CBCmale.sort();

        System.out.println("female");
        CalabashBoyCollection CBCfemale = CBC.divideByGender(Gender.female);
        CBCfemale.sort();
    }
}