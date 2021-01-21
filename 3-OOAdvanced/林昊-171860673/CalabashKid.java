import creature.Human;

public class CalabashKid extends Human implements Comparable<CalabashKid> {
    public CalabashKid() {
        this.priori = 0;
        this.name = "";
    }

    public CalabashKid(int priori) {
        this.priori = priori;
        this.name = "";
    }

    public CalabashKid(int priori, String name) {
        this.priori = priori;
        this.name = name;
    }

    // 葫芦娃可以告诉别人自己的优先级
    public int getPriority() {
        return priori;
    }

    // 葫芦娃可以告诉别人自己的名字
    @Override
    public String getName() {
        return name;
    }

    // 葫芦娃可以和其它葫芦娃比较相互的优先级
    @Override
    public int compareTo(CalabashKid calabashKid) {
        return this.priori - calabashKid.getPriority();
    }

    private int priori;
}
