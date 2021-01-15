package character;

public class Character {
    protected String name;
    private int position;
    static {
        System.out.println("角色被创建");
    }
    public Character(){
        name=" ";
    }
    public void setPosition(int position){
        this.position = position;
    }
    public int getPosition(){
        return position;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
