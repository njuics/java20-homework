import java.util.Iterator;
public class Main{
    public static void main(String[] args) {
        Family<Huluwa> f=new Family<>();
        for(int i=0;i<10;i++) f.add(new Huluwa());
        System.out.println("Generate:");
        f.show();
        System.out.println();

        System.out.println("Random:");
        Iterator<Huluwa> it1=f.randIterator();
        while(it1.hasNext()){
            System.out.println(it1.next().getInfo());
        }
        System.out.println();

        System.out.println("Ascending:");
        Iterator<Huluwa> it2=f.ascendingIterator();
        while(it2.hasNext()){
            System.out.println(it2.next().getInfo());
        }
        System.out.println();

        System.out.println("Decending:");
        Iterator<Huluwa> it3=f.decendingIterator();
        while(it3.hasNext()){
            System.out.println(it3.next().getInfo());
        }
        System.out.println();

        System.out.println("Male Random:");
        Iterator<Huluwa> it4=f.maleRandIterator();
        while(it4.hasNext()){
            System.out.println(it4.next().getInfo());
        }
        System.out.println();

        System.out.println("Male Ascending:");
        Iterator<Huluwa> it5=f.maleAscendingIterator();
        while(it5.hasNext()){
            System.out.println(it5.next().getInfo());
        }
        System.out.println();

        System.out.println("Male Decending:");
        Iterator<Huluwa> it6=f.maleDecendingIterator();
        while(it6.hasNext()){
            System.out.println(it6.next().getInfo());
        }
        System.out.println();

        System.out.println("Female Random:");
        Iterator<Huluwa> it7=f.femaleRandIterator();
        while(it7.hasNext()){
            System.out.println(it7.next().getInfo());
        }
        System.out.println();

        System.out.println("Female Ascending:");
        Iterator<Huluwa> it8=f.femaleAscendingIterator();
        while(it8.hasNext()){
            System.out.println(it8.next().getInfo());
        }
        System.out.println();

        System.out.println("Female Decending:");
        Iterator<Huluwa> it9=f.femaleDecendingIterator();
        while(it9.hasNext()){
            System.out.println(it9.next().getInfo());
        }
        System.out.println();
        
    }
}