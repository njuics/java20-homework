import util.Compare;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class GrandPa<T extends Creature> implements God<T> {

    private GodQueue<T> all;
    private Comparator<T> comparator;

    public GrandPa(GodQueue<T> all) {
        this.all = all;
        this.comparator = (o1, o2) -> Compare.dict(o1.getName(), o2.getName());
    }

    @Override
    public void yellAll() {
        System.out.println(all);
    }

    @Override
    public void yellBoys() {
        Iterator<T> iterator = this.all.iterator();
        while (iterator.hasNext()) {
            T cur = iterator.next();
            if (cur.getSex().equals("boy"))
                System.out.println(cur);
        }
    }

    @Override
    public void yellGirls() {
        Iterator<T> iterator = this.all.iterator();
        while (iterator.hasNext()) {
            T cur = iterator.next();
            if (cur.getSex().equals("girl"))
                System.out.println(cur);
        }
    }

    @Override
    public void sort(GodQueue<T> queue) {
        List<T> tmpList = new ArrayList<>();
        while (true) {
            Iterator<T> iterator = queue.iterator();
            if (!iterator.hasNext())
                break;
            T curEdge = null;
            while (iterator.hasNext()) {
                T tmp = iterator.next();
                if (curEdge == null || (this.compare(tmp, curEdge) < 0)) {
                    curEdge = tmp;
                }
            }
            tmpList.add(curEdge);
            queue.remove(curEdge);
        }
        queue.setArray(tmpList);
    }

    @Override
    public void shuffle(GodQueue<T> queue) {
        List<T> array = queue.getArray();
        Collections.shuffle(array);
        queue.setArray(array);
    }

    @Override
    public int compare(T o1, T o2) {
        return this.comparator.compare(o1, o2);
    }
}
