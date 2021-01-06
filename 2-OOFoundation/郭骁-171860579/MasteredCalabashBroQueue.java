public class MasteredCalabashBroQueue extends CalabashBroQueue{
    public MasteredCalabashBroQueue(String[] names) {
        super(names);
    }
    @Override
    public void lineUp(){
        for (int i = 0; i < length;) {
            int order = members[i].getId();
            if(order!=i)
                members[i].exchange(members[order]);
            else
                i++;
        }
    }
}
