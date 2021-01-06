package Collections;

/**
 * 葫芦娃管理类接口，定义了添加、排序和打印三种方法
 */
public interface HuluwaController {

    void addHuluwa(Huluwa h);

    /**
     * 对葫芦娃数组进行排序的方法，可以有多种实现方法
     * @param reverse 若为true，则按字典序从小到大排序；若为false，从大到小排序
     */
    void sortHuluwa(boolean reverse);

    void printHuluwa();

}
