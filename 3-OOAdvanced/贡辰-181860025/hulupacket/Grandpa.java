package hulupacket;

public final class Grandpa
{
    public void gprint(HuLuWa[] queue)
    {
        for (int i=0;i<queue.length;i++)
            System.out.print(queue[i].getname()+' ');
    }
    public void gsort(HuLuWa[] queue)
    {
        for (int times=0;times<queue.length;times++)
        {
            for (int i = 0; i < queue.length; i++)
                if (!(queue[i].right(queue)))
                {
                    queue[i].getright(i,queue);
                    break;
                }
        }
    }
}