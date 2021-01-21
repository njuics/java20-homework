import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class Grandfather{
    boolean judge(Calabash c1,Calabash c2){
        return c1.level > c2.level;
    }
    void swap(Calabash c1,Calabash c2){
        int tempLevel = c2.level;
        c2.level = c1.level;
        c1.level = tempLevel;
    }
}
class Calabash{
    int level = -1;
    Calabash(){

    }
    Calabash(int level){
        this.level = level;
    }
    public boolean greater(Calabash c){
        return this.level >= c.level;
    }
    public void swapWith(Calabash c){
        //传入的是引用
        int tempLevel = c.level;
        c.level = this.level;
        this.level = tempLevel;
    }
    void show(){
        String name = "";
        switch (this.level){
            case 1:
                name = "老大";
                break;
            case 2:
                name = "老二";
                break;
            case 3:
                name = "老三";
                break;
            case 4:
                name = "老四";
                break;
            case 5:
                name = "老五";
                break;
            case 6:
                name = "老六";
                break;
            case 7:
                name = "老七";
                break;
            default:
                name = "error";
                break;
        }
        System.out.print(name+" ");
    }
}

interface Sort{
    void orchestration(Grandfather grandfather,List<Calabash> calabashList);
    void choreography(List<Calabash> calabashList);
}

interface Show{
    void show(List<Calabash> calabashList,String time);
}

class BubleSort implements Sort,Show{

    @Override
    public void orchestration(Grandfather grandfather, List<Calabash> calabashList) {
        System.out.println("orchestration");
        Random rand=new Random(47);
        Collections.shuffle(calabashList,rand);

        show(calabashList,"before sort");
        for(int j = 0; j < calabashList.size() - 1; ++j){
            int flag = 0;
            for(int i = 0; i < calabashList.size() - j - 1; ++i){
                if(grandfather.judge(calabashList.get(i),calabashList.get(i+1))){
                    grandfather.swap(calabashList.get(i),calabashList.get(i+1));
                    flag = 1;
                }
            }
            if(flag == 0){
                break;
            }
        }
        show(calabashList,"after sort");
    }

    @Override
    public void choreography(List<Calabash> calabashList) {
        System.out.println("choreography");
        Random rand=new Random(47);
        Collections.shuffle(calabashList,rand);
        show(calabashList,"before sort");
        for(int j = 0; j < calabashList.size() - 1; ++j){
            int flag = 0;
            for(int i = 0; i < calabashList.size() - j - 1; ++i){
                if(calabashList.get(i).greater(calabashList.get(i+1))){
                    calabashList.get(i).swapWith(calabashList.get(i+1));
                    flag = 1;
                }
            }
            if(flag == 0){
                break;
            }
        }
        show(calabashList,"after sort");
    }

    @Override
    public void show(List<Calabash> calabashList,String time) {
        System.out.println(time);
        for(Calabash calabash : calabashList){
            calabash.show();
        }
        System.out.println();
    }
}

public class Main {
    public static void mySort(Sort sort,Grandfather grandfather, List<Calabash> calabashList){
        sort.orchestration(grandfather,calabashList);
        sort.choreography(calabashList);
    }
    public static void main(String[] args){
        List<Calabash> calabashList = new ArrayList<>();
        Grandfather grandfather = new Grandfather();
        for(int i = 1; i <= 7; ++i){
            calabashList.add(new Calabash(i));
        }
        BubleSort bubleSort = new BubleSort();
        mySort(bubleSort,grandfather,calabashList);
    }
}
