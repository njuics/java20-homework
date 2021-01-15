import java.util.*;

public class CalabashBrothersSort {
    public static final int N=20;

    public static void main(String[] argv){
        ArrayList<Brother> bro=initialBros();
        choiceSortMethod(bro);
    }

    private static ArrayList<Brother> initialBros(){
        ArrayList<Brother> bro=new ArrayList<Brother>();
        for(int i=0;i<N;++i){
            Brother b=new Brother();
            bro.add(b);
        }
        return bro;
    }

    private static void choiceSortMethod(ArrayList<Brother> bro){
        int choice1=0,choice2=0;
        while(true){
            System.out.println("请选择待排序的葫芦娃——1 全体，2 男生，3 女生：");
            Scanner scan=new Scanner(System.in);
            choice1=scan.nextInt();
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
            break;
        }
    }

    //Comparable
    /*
    private static void brosSort(ArrayList<Brother> temp,int method){
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
    }
    */

    //Comparator
    ///*
    private static void brosSort(ArrayList<Brother> temp,int method){
        switch(method){
            case 1:
                System.out.println("正序");
                Collections.sort(temp,new BrotherCompartor());
                break;
            case 2:
                System.out.println("倒序");
                Collections.sort(temp,new BrotherCompartor());
                Collections.reverse(temp);
                break;
            case 3:
                System.out.println("乱序");
                Collections.shuffle(temp);
        }

        printList(temp);
    }
    //*/

    private static void printList(ArrayList<Brother> temp){
        Iterator<Brother> it=temp.iterator();
        while(it.hasNext())
            System.out.println(it.next().name);
    }

    private static ArrayList<Brother> findMale(ArrayList<Brother> bro){
        ArrayList<Brother> male=new ArrayList<Brother>();
        for(Brother b:bro)
            if(b.gender)
                male.add(b);
        return male;
    }

    private static ArrayList<Brother> findFemale(ArrayList<Brother> bro){
        ArrayList<Brother> female=new ArrayList<Brother>();
        for(Brother b:bro)
            if(!b.gender)
                female.add(b);
        return female;
    }
}

//Comparable
/*
class Brother implements Comparable<Brother> {
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

    @Override
    public int compareTo(Brother b)
    {
        return this.name.compareTo(b.name);
    }
}
*/

//Comparator
///*
class Brother {
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
}

class BrotherCompartor implements Comparator<Brother>
{
    @Override
    public int compare(Brother b1, Brother b2)
    {
        return b1.name.compareTo(b2.name);
    }
}
//*/