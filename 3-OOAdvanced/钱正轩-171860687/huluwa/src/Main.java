import cn.edu.nju.hulu.HuLuBrothers;
import cn.edu.nju.hulu.InsertSorter;
import cn.edu.nju.hulu.QuickSorter;
import cn.edu.nju.hulu.Grandpa;

public class Main {
    public static void main(String[] args) {
        HuLuBrothers huLuBrothers = HuLuBrothers.getHuLuBrothers();
        Grandpa grandpa = new Grandpa(new InsertSorter(), huLuBrothers);

        System.out.println("Sort by Orchestration");

        huLuBrothers.shuffle();
        huLuBrothers.print();
        grandpa.sortByOrchestration();
        huLuBrothers.print();

        grandpa.setSorter(new QuickSorter());

        huLuBrothers.shuffle();
        huLuBrothers.print();
        grandpa.sortByOrchestration();
        huLuBrothers.print();

        System.out.println("Sort by Choreography");

        huLuBrothers.shuffle();
        huLuBrothers.print();
        huLuBrothers.sortByChoreography();
        huLuBrothers.print();
    }
}
