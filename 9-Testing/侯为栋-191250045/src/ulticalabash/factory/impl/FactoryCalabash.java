package ulticalabash.factory.impl;

import ulticalabash.character.impl.Calabash;
import ulticalabash.factory.FactoryCreature;
import ulticalabash.util.Gender;

public class FactoryCalabash implements FactoryCreature {

    @Override
    public Calabash create() {
        return new Calabash();
    }

    @Override
    public Calabash create(String name, Gender sex) {
        return new Calabash(name, sex);
    }
}
