package Collections;

import java.util.*;

/**
 * 利用ArrayList类进行Huluwa类的遍历和排序等
 */
public class Grandpa implements HuluwaController{

    private List<Huluwa> data = new ArrayList<Huluwa>();


    @Override
    public void addHuluwa(Huluwa h){
        data.add(h);
    }

    @Override
    public void sortHuluwa(boolean reversed){
        Collections.sort(data);
        if(reversed) Collections.reverse(data);
    }

    @Override
    public void printHuluwa(){
        for(Huluwa h: data){
            h.call();
        }
    }

    public Grandpa(){}

    public Grandpa(List<Huluwa> list){
        data = list;
    }

    public List<Huluwa> getHuluwaOfGender(boolean gender){
        List<Huluwa> result = new ArrayList<Huluwa>();
        for(Huluwa h: data){
            if(h.gender == gender){
                result.add(h);
            }
        }

        return result;
    }

    /**
     * 对储存的葫芦娃随机排序
     */
    public void shuffleHuluwa(){
        Collections.shuffle(data);
    }


}
