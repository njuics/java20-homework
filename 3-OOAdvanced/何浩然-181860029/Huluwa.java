public class Huluwa extends Creature implements Sorting{
    static{
        race="Huluwa";
    }
    Huluwa(int range){
        this.range = range;
        this.pos=-1;
        switch(range){
            case 1:name="老大";break;
            case 2:name="老二";break;
            case 3:name="老三";break;
            case 4:name="老四";break;
            case 5:name="老五";break;
            case 6:name="老六";break;
            case 7:name="老七";break;
            default:break;
        }
    }
    @Override
    public void sort(Huluwa[] h){//choreography_sort
        if(pos<h.length-1){//该葫芦娃在队首，那么只跟后一个葫芦娃比较年纪大小
            if(this.range>h[pos+1].range){

                Huluwa temp=h[pos];
                h[pos]=h[pos+1];
                h[pos+1]=temp; 
                
                h[pos].pos--;
                this.pos++;
               
            }
        }
    }

}