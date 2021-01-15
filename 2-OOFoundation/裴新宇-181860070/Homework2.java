import java.util.Random;

class Huluwa{
    int color;//0-6
    String name;
    Huluwa(int c){
        color = c;
        switch(color){
            case 0:name = "老大";break;
            case 1:name = "老二";break;
            case 2:name = "老三";break;
            case 3:name = "老四";break;
            case 4:name = "老五";break;
            case 5:name = "老六";break;
            case 6:name = "老七";break;
        }
    }
    void answer(){
        System.out.println(name);
    }
    int find_and_preempt(Huluwa[] arr){
        int index=0;
        for(int i=0;i<7;i++) {
            if(arr[i].color == color){
                index = i;
                break;
            }
        }
        if(index != color) {
            Huluwa t = arr[color];
            arr[color] = arr[index];
            arr[index] = t;
            return index;
        }
        else{
            return -1;
        }
    }
}

class GrandFather{
    void sort(Huluwa[] arr){
        for(int i=0;i<6;i++){
            for(int j=0;j<6-i;j++){
                if(arr[j].color>arr[j+1].color){
                    Huluwa t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
        }
    }
}

public class Homework2{
    public static void main(String []args){ 
        method1();
        method2();
    }
    public static void method1(){
        System.out.println("方法1：");
        Huluwa[] arr = new Huluwa[7];
        boolean[] sig = {false,false,false,false,false,false,false};
        Random r = new Random();
        for(int i=0;i<7;i++){
            int s = r.nextInt(7);
            if(sig[s]==true){
                i--;
            }
            else{
                sig[s] = true;
                arr[i] = new Huluwa(s);
            }
        }
        System.out.print("随机顺序为：");
        for(int i=0;i<7;i++){
            System.out.print(arr[i].color);
        }
        System.out.println();
        GrandFather gf = new GrandFather();
        gf.sort(arr);
        display(arr);
    }
    public static void method2(){
        System.out.println("方法2：");
        Huluwa[] arr = new Huluwa[7];
        boolean[] sig = {false,false,false,false,false,false,false};
        Random r = new Random();
        for(int i=0;i<7;i++){
            int s = r.nextInt(7);
            if(sig[s]==true){
                i--;
            }
            else{
                sig[s] = true;
                arr[i] = new Huluwa(s);
            }
        }
        System.out.print("随机顺序为：");
        for(int i=0;i<7;i++){
            System.out.print(arr[i].color);
        }
        System.out.println();
        int current = 0;
        for(int i=0;i<7;i++){
            int next = arr[current].find_and_preempt(arr);
            if(next == -1){
                for(int j=0;j<7;j++){
                    if(arr[j].color != j){
                        current = j;
                        break;
                    }
                }
            }
            else{
                current = next;
            }
        }
        display(arr);
    }
    public static void display(Huluwa[] arr){
        System.out.println("排序后排队报到：");
        for(int i=0;i<7;i++){
            arr[i].answer();
        }
        System.out.println();
    }
}