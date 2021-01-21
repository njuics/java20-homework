import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Main {

    private static List<HuLuWa> HuluFamily = new ArrayList<HuLuWa>();     /* 全部的葫芦娃们 */

    private static List<HuLuWa> MaleHuluwa = new ArrayList<HuLuWa>();       /* 男性葫芦娃们 */

    private static List<HuLuWa> FemaleHuluwa = new ArrayList<HuLuWa>();     /* 女性葫芦娃们 */

    static String GetNewName() {        /* 随机生成一个长度范围为6-10的英文单词 */
        String str = "abcdefghijklmnopqrstuvwxyz";
        String name = "";
        int length = (new Random()).nextInt(4)+6;
        while(length>0) {
            int random_number = (new Random()).nextInt(25);
            name += str.charAt(random_number);
            length--;
        }
        return name;
    }

    static boolean GetNewSex() {        /* 随机生成一个boolean类型的数 */
        boolean sex = true;
        Random rand = new Random();
        int random_number = rand.nextInt(100);
        if(random_number%2 == 0) {
            sex = false;
        }
        else {
            sex = true;
        }
        return sex;
    }

    static void init() {        /* 初始化随机生成10个葫芦娃 */
        int number = 10;
        while(number>0) {
            String name = GetNewName();
            boolean sex = GetNewSex();
            HuluFamily.add(new HuLuWa(name, sex));
            number--;
        }
        Collections.shuffle(HuluFamily);
    }

    static void print(List<HuLuWa> list){
        String result = "";
        Iterator<HuLuWa> it = list.iterator();
        while(it.hasNext()) {
            HuLuWa hlw = it.next();
            result += hlw.tell_name();
            result += " ";
        }
        System.out.println(result);
    }

    static void correctorder(List<HuLuWa> list) {
        Collections.sort(list, new HuLuWaCorrectComparetor());
    }

    static void inverseoder(List<HuLuWa> list) {
        Collections.sort(list,new HuLuWaInverseComparetor());
    }

    static void partation() {
        Iterator<HuLuWa> it = HuluFamily.iterator();
        while(it.hasNext()) {
            HuLuWa hlw = it.next();
            if(hlw.tell_sex()) {
                MaleHuluwa.add(hlw);
            }
            else {
                FemaleHuluwa.add(hlw);
            }
        } 
    }

    public static void main(String[] args){

        init();     /* 随机生成10个葫芦娃，随机排列 */
        System.out.println("10个葫芦娃随机排序：");
        print(HuluFamily);    /* 打印乱序结果 */

        correctorder(HuluFamily);     /* 将集合按字典正序排序 */
        System.out.println("10个葫芦娃字典正序排序：");
        print(HuluFamily);        /* 打印字典正序结果 */

        inverseoder(HuluFamily);      /* 将集合按字典反序排序 */
        System.out.println("10个葫芦娃字典反序排序：");
        print(HuluFamily);        /* 打印字典反序结果 */

        partation();        /* 将集合按性别分成两个队伍 */

        correctorder(MaleHuluwa);       /* 将雄性葫芦娃按字典正序排序 */
        System.out.println("雄性葫芦娃字典正序排序：");
        print(MaleHuluwa);      /* 打印结果 */

        inverseoder(MaleHuluwa);        /* 将雄性葫芦娃按字典反序排序 */
        System.out.println("雄性葫芦娃字典反序排序：");
        print(MaleHuluwa);      /* 打印结果 */

        correctorder(FemaleHuluwa);     /* 将雌性葫芦娃按字典正序排序 */
        System.out.println("雌性葫芦娃字典正序排序：");
        print(FemaleHuluwa);        /* 打印结果 */

        inverseoder(FemaleHuluwa);      /* 将雌性葫芦娃按字典反序排序 */
        System.out.println("雌性葫芦娃字典反序排序：");
        print(FemaleHuluwa);        /* 打印结果 */
    }
}