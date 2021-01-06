package homework_7;

import java.util.ArrayList;
import java.util.Collections;

public class HuluBro {
    private ArrayList<Huluwa> queBro;
    public HuluBro(int queLength){
        queBro = new ArrayList<Huluwa>();
        for(int i=0;i<queLength;++i){
            queBro.add(new Huluwa());
        }
    }
    public void sortByComparable(int order){
        for(int i=0;i<queBro.size();++i){
            queBro.get(i).selectOrder(order);
        }
        Collections.sort(this.queBro);
    }

    public void sortByComparator(int order){
        Collections.sort(this.queBro,Huluwa.getComparator(order));
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
