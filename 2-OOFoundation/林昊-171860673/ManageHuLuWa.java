import java.util.HashMap;
import java.util.Random;

public class ManageHuLuWa {
    private SingleHuLuWa huLuWaArray[];
    private Random rand = new Random();

    private void shuffle() {
        for (int i = 0; i < huLuWaArray.length; i++) {
            swap(i, rand.nextInt(huLuWaArray.length - i) + i);
        }
    }

    private void swap(int element1, int element2) {
        SingleHuLuWa temp = huLuWaArray[element1];
        huLuWaArray[element1] = huLuWaArray[element2];
        huLuWaArray[element2] = temp;
    }

    public ManageHuLuWa(){
        huLuWaArray = new SingleHuLuWa[7];
        huLuWaArray[0] = new SingleHuLuWa(1, "老大");
        huLuWaArray[1] = new SingleHuLuWa(2, "老二");
        huLuWaArray[2] = new SingleHuLuWa(3, "老三");
        huLuWaArray[3] = new SingleHuLuWa(4, "老四");
        huLuWaArray[4] = new SingleHuLuWa(5, "老五");
        huLuWaArray[5] = new SingleHuLuWa(6, "老六");
        huLuWaArray[6] = new SingleHuLuWa(7, "老七");
        shuffle();
    }

    public void algorithmSort(){
        Sort.algorithmSort(huLuWaArray);
    }

    public void print(){
        for(SingleHuLuWa curHuLuWa : huLuWaArray){
            System.out.println(curHuLuWa.getName());
        }
    }

    public SingleHuLuWa[] getHuLuWaInfo(){
        return huLuWaArray;
    }

    public void cooperationSort() {
        Sort.cooperationSort(huLuWaArray);
    }
}
