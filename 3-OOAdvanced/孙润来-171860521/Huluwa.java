package homework_3;

import java.util.Collections;

public class Huluwa implements SortInterface {
    static int id;
    static {
        id = 0;
    }
    protected int pos;
    protected String name;
    Huluwa(){
        this.pos = id++;
        this.name = "未知";
    }
    Huluwa(String name){
        this.pos = id++;
        this.name = name;
    }

    @Override
    public int getNowPos(String name) {
        return pos;
    }

    @Override
    public void print() {
        System.out.print(this.name+"\t");
    }

    @Override
    public String getName() {
        return this.name;
    }
}
