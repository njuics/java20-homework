package factory;
import model.*;
public class CalabashFactory implements IFactory<Calabash> {
    public Calabash create(String[] args){
        if(args[0].equalsIgnoreCase("StrongCalabash")){
            return new StrongCalabash(args[1],args[2].equals("male"));
        }
        else if(args[0].equalsIgnoreCase("FireCalabash")){
            return new FireCalabash(args[1],args[2].equals("male"));
        }
        else if(args[0].equalsIgnoreCase("WaterCalabash")){
            return new WaterCalabash(args[1],args[2].equals("male"));
        }
        else{
            return new Calabash(args[1],args[2].equals("male"));
        }
    }
}
