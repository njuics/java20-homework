public class HuLuWa extends Unit {
    enum HuLuColor {
        RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE
    }

    final int rank;
    final HuLuColor color;

    public HuLuWa(int rank, HuLuColor color) {
        this.rank = rank;
        this.color = color;
        this.pos = -1;//无位置
    }

    public boolean compareRank(HuLuWa hulu) {
        return hulu.rank < rank;
    }
}