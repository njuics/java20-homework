package cn.edu.nju.java;

import java.util.List;
import cn.edu.nju.java.actor.CalabashBrother;

public interface SortStrategy {
    public void sort(List<CalabashBrother> queue);
}
