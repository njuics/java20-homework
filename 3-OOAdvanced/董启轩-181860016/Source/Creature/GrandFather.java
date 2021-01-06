package Source.Creature;

public class GrandFather extends Human{
    public GrandFather(String name)
    {
        this.name=name;
    }
    public boolean cmpCalabash(CalabashBrother bro1,CalabashBrother bro2){
        return bro1.get_priority()>bro2.get_priority();
    }
    public void swapCalabash(CalabashBrother[] bro,int pos1,int pos2){
        CalabashBrother tmp=bro[pos1];
        bro[pos1]=bro[pos2];
        bro[pos2]=tmp;
    }
}