package character;

public class Character {
    protected String name;
    static {
        System.out.println("角色被创建");
    }
    public Character(){
        name=" ";
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
