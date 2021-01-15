package character;
public class CalabashBrother extends Character {
    private int rank;
    public CalabashBrother(int number, String name) {
        rank = number;
        this.name = name;
    }
    public int getRank(){
        return rank;
    }
    public void setRank(int rank){
        this.rank = rank;
    }
    public void numberOff(){
        System.out.print(name+" ");
    }
    public boolean compare(CalabashBrother b){
        return this.rank <= b.rank;
    }
    public void swap(CalabashBrother b){
        int tempR = this.rank;
        String tempN = this.name;
        this.setName(b.name);
        this.setRank(b.rank);
        b.setRank(tempR);
        b.setName(tempN);
    }
}
