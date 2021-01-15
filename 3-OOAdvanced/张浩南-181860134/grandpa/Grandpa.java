package grandpa;
import hulubro.*;
public class Grandpa{
    public boolean lessThan(HuluBro a,HuluBro b) {return a.getValue()<b.getValue();}
    public void swap(HuluBro a,HuluBro b) {
        int temp=a.getValue();
        a.setValue(b.getValue());
        b.setValue(temp);
    }
}