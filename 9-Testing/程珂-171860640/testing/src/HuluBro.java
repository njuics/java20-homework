package testing.src;

import java.util.Random;
import static java.lang.Math.abs;



class BroComparator extends CreatureComparator<HuluBro>{
    @Override
    public int compare(HuluBro bro1,HuluBro bro2){
        return bro1.compareTo(bro2);
    }
}

public class HuluBro extends Creature implements Comparable<HuluBro>{
    public final static int COLOR_MAX_NUM=Color.values().length;
    public final static int GENDER_MAX_NUM=Gender.values().length;
    private static int MAX_SINGLE_NUM;
    private static int TOTOAL_NUM;
    private static int[] broNums;
    static{
        TOTOAL_NUM=0;
        MAX_SINGLE_NUM=0;
        broNums=new int[COLOR_MAX_NUM];
        for(int i=0;i<COLOR_MAX_NUM;i++)broNums[i]=0;
    }

    private Gender gender;
    private Color color;

    private  HuluBro(Gender g,Color c){
        gender=g;
        color=c;
        super.name=c.toString();
    }

    static public HuluBro getSpecificHuluBro(Color color,Gender gender){
        return new HuluBro(gender,color);
    }

    static public HuluBro getHuluBro(){
        Random random=new Random();
        int gdRandom= abs(random.nextInt()%GENDER_MAX_NUM);
        //
        int clrRandom=abs(random.nextInt() % COLOR_MAX_NUM);
        if(TOTOAL_NUM==MAX_SINGLE_NUM*COLOR_MAX_NUM){//到临界值
            MAX_SINGLE_NUM++;
        }else{
            while(broNums[clrRandom]==MAX_SINGLE_NUM){
                clrRandom=abs(random.nextInt()% COLOR_MAX_NUM);
            }
        }
        broNums[clrRandom]++;
        TOTOAL_NUM++;
        return new HuluBro(Gender.values()[gdRandom],
                Color.values()[clrRandom]);
    }

    public Gender getGender(){ return this.gender; }
    public int getOrder(){return this.color.ordinal();}

    @Override
    public int compareTo(HuluBro o){
        int result=this.color.ordinal()-o.color.ordinal();
        if(result==0)return 0;
        //1 表示比o更大，0表示比o更小
        else return result>0?1:-1;
    }

    @Override
    public String toString(){
        return "HuluBro."+"name:"+name+","+"gender:"+gender.toString();
    }
}
