import java.util.ArrayList;
import java.util.List;

/**
 * 程序入口，演示各种方式的排序
 */
public class CollectionSort {
    private static final int nCalabashBrothers = 100;

    public static void main(String[] args) {
        // 构建问题初始情景，创建一列随机排列的葫芦娃，以及葫芦娃们的爷爷
        ArrayList<CalabashBrother> queue = new ArrayList<>();
        for(int i = 0; i < nCalabashBrothers; i++) {
            queue.add(new CalabashBrother());
        }
        Grandpa grandpa = new Grandpa();
        // 以字典序正序，使用冒泡排序对葫芦娃排序，输出排序结果
        grandpa.setSorter(new BubbleSorter(CalabashBrother::compareTo));
        grandpa.sort(queue);
        System.out.println("Ascending sort result:");
        queue.forEach(CalabashBrother::numberOff);
        // 用字典序逆序重新排序，这次用快速排序
        grandpa.setSorter(new QuickSorter(new DescendingComparator()));
        grandpa.sort(queue);
        System.out.println("Descending sort result:");
        queue.forEach(CalabashBrother::numberOff);
        // 用乱序排序，仍然用快速排序
        grandpa.setSorter(new QuickSorter(new RandomComparator()));
        grandpa.sort(queue);
        System.out.println("Random sort result:");
        queue.forEach(CalabashBrother::numberOff);
        // 将葫芦娃分为两个队伍，再进行正序排序，这次让葫芦娃们自己排序
        List<CalabashBrother> maleQueue = GenderFilter.filter(queue, CalabashBrother.Gender.MALE);
        List<CalabashBrother> femaleQueue = GenderFilter.filter(queue, CalabashBrother.Gender.FEMALE);
        maleQueue.get(0).bubbleSort(maleQueue, maleQueue.size() - 1, CalabashBrother::compareTo);
        femaleQueue.get(femaleQueue.size() - 1).quickSort(femaleQueue, 0, femaleQueue.size() - 1,
                femaleQueue.get(0), false, 0, CalabashBrother::compareTo);
        System.out.println("Male ascending sort result:");
        maleQueue.forEach(CalabashBrother::numberOff);
        System.out.println("Female ascending sort result:");
        femaleQueue.forEach(CalabashBrother::numberOff);
    }
}
