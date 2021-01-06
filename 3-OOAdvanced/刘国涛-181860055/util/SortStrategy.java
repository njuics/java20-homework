package util;

import java.util.Comparator;

import model.Calabash;

public interface SortStrategy {
    public void sort(Calabash[] calabashs,Comparator<Calabash> cmp);
    
}
