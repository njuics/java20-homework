public class GourdBaby {
    private String name;
    private int ranking;
    public GourdBaby(String name,int ranking){
        this.name = name;
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }
    public int getRanking(){
        return ranking;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setRanking(int ranking){
        this.ranking = ranking;
    }

    public void countOff(){
        System.out.println(name);
    }
}
