public class CalabashBrother{
    String name;
    int priority;
    int position;

    CalabashBrother(String nam,int pri,int pos)
    {
        this.name=nam;
        this.priority=pri;
        this.position=pos;
    }
    public void printName()
    {
        System.out.print(this.name);
    }
    public boolean cmp(CalabashBrother bro)
    {
        if(this.priority<bro.priority && this.position>bro.position){
            return true;
        }
        else if(this.priority>bro.priority && this.position<bro.position){
            return true;
        }
        else return false;
    }
    public void swapPosition(CalabashBrother bro)
    {
        int tmp=bro.position;
        bro.position=this.position;
        this.position=tmp;
    }
    public void find_position(CalabashBrother bro[])
    {
        int tmp=1;
        for(int i=0;i<bro.length;i++)
        {
            if(bro[i].priority<this.priority) tmp++;
        }
        if(this.position==tmp) return;
        for(int i=0;i<bro.length;i++)
        {
            if(bro[i].position==tmp){
                this.swapPosition(bro[i]);
                break;
            }
        }
    }
}