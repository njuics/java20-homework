package OOAdvanced.characters;

import java.util.List;

public class Grandpa extends Human{

    //利用静态块实现单例模式
    private static Grandpa instance = null;

    public static Grandpa getInstance(){

        return instance;
    }

    private Grandpa(){
        super("Grandpa");

    }
    //静态块
    static {

        instance = new Grandpa();
    }


    private int compareHuluwa(Huluwa a, Huluwa b){

        return a.compareTo(b);
    }

    private void swapHuluwa(Huluwa a, Huluwa b){

        a.swapWith(b);
    }


    @Override
    public void call() {
        System.out.println("我是爷爷！");
    }

    /**
     * 冒泡排序，从小到大
     * @param list
     */
    public void sortHuluwa(List<Huluwa> list){

        for(int i = list.size()-1 ;i>0;i--){
            for(int j = 0;j < i;j++){
                if(compareHuluwa(list.get(j),list.get(j+1))>0){
                    swapHuluwa(list.get(j),list.get(j+1));
                }
            }
        }

    }

}
