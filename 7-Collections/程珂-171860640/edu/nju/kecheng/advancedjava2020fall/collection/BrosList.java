package edu.nju.kecheng.advancedjava2020fall.collection;

import java.util.*;
import static java.util.Collections.*;

public class BrosList implements Iterable<HuluBro> {
    private ArrayList<HuluBro> bros=new ArrayList<>();
    private TreeSet<HuluBro> femaleBros=new TreeSet<>(new BroComparator());
    private TreeSet<HuluBro> maleBros=new TreeSet<>(new BroComparator());
    public BrosList(){
        for(int i=0;i<HuluBro.COLOR_MAX_NUM;i++){
            HuluBro bro=HuluBro.getHuluBro();
            bros.add(bro);
            if(bro.getGender()==Gender.MALE)maleBros.add(bro);
            else femaleBros.add(bro);
        }
        sort(bros);
    }

    private class BrosIterator implements Iterator<HuluBro>{
        Iterator<HuluBro> brosIterator=bros.iterator();
        @Override
        public boolean hasNext(){
            return brosIterator.hasNext();
        }
        @Override
        public HuluBro next(){
            return brosIterator.next();
        }
        @Override
        public void remove(){
            brosIterator.remove();
        }
    }

    @Override
    public Iterator<HuluBro> iterator(){
        return new BrosIterator();
    }

    public void reversePrintBros(){
        reverse(bros);
        System.out.println(bros);
    }

    public void orderPrintBros(){
        sort(bros);
        System.out.println(bros);
    }

    public void shufflingPrintBros(){
        shuffle(bros);
        System.out.println(bros);
    }

    public void reversePrintMaleBros(){
        System.out.println(maleBros.descendingSet());
    }

    public void orderPrintMaleBros(){
        System.out.println(maleBros);
    }

    public void shufflingPrintMaleBros(){
        List<HuluBro> temp=new ArrayList<>(maleBros);
        shuffle(temp);
        System.out.println(temp);
    }

    public void reversePrintFemaleBros(){
        System.out.println(maleBros.descendingSet());
    }

    public void orderPrintFemaleBros(){
        System.out.println(femaleBros);
    }

    public void shufflingPrintFemaleBros(){
        List<HuluBro> temp=new ArrayList<>(femaleBros);
        shuffle(temp);
        System.out.println(temp);
    }
}
