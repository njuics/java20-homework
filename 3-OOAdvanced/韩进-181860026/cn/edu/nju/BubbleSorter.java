package cn.edu.nju;

interface Sorter
{
    void orchestration(GourdBrother[] gourdBrothers, Grandfather grandfather);

    void choreography(GourdBrother[] gourdBrothers);
}

public class BubbleSorter implements Sorter
{
    @Override
    public void orchestration(GourdBrother[] gourdBrothers, Grandfather grandfather)
    {
        System.out.println("进行orchestration排序");
        shuffleGourds(gourdBrothers);
        reportGourds(gourdBrothers);
        System.out.println("开始排序...");
        for (int i = gourdBrothers.length - 1; i >= 1; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if (grandfather.cmpGourds(gourdBrothers[j], gourdBrothers[j + 1]))
                {
                    grandfather.swapGourds(gourdBrothers, j, j + 1);
                }
            }
        }
        reportGourds(gourdBrothers);
    }

    @Override
    public void choreography(GourdBrother[] gourdBrothers)
    {
        System.out.println("进行choreography排序");
        shuffleGourds(gourdBrothers);
        reportGourds(gourdBrothers);
        System.out.println("开始排序...");
        for (int i = gourdBrothers.length - 1; i >= 1; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if (gourdBrothers[j].cmpIndex(gourdBrothers[j + 1]))
                {
                    gourdBrothers[j].swapWithNextGourd(gourdBrothers, j);
                }
            }
        }
        reportGourds(gourdBrothers);
    }

    void shuffleGourds(GourdBrother[] gourdBrothers)
    {
        final int NUM = gourdBrothers.length;
        System.out.println("随机打乱队列...");
        for (int i = 0; i < 20; i++)
        {
            int pos1 = (int) (Math.random() * NUM);
            int pos2 = (int) (Math.random() * NUM);
            GourdBrother tmp = gourdBrothers[pos1];
            gourdBrothers[pos1] = gourdBrothers[pos2];
            gourdBrothers[pos2] = tmp;
        }
    }

    void reportGourds(GourdBrother[] gourdBrothers)
    {
        for (GourdBrother gourdBrother : gourdBrothers)
        {
            gourdBrother.reportName();
        }
        System.out.println();
    }
}

