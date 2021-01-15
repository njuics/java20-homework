public class Main {
    public static void main(String[] args) {
        sortByChoreography r = new sortByChoreography();
        r.randInitial();
        r.sort_By_Choreography();

        sortByOrchestration h = new sortByOrchestration();
        h.randInitial();
        h.sort_By_Orchestration();
    }
}
