import Source.Creature.*;
import Source.SortMethod.*;

public class Init {
    public CalabashBrother[] bro;
    public GrandFather grandpa;
    static final int NUM_OF_BROTHERS;

    static{
        NUM_OF_BROTHERS=7;
    }

    Init()
    {
        bro=new CalabashBrother[NUM_OF_BROTHERS];
        grandpa=new GrandFather("爷爷");
        for (int i=0;i<NUM_OF_BROTHERS;i++)
        {
            bro[i]=new CalabashBrother(i);
        }
    }
}