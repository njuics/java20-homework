package homework_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HuluBro <T extends Creature>{
    private ArrayList<T> queBro;
    public HuluBro(int queLength,HuluwaFactory<T> factory){
        queBro = new ArrayList<T>();
        for(int i=0;i<queLength;++i){
            queBro.add(factory.create());
        }
    }

    public void sortByComparable(int order){
        for(int i=0;i<queBro.size();++i){
            queBro.get(i).selectOrder(order);
        }
        Collections.sort(this.queBro);
    }

    public void sortByComparator(int order){
        Collections.sort(this.queBro,(Comparator<T>)Huluwa.getComparator(order));
    }

    public void print(int order){
        switch (order){
            case 1:
                System.out.println("--------升序--------");
                break;
            case 2:
                System.out.println("--------降序--------");
                break;
            case 3:
                System.out.println("--------乱序--------");
                break;
            default:
                break;
        }
        System.out.println("male:");
        for(int i=0;i<queBro.size()-1;++i){
            System.out.print(queBro.get(i).getName()+"\t");
            if(queBro.get(i).getGender()!=queBro.get(i+1).getGender()){
                System.out.println("\nfemale:");
            }
        }
        System.out.print(queBro.get(queBro.size()-1).getName()+"\t");
        System.out.println("\n");
    }

    public void myShuffle(){
        System.out.println("--------shuffle--------");
        Collections.shuffle(queBro);
    }
}
