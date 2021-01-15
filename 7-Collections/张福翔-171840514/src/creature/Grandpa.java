package creature;

import utils.ArraySorter;

public class Grandpa extends Creature {
    public Grandpa() {}
    public void sortOrchestration(HuluBaby[]huluBabies) {
        ArraySorter sorter = new ArraySorter();
        sorter.quickSort(huluBabies);
    }
}
