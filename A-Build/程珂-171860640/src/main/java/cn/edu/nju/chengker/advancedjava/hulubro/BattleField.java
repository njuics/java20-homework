package cn.edu.nju.chengker.advancedjava.hulubro;

import org.apache.commons.collections4.list.GrowthList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BattleField implements Iterable<Creature> {

    private List<HuluBro> bros=new GrowthList<>(HuluBro.COLOR_MAX_NUM);

    public BattleField(){
        for(int i=0;i<HuluBro.COLOR_MAX_NUM;i++){
            HuluBro bro=HuluBro.getHuluBro();
            bros.add(bro);
        }
    }

    private class CreaturesIterator implements Iterator<HuluBro> {
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

    public void reverseBros(){
        Collections.reverse(bros);
    }

    public void sortBros(){
        Collections.sort(bros);
    }

    public String toString(){
        String str="[";
        for(int i=0;i<bros.size()-1;i++)str+=bros.get(i).name+",";
        str+=bros.get(bros.size()-1).name+"]";
        return str;

    }

}

