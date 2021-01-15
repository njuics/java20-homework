package cn.edu.nju;

public class GourdBrother extends Human
{
    private int index;

    GourdBrother(String name, int index)
    {
        super(name);
        this.index = index;
    }

    public int getIndex()
    {
        return this.index;
    }

    public boolean cmpIndex(GourdBrother brother)
    {
        return this.index > brother.getIndex();
    }

    public void swapWithNextGourd(GourdBrother[] gourdBrothers, int pos)
    {
        GourdBrother tmp = gourdBrothers[pos];
        gourdBrothers[pos] = gourdBrothers[pos + 1];
        gourdBrothers[pos + 1] = tmp;
    }
}
