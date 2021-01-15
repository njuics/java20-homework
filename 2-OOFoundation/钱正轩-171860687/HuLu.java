import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class HuLuBrothers {
    private enum Name {
        ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, NULL
    }

    private class HuLuWa implements Comparable<HuLuWa> {
        private final Name name;
        private HuLuWa left;
        private HuLuWa right;

        public HuLuWa(Name name) {
            this.name = name;
            this.left = null;
            this.right = null;
        }

        /**
         * 和另一个葫芦娃交换位置
         * @param h 待交换的对象
         */
        public void swap(HuLuWa h) {
            if (this.equals(h)) {
                return;
            }
            HuLuWa al = this.left;
            HuLuWa ar = this.right;
            HuLuWa bl = h.left;
            HuLuWa br = h.right;
            if (ar.equals(h)) {
                al.right = h;
                h.left = al;
                h.right = this;
                this.left = h;
                this.right = br;
                br.left = this;
            } else if (br.equals(this)) {
                bl.right = this;
                this.left = bl;
                this.right = h;
                h.left = this;
                h.right = ar;
                ar.left = h;
            } else {
                this.left = bl;
                this.right = br;
                bl.right = this;
                br.left = this;
                h.left = al;
                h.right = ar;
                al.right = h;
                ar.left = h;
            }
        }

        /**
         * @return the left
         */
        public HuLuWa getLeft() {
            return left;
        }

        /**
         * @param left the left to set
         */
        public void setLeft(HuLuWa left) {
            this.left = left;
        }

        /**
         * @return the right
         */
        public HuLuWa getRight() {
            return right;
        }

        /**
         * @param right the right to set
         */
        public void setRight(HuLuWa right) {
            this.right = right;
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#toString()
         */

        @Override
        public String toString() {
            switch (this.name) {
                case ONE:
                    return "老大";
                case TWO:
                    return "老二";
                case THREE:
                    return "老三";
                case FOUR:
                    return "老四";
                case FIVE:
                    return "老五";
                case SIX:
                    return "老六";
                case SEVEN:
                    return "老七";
                default:
            }
            return "";
        }

        @Override
        public int compareTo(HuLuWa o) {
            return this.name.compareTo(o.name);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            return this.name.equals(((HuLuWa) obj).name);
        }

    }

    public interface SortFunc {
        <T extends Comparable<T>> void sort(List<T> list);
    }

    private static HuLuBrothers huLuBrothers;

    private final List<HuLuWa> hulu;

    private final HuLuWa bound = new HuLuWa(Name.NULL);

    private HuLuBrothers() {
        hulu = new ArrayList<>(Arrays.asList(new HuLuWa(Name.ONE), new HuLuWa(Name.TWO), new HuLuWa(Name.THREE),
                new HuLuWa(Name.FOUR), new HuLuWa(Name.FIVE), new HuLuWa(Name.SIX), new HuLuWa(Name.SEVEN)));
        shuffle();
    }

    /**
     * 根据容器内葫芦娃的顺序调整每个葫芦娃的邻接信息
     */
    private void setAdj() {
        for (int i = 0; i < hulu.size(); i++) {
            hulu.get(i).setLeft(i > 0 ? hulu.get(i - 1) : bound);
            hulu.get(i).setRight((i < hulu.size() - 1) ? hulu.get(i + 1) : bound);
        }
    }

    /**
     * 获取葫芦兄弟实例
     * @return 实例
     */
    public static HuLuBrothers getHuLuBrothers() {
        if (huLuBrothers == null) {
            huLuBrothers = new HuLuBrothers();
        }
        return huLuBrothers;
    }

    /**
     * 打乱葫芦娃的顺序
     */
    public void shuffle() {
        System.out.println("shuffling...");
        Collections.shuffle(hulu);
        setAdj();
    }

    /**
     * 交换葫芦娃的位置
     * @param a 待交换的位置
     * @param b 待交换的位置
     */
    public void swap(int a, int b) {
        hulu.get(a).swap(hulu.get(b));
        Collections.swap(hulu, a, b);
    }

    /**
     * 比较两个葫芦娃
     * @param a 待比较的位置
     * @param b 待比较的位置
     * @return 比较结果
     */
    public int compare(int a, int b) {
        return hulu.get(a).compareTo(hulu.get(b));
    }

    /**
     * 返回葫芦娃总数
     * @return 葫芦娃总数
     */
    public int getNumber() {
        return 7;
    }

    /**
     * 将葫芦娃按序打印
     */
    public void print() {
        System.out.println("==========报数==========");
        HuLuWa head = null;
        for (HuLuWa h : hulu) {
            if (h.getLeft().equals(bound)) {
                head = h;
            }
        }
        if (head == null) {
            System.out.println("Error!");
            return;
        }
        while (!head.equals(bound)) {
            System.out.println(head);
            head = head.getRight();
        }
    }

    /**
     * 默认的排序函数，实现插入排序算法
     * @param <T> 待排序的类型，需要实现 Comparable
     * @param list 待排序的对象的集合
     */
    private static <T extends Comparable<T>> void defaultSort(List<T> list) {
        if (list.size() < 2) {
            return;
        }
        for (int i = 1; i < list.size(); i++) {
            T key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).compareTo(key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    /**
     * 根据提供的函数对葫芦娃排序
     * @param func 排序函数
     */
    public void sortByAlgorithm(SortFunc func) {
        func.sort(hulu);
        setAdj();
    }

    /**
     * 使用默认函数对葫芦娃排序
     */
    public void sortByAlgorithm() {
        sortByAlgorithm(HuLuBrothers::defaultSort);
    }

    /**
     * 葫芦娃自己协作完成排序
     */
    public void sortByChoreography() {
        boolean flag = true;
        for (HuLuWa h : hulu) {
            flag = true;
            while (flag) {
                if (!h.getLeft().equals(bound) && h.compareTo(h.getLeft()) < 0) {
                    h.swap(h.getLeft());
                } else if (!h.getRight().equals(bound) && h.compareTo(h.getRight()) > 0) {
                    h.swap(h.getRight());
                } else {
                    flag = false;
                }
            }
        }
    }
}

class Grandpa {
    private final HuLuBrothers huLuBrothers;

    public Grandpa() {
        huLuBrothers = HuLuBrothers.getHuLuBrothers();
    }

    private void quickSort(int start, int end) {
        if (start < end) {
            int pivot = end;
            int i = start - 1;
            for (int j = start; j < end; j++) {
                if (huLuBrothers.compare(j, pivot) < 0) {
                    i++;
                    huLuBrothers.swap(i, j);
                }
            }
            huLuBrothers.swap(i + 1, end);
            int q = i + 1;
            quickSort(start, q - 1);
            quickSort(q + 1, end);
        }
    }

    /**
     * 调度葫芦娃排序
     */
    public void sortByOrchestration() {
        int n = huLuBrothers.getNumber();
        quickSort(0, n - 1);
    }
}

public class HuLu {
    private static <T extends Comparable<T>> void quickSort(List<T> list) {
        quickSort(list, 0, list.size() - 1);
    }

    private static <T extends Comparable<T>> void quickSort(List<T> list, int start, int end) {
        if (start < end) {
            T pivot = list.get(end);
            int i = start - 1;
            for (int j = start; j < end; j++) {
                if (list.get(j).compareTo(pivot) < 0) {
                    i++;
                    Collections.swap(list, i, j);
                }
            }
            Collections.swap(list, i + 1, end);
            int q = i + 1;
            quickSort(list, start, q - 1);
            quickSort(list, q + 1, end);
        }
    }

    public static void main(String[] args) {
        // Sort By Algorithm
        System.out.println("Sort By Algorithm");
        HuLuBrothers huLuBrothers = HuLuBrothers.getHuLuBrothers();
        huLuBrothers.shuffle();
        huLuBrothers.print();
        // huLuBrothers.sortByAlgorithm();
        huLuBrothers.sortByAlgorithm(HuLu::quickSort);
        huLuBrothers.print();

        // Sort By Orchestration
        System.out.println("Sort By Orchestration");
        Grandpa grandpa = new Grandpa();
        huLuBrothers.shuffle();
        huLuBrothers.print();
        grandpa.sortByOrchestration();
        huLuBrothers.print();

        // Sort By Choreography
        System.out.println("Sort By Choreography");
        huLuBrothers.shuffle();
        huLuBrothers.print();
        huLuBrothers.sortByChoreography();
        huLuBrothers.print();
    }
}