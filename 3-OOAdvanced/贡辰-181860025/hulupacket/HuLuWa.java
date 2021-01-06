package hulupacket;

public class HuLuWa
{
    private HuluColor hulucolor;

    public HuLuWa(HuluColor color)
    {
        this.hulucolor=color;
    }

    public boolean right(HuLuWa[] queue)
    {
        return (queue[this.getvalue()].hulucolor==this.hulucolor);
    }
    public String getname()
    {
        return hulucolor.getname();
    }
    public int getvalue() {return hulucolor.getvalue();}
    public void getright(int pos, HuLuWa[] queue)
    {
        //System.out.print('!');
        if (queue[this.hulucolor.getvalue()].hulucolor!=this.hulucolor)
        {
            //System.out.print('?');
            HuLuWa tmp=queue[this.hulucolor.getvalue()];
            queue[this.hulucolor.getvalue()]=this;
            queue[pos]=tmp;

        }
    }
}
