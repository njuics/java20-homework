package Gourd;

public  abstract class GourdBaby implements Method{
    private int ranking;
    private String name;
    public GourdBaby() {
    }
    public GourdBaby(int ranking, String name) {
        this.ranking = ranking;
        this.name = name;
    }
    public int getRanking() {
        return this.ranking;
    }
    public String getName() {
        return this.name;
    }
    public void reportName() {

    }

}
