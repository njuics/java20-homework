package JUnitTest.characters;

import JUnitTest.utils.HumanController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Grandpa extends Human implements HumanController<Huluwa>, Comparator<Huluwa> {


    //利用静态块实现单例模式
    private static Grandpa instance = null;

    public static Grandpa getInstance(){

        return instance;
    }


    //静态块
    static {

        instance = new Grandpa();
    }

    private Grandpa(){

        super("Grandpa", true);

        list = new ArrayList<Huluwa>();
    }


    //储存葫芦娃对象的List
    private List<Huluwa> list;


    public static void swap(Huluwa a, Huluwa b){

        a.swapWith(b);
    }

    public List<Huluwa> getList(){
        return list;
    }

    @Override
    public void call() {
        System.out.println("我是爷爷！");
    }


    @Override
    public void add(Huluwa huluwa) {
        list.add(huluwa);
    }

    @Override
    public void addAll(List<Huluwa> t) {
        list.addAll(t);
    }


    @Override
    public void remove(Huluwa huluwa) {
        list.remove(huluwa);
    }

    @Override
    public void sort(boolean reverse) {

        for(int i = list.size()-1 ;i>0;i--){
            for(int j = 0;j < i;j++){
                int temp = compare(list.get(j),list.get(j+1));
                if((!reverse && temp>0) || (reverse && temp<0)){
                    swap(list.get(j),list.get(j+1));
                }
            }
        }
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public void printAll() {
        for (Huluwa h: list
             ) {
            h.call();
        }
    }

    @Override
    public int compare(Huluwa o1, Huluwa o2) {
        return o1.name.compareTo(o2.name);
    }
}
