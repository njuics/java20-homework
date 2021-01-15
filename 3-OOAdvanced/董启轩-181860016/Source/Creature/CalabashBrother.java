package Source.Creature;

public class CalabashBrother extends Human{
    private final static int NUM_OF_BROTHERS=7;
    private int priority;
    public CalabashBrother(int p){
        priority=p;
        switch(priority){
            case 0:this.name="大娃";break;
            case 1:this.name="二娃";break;
            case 2:this.name="三娃";break;
            case 3:this.name="四娃";break;
            case 4:this.name="五娃";break;
            case 5:this.name="六娃";break;
            case 6:this.name="七娃";break;
        }
    }
    public int get_num(){
        int x=NUM_OF_BROTHERS;
        return x;
    }
    public String get_name(){
        return this.name;
    }
    public int get_priority(){
        int x=priority;
        return x;
    }
    public boolean cmp(CalabashBrother bro){
        return this.priority>bro.get_priority();
    }
    public void swap_with_next(CalabashBrother[] bro,int pos){
        CalabashBrother tmp=bro[pos];
        bro[pos]=bro[pos+1];
        bro[pos+1]=tmp;
    }
}