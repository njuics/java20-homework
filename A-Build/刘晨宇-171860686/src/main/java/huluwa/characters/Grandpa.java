package huluwa.characters;

import java.util.Comparator;
import java.util.List;

import huluwa.tools.Sorter;

/**
 * 老爷爷类，它的行为是对葫芦娃们组成的队列进行排序，该工作实际上委托给Sorter完成，
 * 只需要set不同的Sorter，就可以以不同的方式来完成排序
 */
public class Grandpa extends Character {
    public Grandpa() {
        this.name = "Grandpa";
        this.gender = Gender.MALE;
    }

    private Sorter sorter;

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    public void sort(List<CalabashBrother> list, Comparator<? super CalabashBrother> comparator) {
        sorter.sort(list, comparator);
    }
}
