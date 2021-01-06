package homework_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Hulu implements Comparable<Hulu>{
    int pos;
    String name;
    Hulu(int p,String c){
        pos = p;
        name = c;
    }
    @Override
    public int compareTo(Hulu hulu){
        if(hulu.pos > this.pos)
            return -1;
        else if(hulu.pos < this.pos)
            return 1;
        else
            return 0;
    }
}

class GrandFather{
    ArrayList<Integer> rank;
    GrandFather(){
        rank = new ArrayList<Integer>();
        for(int i=0;i<7;++i){
            rank.add(i);
        }
    }
    public ArrayList<Hulu> sort(ArrayList<Hulu> brothers){
        for(int i=0;i<rank.size();++i){
            for(int j=i;j<brothers.size();++j){
                if(brothers.get(j).pos==rank.get(i)){
                    Collections.swap(brothers,i,j);
                    break;
                }
            }
        }
        return brothers;
    }
}

public class HuluSort {
    ArrayList<String> name;
    ArrayList<Hulu> brothers;
    public HuluSort(){
        name = new ArrayList<String>(Arrays.asList("老大","老二","老三","老四","老五","老六","老七"));
        brothers = new ArrayList<Hulu>();
        for(int i=0;i<7;++i){
            brothers.add(new Hulu(i, name.get(i)));
        }
        Collections.shuffle(brothers);
    }

    public void sort(){
        for(int i=0;i<brothers.size();++i){
            Collections.swap(brothers, i, brothers.get(i).pos);
        }
    }

    public void print(){
        for(int i=0;i<brothers.size();++i){
            System.out.printf("%s ",brothers.get(i).name);
        }
        System.out.print("\n");
    }

    public static void main(String[] args) throws Exception{
        HuluSort hulusort = new HuluSort();
        String sortModel = args[0];
        switch (sortModel){
            case "1": {
                System.out.print("协同排序 \n");
                System.out.print("排序前: \t");
                hulusort.print();
                hulusort.sort();
                System.out.print("排序后： \t");
                hulusort.print();
                break;
            }
            case "2": {
                System.out.print("编排排序 \n");
                GrandFather father = new GrandFather();
                Collections.shuffle(hulusort.brothers);
                System.out.print("排序前： \t");
                hulusort.print();
                hulusort.brothers = father.sort(hulusort.brothers);
                System.out.print("排序后： \t");
                hulusort.print();
                break;
            }
            default:{
                System.out.print("算法替换 \n");
                Collections.shuffle(hulusort.brothers);
                System.out.print("排序前： \t");
                hulusort.print();
                Collections.sort(hulusort.brothers);
                System.out.print("排序后： \t");
                hulusort.print();
            }
        }
    }
}
