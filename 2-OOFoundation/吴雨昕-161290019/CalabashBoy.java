import java.util.Random;
class CalabashBoy{
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

class BoyQueue{
    public CalabashBoy[] queue;
    public BoyQueue(){
        queue = new CalabashBoy[7];
        for(int i=0;i<7;i++){
            queue[i] = new CalabashBoy(i+1);
        }
    }
    public void shuffle(){
        Random rand = new Random();
        for(int i=0;i<7;i++){
            int rand_pos = rand.nextInt(7);
            queue[i].swap(queue[rand_pos]);
        }
    }
    public void show(){
        for(CalabashBoy boy: queue){
            boy.print();
        }
    }

    //找到编号为index的葫芦娃的位置
    public int findBoy(int index){
        for(int i=0;i<queue.length;i++){
            if(queue[i].getNo()==index)
                return i;
        }
        return -1;
    }
}