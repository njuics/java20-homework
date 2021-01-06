import java.util.*;

public class CalabashBrothersSort {
    public static final int N=20;

    public static void main(String[] argv){
        ArrayList<Brother> bro=initialBros();
        choiceSortMethod(bro);
    }

    public static ArrayList<Brother> initialBros(){
        ArrayList<Brother> bro=new ArrayList<Brother>();
        for(int i=0;i<N;++i){
            //Brother b=new Brother();
            Brother b;
            switch (i%7){
                case 0:b=new GiantBoy();bro.add(b);break;
                case 1:b=new DetectiveBoy();bro.add(b);break;
                case 2:b=new DiamondBoy();bro.add(b);break;
                case 3:b=new FireBoy();bro.add(b);break;
                case 4:b=new WaterBoy();bro.add(b);break;
                case 5:b=new CloakingBoy();bro.add(b);break;
                case 6:b=new BarathrumBoy();bro.add(b);break;
            }

        }
        return bro;
    }

    private static void choiceSortMethod(ArrayList<Brother> bro){
        int choice1=0,choice2=0;
        while(true){
            System.out.println("请选择待排序的葫芦娃——1 全体，2 男生，3 女生，0 退出：");
            Scanner scan=new Scanner(System.in);
            choice1=scan.nextInt();
            if(choice1==0)
                break;
            System.out.println("请选择排序方式——1 正序，2 倒序，3 乱序：");
            choice2=scan.nextInt();
            if(choice2!=1&&choice2!=2&&choice2!=3) {
                System.out.println("请选择正确的排序方式！");
                continue;
            }
            if(choice1==1) {
                System.out.println("全体");
                brosSort(bro, choice2);
            }
            else if(choice1==2) {
                System.out.println("男生");
                brosSort(findMale(bro), choice2);
            }
            else if(choice1==3) {
                System.out.println("女生");
                brosSort(findFemale(bro), choice2);
            }
            else {
                System.out.println("请选择正确的待排序葫芦娃群体！");
                continue;
            }
        }
    }

    //Comparable
    public static ArrayList<Brother> brosSort(ArrayList<Brother> temp,int method){
        switch(method){
            case 1:
                System.out.println("正序");
                Collections.sort(temp);
                break;
            case 2:
                System.out.println("倒序");
                Collections.sort(temp);
                Collections.reverse(temp);
                break;
            case 3:
                System.out.println("乱序");
                Collections.shuffle(temp);
        }

        printList(temp);
        return temp;
    }

    private static void printList(ArrayList<Brother> temp){
        Iterator<Brother> it=temp.iterator();
        while(it.hasNext()){
            Brother b=it.next();
            System.out.print("名字："+b.name+"\t性别："+(b.gender?"男生":"女生")+"\t发大招：");
            useOwnMagic(b);
        }
    }

    private static <T extends Brother> void useOwnMagic(T bro){
        bro.useMagic();
    }

    public static ArrayList<Brother> findMale(ArrayList<Brother> bro){
        ArrayList<Brother> male=new ArrayList<Brother>();
        for(Brother b:bro)
            if(b.gender)
                male.add(b);
        return male;
    }

    public static ArrayList<Brother> findFemale(ArrayList<Brother> bro){
        ArrayList<Brother> female=new ArrayList<Brother>();
        for(Brother b:bro)
            if(!b.gender)
                female.add(b);
        return female;
    }
}

abstract class Brother implements Comparable<Brother> {
    String name;
    boolean gender;
    Random r=new Random();

    Brother(){
        this.name=randomName();
        this.gender=randomGender();
    }
    String randomName(){
        StringBuffer tempstring=new StringBuffer();
        String selectstr="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int length=r.nextInt(10);
        for(int i=0;i<=length;i++)
            tempstring.append(selectstr.charAt(r.nextInt(62)));
        return tempstring.toString();
    }
    boolean randomGender(){
        boolean result=false;
        switch (r.nextInt(2)){
            case 0:result=false;break;//女性
            case 1:result=true;//男性
        }
        return result;
    }

    abstract void useMagic();

    @Override
    public int compareTo(Brother b)
    {
        return this.name.compareTo(b.name);
    }
}

class GiantBoy extends Brother{
    void useMagic(){
        System.out.println("变大");
    }
}

class DetectiveBoy extends Brother{
    void useMagic(){
        System.out.println("眼观六路耳听八方");
    }
}

class DiamondBoy extends Brother{
    void useMagic(){
        System.out.println("金刚不坏");
    }
}

class FireBoy extends Brother{
    void useMagic(){
        System.out.println("喷火");
    }
}

class WaterBoy extends Brother{
    void useMagic(){
        System.out.println("喷水");
    }
}

class CloakingBoy extends Brother{
    void useMagic(){
        System.out.println("隐身");
    }
}

class BarathrumBoy extends Brother{
    void useMagic(){
        System.out.println("吸入万物");
    }
}