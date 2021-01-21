public class Grandfather
{
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

    public void sortGourds(GourdBrother[] gourdBrothers)
    {
        for (int i = gourdBrothers.length - 1; i >= 1; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if (cmpGourds(gourdBrothers[j], gourdBrothers[j + 1]))
                {
                    swapGourds(gourdBrothers, j, j + 1);
                }
            }
        }
    }

}
