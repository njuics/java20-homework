public class Huluwasorting{
    public static void main( String[] args){
        Grandfather grandfather=new Grandfather();
        Huluwa[] huluwa=new Huluwa[7];
        System.out.print("未排序前的顺序: ");
        for(int i=0;i<huluwa.length;i++){
           huluwa[i]=new Huluwa(huluwa.length-i);
           System.out.print(huluwa[i].name+" ");
        }
        grandfather.orchestration_sort(huluwa);
        System.out.println("\n"+"orchestration排序后数组：");
        for(int i=0;i<huluwa.length;i++){
            System.out.print(huluwa[i].name+" ");
        }
        //
        System.out.print("\n"+"未排序前的顺序: ");
        for(int i=0;i<huluwa.length;i++){
           huluwa[i]=new Huluwa(huluwa.length-i);
           huluwa[i].pos=i;
           System.out.print(huluwa[i].name+" ");
        }
        int j=huluwa.length;
        while(j>1){
            for(int i=0;i<j;i++){
                huluwa[i].choreography_sort(huluwa);
            }
            j--;
        }
        System.out.println("\n"+"choreography排序后数组：");
        for(int i=0;i<huluwa.length;i++){
            System.out.print(huluwa[i].name+" ");
        }

    }
}
class Huluwa{//葫芦娃
    int range;
    int pos;
    String name;
    Huluwa(int range){
        this.range=range;
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
    void choreography_sort(Huluwa[] h){
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
class Grandfather{//葫芦娃爷爷
    void orchestration_sort(Huluwa[] h){
        int minpos=0;
        Huluwa mintemp=h[0];
        int j=h.length;
        while(j>1){//选择排序,爷爷每次找到葫芦娃中年纪最小的，也就是排行最末的葫芦娃放到最后面去
            for(int i=0;i<j;i++){
                if(h[i].range>mintemp.range){
                    mintemp=h[i];
                    minpos=i;
                }
            }
            j--;
            h[minpos]=h[j];
            h[j]=mintemp;
            mintemp=h[0];
            minpos=0;
        }
    }

}