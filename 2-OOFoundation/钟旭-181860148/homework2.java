
import java.util.Random;

class CalabashBoy{
    public  int id;
    CalabashBoy(int num){
        id=num;
    }
    public void count(){
        switch(id){
            case 0:System.out.print("老大 ");break;
            case 1:System.out.print("老二 ");break;
            case 2:System.out.print("老三 ");break;
            case 3:System.out.print("老四 ");break;
            case 4:System.out.print("老五 ");break;
            case 5:System.out.print("老六 ");break;
            case 6:System.out.print("老七 ");break;
            default:break;
        }
    }
}

class queue{
    public void sort(CalabashBoy[] brothers){}
    public void swap(CalabashBoy a,CalabashBoy b){
        int tmp=a.id;
        a.id=b.id;
        b.id=tmp;
    }
}

class Orchestration extends queue{
    @Override
    public void sort(CalabashBoy[] brothers){
        for(int i=0;i<7;i++){
            while(brothers[i].id!=i){
                swap(brothers[i],brothers[brothers[i].id]);
            }
        }
    }
}

class Choreography extends queue{
    @Override
    public void sort(CalabashBoy[] brothers){
        for(int i=0;i<7;i++){
            for(int j=6;j>i;j--){
                if(brothers[j].id<brothers[j-1].id)swap(brothers[j],brothers[j-1]);
            }
        }
    }

}

public class homework2 {
    int[] num=new int[7];
    static CalabashBoy[] brothers=new CalabashBoy[7];
    public static void main(String[] args) {
        homework2 hw2=new homework2();
        hw2.construct_queue();//生成随机队列
        hw2.count_off();//报数
        System.out.println("");
        queue gf=new Choreography();//选择排序方法
        //queue gf=new Orchestration();
        gf.sort(brothers);
        hw2.count_off();
        

    }
    void count_off(){
        for(int i=0;i<7;i++)
           brothers[i].count();
    }

    void construct_queue(){
        Random r=new Random();
        for(int i=0;i<7;i++){
            int a=r.nextInt(7);
            boolean flag=false;
            for(int j=0;j<i;j++){
                if(num[j]==a){
                    flag=true;
                    break;
                }
            }
            if(flag==true){i--;continue;}
            else num[i]=a;
        }
        for(int i=0;i<7;i++)brothers[i]=new CalabashBoy(num[i]);
    }
    
}
