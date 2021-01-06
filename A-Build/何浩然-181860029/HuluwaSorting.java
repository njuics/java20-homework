import java.util.*;
import org.apache.commons.lang3.RandomUtils;

public class HuluwaSorting {
    public static  void main(String[] args){
        Sorting<Huluwa> s=new Sorting<Huluwa>();
        for(int i=0;i<7;i++) {//原先存在的老大至老七
            s.add_some(new Huluwa(i + 1));
        }
        int addnum=RandomUtils.nextInt()%10+1;;//重写，后面随机生成的数目
        for(int i=0;i<addnum;i++) {
            s.add_some(new Huluwa());
        }
        System.out.println("乱序为：");
        s.print();
        System.out.println("正序为：");
        s.p.sort(s);
        s.print();

    }


}
