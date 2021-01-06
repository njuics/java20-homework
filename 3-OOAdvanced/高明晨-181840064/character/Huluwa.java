package character;
public class Huluwa{
    private int index;
    private String name;
    public static int num;
    static{
        num=0;
    }
    public Huluwa(){
        this(1);
    }
    public Huluwa(int index){
        Huluwa.num++;
        this.index=index;
        name=getNameFromIndex(index);
    }    

    public boolean isSmall(Huluwa y){
        if(this.index<y.index){ 
            return true;
        }
        else{
            return false;
        }
    }
    public void exchange(Huluwa y){
        int x_index=index;
        int y_index=y.answerIndex();
        setIndex(y_index);
        y.setIndex(x_index);
    }
    public String answerName(){
        return name;
    }
    public int answerIndex(){
        return index;
    }
    public void setIndex(int index){
        this.index=index;
        name=getNameFromIndex(index);
    }
    private String getNameFromIndex(int index){
        String Name=new String();
        switch (index) {
            case 1:
                Name="老大";
                break;
            case 2:
                Name="老二";
                break;
            case 3:
                Name="老三";
                break;
            case 4:
                Name="老四";
                break;
            case 5:
                Name="老五";
                break;
            case 6:
                Name="老六";
                break;
            case 7:
                Name="老七";
                break;
            default:
                break;
        }
        return Name;
    }
}