package org.cvm.world.Buff;

public class ArmorBuff {
    private int ArmorChange;
    private int Armorbufftime;
    public ArmorBuff()
    {
        Armorbufftime=0;
        ArmorChange=0;
    }
    public ArmorBuff(int ArmorChange, int Armorbufftime){
        this.ArmorChange=ArmorChange;
        this.Armorbufftime=Armorbufftime;
    }
    public boolean Armorbuffoverdue(){
        return Armorbufftime==0;
    }
    public void countdown(){
        if(Armorbufftime>0) Armorbufftime--;
    }

    public int getArmorChange() {
        return ArmorChange;
    }

    public int getArmorbufftime() {
        return Armorbufftime;
    }
}
