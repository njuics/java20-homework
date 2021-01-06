package cn.edu.nju.java2020.lq.homework03;

public class Grandpa {

    boolean compare(Huluwa huluwa1, Huluwa huluwa2) {return huluwa1.getOrder() > huluwa2.getOrder();}

    void swap(Huluwa huluwa1, Huluwa huluwa2) {
        int tmpOrder = huluwa1.getOrder();
        String tmpName = huluwa1.getName();
        huluwa1.setOrder(huluwa2.getOrder());
        huluwa1.setName(huluwa2.getName());
        huluwa2.setOrder(tmpOrder);
        huluwa2.setName(tmpName);
    }
}
