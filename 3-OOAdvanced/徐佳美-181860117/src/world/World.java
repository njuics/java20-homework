package world;

public class World{
   
    public static void main(String[] args) {
        Orchestration orchestration = new Orchestration();
        Choreography choreography = new Choreography();
        orchestration.run(args);
        choreography.run(args);
    }
};