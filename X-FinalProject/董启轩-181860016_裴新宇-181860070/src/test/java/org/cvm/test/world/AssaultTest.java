package org.cvm.test.world;

import org.cvm.world.Algorithm.Assault;
import org.junit.Test;
import org.junit.Before;
import org.junit.Assert.*;
import org.cvm.world.Character.CalabashBrother;
import org.cvm.world.Character.Monster;

public class AssaultTest {
    CalabashBrother attacker;
    Monster defender;
    Assault a;
    @Before
    public void construction(){
        attacker=new CalabashBrother(100,100,0,0,400,1);
        defender=new Monster(100,100,0,0,400,1);
        a=new Assault();
    }

    @Test
    public void DamageTest(){
        int Damage=a.DamageCaculate(attacker,defender);
        int CalculateDamage=(int)(attacker.getAttack()/(1+(defender.getArmor()/100)));
        if(Damage==-1 || Damage==(int)(1.5*CalculateDamage)){
            System.out.println("May have Error in Miss or critialDamage");
        }
        assert(Damage==CalculateDamage);
    }

}
