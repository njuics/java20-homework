import java.util.Comparator;

class HuLuWaCorrectComparetor implements Comparator<HuLuWa> {

    @Override
    public int compare(HuLuWa hlw1, HuLuWa hlw2) {
        return (hlw1.tell_name()).compareTo(hlw2.tell_name());
    }
}

class HuLuWaInverseComparetor implements Comparator<HuLuWa> {

    @Override
    public int compare(HuLuWa hlw1,HuLuWa hlw2) {
        return (hlw2.tell_name()).compareTo(hlw1.tell_name());
    }
}

public class HuLuWa {       /* 葫芦娃类 */

    protected String name;      /* 葫芦娃的名字 */

    protected boolean sex;      /* 葫芦娃的性别 */

    public HuLuWa(String name,boolean sex) {       /* 初始构造函数 */
        this.name = name;
        this.sex = sex;
    }

    public String tell_name() {     /* 返回自己的名字 */
        return this.name;
    }

    public boolean tell_sex() {     /* 返回自己的性别 */
        return this.sex;
    }
}