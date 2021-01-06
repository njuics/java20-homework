package characters;

public class Tile {//可容纳一个葫芦娃的位置
    private Unit member;
    boolean isEmpty;
    final int pos;

    public Tile(int p, Unit m) {
        pos = p;
        member = m;
        m.pos = this.pos;
        isEmpty = false;
    }

    public Tile(int p) {
        pos = p;
        member = null;
        isEmpty = true;
    }

    public Unit leave() {
        if (isEmpty)
            return null;
        isEmpty = true;
        member.pos = -1;
        return member;
    }

    public boolean enter(Unit m) {
        if (!isEmpty)
            return false;
        isEmpty = false;
        member = m;
        member.pos = this.pos;
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
}