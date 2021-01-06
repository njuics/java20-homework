public class Calabash implements Comparable<Calabash>{ // 实现Comparable接口可直接使用Collections.sort()排序；

    private int gander; // 性别，0 male，1 female；
    private String name; // 姓名；

    Calabash() {
        gander=0;
        name="";
    }
    Calabash(int g,String n) {
        gander=g;
        name=n;
    }
    int getGander() {
        return gander;
    }
    String getName() {
        return name;
    }

    @Override
    public int compareTo(Calabash o) {
        return this.name.compareTo(o.name);
    }
}