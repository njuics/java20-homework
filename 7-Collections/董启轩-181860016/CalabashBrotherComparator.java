import java.util.Comparator;
import java.util.Random;
enum Order{
    POSITIVE,NEGATIVE,RANDOM
}
public  class CalabashBrotherComparator implements Comparator<CalabashBrother>{
    public Order order;
    CalabashBrotherComparator(){
        order=Order.POSITIVE;
    }
    CalabashBrotherComparator(Order o){
        order=o;
    }
    public void set_order(Order o){
        order=o;
    }
    @Override
    public int compare(CalabashBrother bro1,CalabashBrother bro2){
        switch(order){
            case POSITIVE:
            return bro1.compareTo(bro2);
            case NEGATIVE:
            return -bro1.compareTo(bro2);
            default:
            Random r=new Random();
            int randnum1=r.nextInt();
            int randnum2=r.nextInt();
            return randnum1-randnum2;
        }
    }

}