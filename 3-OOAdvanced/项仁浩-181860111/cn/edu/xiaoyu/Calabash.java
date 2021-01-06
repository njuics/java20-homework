package cn.edu.xiaoyu;

public class Calabash extends Human{
    int prio;
    int pos;

    Calabash(String name,int prio){
        super(name);
        this.prio=prio;
        pos=0;
    }

    public boolean observe(Calabash a){
        if(this.prio>a.prio)
            return true;
        return false;
    }

    public void exchange(Calabash a){
        int temp=pos;
        pos=a.pos;
        a.pos=temp;
    }
}
