// package java20homework.ooadvanced;

import java.util.Comparator;

public class SortMethodB extends Sort {
    //本类实现选择排序
    @Override
    public void sort(Calabash[] queue) {
        for (int i = 0; i < 7; ++i) {
            int curMin = i;
            for (int j = i + 1; j < 7; ++j) {
                if (queue[curMin].compareTo(queue[j]) < 0) continue;
                curMin = j;
            }
            if (curMin != i) queue[i].exchangePos(queue[curMin], queue);
        }
    }

    @Override
    public void sort(GrandPa grandPa) {
        Calabash[] queue = grandPa.getQueue();
        Comparator<Calabash> comparator = grandPa.getSortStandard();
        for (int i = 0; i < 7; ++i) {
            int curMin = i;
            for (int j = i + 1; j < 7; ++j) {
                if (comparator.compare(queue[curMin], queue[j]) < 0) continue;
                curMin = j;
            }
            if (curMin != i) grandPa.exchangePositions(queue[i], queue[curMin]);
        }
    }
}
