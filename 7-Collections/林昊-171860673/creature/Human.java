package creature;

public abstract class Human extends Creature {
    protected String name;
    // 人类可以告诉别人自己的名字
    public abstract String getName();
    // 转换成String输出
    public abstract String toString();
}
