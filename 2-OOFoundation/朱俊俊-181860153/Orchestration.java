public class Orchestration {
    static int grandpaCompare(Hulu a, Hulu b) {
        return a.getIndex() - b.getIndex();
    }

    static void grandpaSwap(Hulu[] hulus, int a, int b) {
        Hulu tmp = hulus[a];
        hulus[a] = hulus[b];
        hulus[b] = tmp;
    }

    static void sort(Hulu[] hulus) {
        int n = hulus.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (grandpaCompare(hulus[j], hulus[j + 1]) > 0) {
                    grandpaSwap(hulus, j, j + 1);
                }
            }
        }
    }
}