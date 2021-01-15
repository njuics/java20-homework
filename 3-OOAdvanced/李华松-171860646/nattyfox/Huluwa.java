package nattyfox;
class Human{

}
public class Huluwa extends Human{
    static String guardian = "A old man";

    private int rank;
    int pos;
    private String name

    
    static void jiaoyeye(){
        System.out.println(guardian);
    }
    
    Huluwa(){
        rank = 0;
        pos = 0;
        name = "";
    }
    Huluwa(int r,int pos){
        this.rank = r;
        this.pos = pos;
        setName();
       
    }
    public void setRank(int r){
        this.rank = r;
    }
    public void setPos(int pos){
        
        this.pos = pos;
    }
    public void setName(){
        switch (this.rank) {
            case 0:
                name = "Red 老大";
                break;
            case 1:
                name = "Orange 老二";
                break;
            case 2:
                name = "Yellow 老三";
                break;
            case 3:
               name = "Green 老四";
                break;
            case 4:
                name = "Cyan 老五";
                break;
            case 5:
                name = "Blue 老六";
                break;
            case 6:
               name = "Purple 老七";
                break;
            default:
                break;
        }
    }
    void  moveTo(int rank){
        this.rank = rank;
        setName();
    }
    public int getRank(){
        return this.rank;
    }
    public String getName(){
        return this.name;
    }
    void exchangePosition(Huluwa huluwa){
        int tempRank = this.rank;
        String tempName = this.name;
        this.rank = huluwa.rank;
        this.name = huluwa.name;
        huluwa.rank = tempRank;  
        huluwa.name = tempName;
    }
    void countOff(){
        System.out.print(this.name + " ");
    }
}