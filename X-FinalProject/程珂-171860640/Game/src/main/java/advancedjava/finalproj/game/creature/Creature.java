package advancedjava.finalproj.game.creature;

import advancedjava.finalproj.game.CampEnum;

import java.util.Random;

import static advancedjava.finalproj.game.creature.Utils.formatDouble;

public class Creature
{
    public static final double CRIT_GAIN = 1.2;
    public static final double DEFENSE_GAIN = 1.2;
    private double hpValue;
    private double damageValue;
    private double damageRangeValue;
    private double defenseValue;
    private boolean isDefensiveValue;
    private CampEnum camp;

    //暴击率
    private double propOfCritValue;


    protected Creature(double hpValue, double damageValue,
                       double damageRangeValue, double defenseValue, double propOfCritValue, CampEnum camp)
    {
        this.hpValue = hpValue;
        this.damageValue = damageValue;
        this.damageRangeValue = damageRangeValue;
        this.defenseValue = defenseValue;
        this.propOfCritValue = propOfCritValue;
        this.isDefensiveValue = false;
        this.camp = camp;
    }

    public double attack(Creature enemy, Random rand)
    {
        double attackDamage = this.damageValue;
        double defenseValue = enemy.defenseValue;
        //是否打出暴击
        if (rand.nextDouble() <= propOfCritValue)
            attackDamage *= CRIT_GAIN;
        //是否防御
        if (enemy.isDefensiveValue)
            defenseValue *= DEFENSE_GAIN;
        //攻击
        double harm = formatDouble(attackDamage / defenseValue);
        enemy.hpValue = formatDouble(enemy.hpValue - harm);
        return harm;
    }

    public boolean isDead()
    {
        return this.hpValue <= 0;
    }

    public void defense()
    {
        this.isDefensiveValue = true;
    }

    public void takeDownDefense()
    {
        this.isDefensiveValue = false;
    }

    public boolean isDefensive()
    {
        return this.isDefensiveValue;
    }

    public double getDamageRange()
    {
        return this.damageRangeValue;
    }

    public double getHp()
    {
        return this.hpValue;
    }

    public double getDamage()
    {
        return this.damageValue;
    }

    public double getDefense()
    {
        return this.defenseValue;
    }

    public CampEnum getCamp()
    {
        return this.camp;
    }

}