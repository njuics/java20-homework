import java.util.*;
enum Order{
    POSITIVE,NEGATIVE,RANDOM
}
public  class ComparatorT {
    private Order order;
    ComparatorT(){
        order=Order.POSITIVE;
    }
    ComparatorT(Order o){
        order=o;
    }
    public void set_order(Order o){
        order=o;
    }
    public Order get_order(){
        return order;
    }
    public <T extends Comparable<? super T>> int compareT(T bro1,T bro2){
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
    public <T extends Comparable<? super T>> void DOSort(List<T> list){
        for(int i=0;i<list.size()-1;i++){
            for(int j=0;j<list.size()-i-1;j++)
            {
                if(compareT(list.get(j), list.get(j+1))>0){
                    T temp=list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,temp);
                }
            }
        }
    }
}