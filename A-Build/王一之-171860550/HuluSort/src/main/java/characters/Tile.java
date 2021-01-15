package characters;


public class Tile implements Comparable<Tile> {//可容纳一个葫芦娃的位置
    private Unit member;
    boolean isEmpty;
    private int row;
    private int col;

    public Tile(Unit m) {
        member = m;
        isEmpty = false;
    }

    public Tile() {
        member = null;
        isEmpty = true;
    }

    public Unit leave() {
        if (isEmpty)
            return null;
        isEmpty = true;
        return member;
    }

    public boolean enter(Unit m) {
        if (!isEmpty)
            return false;
        isEmpty = false;
        member = m;
        return true;
    }

    public Unit getMember() {
        if (isEmpty)
            return null;
        return member;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public static void swap(Tile ga, Tile gb) {
        Unit a;
        Unit b;
        if (ga.isEmpty) {
            if (!gb.isEmpty) {
                b = gb.leave();
                ga.enter(b);
            }
        } else if (gb.isEmpty) {
            a = ga.leave();
            gb.enter(a);
        } else {
            a = ga.leave();
            b = gb.leave();
            ga.enter(b);
            gb.enter(a);
        }
    }

    @Override
    public int compareTo(Tile t) {
        if (!(member instanceof HuLuWa))
            return 0;
        HuLuWa hulu = (HuLuWa) member;
        return hulu.compareTo(t.getMember());
    }
}