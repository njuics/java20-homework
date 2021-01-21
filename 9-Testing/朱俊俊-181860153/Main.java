import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args){
        Grandpa grandpa = new Grandpa();
        ArrayList<Calabash>calabashArrayList = grandpa.getCalabash();

        new Sort<Calabash, Comparator<Calabash>>().sort(calabashArrayList,grandpa.random());
        System.out.println(calabashArrayList);
        new Sort<Calabash, Comparator<Calabash>>().sort(calabashArrayList,grandpa);
        System.out.println(calabashArrayList);
        new Sort<Calabash, Comparator<Calabash>>().sort(calabashArrayList,grandpa.reversed());
        System.out.println(calabashArrayList);

    }
}
