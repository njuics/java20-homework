package cn.edu.xiaoyu;

public class Grandpa extends Human{
    Grandpa(String name){
        super(name);
    }
    public boolean observe(Calabash a,Calabash b){
        if(a.prio>b.prio)
            return true;
        return false;
    }

    public void exchange(Calabash a,Calabash b){
        int temp=a.pos;
        a.pos=b.pos;
        b.pos=temp;
    }
}
