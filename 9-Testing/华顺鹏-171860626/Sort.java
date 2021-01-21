import java.text.CollationElementIterator;
import java.util.*;

public class Sort {
    static List<Hulu> huluranks;
    static List<Hulu> malehulu;
    static List<Hulu> femalehulu;

    public static void sortbyway(List<Hulu> ranks, int way) throws Exception{
        if(way==2)
            Collections.shuffle(ranks);
        else if(way==0||way==1)
            Collections.sort(ranks);
        else {
                throw new Exception("排序方式输入错误");
        }
        for(Hulu hulu:ranks)
            System.out.print(hulu.getName() + " ");
        System.out.println();
    }

    public static void hulusort(int num) {
        huluranks = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            huluranks.add(new Hulu());
        }
        System.out.println("现在葫芦娃的队伍情况是：");
        for (Hulu hulu : huluranks) {
            System.out.print(hulu.getName() + " ");
        }
        System.out.println();
        System.out.println("请输入你选择的排序方式，0表示正序，1表示反序，2表示乱序");
        Scanner sc = new Scanner(System.in);
        Hulu.sortway = sc.nextInt();
        System.out.println("排序后的葫芦娃队伍情况：");
        try {
            sortbyway(huluranks, Hulu.sortway);
        }
        catch (Exception e){
            e.printStackTrace();
        }


        //采用有了泛型之后的迭代器进行输出
        System.out.println();
        System.out.println("利用设计的拥有泛型的HuluRanks进行迭代，输出队伍：");
        Iterable<Hulu> it2 = new HuluRanks<Hulu>(huluranks);
        for (Hulu hulu : it2)
            System.out.print(hulu.getName() + " ");
        System.out.println();

        malehulu = new ArrayList<>();
        femalehulu = new ArrayList<>();
        for (int i = num - 1; i >= 0; i--) {
            if (huluranks.get(i).getGender())
                malehulu.add(huluranks.get(i));
            else
                femalehulu.add(huluranks.get(i));
            huluranks.remove(i);
        }
        System.out.println();
        System.out.println("请输入你选择的排序方式，0表示正序，1表示反序，2表示乱序");
        Hulu.sortway = sc.nextInt();
        try{
            System.out.println("男葫芦娃的排队情况：");
            sortbyway(malehulu,Hulu.sortway);
            System.out.println("女葫芦娃的排队情况：");
            sortbyway(femalehulu,Hulu.sortway);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        int num = 0;
        System.out.println("请输入葫芦娃的数量");
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        hulusort(num);
    }
}
