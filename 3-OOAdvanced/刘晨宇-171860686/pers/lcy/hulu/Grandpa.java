package pers.lcy.hulu;

import java.util.ArrayList;

/**
 * Grandpa类是对葫芦娃们的爷爷的抽象，目前问题中的爷爷还不具有状态，因此该类也没有属性；
 * 爷爷的行为是以编排的形式对葫芦娃们组成的队列进行排序(冒泡排序或快速排序)，实现中实际采用了
 * 委托的方式，对排序方法的调用直接转交到合成Grandpa类的OrchestrationSorter类对象实现
 */
public class Grandpa {
    private BrotherComparator bComparator = new BrotherComparator();

    private Sorter<CalabashBrother> oSorter = new OrchestrationSorter<>(bComparator);

    public void bubbleSort(ArrayList<CalabashBrother> givenQueue) {
        oSorter.bubbleSort(givenQueue);
    }

    public void quickSort(ArrayList<CalabashBrother> givenQueue) {
        oSorter.quickSort(givenQueue);
    }
}
