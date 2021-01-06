package OOAdvanced.characters;

public class Huluwa extends Human implements Comparable<Huluwa>{

    public int num;

    public Huluwa(int n, String nm){
        super(nm);
        num = n;
    }

    @Override
    public int compareTo(Huluwa o) {
        return num - o.num;
    }

    public void swapWith(Huluwa o){

        int temp = num;
        num = o.num;
        o.num = temp;

        String nm = name;
        name = o.name;
        o.name = nm;

    }
}
