public class Creature {

    protected double life;       /* 生命值 */

    protected double anger_level;     /* 怒气值 */

    protected double attack;        /* 攻击力 */

    protected double defence;       /* 防御值 */

    Creature() {
        this.life = 100.0;
        this.anger_level = 0.0;
        this.attack = 10.0;
        this.defence = 1.0;
    }

    public double get_life() {
        return this.life;
    }

    public double get_anger_level() {
        return this.anger_level;
    }

    public double get_attack() {
        return this.attack;
    }
    
    public double get_defence() {
        return this.defence;
    }
    
    public String get_name() {
        return "Creature";
    }
    
    public int walk() {
        return 0;
    }
}