package hulu;
import org.junit.*;
import static org.junit.Assert.*;
import com.google.common.collect.*;
import java.util.*;
import java.util.function.Function;
enum Gender{
    ALL,WOMAN,MAN
};
class Hulus{
    String name;
    Gender gender;
    Hulus(){}
    Hulus(String name,Gender gender){this.name=new String(name);this.gender=gender;}
    void Change(Hulus x){this.name=new String(x.name);this.gender=x.gender;}
}
class ManHulus extends Hulus{}
class WomanHulus extends Hulus{}
class HulusCollection<T extends Hulus>{
    ArrayList<T> hulusArray=new ArrayList<>();
    Ordering posiOrder=Ordering.natural().from((Hulus o1,Hulus o2)->o1.name.compareTo(o2.name));
    Ordering negaOrder=posiOrder.reverse();
    void add(T x){hulusArray.add(x);}
    void PosiSort()
    {
        Collections.sort(hulusArray,posiOrder);
    }
    void NegaSort()
    {
        Collections.sort(hulusArray,negaOrder);
    }
    ArrayList<String> getName()
    {
        ArrayList<String> ret=new ArrayList<String>();
        for (Hulus x:hulusArray)
        {
            ret.add(x.name);
            System.out.println(x.name);
        }
        return ret;
    }
}
public class HuluCase{
    private static Random rand=new Random();
    static ArrayList<Hulus> hulusarray=new ArrayList<Hulus>();
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
    @Test
    static <T extends Hulus> ArrayList<String> SortResult(int sortType,HulusCollection<T> hulus)
    {
        switch (sortType) {
            case 0:
                hulus.PosiSort();
                break;
            case 1:
                hulus.NegaSort();
                break;
            default:
                break;
        }
        return hulus.getName();
    }
    public static ArrayList<String> run(int huluCnt,String[] huluName,int[] huluGender,int sortGender,int sortType)
    {
        //sortGender=0表示男性，1表示女性，2表示全性别
        //sortType=0表示正序排列，1表示倒序排列，2表示原样输出
        hulusarray.clear();
        for (int i=0;i<huluCnt;++i)
            hulusarray.add(new Hulus(huluName[i],huluGender[i]==0?Gender.MAN:Gender.WOMAN));
        HulusCollection<Hulus> hulus=GenderDivide(hulusarray, sortGender==0?Gender.MAN:(sortGender==1?Gender.WOMAN:Gender.ALL),Hulus.class);
        return SortResult(sortType,hulus);
    }
    public static void main(String[] args)
    {
        for (String i:run(4,new String[] {"AC","BD","BAD","CA"},new int[]{0,0,0,0},0,0))
            System.out.println(i);
            
    }
}