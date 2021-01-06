/*
默认葫芦娃数目为N=20
利用Comparator进行排序 */
import java.util.*;

enum Gender{
    ALL,WOMAN,MAN
};
class Hulus{
    String name;
    Gender gender;
    Hulus(){}
    Hulus(String name,Gender gender){this.name=name;this.gender=gender;}
    void Change(Hulus x){this.name=x.name;this.gender=x.gender;}
}
class ManHulus extends Hulus{}
class WomanHulus extends Hulus{}
class Positive implements Comparator<Hulus>{
    @Override
    public int compare(Hulus o1,Hulus o2){
        return o1.name.compareTo(o2.name);
    }
}
class Negative implements Comparator<Hulus>{
    @Override
    public int compare(Hulus o1,Hulus o2){
        return o2.name.compareTo(o1.name);
    }
}
class HulusCollection<T extends Hulus>{
    ArrayList<T> hulusArray=new ArrayList<>();
    void add(T x){hulusArray.add(x);}
    void PosiSort()
    {
        Collections.sort(hulusArray,new Positive());
    }
    void NegaSort()
    {
        Collections.sort(hulusArray,new Negative());
    }
    void ChaosSort()
    {
        Random rand=new Random();
        Collections.shuffle(hulusArray,rand);
    }
    void printH()
    {
        for (T x:hulusArray)
            System.out.println(x.name+","+x.gender);
    }
}
public class Generics{
    private static Random rand=new Random();
    private static final int N=20;
    static ArrayList<Hulus> hulusarray=new ArrayList<Hulus>();
    public static String get_name(int n)
    {
        String name=new String("");
        for (int i=0;i<n;++i)
            name=name+(char)(rand.nextInt(26)+'a');
        return name;
    }
    static <T extends Hulus> HulusCollection<T> GenderDivide(ArrayList<Hulus> hulusarray,Gender gender,Class<T> type)//进行性别区分
    {        
        HulusCollection<T> ret=new HulusCollection<>();
        for (Hulus x:hulusarray)
        {
            try{
                T hulu=type.newInstance();
                hulu.Change(x);
                if (hulu.gender==gender||gender==Gender.ALL) ret.add(hulu);
            }
            catch (Exception e){e.printStackTrace();}
        }
        return ret;
    }
    static <T extends Hulus> void SortAndPrint(String type,HulusCollection<T> hulus)
    {
        hulus.PosiSort();
        System.out.println(type+" Positive Sort:");
        hulus.printH();

        hulus.NegaSort();
        System.out.println(type+" Negative Sort:");
        hulus.printH();

        hulus.ChaosSort();
        System.out.println(type+" Chaos Sort:");
        hulus.printH();
    }
    public static void main(String[] args)
    {
        for (int i=0;i<N;++i)//默认葫芦娃的名字为5个小写字母
            hulusarray.add(new Hulus(get_name(5),rand.nextBoolean()?Gender.MAN:Gender.WOMAN));
        HulusCollection<Hulus> hulus=GenderDivide(hulusarray, Gender.ALL,Hulus.class);
        SortAndPrint("All Hulus",hulus);
        HulusCollection<ManHulus> menHulus=GenderDivide(hulusarray, Gender.MAN,ManHulus.class);
        SortAndPrint("hulusMen",menHulus);
        HulusCollection<WomanHulus> womenHulus=GenderDivide(hulusarray, Gender.WOMAN,WomanHulus.class);
        SortAndPrint("hulusWomen",womenHulus);
    }
}
