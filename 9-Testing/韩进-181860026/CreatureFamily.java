import java.util.*;


public class CreatureFamily<T extends Creature> implements Iterable<T>
{
    private List<T> creatureList = new ArrayList<>();
    List<T> maleList = new ArrayList<>();
    List<T> femaleList = new ArrayList<>();
    NegativeComparator<T> negComparator = new NegativeComparator();

    public void add(T cre)
    {
        creatureList.add(cre);
    }

//    public void setFamilyList(List<T> creatureList)
//    {
//        this.creatureList = creatureList;
//    }

    public Iterator<T> iterator()
    {
        Collections.sort(creatureList);
        return new Iterator<T>()
        {
            private int index = 0;

            @Override
            public boolean hasNext()
            {
                return index < creatureList.size();
            }

            @Override
            public T next()
            {
                return creatureList.get(index++);
            }
        };
    }

    public Iterable<T> reverseIterator()
    {
        Collections.sort(creatureList, negComparator);
        return () -> new Iterator<T>()
        {
            private int index = 0;

            @Override
            public boolean hasNext()
            {
                return index < creatureList.size();
            }

            @Override
            public T next()
            {
                return creatureList.get(index++);
            }
        };
    }

    public Iterable<T> mixIterator()
    {
        Collections.shuffle(creatureList);
        return () -> new Iterator<T>()
        {
            private int index = 0;

            @Override
            public boolean hasNext()
            {
                return index < creatureList.size();
            }

            @Override
            public T next()
            {
                return creatureList.get(index++);
            }
        };
    }

    public Iterable<T> maleIterator()
    {
        maleList = new ArrayList<>();
        for (T gb : creatureList)
        {
            if (gb.getGender())
            {
                maleList.add(gb);
            }
        }
        Collections.sort(maleList);
        return () -> new Iterator<T>()
        {
            private int index = 0;

            @Override
            public boolean hasNext()
            {
                return index < maleList.size();
            }

            @Override
            public T next()
            {
                return maleList.get(index++);
            }
        };
    }

    public Iterable<T> femaleIterator()
    {
        femaleList = new ArrayList<>();
        for (T gb : creatureList)
        {
            if (!gb.getGender())
            {
                femaleList.add(gb);
            }
        }
        Collections.sort(femaleList);
        return () -> new Iterator<T>()
        {
            private int index = 0;

            @Override
            public boolean hasNext()
            {
                return index < femaleList.size();
            }

            @Override
            public T next()
            {
                return femaleList.get(index++);
            }
        };
    }

}


class NegativeComparator<T extends Creature> implements Comparator<T>
{
    public int compare(T cre1, T cre2)
    {
        String name1 = cre1.getName();
        String name2 = cre2.getName();
        return -name1.compareTo(name2);
    }
}
