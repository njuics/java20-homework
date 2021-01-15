package ulticalabash.character.impl;

import ulticalabash.character.Creature;
import ulticalabash.util.Gender;

public class Calabash extends Creature {

    public Calabash() {
        super();
    }

    public Calabash(String name, Gender sex) {
        super(name, sex);
    }

    @Override
    protected Object clone() {
        Calabash res = new Calabash(this.name, this.sex);
        return res;
    }


}
