public class Golbin extends Creature {
    Golbin()
    {
        super();
    }
    Golbin(String name1)
    {
        super(name1);
    }
    String get_name()
    {
        return super.get_name();
    }
    String get_gender()
    {
        return super.get_gender();
    }
    public int compareTo(Calabash brother)
    {
        return super.get_name().compareTo(brother.get_name());
    }
}
