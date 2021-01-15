package factory;
import model.*;

public class CalabashFactory implements IFactory<Calabash> {
    static private String[] calabashTypes = {
        "StrongCalabash","FireCalabash","WaterCalabash"
    };
    public Calabash create(String[] args){
        for(String calabashType:calabashTypes){
            if(args[0].equalsIgnoreCase(calabashType)){
                Calabash calabash = null;
                try {
                    calabash = (Calabash) Class.forName("model."+calabashType)
                                                .getDeclaredConstructor(String.class,Boolean.class)
                                                .newInstance(args[1],args[2].equals("male"));
                    
                } catch (Exception e) {    
                    e.printStackTrace();
                }
                return calabash;
            }
        }

        return new Calabash(args[1],args[2].equals("male"));
    }
    public String[] getCalabashTypes(){
        return calabashTypes;
    }
}
