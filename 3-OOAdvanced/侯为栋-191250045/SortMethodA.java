// package java20homework.ooadvanced;

import java.util.Comparator;

public class SortMethodA extends Sort {
    //本类实现冒泡排序
    @Override
    public void sort(Calabash[] queue) {
        for (int i = 6; i >= 0; --i) {
            for (int j = 0; j < i; ++j) {
                if (queue[j].compareTo(queue[i]) < 0) continue;
                queue[j].exchangePos(queue[i], queue);
            }
        }
    }

    @Override
    public void sort(GrandPa grandPa) {
        Calabash[] queue = grandPa.getQueue();
        Comparator<Calabash> comparator = grandPa.getSortStandard();
        for (int i = 6; i >= 0; --i) {
            for (int j = 0; j < i; ++j) {
                if (comparator.compare(queue[j], queue[i]) < 0) continue;
                grandPa.exchangePositions(queue[i], queue[j]);
            }
        }
    }
}
