package cn.nju.edu;

public class Creature implements Comparable<Creature>{
    protected Position position;
    protected String name;

    Creature(String name, Position position){
        this.name = name;
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void numberOff(){
        System.out.println("Name:" + this.name + " Position:" + this.position.getPosition());
    }

    @Override
    public int compareTo(Creature o) {
        return this.name.compareTo(o.name);
    }
}
