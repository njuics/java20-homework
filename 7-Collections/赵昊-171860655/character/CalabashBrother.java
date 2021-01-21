package character;
public class CalabashBrother extends Character implements Comparable<CalabashBrother>{
    private int rank;
    private int gender;
    public CalabashBrother(int number, String name,int gender) {
        rank = number;
        this.name = name;
        this.gender = gender;
    }
    public int getRank(){
        return rank;
    }
    public void setRank(int rank){
        this.rank = rank;
    }
    public int getGender(){
        return gender;
    }
    public void setGender(int gender){
        this.gender = gender;
    }
    public void numberOff(){
        System.out.print(name+" ");
    }
    public int compare(CalabashBrother b){
        return this.name.compareTo(b.name);
    }
    public void swap(CalabashBrother b){
        int temp1=getPosition();
        int temp2=b.getPosition();
        setPosition(temp2);
        b.setPosition(temp1);
    }

    @Override
    public int compareTo(CalabashBrother o) {
        return this.getName().compareTo(o.getName());
    }
}
