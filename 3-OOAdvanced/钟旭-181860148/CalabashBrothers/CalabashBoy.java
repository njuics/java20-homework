package CalabashBrothers;

public class CalabashBoy{
    private int id;
    private String name;
    public CalabashBoy(){}
    public CalabashBoy(int num, String name1){
        id=num;
        name=name1;
    }
    public static  boolean compare(CalabashBoy a,CalabashBoy b){
        if(a.id<b.id)return true;
        else return false;
    }
    public static void swap(CalabashBoy a,CalabashBoy b){
        int tmp=a.id;
        String tmp1=a.name;
        a.id=b.id;a.name=b.name;
        b.id=tmp;b.name=tmp1;
    }
    public int getid(){
        return this.id;
    }
    public void output(){
        System.out.print(name+" ");
    }
}
