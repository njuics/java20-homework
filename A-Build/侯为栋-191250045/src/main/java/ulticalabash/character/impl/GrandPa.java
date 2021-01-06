package ulticalabash.character.impl;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import ulticalabash.character.God;
import ulticalabash.factory.impl.FactoryCalabash;
import ulticalabash.util.Comparators;
import ulticalabash.util.CompareFlag;
import ulticalabash.util.Gender;
import ulticalabash.util.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

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
    public Pair<ArrayList<Calabash>, ArrayList<Calabash>> classify() {
        ArrayList<Calabash> boys = new ArrayList<>();
        ArrayList<Calabash> girls = new ArrayList<>();
        for (var child : this.children) {
            if (child.getSex().equals(Gender.BOY)) boys.add(child);
            else girls.add(child);
        }
        return new ImmutablePair<>(boys, girls);
    }

    @Override
    public Triple<ArrayList<Calabash>, ArrayList<Calabash>, ArrayList<Calabash>> classify(CompareFlag flag, String edge) {
        ArrayList<Calabash> resA = new ArrayList<>(this.children.stream().filter(a -> Comparators.dict(a.getFlag(flag), edge) < 0).collect(Collectors.toList()));
        ArrayList<Calabash> resB = new ArrayList<>(this.children.stream().filter(a -> Comparators.dict(a.getFlag(flag), edge) == 0).collect(Collectors.toList()));
        ArrayList<Calabash> resC = new ArrayList<>(this.children.stream().filter(a -> Comparators.dict(a.getFlag(flag), edge) > 0).collect(Collectors.toList()));
        return new ImmutableTriple<>(resA, resB, resC);
    }

    @Override
    public int compare(Calabash o1, Calabash o2) {
        return this.buildComparator().compare(o1, o2);
    }


}
