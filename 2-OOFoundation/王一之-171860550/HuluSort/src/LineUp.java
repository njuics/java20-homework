import java.util.Random;

public class LineUp {
    public static void sortChoreography(Tile[] g, HuLuWa[] hulu) {//协作
        boolean flag = false;
        while (!flag) {//若进行了位置交换则继续
            flag = true;
            for (HuLuWa h : hulu) {//每个身后有人的葫芦娃看自己是否需要和身后交换位置
                if (h.pos < g.length - 1 && h.compareRank((HuLuWa) g[h.pos + 1].getMember())) {
                    flag = false;
                    Tile.swap(g[h.pos], g[h.pos + 1]);//交换位置
                }
            }
        }
    }

    public static void sortOrchestration(Tile[] g) {//指挥 冒泡
        for (int i = 1; i < g.length; ++i)
            for (int j = 0; j < g.length - i; ++j) {
                if (((HuLuWa) g[j].getMember()).rank < ((HuLuWa) g[j + 1].getMember()).rank) {
                    Tile.swap(g[j], g[j + 1]);
                }
            }
    }

    public static void randomInit(Tile[] g, HuLuWa[] h) {
        if (h.length != g.length)
            return;//error
        int len = g.length;
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
            g[i] = new Tile(i, h[array[i]]);
        }
    }

    public static void printTile(Tile[] ground) {
        for (Tile g : ground) {
            if (!g.isEmpty)
                System.out.println(((HuLuWa) g.getMember()).rank);
            else
                System.out.println("此处为空");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Tile[] ground = new Tile[7];//生成7块空地

        HuLuWa[] hulu = new HuLuWa[7];
        hulu[0] = new HuLuWa(1, HuLuWa.HuLuColor.RED);
        hulu[1] = new HuLuWa(2, HuLuWa.HuLuColor.ORANGE);
        hulu[2] = new HuLuWa(3, HuLuWa.HuLuColor.YELLOW);
        hulu[3] = new HuLuWa(4, HuLuWa.HuLuColor.GREEN);
        hulu[4] = new HuLuWa(5, HuLuWa.HuLuColor.CYAN);
        hulu[5] = new HuLuWa(6, HuLuWa.HuLuColor.BLUE);
        hulu[6] = new HuLuWa(7, HuLuWa.HuLuColor.PURPLE);

        randomInit(ground, hulu);
        System.out.println("init:");
        printTile(ground);

        sortOrchestration(ground);
        System.out.println("after Orchestration:");
        printTile(ground);

        sortChoreography(ground, hulu);
        System.out.println("after Choreography:");
        printTile(ground);

    }

}