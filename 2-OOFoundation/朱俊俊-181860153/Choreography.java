public class Choreography {
    static void sort(Hulu[] hulus) {
        int n = hulus.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (hulus[j].selfCompare(hulus[j + 1]) > 0) {
                    Hulu.selfSwap(hulus, j, j + 1);
                }
            }
        }
    }
}