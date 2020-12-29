package cn.edu.nju;
import java.util.*;
import com.google.common.collect.Ordering;

public class CreatureFamily<T extends Creature> implements Iterable<T>
{
    private List<T> creatureList = new ArrayList<>();
    List<T> maleList = new ArrayList<>();
    List<T> femaleList = new ArrayList<>();    

    public void add(T cre)
    {
        creatureList.add(cre);
    }

    public Iterator<T> iterator()
    {
        Collections.sort(creatureList, Ordering.usingToString());
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
        Collections.sort(creatureList, Ordering.usingToString().reverse());
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
        Collections.sort(maleList, Ordering.usingToString());
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
        Collections.sort(femaleList, Ordering.usingToString());
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

