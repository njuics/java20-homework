import java.util.Arrays;
import java.util.List;

/**
 * @author q
 * @create 2020-09-20 15:51
 */
public class HLWGroup {

    //有一队乱序葫芦娃们，让他们自己协作完成排序
    //主要用到冒泡排序
    HuLuWa[] huLuWas;

    public HLWGroup(HuLuWa[] huLuWas) {
        this.huLuWas = huLuWas;
    }

    //葫芦娃群体类中，应当具有让任意两个葫芦娃交换位置的功能
    public void exchange(int i, int j){
        int indexTemp = huLuWas[i].index;
        String nameTemp = huLuWas[i].name;
        huLuWas[i].index = huLuWas[j].index;
        huLuWas[i].name = huLuWas[j].name;
        huLuWas[j].index = indexTemp;
        huLuWas[j].name = nameTemp;
    }
    
    //葫芦娃自己协作排序
    public void groupSort(){
        for (int i = 1; i <= huLuWas.length; i++) {
            for (int j = 0; j < huLuWas.length - i; j++) {
                if (huLuWas[j].compareOther(huLuWas[j+1])>0){
                    this.exchange(j,j+1);
                }

            }
        }
    }

    @Override
    public String toString() {
        return "HLWGroup{" +
                "huLuWas=" + Arrays.toString(huLuWas) +
                '}';
    }
}
