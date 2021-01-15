import java.util.*;

/**
 * 葫芦娃类，初始化时随机生成姓名和性别，能够报数，能够与另外一个葫芦娃在队伍中交换位置，
 * 也能够在队列中与其他葫芦娃合作，完成Choreography形式的排序
 */
public class CalabashBrother implements Comparable<CalabashBrother> {
    private final String name;
    enum Gender {
        MALE, FEMALE
    }
    private final Gender gender;

    CalabashBrother() {
        name = UUID.randomUUID().toString();
        int randomNumber = new Random(System.currentTimeMillis()).nextInt();
        if(randomNumber % 2 == 0) {
            gender = Gender.MALE;
        } else {
            gender = Gender.FEMALE;
        }
    }

    @Override
    public int compareTo(CalabashBrother o) {
        return this.name.compareTo(o.name);
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public void numberOff() {
        System.out.println("Name: " + name + ", Gender: " + gender.name());
    }

    public void swap(List<CalabashBrother> list, CalabashBrother o) {
        int thisIndex = list.indexOf(this);
        int otherIndex = list.indexOf(o);
        Collections.swap(list, thisIndex, otherIndex);
    }

    // Choreography形式的冒泡排序，与其他葫芦娃协同完成，不依赖于Sorter
    public void bubbleSort(List<CalabashBrother> list, int lastPosition,
                                 Comparator<CalabashBrother> comparator) {
        // 获取自己的位置
        int thisPosition = list.indexOf(this);
        // 如果自己不在可移动到的最后一个位置，并且自己比下一个位置的葫芦娃排行靠后，则和它交换位置
        CalabashBrother nextBrother = null;
        while(thisPosition < lastPosition &&
                comparator.compare(this, nextBrother = list.get(thisPosition + 1)) > 0) {
            swap(list, nextBrother);
        }
        // 如果循环结束后仍不在可移动到的最后一个位置，则向下一个葫芦娃传递消息，让它接替排序过程
        // 如果已经在最后一个位置，则当前趟结束，向队首的葫芦娃传递消息，让它开始下一趟排序
        if(thisPosition < lastPosition) {
            nextBrother.bubbleSort(list, lastPosition, comparator);
        } else if(lastPosition > 0) {
            list.get(0).bubbleSort(list, lastPosition - 1, comparator);
        }
    }

    // Choreography形式的快速排序，与其他葫芦娃协同完成，不依赖于Sorter
    public void quickSort(List<CalabashBrother> list, int left, int right, CalabashBrother base,
                          boolean forward, int vacancy, Comparator<CalabashBrother> comparator) {
        // 获取自己的位置
        int thisPosition = list.indexOf(this);
        // 如果排序进行到空位置旁边，则分治算法即将把队列分为两部分
        if(thisPosition + (forward ? 1 : -1) == vacancy) {
            // 通过与基准葫芦娃进行比较，结合当前排序的进行方向，判断是否交换位置
            if(comparator.compare(this, base) < 0 ^ forward) {
                swap(list, base);
            }

            // 分治的结束条件，即再分后的队列长度是否不大于1
            if(left < vacancy - 1) {
                CalabashBrother leftSuccessor = list.get(vacancy - 1);
                CalabashBrother leftBase = list.get(0);
                leftSuccessor.quickSort(list, left, vacancy - 1, leftBase,
                        false, 0, comparator);
            }
            if(vacancy + 1 < right) {
                CalabashBrother rightSuccessor = list.get(right);
                CalabashBrother rightBase = list.get(vacancy + 1);
                rightSuccessor.quickSort(list, vacancy + 1, right, rightBase,
                        false, vacancy + 1, comparator);
            }
        } else {
            // 通过与基准葫芦娃进行比较，结合当前排序的进行方向，判断是否交换位置
            // 如果交换位置，则葫芦娃的当前位置成为新的空位置，并且排序算法将从旧的空位置向反方向进行
            // 如果不交换位置，则排序算法顺当前方向进行到下一个葫芦娃
            if(comparator.compare(this, base) < 0 ^ forward) {
                swap(list, base);
                CalabashBrother successor = list.get(vacancy + (forward ? -1 : 1));
                successor.quickSort(list, left, right, base, !forward, thisPosition, comparator);
            } else {
                CalabashBrother successor = list.get(thisPosition + (forward ? 1 : -1));
                successor.quickSort(list, left, right, base, forward, vacancy, comparator);
            }
        }
    }
}
