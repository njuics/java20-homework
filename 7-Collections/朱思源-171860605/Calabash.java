import java.util.Comparator;
import java.util.Random;

enum GENDER{
    MALE,FEMALE
}

enum ORDER {
    ASC,DESC,RAN
}

enum FLAG{
    SORT_ALL,SORT_BY_GENDER
}

public class Calabash implements Comparable<Calabash>{

    private static final int MIN_ASCII=65;
    private static final int MAX_ASCII=90;
    private static final int ALPHABET_LEN=MAX_ASCII-MIN_ASCII+1;
    private static final int LEN=20;

    private final String name;
    private final GENDER gender;
    private ORDER order;
    private FLAG flag;

    Calabash()
    {
        Random random=new Random();

        StringBuilder strBuilder=new StringBuilder();
        for(int i=0;i<LEN;i++){
            int tmpIndex=random.nextInt(ALPHABET_LEN);
            strBuilder.append((char)(tmpIndex+MIN_ASCII));
        }
        name="CALABASH{"+strBuilder.toString()+"}";
        gender=GENDER.values()[random.nextInt(2)];

        order=ORDER.ASC;
        flag=FLAG.SORT_ALL;

        //System.out.println(name);
        //System.out.println(gender);
    }

    public void setSortOption(ORDER order,FLAG flag){
        this.order=order;
        this.flag=flag;
    }

    @Override
    public int compareTo(Calabash o) {
        if(flag==FLAG.SORT_BY_GENDER&&gender!=o.gender){
            return (gender==GENDER.MALE)?1:-1;
        }
        else {
            switch (order) {
                case ASC: {
                    return name.compareTo(o.name);
                }
                case DESC:{
                    return -name.compareTo(o.name);
                }
                case RAN: {
                    int tmp=new Random().nextInt();
                    return Integer.compare(tmp,0);
                }
                default: {
                    return 0;
                }
            }
        }
    }

    @Override
    public String toString(){
        return "<Name>"+name+"|<Gender>"+gender.toString();
    }

    public static Comparator<Calabash> getComparator(ORDER order){
        return getComparator(order,FLAG.SORT_ALL);
    }

    public static Comparator<Calabash> getComparator(ORDER order, FLAG flag){
        switch (order){
            case ASC:{
                return getAscComparator(flag);
            }
            case DESC:{
                return getDescComparator(flag);
            }
            case RAN:{
                return getRanComparator(flag);
            }
            default:{
                return getAscComparator(flag);
            }
        }
    }

    public static  Comparator<Calabash> getAscComparator(FLAG flag){
        return (o1, o2) -> {
            if(flag==FLAG.SORT_BY_GENDER&&o1.gender!=o2.gender){
                return (o1.gender==GENDER.MALE)?1:-1;
            }else {
                return o1.name.compareTo(o2.name);
            }
        };
    }

    public static  Comparator<Calabash> getDescComparator(FLAG flag){
        return (o1, o2) -> {
            if(flag==FLAG.SORT_BY_GENDER&&o1.gender!=o2.gender){
                return (o1.gender==GENDER.MALE)?1:-1;
            }else {
                return -o1.name.compareTo(o2.name);
            }
        };
    }

    public static  Comparator<Calabash> getRanComparator(FLAG flag){
        return (o1, o2) -> {
            if(flag==FLAG.SORT_BY_GENDER&&o1.gender!=o2.gender){
                return (o1.gender==GENDER.MALE)?1:-1;
            }else {
                int tmp=new Random().nextInt();
                return Integer.compare(tmp, 0);
            }
        };
    }
}
