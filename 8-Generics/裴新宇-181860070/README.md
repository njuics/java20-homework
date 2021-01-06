# 在第七次作业基础上的修改：

## 1、两个比较器

`HuluwaAscendingComparator` 和 `HuluwaDescendingComparator` 分别修改为使用了泛型的 `TAscendingComparator` 和 `TDescendingComparator`。原本只能对 Huluwa 类的对象进行排序，现在可以对所有 Creature 类（及其子类）的对象进行排序。



## 2、报名函数 Count_off

由 `public static void Count_off(LinkedList<Huluwa> list)` 改为 `public static void Count_off(LinkedList<? extends Creature> list)`。原本仅能对存有 huluwa 对象的链表进行操作，现扩充为所有 Creature。



## 3、增加了 Monster 类型的定义

```java
public class Monster extends Creature{
    private int health;
    private int damage;
    public Monster();
    public Monster(String name,int health,int damage);
    public int get_health();
    public void set_health(int health);
    public int get_damage();
    public void set_damage(int damage);
}
```