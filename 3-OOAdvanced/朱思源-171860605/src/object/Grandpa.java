package object;

import control.BubbleSort;
import control.Sorter;
import map.*;

public class Grandpa extends Creature {

    public Grandpa(){
        super("老爷爷");
    }

    public void sort(Queue que){
        BubbleSort bSort=new BubbleSort();
        bSort.sort(que);
    }

    public void changePos(Boy b1, Boy b2){
        b1.changePos(b2);
    }

    @Override
    public void info()
    {
        System.out.println("老爷爷 is ready to organize now...");
    }
}
