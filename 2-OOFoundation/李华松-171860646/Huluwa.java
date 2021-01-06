class Huluwa{
   
    int rank;
    int pos;

    Huluwa(){
        rank = 0;
        pos = 0;
    }
    Huluwa(int r,int pos){
        this.rank = r;
        this.pos = pos;
       
    }
    public void setRank(int r){
        this.rank = r;
    }
    public void setPos(int pos){
        
        this.pos = pos;
    }
    void  moveTo(int rank){
        this.rank = rank;
    }
    void exchangePosition(Huluwa huluwa){
        int tempRank = this.rank;
        this.rank = huluwa.rank;
        huluwa.rank = tempRank;  
    }
    void countOff(){
        String name = "'";
        switch (this.rank) {
            case 0:
                name = "老大";
                break;
            case 1:
                name = "老二";
                break;
            case 2:
                name = "老三";
                break;
            case 3:
               name = "老四";
                break;
            case 4:
                name = "老五";
                break;
            case 5:
                name = "老六";
                break;
            case 6:
               name = "老七";
                break;
            default:
                break;
        }
        System.out.print(name + " ");
    }
}