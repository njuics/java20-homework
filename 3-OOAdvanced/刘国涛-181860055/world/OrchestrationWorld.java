package world;
import model.Calabash;
import model.GrandFather;
public class OrchestrationWorld extends World {
    private GrandFather grandFather = new GrandFather();
    private Calabash[] calabashs;
    @Override
    public final void run(){
        System.out.println("Orchestration World run");
        calabashs = grandFather.plantCalabash();
        randomShuffle(calabashs);
        grandFather.reportInOrder(calabashs);
        grandFather.sortCalabash(calabashs);
        grandFather.reportInOrder(calabashs);
    }
}
