/**
 * @author q
 * @create 2020-09-19 16:25
 */

//葫芦娃类
public class HuLuWa {
    //葫芦娃的名字和位次
    public String name;
    public int index;

    public HuLuWa(String name, int index) {
        this.name = name;
        this.index = index;
    }

    //葫芦娃类中，应当具有比较自己和别人位次的能力
    public int compareOther(HuLuWa huLuWa){
        return this.index - huLuWa.index;
    }

    @Override
    public String toString() {
        return "HuLuWa{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }
}
