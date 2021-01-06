package cn.edu.nju.wuyuxin;

public class CalabashBoy{
    private String name;
    private int No;

    public CalabashBoy(int no){
        this.No = no;
        switch (no){
            case 1:this.name="老大";break;
            case 2:this.name="老二";break;
            case 3:this.name="老三";break;
            case 4:this.name="老四";break;
            case 5:this.name="老五";break;
            case 6:this.name="老六";break;
            case 7:this.name="老七";break;
        }
    }
    //用于orchestration模式
    public int getNo(){
        return No;
    }
    public void print(){
        System.out.println(name);
    }

    //用于choreography模式
    public boolean cmp(CalabashBoy boy){
        return this.No>boy.No;
    }
    public void swap(CalabashBoy boy){
        String tempName = this.name;
        int tempNo = this.No;
        this.name = boy.name;
        this.No = boy.No;
        boy.name = tempName;
        boy.No = tempNo;
    }
}

