public class Calabash extends Creature implements Comparable<Calabash>{
    private String name;
    private String gender;
    Calabash()
    {
        super(" aaa");
        name=" ";
        gender=" ";

    }
    Calabash(String name1,String gender1)
    {
        super(name1);
        name=name1;
        gender=gender1;
    }
    String get_name()
    {
        return super.get_name();
    }
    String get_gender()
    {
        return super.get_gender();
    }
    void set_name_calabash(String name)
    {
        this.name=name;
        super.set_name(name);
    }
    void set_gender_calabash(String a)
    {
        gender=a;
        super.set_gender(a);
    }
    public int compareTo(Calabash brother)
    {
        return name.compareTo(brother.get_name());
    }
}
