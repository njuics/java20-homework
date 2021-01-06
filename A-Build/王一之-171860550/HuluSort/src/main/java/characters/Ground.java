package characters;

import characters.HuLuWa;
import characters.Tile;
import characters.Unit;

import java.util.*;

public class Ground {
    private final ArrayList<ArrayList<Tile>> tiles;

    public Ground(int col) {//初始化为共col列，至少为1
        tiles = new ArrayList<>();
        if (col < 1)
            tiles.add(new ArrayList<Tile>());
        for (int i = 0; i < col; ++i) {
            tiles.add(new ArrayList<Tile>());
        }
    }

    public ArrayList<Tile> getColumn(int n){
        return tiles.get(n);
    }
    public void printColumn(int n) {
        for (Iterator<Tile> it = tiles.get(n).iterator(); it.hasNext(); ) {
            Tile t = it.next();
            if (!t.isEmpty())
                System.out.println(t.getMember().toString());
            else
                System.out.println("此处为空");
        }
        System.out.println();
    }

    public void sort(int col, int mode) {//1 正序 2 逆序 3乱序
        ArrayList<Tile> t = tiles.get(col);
        switch (mode) {
            case 1:
                Collections.sort(t);
                break;
            case 2:
                Collections.sort(t);
                Collections.reverse(t);
                break;
            case 3:
                Collections.shuffle(t);
        }
    }

    public void divideByGender(int col) {
        ArrayList<Tile> maleList = new ArrayList<Tile>();
        ArrayList<Tile> femaleList = new ArrayList<Tile>();
        for (Iterator<Tile> it = tiles.get(col).iterator(); it.hasNext(); ) {
            Tile t = it.next();
            if (t.getMember() != null && t.getMember() instanceof HuLuWa) {
                HuLuWa hulu = (HuLuWa) t.getMember();
                if (hulu.gender == HuLuWa.Gender.MALE)
                    maleList.add(t);
                else if (hulu.gender == HuLuWa.Gender.FEMALE)
                    femaleList.add(t);
            }
        }
        tiles.set(0, maleList);
        tiles.set(1, femaleList);
    }
    /*public Unit leave(int col, int pos) {//第几列第几个
        return tiles.get(col).get(pos).leave();
    }

    public boolean enter(int col, int pos, Unit m) {

        return tiles.get(col).get(pos).enter(m);
    }

    public Unit getMember(int col, int pos) {
        return tiles.get(col).get(pos).getMember();
    }

    public boolean isEmpty(int col, int pos) {
        return tiles.get(col).get(pos).isEmpty();
    }*/

    public void init(int col,Unit[] units) {//将units中的单元随机分配到ground中
        int len = units.length;
        for (Unit unit : units) {//用该序列初始化位置
            tiles.get(col).add(new Tile(unit));
        }
    }
}
