package order;

import java.util.Random;

public class ranStrategy<T extends Comparable<T>> extends orderStrategy<T>{
    static private Random random = new Random();
    @Override
    public int compare(T a,T b){
        return random.nextInt(3)-2;
    }
}

