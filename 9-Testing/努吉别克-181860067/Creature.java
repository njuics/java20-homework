import java.util.Random;

public class Creature {
    String my_name;
    String gender;
    Creature()
    {
        my_name="null";
    }
    Creature(String name)
    {
        my_name=name;
    }
    void print_name()
    {
        System.out.print(my_name);
    }
    String get_name()
    {
        return my_name;
    }
    String get_gender()
    {
        return gender;
    }
    public int compareTo(Creature a)
    {
        return my_name.compareTo(a.get_name());
    }
    public void set_name(String name)
    {
        my_name=name;
    }
    public  void set_gender(String a)
    {
        gender=a;
    }
}
