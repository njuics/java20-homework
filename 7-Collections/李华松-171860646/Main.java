import java.util.Iterator;

public class Main {
    public static void display(HuluwaCollection a){
        Iterator<Huluwa> i = a.iterator();
        while(i.hasNext()){
            Huluwa h = i.next();
            System.out.println(h);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        //Huluwa h =new Huluwa();
        //System.out.print(h);      
        System.out.println("原始序列：");
        HuluwaCollection r = new HuluwaCollection();
        display(r);
        System.out.println("降序序列：");
        r.sortByAsc();
        display(r);
        System.out.println("升序序列：");
        r.sortByDes();
        display(r);
        System.out.println("按性别分开后升序序列：");
        r.sortByGender();
        display(r);
        System.out.println("乱序序列：");
        r.shffule();
        display(r);
    }
}
