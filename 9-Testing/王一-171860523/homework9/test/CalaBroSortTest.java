package homework9.test;

import homework9.CalaBro;
import homework9.sort.CalaAllSort;
import homework9.sort.CalaSexSort;
import homework9.sort.MySort;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CalaBroSortTest {
    private static int calaBroNum;
    @BeforeClass
    public static void init() {
        Random random = new Random();
        calaBroNum = random.nextInt(20) + 1; // [1,20]个葫芦娃
        for(int i = 0; i < calaBroNum; ++i)
            new CalaBro();
        System.out.println("诞生了" + calaBroNum + "个葫芦娃");
    }
    @Test
    public void testCalaBroNum() throws Exception{
        if (calaBroNum < 1 || calaBroNum > 20)
            throw new Exception("葫芦娃数目异常: " + calaBroNum);
    }
    /**
     * 判断传入的数组是否服从指定顺序
     * @throws Exception
     */
    @Test
    public void testSort() throws Exception {
        System.out.println("========Testing Srot========");
        System.out.println("  ======全体排序======");
        MySort allSort = new CalaAllSort();
        System.out.println("    ====正序====");
        if (judgeOrder(allSort.sort(CalaBro.calaBroList, 1), 1))
            System.out.println("    顺序无问题");
        else
            throw new Exception("全排序正序顺序出错！");
        System.out.println("    ====逆序====");
        if (judgeOrder(allSort.sort(CalaBro.calaBroList, -1), -1))
            System.out.println("    顺序无问题");
        else
            throw new Exception("全排序逆序顺序出错！");

        System.out.println("  ======性别排序======");
        MySort sexSort = new CalaSexSort();
        List<CalaBro> maleList;
        List<CalaBro> femaleList;
        System.out.println("    ====正序====");
        List<CalaBro> list = sexSort.sort(CalaBro.calaBroList, 1);
        if (judgeSex(list))
            System.out.println("    性别队列划分无问题");
        else
            throw new Exception("按性别排序正序性别队列划分出错！");
        maleList = list.stream()
                .filter((CalaBro cb) -> cb.getSex().equals("Male"))
                .collect(Collectors.toList());
        femaleList = list.stream()
                .filter((CalaBro cb) -> cb.getSex().equals("Female"))
                .collect(Collectors.toList());
        if (judgeOrder(maleList, 1))
            System.out.println("    男性序列顺序无问题");
        else
            throw new Exception("性别排序男性队列正序顺序出错！");
        if (judgeOrder(femaleList, 1))
            System.out.println("    女性序列顺序无问题");
        else
            throw new Exception("性别排序女性队列正序顺序出错！");
        System.out.println("    ====逆序====");
        list = sexSort.sort(CalaBro.calaBroList, -1);
        if (judgeSex(list))
            System.out.println("    性别队列划分无问题");
        else
            throw new Exception("按性别排序逆序性别队列划分出错！");
        maleList = list.stream()
                .filter((CalaBro cb) -> cb.getSex().equals("Male"))
                .collect(Collectors.toList());
        femaleList = list.stream()
                .filter((CalaBro cb) -> cb.getSex().equals("Female"))
                .collect(Collectors.toList());
        if (judgeOrder(maleList, -1))
            System.out.println("    男性序列顺序无问题");
        else
            throw new Exception("性别排序男性队列逆序顺序出错！");
        if (judgeOrder(femaleList, -1))
            System.out.println("    女性序列顺序无问题");
        else
            throw new Exception("性别排序女性队列逆序顺序出错！");
    }

    /**
     * 判断队列是否符合指定顺序
     * @param list 传入排序后的葫芦娃序列
     * @param mode 1为正序，-1为逆序
     * @return
     */
    private boolean judgeOrder(List<CalaBro> list, int mode) {
        if (mode == -1) { // 逆序
            for (int i = 0; i < list.size()-1; ++i) {
                if (list.get(i).getName().compareTo(list.get(i+1).getName()) < 0) // 逆序中出现前一个小于后一个
                    return false;
            }
        } else { // 正序
            for (int i = 0; i < list.size()-1; ++i) {
                if (list.get(i).getName().compareTo(list.get(i+1).getName()) > 0) // 正序中出现前一个大于后一个
                    return false;
            }
        }
        return true;
    }
    /**
     * 判断是否分为两个性别队列，是否有个体出现在另一个队列中
     * @param list 传入sort函数返回的List
     * @return
     */
    private boolean judgeSex(List<CalaBro> list) {
        int femaleFlag = 0; // 用于判断是否开始出现female
        for (CalaBro cb : list) {
            if (cb.getSex().compareTo("Male") == 0) {
                if (femaleFlag == 1)
                    return false;
            }
            else
                femaleFlag = 1;
        }
        return true;
    }
}
