public class HuLuWa extends Creature {
    
    protected String name;      /* 姓名 */

    protected int rank;     /* 排名 */

    public HuLuWa(String name,int rank) {
        this.name = name;
        this.rank = rank;
    }

    @Override
    public String get_name() {      /* 获得葫芦娃的名字 */
        return this.name;
    }

    @Override
    public int walk() {
        return this.rank;
    }

    public void skill() {}

}