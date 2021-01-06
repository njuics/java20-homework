package cn.edu.nju.java.strategy;

import java.util.List;
import cn.edu.nju.java.SortStrategy;
import cn.edu.nju.java.actor.CalabashBrother;

public class Choreography implements SortStrategy {
    @Override
    public void sort(List<CalabashBrother> queue) {
        queue.sort((b1, b2) -> b1.compareTo(b2));
    }
}
