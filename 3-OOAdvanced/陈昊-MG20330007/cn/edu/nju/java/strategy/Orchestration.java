package cn.edu.nju.java.strategy;

import java.util.List;
import cn.edu.nju.java.SortStrategy;
import cn.edu.nju.java.actor.CalabashBrother;
import cn.edu.nju.java.actor.GrandFather;

public class Orchestration implements SortStrategy{
    private GrandFather gfather;

    public Orchestration(GrandFather gfather) {
        this.gfather = gfather;
    }

    @Override
    public void sort(List<CalabashBrother> queue) {
        gfather.instruct(queue);
    }
}
