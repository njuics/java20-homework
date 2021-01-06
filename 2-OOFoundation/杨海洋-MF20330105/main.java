import ooFoundation.GourdBaby;
import ooFoundation.GrandFather;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPOutputStream;

/**
 * @author ：杨海洋
 * @date ：Created in 2020/9/16 13:31
 * @description：对葫芦娃们进行排序
 * @modified By：
 * @version: $
 */
public class main {
    public static void main(String[] args) {
        GourdBaby first=new GourdBaby("大娃",1);
        GourdBaby second=new GourdBaby("二娃",2);
        GourdBaby third=new GourdBaby("三娃",3);
        GourdBaby forth=new GourdBaby("四娃",4);
        GourdBaby fifth=new GourdBaby("五娃",5);
        GourdBaby sixth=new GourdBaby("六娃",6);
        GourdBaby seventh=new GourdBaby("七娃",7);

        List<GourdBaby> list=new ArrayList<>();
        list.add(first);
        list.add(second);
        list.add(third);
        list.add(forth);
        list.add(fifth);
        list.add(sixth);
        list.add(seventh);

        List<GourdBaby> list1=GrandFather.shuffle(list);
        GrandFather.sort(list1);
        List<GourdBaby> list2=GrandFather.shuffle(list);
        GourdBaby.sort(list1);
    }
}
