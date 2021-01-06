import java.lang.StringBuffer;
import java.lang.String;
import java.util.*;
class Creature{
    public String name;
    public sex _sex;
    public Creature(){
        Random seed = new Random();
        int len = 2 + seed.nextInt(3);
        String str="qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        StringBuffer my_name = new StringBuffer();
        for(int i=0;i<len;i++) my_name.append(str.charAt(seed.nextInt(str.length())));
        name = my_name.toString();

        Random seed2 = new Random();
        sex a[] = {sex.female,sex.male};
        _sex = a[seed2.nextInt(2)];
    }
    public String get_name(){return name;}
    public sex get_sex(){return _sex;}
    @Override
    public String toString(){
        return name+"<"+_sex.toString()+">";
    }
}
enum sex{
    male(1),
    female(0);
    private int sex_value;
    sex(int x){
        sex_value = x;
    }
    @Override
    public String toString(){
        if(sex_value == 0) return "girl";
        else return "boy";
    }
}

class huluwa<T extends Creature> extends Creature implements Comparable<T>{
    @Override
    public int compareTo(T a){
        String _name = a.get_name();
        return _name.compareTo(name);
    }
}
class yeyecomparator<T extends Creature> implements Comparator<T>{
    @Override
    public int compare(T a,T b){
        if(a.name.compareTo(b.name)<0)
            return 1;
        else if(a.name.compareTo(b.name)>0) return -1;
        else return 0;
    }
}
public class collection<T extends Creature>{
    ArrayList<huluwa> huluteng = new ArrayList<huluwa>();

    collection linebysex(sex a){
        collection tmp = new collection();
        for(int i=0;i<huluteng.size();i++){
            if(huluteng.get(i).get_sex() == a)
                tmp.huluteng.add(huluteng.get(i));
        }
        return tmp;
    }

    public void print(collection a){
        ArrayList<huluwa> tmp = a.huluteng;
        for(int i=0;i<tmp.size();i++){
            System.out.print(huluteng.get(i).toString()+" ");
        }
        System.out.println();
    }

    void my_sort(){
        print(this);
        System.out.println("反序排序");
        yeyecomparator comparator = new yeyecomparator();
        huluteng.sort(comparator);
        print(this);
        System.out.println("乱序排列");
        Collections.shuffle(huluteng);
        print(this);
        System.out.println("正序排列");
        Collections.sort(huluteng);
        print(this);
    }
    public void build_hulut(int num){
        for(int i=0;i<num;i++){
            huluwa onel = new huluwa();
            huluteng.add(onel);
        }
    }
    /*public static void main(String args[]){
        collection a = new collection();
        for(int i=0;i<10;i++){
            huluwa one = new huluwa();
            a.huluteng.add(one);
        }
        System.out.println("\n######一起排队######");
        a.my_sort();

        sex _female = sex.female,_male = sex.male;
        collection male = a.linebysex(_male),female = a.linebysex(_female);
        System.out.println("\n######男生排队######");
        male.my_sort();
        System.out.println("\n######女生排队######");
        female.my_sort();
    }*/
}