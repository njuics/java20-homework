public class Calabash implements Comparable<Calabash>{
    private String name;
    private String gender;
    Calabash()
    {
        name=" ";
        gender=" ";
    }
    Calabash(String name1,String gender1)
    {
        name=name1;
        gender=gender1;
    }
    String get_name()
    {
        return name;
    }
    String get_gender()
    {
        return gender;
    }
    public int compareTo(Calabash brother)
    {
        return name.compareTo(brother.get_name());
    }
}
