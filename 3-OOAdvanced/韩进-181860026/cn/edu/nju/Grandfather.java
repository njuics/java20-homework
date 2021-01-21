package cn.edu.nju;

public class Grandfather extends Human
{
    Grandfather(String name)
    {
        super(name);
    }

    public boolean cmpGourds(GourdBrother brother1, GourdBrother brother2)
    {
        return brother1.getIndex() > brother2.getIndex();
    }

    public void swapGourds(GourdBrother[] gourdBrothers, int pos1, int pos2)
    {
        GourdBrother tmp = gourdBrothers[pos1];
        gourdBrothers[pos1] = gourdBrothers[pos2];
        gourdBrothers[pos2] = tmp;
    }
}
