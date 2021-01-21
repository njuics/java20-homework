public class GourdBrother implements Comparable<GourdBrother>
{
    private String name;
    private boolean isMale;

    GourdBrother(String name, boolean isMale)
    {
        this.name = name;
        this.isMale = isMale;
    }

    @Override
    public int compareTo(GourdBrother gb)
    {
        return this.name.compareTo(gb.name);
    }

    @Override
    public String toString()
    {
        return "GourdBrother{" +
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
