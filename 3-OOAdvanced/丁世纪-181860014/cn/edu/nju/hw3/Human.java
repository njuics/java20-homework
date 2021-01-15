package cn.edu.nju.hw3;
interface Communicate{
    public void Speaksth(String str);

    public void RecieveInfo(String str);

}

interface Fight{
    public void Attack();
    public void Ultra();
    public void Attack(Human h);
    public void Ultra(Human h);
}

class Human implements Communicate {
    protected String name;

    static int total;
    static{
        total = 0;
    }

    Human()
    {
        name="ungiven";
        total++;
    }

    public int population()
    {
        return total;
    }

    public void Attack()
    {
        System.out.println(name+" 无力地打了一拳");
    }
    public void Ultra()
    {
        System.out.println(name+" 狠狠地打了一拳");
    }

    public void Attack(Human h)
    {
        System.out.println(name+"对着"+h.get_name()+"无力地打了一拳");
    }
    public void Ultra(Human h)
    {
        System.out.println(name+"对着"+h.get_name()+"狠狠地打了一拳");
    }

    //说话
    public void Speaksth(String str)
    {
        System.out.println(name+": "+str);
    }

    public void RecieveInfo (String str)
    {
        System.out.println(name+":你说得对.");
    }

    //让两个葫芦娃交换位置
    protected void Ask2boys2swap(World w,int a,int b)
    {
        w.Swap2boy(a, b);
    }

    String get_name()
    {
        return name;
    }
}

