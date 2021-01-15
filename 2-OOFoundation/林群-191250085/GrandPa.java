public class GrandPa {
    boolean compare(Huluwa huluwa1, Huluwa huluwa2) {return huluwa1.getOrder() > huluwa2.getOrder();}
    void swap(Huluwa huluwa1, Huluwa huluwa2) {
        int temp = huluwa1.getOrder();
        huluwa1.setOrder(huluwa2.getOrder());
        huluwa2.setOrder(temp);
    }
}
