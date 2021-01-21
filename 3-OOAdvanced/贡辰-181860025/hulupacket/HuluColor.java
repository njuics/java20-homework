package hulupacket;

public enum HuluColor
{
    Red("大娃",0),Orange("二娃",1),Yellow("三娃",2),
    Green("四娃",3),Cyan("五娃",4),Blue("六娃",5),
    Purple("七娃",6);
    private String name;
    private int value;

    private HuluColor(String huluname, int huluvalue)
    {
        this.name=huluname;
        this.value=huluvalue;
    }
    public int getvalue()
    {
        return value;
    }
    public String getname()
    {
        return name;
    }
}