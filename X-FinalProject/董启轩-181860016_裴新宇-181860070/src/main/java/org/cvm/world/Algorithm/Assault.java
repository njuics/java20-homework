package org.cvm.world.Algorithm;
import org.cvm.world.Buff.*;
import org.cvm.world.Character.*;

import java.util.List;
import java.util.Random;

public class Assault {
    public <T extends Creature> int DamageCaculate(T attacker,T defenser){
        int finaldamage=0;
        int Attack=attacker.getAttack();
        int Armor=defenser.getArmor();
        List<AttackBuff> attackBuffs=attacker.getAttackBuffs();
        List<ArmorBuff> armorBuffs=defenser.getArmorBuffs();
        int Attackbuffnumber=0;
        int Armorbuffnumber=0;
        for(AttackBuff att:attackBuffs){
            Attackbuffnumber=Attackbuffnumber+att.getAttackChange();
        }
        for(ArmorBuff arm:armorBuffs){
            Armorbuffnumber=Armorbuffnumber+arm.getArmorChange();
        }
        Attack=Attack+Attackbuffnumber;
        Armor=Armor+Armorbuffnumber;
        if(Armor<=0) finaldamage=Attack;
        else finaldamage=(int)(Attack/(1+(Armor/100)));
        if(ifcritical(attacker)) finaldamage=(int)(finaldamage*1.5);
        if(ifmiss(defenser)) return -1;
        else return finaldamage;
    }

    <T extends Creature> boolean ifcritical(T attacker){
        int critical=attacker.getCriticalStrike();
        Random random=new Random();
        int rand=random.nextInt(100);
        if(rand<critical) return true;
        else return false;
    }
    <T extends Creature> boolean ifmiss(T defenser){
        int miss=defenser.getMissrate();
        Random random=new Random();
        int rand=random.nextInt(100);
        if(rand<miss) return true;
        else return false;
    }
}

