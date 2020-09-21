public class HuluBrother {
    String name;
    int rank;

    HuluBrother(String s,int i)
    {
        name=s;
        rank=i;
    }

    public void intro()
    {
        System.out.println("My name is "+name);
    }

    public void Self_sort(World w,int i)
    {
        //向队伍前侧交换直到左侧没人或者小于自身
        if(i==0)
            return;
        else if(w.hulu[i-1].rank>w.hulu[i].rank)
        {
            w.Swap2boy(i-1, i);
            Self_sort(w,i-1);
        }
    }


}
