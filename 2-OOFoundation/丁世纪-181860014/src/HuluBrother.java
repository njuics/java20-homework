public class HuluBrother {
    String name;
    int rank;

    HuluBrother(String s,int i)
    {
        name=s;
        rank=i;
    }

    public void intro()
    {
        System.out.println("My name is "+name);
    }
}
