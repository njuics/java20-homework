public class Huluwa{
    int index;
    String name;

    Huluwa(){
    }
    Huluwa(int index){
        this.index=index;
        switch (index) {
            case 1:
                name="老大";
                break;
            case 2:
                name="老二";
                break;
            case 3:
                name="老三";
                break;
            case 4:
                name="老四";
                break;
            case 5:
                name="老五";
                break;
            case 6:
                name="老六";
                break;
            case 7:
                name="老七";
                break;
            default:
                break;
        }
    }
    boolean is_small(Huluwa y){
        if(this.index<y.index){ 
            return true;
        }
        else{
            return false;
        }
    }
    void exchange(Huluwa y){
        Huluwa temp=new Huluwa();
        temp.name=this.name;
        temp.index=this.index;
        this.name=y.name;
        this.index=y.index;
        y.name=temp.name;
        y.index=temp.index;

    }
    void answer(){
        System.out.println(this.name);
    }
}