import java.util.Random;
import Sort.*;
import CalabashBrothers.* ;
public class Homework3 {
    static CalabashBoy[] brothers;
    static int Num;
    static{
        Num=7;
        brothers=new CalabashBoy[Num];
    }
     
    
    
    
    void construct_queue(){
        int[] num=new int[Num];
        Random r=new Random();
        for(int i=0;i<Num;i++){
            int a=r.nextInt(Num);
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
        for(int i=0;i<Num;i++)
        {
            switch(num[i]){
                case 0: brothers[i]=new CalabashBoy(0,"老大");break;
                case 1: brothers[i]=new CalabashBoy(1,"老二");break;
                case 2: brothers[i]=new CalabashBoy(2,"老三");break;
                case 3: brothers[i]=new CalabashBoy(3,"老四");break;
                case 4: brothers[i]=new CalabashBoy(4,"老五");break;
                case 5: brothers[i]=new CalabashBoy(5,"老六");break;
                case 6: brothers[i]=new CalabashBoy(6,"老七");break;
                default:break;
            }
        }
        
    }

    void count_off(){
        
        for(CalabashBoy i:brothers)i.output();
    }

    public static void main(String[] args) {
        Homework3 hw3=new Homework3();

        //Choreography
        hw3.construct_queue();//生成随机队列
        hw3.count_off();
        System.out.println("");
        Ssort s=new Choreography();//选择排序方法
        s.sort(brothers,Num);
        hw3.count_off();
        System.out.println("\n");
        

        //Orchestration
        hw3.construct_queue();
        hw3.count_off();
        System.out.println("");
        s=new Orchestration();
        s.sort(brothers,Num);
        hw3.count_off();
    }

    
    
}
