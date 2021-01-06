package generics;

import java.util.*;

public class BattleField implements Iterable<Creature> {

    private TreeSet<HuluBro> bros=new TreeSet<>( new BroComparator());

    public BattleField(){
        for(int i=0;i<HuluBro.COLOR_MAX_NUM;i++){
            HuluBro bro=HuluBro.getHuluBro();
            bros.add(bro);
        }
    }

    private class CreaturesIterator implements Iterator<HuluBro>{
        Iterator<HuluBro> creaturesIterator=bros.iterator();
        @Override
        public boolean hasNext(){
            return creaturesIterator.hasNext();
        }
        @Override
        public HuluBro next(){
            return creaturesIterator.next();
        }
        @Override
        public void remove(){
            creaturesIterator.remove();
        }
    }

    @Override
    public Iterator iterator(){
        return new CreaturesIterator();
    }


    public void reversePrintCretures(){
        System.out.println(bros.descendingSet());
    }

    public void orderPrintCretures(){
        System.out.println(bros);
    }

}
