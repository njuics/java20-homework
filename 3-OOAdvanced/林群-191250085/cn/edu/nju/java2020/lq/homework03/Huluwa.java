package cn.edu.nju.java2020.lq.homework03;

public class Huluwa {
    private int order;//葫芦娃排名
    private String name; //葫芦娃名字

    Huluwa(int order, String name) {
        this.name = name;
        this.order = order;
    }

    void setOrder(int order){this.order = order;}
    void setName(String name){this.name = name;}

    int getOrder(){return this.order;}
    String getName(){return this.name;}

    //报数
    void number(){
        System.out.print(name + " ");
    }

    boolean compare(Huluwa huluwa) {
            return this.order > huluwa.getOrder();
        }

    void swap(Huluwa huluwa) {
       int tmpOrder = huluwa.getOrder();
       String tmpName = huluwa.getName();
       huluwa.setOrder(this.order);
       huluwa.setName(this.name);
       this.order = tmpOrder;
       this.name = tmpName;
    }
}
