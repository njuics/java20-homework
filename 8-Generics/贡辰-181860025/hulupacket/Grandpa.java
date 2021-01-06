package hulupacket;

public final class Grandpa
{
    public void gprint(HuLuWa[] queue)
    {
        for (int i=0;i<queue.length;i++)
            System.out.print(queue[i].getname()+' ');
    }
    public void gsort(posqueue<HuLuWa> queue)
    {
        for (int times=0;times<queue.size();times++)
        {
            for (int i = 0; i < queue.size(); i++)
                if (!(queue.get(i).right(queue)))
                {
                    queue.get(i).getright(i,queue);
                    break;
                }
        }
    }
}