/*
默认葫芦娃数目为N=20
利用Comparator进行排序 */
import java.util.*;

enum Gender{
    WOMAN,MAN
};
class Hulus{
    String name;
    Gender gender;
    Hulus(String name,Gender gender){this.name=name;this.gender=gender;}
}
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
class HuluSort{
    
    static void PosiSort(ArrayList<Hulus> hulus)
    {
        Collections.sort(hulus,new Positive());
    }
    static void NegaSort(ArrayList<Hulus> hulus)
    {
        Collections.sort(hulus,new Negative());
    }
    static void ChaosSort(ArrayList<Hulus> hulus)
    {
        Random rand=new Random();
        Collections.shuffle(hulus,rand);
    }
}
public class CollectionHulu{
    private static Random rand=new Random();
    private static final int N=20;
    static ArrayList<Hulus> hulus=new ArrayList<Hulus>();
    public static String get_name(int n)
    {
        String name=new String("");
        for (int i=0;i<n;++i)
            name=name+(char)(rand.nextInt(26)+'a');
        return name;
    }
    static ArrayList<Hulus> GenderDivide(ArrayList<Hulus> hulus,Gender gender)//进行性别区分
    {
        ArrayList<Hulus> ret=new ArrayList<Hulus>();
        Iterator<Hulus> it=hulus.iterator();
        while (it.hasNext())
        {
            Hulus Hulus=it.next();
            if (Hulus.gender==gender) ret.add(Hulus);
        }
        return ret;
    }
    static void printH(Iterable<Hulus> hulus)
    {
        Iterator<Hulus> it=hulus.iterator();

        while (it.hasNext())
        {
            Hulus hulu=it.next();
            System.out.println(hulu.name+","+hulu.gender);
        }
    }
    static void SortAndPrint(String type,ArrayList<Hulus> hulus)
    {
        HuluSort.PosiSort(hulus);
        System.out.println(type+"Positive Sort:");
        printH(hulus);

        HuluSort.NegaSort(hulus);
        System.out.println(type+"Negative Sort:");
        printH(hulus);

        HuluSort.ChaosSort(hulus);
        System.out.println(type+"Chaos Sort:");
        printH(hulus);
    }
    public static void main(String[] args)
    {
        for (int i=0;i<N;++i)//默认葫芦娃的名字为5个小写字母
            hulus.add(new Hulus(get_name(5),rand.nextBoolean()?Gender.MAN:Gender.WOMAN));
        //printH(hulus);
    
        SortAndPrint("All Hulus",hulus);
        ArrayList<Hulus> hulusMen=GenderDivide(hulus, Gender.MAN);
        SortAndPrint("hulusMen",hulusMen);
        ArrayList<Hulus> hulusWomen=GenderDivide(hulus, Gender.WOMAN);
        SortAndPrint("hulusWomen",hulusWomen);
    }
}
