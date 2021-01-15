import java.util.Random;

class HuluBro{
    String name;
    int key;
    void call()
    {
        System.out.println(name);
    }
    HuluBro(){key=0;name=null;}
    void nameIt(int Key,String Name)
    {
        key=Key;
        name=Name;
    }
    boolean lessThan(HuluBro other)
    {
        return key<other.key?true:false;
    }
}
class Grandpa{
    static boolean lessThan(HuluBro a,HuluBro b)
    {
        return a.key<b.key?true:false;//a.key<b.key返回true，否则false
    }
    static void swap(HuluBro[] huluBro,int i,int j)
    {
        HuluBro temp=huluBro[i];
        huluBro[i]=huluBro[j];
        huluBro[j]=temp;
    }
    static void selectSort(HuluBro[] huluBro)//选择排序
    {
        for (int minor,i=0;i<huluBro.length;++i)
        {
            minor=i;
            for (int j=i+1;j<huluBro.length;++j)
                if (Grandpa.lessThan(huluBro[j],huluBro[minor]))
                    minor=j;
            Grandpa.swap(huluBro,minor,i);
        }
    }
    static void bubbleSort(HuluBro[] huluBro)//冒泡排序
    {
        for (int i=0;i<huluBro.length;++i)
            for (int j=huluBro.length-1;j>i;--j)
                if (Grandpa.lessThan(huluBro[j],huluBro[j-1]))
                Grandpa.swap(huluBro,j,j-1);
    }
}
class Self{
    static void selectSort(HuluBro[] huluBro)//选择排序
    {
        HuluBro temp;
        for (int minor,i=0;i<huluBro.length;++i)
        {
            minor=i;
            for (int j=i+1;j<huluBro.length;++j)
                if (huluBro[j].lessThan(huluBro[minor]))
                    minor=j;
            temp=huluBro[minor];
            huluBro[minor]=huluBro[i];
            huluBro[i]=temp;
        }
    }
    static void bubbleSort(HuluBro[] huluBro)//冒泡排序
    {
        HuluBro temp;
        for (int i=0;i<huluBro.length;++i)
            for (int j=huluBro.length-1;j>i;--j)
                if (huluBro[j].lessThan(huluBro[j-1]))
                {
                    temp=huluBro[j-1];
                    huluBro[j-1]=huluBro[j];
                    huluBro[j]=temp;
                }
    }
}
public class HuluSort{
    HuluBro[] huluBro=new HuluBro[7];
    void initialize()
    {
        huluBro[0]=new HuluBro();
        huluBro[0].nameIt(0,"老大");
        huluBro[1]=new HuluBro();
        huluBro[1].nameIt(1,"老二");
        huluBro[2]=new HuluBro();
        huluBro[2].nameIt(2,"老三");
        huluBro[3]=new HuluBro();
        huluBro[3].nameIt(3,"老四");
        huluBro[4]=new HuluBro();
        huluBro[4].nameIt(4,"老五");
        huluBro[5]=new HuluBro();
        huluBro[5].nameIt(5,"老六");
        huluBro[6]=new HuluBro();
        huluBro[6].nameIt(6,"老七");
    }
    void randomShuffle()//随意站队
    {
        Random seed=new Random();
        HuluBro temp;
        for (int j,i=1;i<huluBro.length;++i)
        {
            //第i个位置与0~i中的任意位置交换
            j=seed.nextInt(i+1);
            temp=huluBro[i];
            huluBro[i]=huluBro[j];
            huluBro[j]=temp;
        }
    }
    void orchestrationSort()//由爷爷来指挥排序
    {
        //选择排序
        //Grandpa.selectSort(huluBro);
        //冒泡排序
        Grandpa.bubbleSort(huluBro);
    }
    void choreographySort()//葫芦娃之间相互交流排序
    {
        //选择排序
        Self.selectSort(huluBro);
        //冒泡排序
        //Self.bubbleSort(huluBro);
    }
    void allCall()
    {
        for (int i=0;i<huluBro.length;++i) huluBro[i].call();
    }
    public static void main(String[] args)
    {
        HuluSort huluSort=new HuluSort();
        huluSort.initialize();
        huluSort.randomShuffle();
        huluSort.orchestrationSort();
        //huluSort.choreographySort();
        huluSort.allCall();
    }
}