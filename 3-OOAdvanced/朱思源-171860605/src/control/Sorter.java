package control;

import map.*;
import object.Boy;

public interface Sorter {
    public int comparable(Boy b1, Boy b2);
    public void sort(Queue queue);
}
