package model;

public class WaterCalabash extends Calabash{
    public WaterCalabash(String name,Boolean gender){
        super(name,gender);
    }
    @Override
    public void reportName(){
        System.out.println("Name: " + name + " Gender: " + (gender ? "male" : "female") + " Kind:WaterCalabash");
    }
}
