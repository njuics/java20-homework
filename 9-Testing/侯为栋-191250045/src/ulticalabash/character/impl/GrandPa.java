package ulticalabash.character.impl;

import ulticalabash.character.God;
import ulticalabash.factory.impl.FactoryCalabash;
import ulticalabash.util.Gender;
import ulticalabash.util.Sort;

import java.util.Collections;

public class GrandPa extends God<Calabash> {

    FactoryCalabash factory;

    public GrandPa() {
        this.factory = new FactoryCalabash();
    }

    @Override
    public void sortChildren() {
        Sort.sort(this.children, this.buildComparator());
    }

    @Override
    public void shuffleChildren() {
        Collections.shuffle(this.children);
    }

    @Override
    public Calabash newChild() {
        return this.factory.create();
    }

    @Override
    public Calabash newChild(String name, Gender sex) {
        return this.factory.create(name, sex);
    }

    @Override
    public int compare(Calabash o1, Calabash o2) {
        return this.buildComparator().compare(o1, o2);
    }


}
