package org.cvm.world.Buff;

public class AttackBuff {
    private int AttackChange;
    private int Attackbufftime;
    public AttackBuff()
    {
        Attackbufftime=0;
        AttackChange=0;
    }
    public AttackBuff(int AttackChange, int Attackbufftime){
        this.AttackChange=AttackChange;
        this.Attackbufftime=Attackbufftime;
    }
    public boolean Attackbuffoverdue(){
        return Attackbufftime==0;
    }
    public void countdown(){
        if(Attackbufftime>0) Attackbufftime--;
    }

    public int getAttackChange() {
        return AttackChange;
    }
    public int getAttackbufftime(){ return Attackbufftime;}

}
