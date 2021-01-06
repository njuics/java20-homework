package human;

public class Hulu {
    private String name;
    private int rank;
    
    public static int count;
    static{
        count = 0;
    }

    public Hulu(String name, int rank){
        Hulu.count++;
        this.name = name;
        this.rank = rank;
    }

    public int getRank(){
        return this.rank;
    }

    public int getOtherRank(Hulu hulu){
        return hulu.getRank();
    }

    public void exchangePos(Hulu hulu){
        String tmpName = hulu.name;
        hulu.name = this.name;
        this.name = tmpName;
        int tmpRank = hulu.rank;
        hulu.rank = this.rank;
        this.rank = tmpRank;
    }

    public void soundOff(){
        System.out.print(this.name + ' ');
    }
}
