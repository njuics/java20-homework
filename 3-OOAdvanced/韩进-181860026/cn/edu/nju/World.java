package cn.edu.nju;

public class World
{
    private GourdBrother[] gourdBrothers;
    private Grandfather grandfather;
    static final int NUM_OF_GOURDS;

    static
    {
        NUM_OF_GOURDS = 7;
    }

    World()
    {
        gourdBrothers = new GourdBrother[NUM_OF_GOURDS];
        grandfather = new Grandfather("爷爷");
        final String[] gourd_names = {"大娃", "二娃", "三娃", "四娃", "五娃", "六娃", "七娃"};
        for (int i = 0; i < NUM_OF_GOURDS; i++)
        {
            gourdBrothers[i] = new GourdBrother(gourd_names[i], i);
        }
    }

    public void start()
    {
        Sorter sorter = new BubbleSorter();
        sorter.orchestration(gourdBrothers, grandfather);
        sorter.choreography(gourdBrothers);
    }

}
