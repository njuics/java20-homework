import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuluList {
    public Hulu[] huluBrothers;

    public HuluList() {
        huluBrothers = new Hulu[]{
                new Hulu("老大", 1), new Hulu("老二", 2),
                new Hulu("老三", 3), new Hulu("老四", 4),
                new Hulu("老五", 5), new Hulu("老六", 6),
                new Hulu("老幺", 7)
        };
    }

    public void countOff() {
        for (int i = 0; i < huluBrothers.length; ++i) {
            System.out.print(huluBrothers[i].getName() + " ");
        }
        System.out.println();
    }

    public void shuffle() {
        List huluList = new ArrayList();
        for (int i = 0; i < huluBrothers.length; ++i) {
            huluList.add(huluBrothers[i]);
        }
        Collections.shuffle(huluList);
        for (int i = 0; i < huluList.size(); ++i) {
            huluBrothers[i] = (Hulu) huluList.get(i);
        }
        countOff();
    }

    public void swap(int i, int j) {
        Hulu temp = new Hulu("temp", 0);
        temp = huluBrothers[i];
        huluBrothers[i] = huluBrothers[j];
        huluBrothers[j] = temp;
    }

    private void bubbleSort() {
        for (int i = 0; i < huluBrothers.length - 1; ++i) {
            for (int j = 0; j < huluBrothers.length - 1 - i; ++j) {
                if (huluBrothers[j].compare(huluBrothers[j + 1])) {
                    swap(j, j + 1);
                }
            }
        }
    }

    public void choreography() {
        bubbleSort();
        countOff();
        System.out.println();
    }
}

class Hulu {
    private String name;
    private int rank;

    public Hulu(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    public boolean compare(Hulu a) {
        return this.rank > a.rank;
    }

    public int getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }
}
