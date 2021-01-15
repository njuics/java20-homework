public class GourdBrother
{
    String name;
    int index;

    GourdBrother(String name, int index)
    {
        this.name=name;
        this.index=index;
    }

    public void reportName()
    {
        System.out.print(this.name+" ");
    }

    public int getIndex()
    {
        return this.index;
    }

    public boolean cmpIndex(GourdBrother brother)
    {
        return this.index> brother.getIndex();
    }

    public void swapWithNextGourd(GourdBrother[] gourdBrothers, int pos)
    {
        GourdBrother tmp = gourdBrothers[pos];
        gourdBrothers[pos] = gourdBrothers[pos+1];
        gourdBrothers[pos+1] = tmp;
    }
}
