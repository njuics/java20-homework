public class CalabashBrother {
    private int id;
    private String name;
    public CalabashBrother(int id, String name){
        this.id = id;
        this.name = name;
    }
    public boolean compareTo(CalabashBrother another){
        return this.id<=another.id;
    }
    public void exchange(CalabashBrother another){
        int tempId = another.id;
        String tempName = another.name;

        another.id = this.id;
        another.name = this.name;

        this.id = tempId;
        this.name = tempName;
    }
    public void report(){
        System.out.print(name);
    }
    public int getId(){return id;}
}
