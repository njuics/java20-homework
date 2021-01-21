import java.lang.Math;

public class World
{
    GourdBrother[] gourdBrothers;
    Grandfather grandfather;
    final int NUM_OF_GOURDS = 7;

    World()
    {
        gourdBrothers = new GourdBrother[NUM_OF_GOURDS];
        grandfather = new Grandfather();
        String[] gourd_names = {"大娃", "二娃", "三娃", "四娃", "五娃", "六娃", "七娃"};
        for (int i = 0; i < NUM_OF_GOURDS; i++)
        {
            gourdBrothers[i] = new GourdBrother(gourd_names[i], i);
        }
    }


    void sortByGourds()
    {
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
    }

    void sortByGrandfather()
    {
        grandfather.sortGourds(gourdBrothers);
    }

    void shuffleGourds()
    {
        System.out.println("随机打乱队列...");
        for (int i = 0; i < 20; i++)
        {
            int pos1 = (int) (Math.random() * NUM_OF_GOURDS);
            int pos2 = (int) (Math.random() * NUM_OF_GOURDS);
            GourdBrother tmp = gourdBrothers[pos1];
            gourdBrothers[pos1] = gourdBrothers[pos2];
            gourdBrothers[pos2] = tmp;
        }
    }

    void reportGourds()
    {
        for (int i = 0; i < NUM_OF_GOURDS; i++)
        {
            gourdBrothers[i].reportName();
        }
        System.out.println();
    }

    void orchestrationSort()
    {
        System.out.println("进行orchestration排序");
        shuffleGourds();
        reportGourds();
        System.out.println("开始排序...");
        sortByGrandfather();
        reportGourds();
    }

    void choreographySort()
    {
        System.out.println("进行choreography排序");
        shuffleGourds();
        reportGourds();
        System.out.println("开始排序...");
        sortByGourds();
        reportGourds();
    }

    public static void main(String[] args)
    {
        World world = new World();
        world.orchestrationSort();
        world.choreographySort();
    }

}
