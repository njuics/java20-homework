package hulupacket;

public class HuLuWa
{
    private HuluColor hulucolor;

    public HuLuWa(HuluColor color)
    {
        this.hulucolor=color;
    }

    public boolean right(posqueue<HuLuWa> queue)
    {
        return (queue.get(this.getvalue()).hulucolor==this.hulucolor);
    }
    public String getname()
    {
        return hulucolor.getname();
    }
    public int getvalue() {return hulucolor.getvalue();}
    public void getright(int pos, posqueue<HuLuWa> queue)
    {
        //System.out.print('!');
        if (queue.get(this.hulucolor.getvalue()).hulucolor!=this.hulucolor)
        {
            //System.out.print('?');
            HuLuWa tmp=queue.get(this.hulucolor.getvalue());
            queue.modify(this.hulucolor.getvalue(),this);
            queue.modify(pos,tmp);
        }
    }
}
