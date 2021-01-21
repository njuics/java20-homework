package model;

public class StrongCalabash extends Calabash{
    public StrongCalabash(String name,Boolean gender){
        super(name,gender);
    }
    @Override
    public void reportName(){
        System.out.println("Name: " + name + " Gender: " + (gender ? "male" : "female") + " Kind:StrongCalabash");
    }
}
