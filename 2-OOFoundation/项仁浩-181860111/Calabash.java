public class Calabash {
    static final String[] name={"老大","老二","老三","老四","老五","老六","老七"};
    int identifier;
    int pos;
    String calabashName;

    Calabash(int identifier){
        this.identifier=identifier;
        calabashName=name[identifier-1];
        pos=0;
    }

    public boolean observe(Calabash other){
        if(identifier>other.identifier)
            return true;
        return false;
    }

    public void exchange(Calabash other){
        int temp=pos;
        pos=other.pos;
        other.pos=temp;
    }
}
