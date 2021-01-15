package characters;

public class HuLuWa extends Unit{
    public enum HuLuColor {
        RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE
    }

    public final int rank;
    public final HuLuColor color;

    public HuLuWa(int rank, HuLuColor color) {
        this.rank = rank;
        this.color = color;
        this.pos = -1;//无位置
    }

    @Override
    public String sayName() {
        return ""+rank;
    }

    public boolean compare(Unit hulu) {
        if(hulu instanceof HuLuWa)
            return ((HuLuWa)hulu).rank < rank;
        return false;
    }
}