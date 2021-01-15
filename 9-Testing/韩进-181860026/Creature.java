

public class Creature implements Comparable<Creature>
{

    protected String name;
    protected boolean isMale;

    Creature(String name, boolean isMale)
    {
        this.name = name;
        this.isMale = isMale;
    }

    @Override
    public int compareTo(Creature cre)
    {
        return this.name.compareTo(cre.name);
    }

    @Override
    public String toString()
    {
        return "Creature{" +
                "name='" + name + '\'' +
                ", isMale=" + isMale +
                '}';
    }

    public String getName()
    {
        return this.name;
    }

    public boolean getGender()
    {
        return this.isMale;
    }
}
