package hsp.java.nju;
interface Manage{    //管理者的接口
    public int command(Hulu hulu1,Hulu hulu2);
}
public class Grandpa extends Human implements Manage{
    public Grandpa(){
        super("爷爷");
    }

    @Override
    public int command(Hulu hulu1, Hulu hulu2) {
        System.out.println();
        System.out.println(this.getName()+":我是爷爷，我开始调整队伍");
        if(hulu1.getId()<hulu2.getId())
        {
            System.out.println(this.getName()+":"+hulu1.getName()+"和"+hulu2.getName()+"你们两兄弟的站位很好，暂时不需要调整");
            System.out.println("本次调整完成");
            System.out.println();
            return 1;
        }
        else
        {
            System.out.println(this.getName()+":"+hulu1.getName()+"和"+hulu2.getName()+"你们两兄弟的站位错了，你们交换一下顺序吧");
            hulu1.swap(hulu2);
            System.out.println("交换完成");
            System.out.println("本次调整完成");
            System.out.println();
            return 2;
        }
    }
}
