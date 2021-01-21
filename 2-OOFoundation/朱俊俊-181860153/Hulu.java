public class Hulu {
    static String[] name = new String[]{"老大", "老二", "老三", "老四", "老五", "老六", "老七"};
    int index;

    Hulu(int i) {
        index = i;
    }

    int getIndex() {
        return index;
    }

    String getName() {
        return name[index];
    }

    int selfCompare(Hulu hulu) {
        return index - hulu.index;
    }

    static void selfSwap(Hulu[] hulus, int i, int j) {
        Hulu tmp = hulus[i];
        hulus[i] = hulus[j];
        hulus[j] = tmp;
    }

    void countOff() {
        System.out.print(this.getName() + " ");
    }
}
