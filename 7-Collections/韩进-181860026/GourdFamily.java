import java.util.*;


public class GourdFamily implements Iterable<GourdBrother>
{
    private List<GourdBrother> gourdList = new ArrayList<>();
    List<GourdBrother> maleList=new ArrayList<>();
    List<GourdBrother> femaleList=new ArrayList<>();
    NegativeComparator negComparator = new NegativeComparator();

    public void add(GourdBrother gb)
    {
        gourdList.add(gb);
    }

    public Iterator<GourdBrother> iterator()
    {
        Collections.sort(gourdList);
        return new Iterator<GourdBrother>()
        {
            private int index = 0;

            @Override
            public boolean hasNext()
            {
                return index < gourdList.size();
            }

            @Override
            public GourdBrother next()
            {
                return gourdList.get(index++);
            }
        };
    }

    public Iterable<GourdBrother> reverseIterator()
    {
        Collections.sort(gourdList, negComparator);
        return () -> new Iterator<GourdBrother>()
        {
            private int index = 0;

            @Override
            public boolean hasNext()
            {
                return index < gourdList.size();
            }

            @Override
            public GourdBrother next()
            {
                return gourdList.get(index++);
            }
        };
    }

    public Iterable<GourdBrother> mixIterator()
    {
        Collections.shuffle(gourdList);
        return () -> new Iterator<GourdBrother>()
        {
            private int index = 0;

            @Override
            public boolean hasNext()
            {
                return index < gourdList.size();
            }

            @Override
            public GourdBrother next()
            {
                return gourdList.get(index++);
            }
        };
    }

    public Iterable<GourdBrother> maleIterator()
    {
        maleList=new ArrayList<>();
        for (GourdBrother gb: gourdList)
        {
            if (gb.getGender())
            {
                maleList.add(gb);
            }
        }
        Collections.sort(maleList);
        return () -> new Iterator<GourdBrother>()
        {
            private int index = 0;

            @Override
            public boolean hasNext()
            {
                return index < maleList.size();
            }

            @Override
            public GourdBrother next()
            {
                return maleList.get(index++);
            }
        };
    }

    public Iterable<GourdBrother> femaleIterator()
    {
        femaleList=new ArrayList<>();
        for (GourdBrother gb: gourdList)
        {
            if (!gb.getGender())
            {
                femaleList.add(gb);
            }
        }
        Collections.sort(femaleList);
        return () -> new Iterator<GourdBrother>()
        {
            private int index = 0;

            @Override
            public boolean hasNext()
            {
                return index < femaleList.size();
            }

            @Override
            public GourdBrother next()
            {
                return femaleList.get(index++);
            }
        };
    }

}


class NegativeComparator implements Comparator<GourdBrother>
{
    public int compare(GourdBrother gb1, GourdBrother gb2)
    {
        String name1 = gb1.getName();
        String name2 = gb2.getName();
        return -name1.compareTo(name2);
    }
}
