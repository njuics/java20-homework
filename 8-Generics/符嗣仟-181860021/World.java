import java.util.Random;

public abstract class World {
    int NUMS_OF_HULUWA = 7;
    //Calabash []huluwas;
    CreatureList<Calabash> huluwas = new CreatureList<>();

    World(){
        for(int i=0;i<NUMS_OF_HULUWA;i++){
            Calabash cb = new Calabash(generate_name(), generate_sex());
            huluwas.add(cb);
        }
        //初始化葫芦娃数组
    }
    public String generate_name(){
        //假设名字为2-10乱序英文字母
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<5;i++){
          int number=random.nextInt(62);
          sb.append(str.charAt(number));
        }
        return sb.toString();
    }
    public Sexual generate_sex(){
        Random random = new Random();
        int num = random.nextInt(2);
        if (num==0) return Sexual.MALE;
        else return Sexual.FEMALE;
    }
    public abstract void sort(CreatureList<?> kids,int type);
    //抽象function，在子类中完成多态
}
