package characters;

import java.util.Random;

public class Ground {
    private Tile []tiles;
    public Ground(int num){
        tiles=new Tile[num];
    }
    public void printTile() {
        for (Tile g : tiles) {
            if (!g.isEmpty())
                System.out.println( g.getMember().sayName());
            else
                System.out.println("此处为空");
        }
        System.out.println();
    }

    public void randomInit(Unit[] units) {//将units中的单元随机分配到ground中
        if (tiles.length < units.length)
            return;//error
        int len = units.length;
        int[] array = new int[len];
        for (int i = 0; i < len; ++i) {
            array[i] = 0;
        }
        int pos;
        Random r = new Random();
        for (int i = 0; i < len; ++i) {//生成随机序列
            do {
                pos = r.nextInt(len - 1);
            } while (array[pos] != 0);
            array[pos] = i;
        }

        for (int i = 0; i < len; ++i) {//用该序列初始化位置
            tiles[i] = new Tile(i, units[array[i]]);
        }
    }

    public void sortOrchestration() {//指挥 冒泡
        for (int i = 1; i < tiles.length; ++i)
            for (int j = 0; j < tiles.length - i; ++j) {
                if (!tiles[j].getMember().compare(tiles[j+1].getMember())){
                    Tile.swap(tiles[j],tiles[j + 1]);
                }
            }
    }
    public void sortChoreography(Unit[] hulu) {//协作
        boolean flag = false;
        while (!flag) {//若进行了位置交换则继续
            flag = true;
            for (Unit h : hulu) {//每个身后有人的葫芦娃看自己是否需要和身后交换位置
                if (h.getPos() < tiles.length - 1 && h.compare((HuLuWa) tiles[h.getPos() + 1].getMember())) {
                    flag = false;
                    Tile.swap(tiles[h.getPos()], tiles[h.getPos() + 1]);//交换位置
                }
            }
        }
    }
}
