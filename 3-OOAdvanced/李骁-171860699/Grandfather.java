package lixiao.grandfather;

import lixiao.huluwa.*;
import lixiao.sortalgorithm.*;

public final class Grandfather {
    private static Grandfather grandfather;

    static {
        grandfather = null;
    }

    private Grandfather() {}
    
    public static Grandfather getInstance() {
        if (grandfather == null) {
            grandfather = new Grandfather();
        }
        return grandfather;
    }

    public void sortHuluwa(Huluwa[] queue) {
        SortAlgorithm.sort(queue);
    }
}