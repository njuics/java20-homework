public class SingleHuLuWa{
    private int priority;
    private String name;

    public SingleHuLuWa(int priority, String name){
        this.priority = priority;
        this.name = name;
    }

    public int getPriority(){
        return priority;
    }

    public String getName(){
        return name;
    }

    public boolean compareTo(SingleHuLuWa singleHuLuWa) {
        return this.priority > singleHuLuWa.getPriority();
    }
}
