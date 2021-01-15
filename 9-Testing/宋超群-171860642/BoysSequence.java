import java.util.ArrayList;

//葫芦娃队列
public class BoysSequence <Boy extends CalabashBoy>{
    public ArrayList<CalabashBoy> boysList;
    BoysSequence(){
        boysList = new ArrayList<>();
    }

    void add(Boy newBoy){
        boysList.add(newBoy);
    }

    //按序输出葫芦娃名单
    void outputNameList(){
        for(CalabashBoy boy : boysList){
            System.out.println(boy.getName());
        }
    }

    //葫芦娃按序进行自我介绍
    void outputSequence(){
        for(CalabashBoy boy : boysList){
            System.out.println(boy.toString());
        }
    }
}