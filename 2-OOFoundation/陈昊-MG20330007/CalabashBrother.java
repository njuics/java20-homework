public class CalabashBrother extends Human implements Comparable<CalabashBrother>{
    int idx;

    CalabashBrother(String name, int idx) {
        this.nickname = name;
        this.idx = idx;
    }

    @Override
    public int compareTo(CalabashBrother other) {
        if (this.idx < other.idx) {
            System.out.println(this.nickname + " said: I should be in front of you, " + other.nickname);
            return -1;
        } else if (this.idx > other.idx) {
            System.out.println(this.nickname + " said: I should be in behind of you, " + other.nickname);
            return 1;
        } else {
            return 0;
        }
    }
}
