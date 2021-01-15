package hulubro;
public class HuluBro{
    public static final int count=7;
    private static final String[] nameSet={"老大","老二","老三","老四","老五","老六","老七"};
    //private String name;
    private int value;
    public HuluBro(int value)
    {
        this.value=value;
    }
    public int getValue(){return value;}
    public void setValue(int value){this.value=value;}
    public void swap(HuluBro other)
    {
        int tmp=other.getValue();
        other.setValue(this.value);
        this.value=tmp;
    }
    public boolean lessThan(HuluBro other){return this.value<other.getValue();}
    public void call()
    {
        System.out.println(nameSet[value]);
    }
}