package testing.src;


import java.util.*;

public class BattleField implements Iterable<Creature> {

    private ArrayList<HuluBro> bros=new ArrayList<>();

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

    public void reverseBros(){
        System.out.println(bros);
        Collections.reverse(bros);
        System.out.println(bros);
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
