import java.util.*;

public class Sort {
    public static void main(String[] args){
        int num = 0;
        System.out.println("请输入葫芦娃的数量");
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        List<Hulu> huluranks = new ArrayList<>();
        for(int i=0;i<num;i++) {
            huluranks.add(new Hulu());
        }
        System.out.println("现在葫芦娃的队伍情况是：");
        for(Hulu hulu:huluranks)
        {
            System.out.print(hulu.getName() + " ");
        }
        System.out.println();
        System.out.println("请输入你选择的排序方式，0表示正序，1表示反序，2表示乱序");
        Hulu.sortway = sc.nextInt();
        if(Hulu.sortway==2)
        {
            Collections.shuffle(huluranks);
        }
        else
            Collections.sort(huluranks);

        for(Hulu hulu:huluranks)
        {
            System.out.print(hulu.getName() + " ");
        }
        System.out.println();

        //采用自己设计的迭代器进行输出的话
        System.out.println();
        System.out.println("利用设计的HuluIterable进行迭代，输出队伍");
        Iterator<Hulu> it = new HuluIterable(huluranks).iterator();
        while(it.hasNext())
            System.out.print(it.next().getName()+" ");
        System.out.println();


        List<Hulu> malehulu = new ArrayList<>();
        List<Hulu> femalehulu = new ArrayList<>();
        for(int i=num-1;i>=0;i--)
        {
            if(huluranks.get(i).getGender())
                malehulu.add(huluranks.get(i));
            else
                femalehulu.add(huluranks.get(i));
            huluranks.remove(i);
        }
        System.out.println("请输入你选择的排序方式，0表示正序，1表示反序，2表示乱序");
        Hulu.sortway = sc.nextInt();
        if(Hulu.sortway==2) {
            Collections.shuffle(malehulu);
            Collections.shuffle(femalehulu);
        }
        else{
            Collections.sort(malehulu);
            Collections.sort(femalehulu);
        }
        System.out.println("男葫芦娃的排队情况：");
        for(Hulu hulu:malehulu)
            System.out.print(hulu.getName() + " ");
        System.out.println();
        System.out.println("女葫芦娃的排队情况：");
        for(Hulu hulu:femalehulu)
            System.out.print(hulu.getName() + " ");
        System.out.println();
    }
}
