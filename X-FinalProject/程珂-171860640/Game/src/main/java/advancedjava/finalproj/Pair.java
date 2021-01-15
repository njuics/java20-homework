package advancedjava.finalproj;

public class Pair<T>
{
    protected T first;
    protected T second;

    public Pair(T first, T second)
    {
        this.first = first;
        this.second = second;
    }

    public T getFirst()
    {
        return this.first;
    }

    public T getSecond()
    {
        return this.second;
    }
}


