import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class Main {
    public static void main(String[] args){
        Grandpa grandpa = new Grandpa();
        ArrayList<Calabash>calabashArrayList = grandpa.getCalabash();

        new Sort<Calabash, Comparator<Calabash>>().sortAndShow(calabashArrayList,grandpa.random());
        new Sort<Calabash, Comparator<Calabash>>().sortAndShow(calabashArrayList,grandpa);
        new Sort<Calabash, Comparator<Calabash>>().sortAndShow(calabashArrayList,grandpa.reversed());
    }
}
