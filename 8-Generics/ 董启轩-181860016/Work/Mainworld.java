import java.util.*;

public class Mainworld{
    private static final int EveryCreatureNum=6;
    public static void print(List<? extends Creature> list){
        for(int i=0;i<list.size();i++){
            Object temp=list.get(i);
            if(temp.getClass().equals(Monster.class)){
                Monster monster=(Monster) temp;
                monster.printInformation();
            }
            else if(temp.getClass().equals(CalabashBrother.class)){
                CalabashBrother bro=(CalabashBrother) temp;
                bro.printInformation();
            }
            else {
                Creature c=(Creature)temp;
                c.printInformation();
            }
        }
    }
    public static void main(String[] args){
        List<Creature> list=new ArrayList<>();
        for(int i=0;i<EveryCreatureNum;i++){
            list.add(new Monster());
            list.add(new CalabashBrother());
        }
        ComparatorT ct=new ComparatorT();
        System.out.println("Before sort;");
        print(list);
        ct.DOSort(list);
        System.out.println("After positive sort:");
        print(list);
        ct.set_order(Order.NEGATIVE);
        ct.DOSort(list);
        System.out.println("After negative sort:");
        print(list);
        ct.set_order(Order.RANDOM);
        ct.DOSort(list);
        System.out.println("After random sort:");
        print(list);
    }
}