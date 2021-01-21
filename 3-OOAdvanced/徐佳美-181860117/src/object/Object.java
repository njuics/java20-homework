package object;


public class Object{
    protected String name;
    protected int age;
    public Object(){
        name = "";
        age = 0;
    }
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void sayName() {
        System.out.print(this.name + "  ");
    }
};