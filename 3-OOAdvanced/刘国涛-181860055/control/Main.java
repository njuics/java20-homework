package control;
import world.*;
public class Main {
    public static void main(String[] args){
        World[] worlds = {new OrchestrationWorld(),new ChoreographyWorld()};
        for(World world:worlds){
            world.run();
        }
    }
}


