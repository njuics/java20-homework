// package java20homework.collections;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@Getter
public class GrandPa implements Comparator<Calabash> {
    private GrandQueue<Calabash> calabashes;
    private GrandQueue<Calabash> boys;
    private GrandQueue<Calabash> girls;

    public GrandPa(int size) {
        List<Calabash> tmpList = new ArrayList<>();
        for (int i = 0; i < size; ++i) tmpList.add(new Calabash());
        this.calabashes = new GrandQueue<>(tmpList);
        this.boys = null;
        this.girls = null;
    }

    public void classify() {
        Iterator<Calabash> iterator = this.calabashes.iterator();
        List<Calabash> listA = new ArrayList<>();
        List<Calabash> listB = new ArrayList<>();
        while (iterator.hasNext()) {
            Calabash cur = iterator.next();
            if (cur.getSex().equals("boy")) listA.add(cur);
            else listB.add(cur);
        }
        this.boys = new GrandQueue<>(listA);
        this.girls = new GrandQueue<>(listB);
    }

    public void sort(GrandQueue<Calabash> grandQueue, boolean reversed) {
        List<Calabash> tmpList = new ArrayList<>();
        while (true) {
            Iterator<Calabash> iterator = grandQueue.iterator();
            if (!iterator.hasNext()) break;
            Calabash curEdge = null;
            while (iterator.hasNext()) {
                Calabash tmp = iterator.next();
                if (curEdge == null || ((this.compare(tmp, curEdge) < 0) != reversed)) {
                    curEdge = tmp;
                }
            }
            tmpList.add(curEdge);
            grandQueue.remove(curEdge);
        }
        grandQueue.setArray(tmpList);
    }

    public void yellAll() {
        System.out.println("All!");
        System.out.println(this.calabashes);
    }

    public void yellBoys() {
        System.out.println("Boys! ");
        System.out.println(this.boys);
    }

    public void yellGirls() {
        System.out.println("Girls! ");
        System.out.println(this.girls);
    }

    @Override
    public int compare(Calabash o1, Calabash o2) {
        return o1.compareTo(o2);
    }

    public static void main(String[] args) {
        GrandPa grandpa = new GrandPa(20);
        grandpa.yellAll();
        grandpa.sort(grandpa.getCalabashes(), false);
        grandpa.yellAll();
        grandpa.getCalabashes().shuffle();
        grandpa.classify();
        grandpa.sort(grandpa.getBoys(), false);
        grandpa.sort(grandpa.getGirls(), false);
        grandpa.yellBoys();
        grandpa.yellGirls();
    }
}
