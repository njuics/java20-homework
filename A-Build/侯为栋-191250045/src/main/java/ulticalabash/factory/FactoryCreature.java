package ulticalabash.factory;

import ulticalabash.character.Creature;
import ulticalabash.util.Gender;

public interface FactoryCreature {

    Creature create();

    Creature create(String name, Gender sex);
}
