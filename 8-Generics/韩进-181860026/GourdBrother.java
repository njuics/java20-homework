public class GourdBrother extends Creature
{
    GourdBrother(String name, boolean isMale)
    {
        super(name, isMale);
    }

    @Override
    public String toString()
    {
        return "GourdBrother{" +
                "name='" + name + '\'' +
                ", isMale=" + isMale +
                '}';
    }
}
