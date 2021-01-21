package model;

public class FireCalabash extends Calabash{
    public FireCalabash(String name,Boolean gender){
        super(name,gender);
    }
    @Override
    public void reportName(){
        System.out.println("Name: " + name + " Gender: " + (gender ? "male" : "female") + " Kind:FireCalabash");
    }
}
