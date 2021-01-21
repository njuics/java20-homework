package pers.lcy.hulu;

import java.util.Comparator;

/**
 * BrotherComparator比较两个葫芦娃的排行，如果第一个葫芦娃排行较小则返回值＞0
 */
public class BrotherComparator implements Comparator<CalabashBrother>{
    @Override
    public int compare(CalabashBrother o1, CalabashBrother o2) {
        return o1.getBirthOrder() - o2.getBirthOrder();
    }
}
