package mycode.hw7;
enum Gender {male,female,unknown};
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


class Human extends Creature implements Communicate {
    protected String name;
    protected Gender gender;

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
        System.out.println(name+" attack");
    }
    public void Ultra()
    {
        System.out.println(name+" cast an ultraskill");
    }

    public void Attack(Human h)
    {
        System.out.println(name+"->"+h.get_name()+"attack");
    }
    public void Ultra(Human h)
    {
        System.out.println(name+"->"+h.get_name()+"cast an ultraskill");
    }

    //说话
    public void Speaksth(String str)
    {
        System.out.println(name+": "+str);
    }

    public void RecieveInfo (String str)
    {
        System.out.println(name+":receive msg.");
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

