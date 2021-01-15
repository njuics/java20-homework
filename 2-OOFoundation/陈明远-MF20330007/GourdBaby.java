import java.security.UnrecoverableKeyException;

public class GourdBaby {
    private String name;
    private int rank;
    public GourdBaby(String name, int rank) {
        this.name = name;
        this.rank  = rank;
    }
    public String getName() {
        return this.name;
    }
    public int getRank() {
        return this.rank;
    }
    public void reportNumber(String name) {
        System.out.println(name);
    }
}
