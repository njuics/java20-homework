import Source.Creature.*;
import Source.SortMethod.*;

public class Main {
    public static void main(String []args){
        Init i=new Init();
        Choreography C=new Choreography();
        Orchestration O=new Orchestration();
        C.ChoreographySort(i.bro);
        O.OrchestrationSort(i.grandpa,i.bro);
    }
}