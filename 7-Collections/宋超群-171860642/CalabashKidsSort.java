import java.lang.reflect.Method;
import java.util.*;

public class CalabashKidsSort{
    public static void main(String[] args){
        GrandFather myGF = new GrandFather(100);
        ArrayList<CalabashKid> boys = myGF.getBoys();
        ArrayList<CalabashKid> girls = myGF.getGirls();

        System.out.println("boys正序：\n");
        myGF.kidsSort(boys,1);
        myGF.kidsPrint(boys);
        System.out.println("\ngirls乱序：\n");
        myGF.kidsSort(girls,0);
        myGF.kidsPrint(girls);
        System.out.println("\nboys倒序：\n");
        myGF.kidsSort(girls,1);
        myGF.kidsPrint(girls);
    }

}

class CalabashKid{
    private String name;
    private boolean sex;

    CalabashKid(){
        //随机生成名字和性别
        sex = new Random().nextBoolean() ? true : false;
        name = getRandomString(8);
    }

    String getName(){
        return name;
    }

    boolean getSex(){
        return sex;
    }

    String getSexStr(){
        return sex ? "boy" : "girl";
    }
    String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer tmpStringBuffer = new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);//随机获取一个位置
            tmpStringBuffer.append(str.charAt(number));//在str中找到该位置对应的字符
        }
        return tmpStringBuffer.toString();
    }
}

class GrandFather{
    ArrayList<CalabashKid> calabashBoys;
    ArrayList<CalabashKid> calabashGirls;

    //初始化列表，构造含有num个葫芦娃的两个列表
    GrandFather(int num){
        calabashBoys = new ArrayList<CalabashKid>();
        calabashGirls = new ArrayList<CalabashKid>();
        for(int i = 0; i < num; i++){
            CalabashKid calabashKid = new CalabashKid();
            if(calabashKid.getSex()){
                calabashBoys.add(calabashKid);
            }else calabashGirls.add(calabashKid);
        }
    }

    ArrayList<CalabashKid> getBoys(){
        return calabashBoys;
    }
    ArrayList<CalabashKid> getGirls(){
        return calabashGirls;
    }

    //对葫芦娃进行排序，way=1正序，way=0乱序，way=-1倒序
    void kidsSort(ArrayList<CalabashKid> calabashKids, int way){
        if(way == 1){
            Collections.sort(calabashKids, CalabashKidComparator);
        }
        else if(way == -1){
            Collections.sort(calabashKids, CalabashKidComparator);
            Collections.reverse(calabashKids);
        }
        else Collections.shuffle(calabashKids);
    }

    void kidsPrint(ArrayList<CalabashKid> calabashKids){
        Iterator<CalabashKid> boyIterator = calabashKids.iterator();
        while(boyIterator.hasNext()){
            System.out.println(boyIterator.next().getName());
        }
    }

    Comparator<CalabashKid> CalabashKidComparator = new Comparator<CalabashKid>() {
        @Override
        public int compare(CalabashKid o1, CalabashKid o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };
}