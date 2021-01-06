import java.util.*;


public class World
{
    CreatureFamily<GourdBrother> gourdFamily = new CreatureFamily<>();

    World()
    {
        random_generate();
    }

//    World(List<GourdBrother> gourdBrothers)
//    {
//        gourdFamily.setFamilyList(gourdBrothers);
//    }


    void random_generate()
    {
        Random r = new Random();
        int gourdNum = r.nextInt(5) + 5;
        for (int i = 0; i < gourdNum; i++)
        {
            boolean gender = r.nextBoolean();
            StringBuffer gourdName = new StringBuffer();
            int nameLength = r.nextInt(8) + 1;
            for (int j = 0; j < nameLength; j++)
            {
                char randCh = (char) (r.nextInt(26) + 'a');
                gourdName.append(randCh);
            }
            GourdBrother gb = new GourdBrother(gourdName.toString(), gender);
            gourdFamily.add(gb);
        }
    }

    public void start()
    {
        System.out.println("顺序排列...");
        for (GourdBrother gourdBrother : gourdFamily)
        {
            System.out.println(gourdBrother);
        }
        System.out.println("倒序排列...");
        for (GourdBrother gourdBrother : gourdFamily.reverseIterator())
        {
            System.out.println(gourdBrother);
        }
        System.out.println("乱序排列...");
        for (GourdBrother gourdBrother : gourdFamily.mixIterator())
        {
            System.out.println(gourdBrother);
        }
        System.out.println("按性别排成两队...");
        System.out.println("male...");
        for (GourdBrother gourdBrother : gourdFamily.maleIterator())
        {
            System.out.println(gourdBrother);
        }
        System.out.println("female...");
        for (GourdBrother gourdBrother : gourdFamily.femaleIterator())
        {
            System.out.println(gourdBrother);
        }
    }

}
