package hulupacket;

public class posqueue<E>
{
    private Object[] queue;
    public posqueue(int size)
    {
        queue=new Object[size];
    }
    public void setsize(int size)
    {
        Object[] dest = new Object[size];
        queue=dest;
    }
    public void modify(int index, E s) {
        queue[index]=s;
    }

    public E get(int index) {
        return (E)queue[index];
    }

    public int size() {
        return queue.length;
    }

}
