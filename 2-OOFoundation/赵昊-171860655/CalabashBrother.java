public class CalabashBrother {
    private int rank;
    private String name;
    CalabashBrother(int number) {
        rank = number;
        switch (rank) {
            case 1 -> name = "老大";
            case 2 -> name = "老二";
            case 3 -> name = "老三";
            case 4 -> name = "老四";
            case 5 -> name = "老五";
            case 6 -> name = "老六";
            case 7 -> name = "老七";
            default -> System.out.println("没有这个葫芦娃排行");
        }
    }
    public int getRank(){
        return rank;
    }
    public String getName(){
        return name;
    }
    public void setRank(int rank){
        this.rank = rank;
    }
    public void setName(String name){
        this.name = name;
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
