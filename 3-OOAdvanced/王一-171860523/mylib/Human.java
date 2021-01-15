package homework3.mylib;

public class Human implements Action {
    private static final String[] names;
    public static Human[] humanQueue;
    static {
        names = new String[]{"爷爷", "大娃", "二娃", "三娃", "四娃", "五娃", "六娃", "七娃"};
        humanQueue = new Human[8];
    }
    protected String name;
    protected int id;
    protected int position;

    public Human(int id) {
        this.name = names[id];
        this.id = id;
    }

    public void sayOutName() {
        System.out.println(name);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }

    public void compareExchange() {
        System.out.println("Please use subclass function");
    }
}
