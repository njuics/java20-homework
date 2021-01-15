package src.hulusort;
public class Huluwa extends Hulu implements Comparable<Huluwa>{
    static int numHuluwa;
    private int rank;
    static{
        numHuluwa=0;
    }

    String name;
    public Huluwa() {
        super();
        rank=0;
        numHuluwa++;
    }
    public Huluwa(int color,String name) {
        super(color);
        rank=0;
        numHuluwa++;
        this.name=name;
    }

    public void sayName() {
        System.out.print(name);
    }
    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }

    void message(int color) {
        if (color<super.getColor()) {
            rank++;
        }
    }

    @Override
    public int compareTo(Huluwa o) {
        if(super.getColor()<o.getColor())
            return -1;
        else if(super.getColor()==o.getColor())
            return 0;
        else 
            return 1;
    }

}