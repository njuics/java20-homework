package homework_9;

import java.util.Comparator;
import java.util.Random;

public class Huluwa extends Creature{
    private static String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private int nameLength;

    public static String getRandomString(int length){
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(52);
            sb.append(letters.charAt(number));
        }
        return sb.toString();
    }

    public static boolean getRandomGender(){
        Random random = new Random();
        return random.nextBoolean();
    }
    public Huluwa(){
        Random random = new Random(System.currentTimeMillis());
        nameLength = random.nextInt(6)+5;
        name = getRandomString(nameLength);
        gender = getRandomGender();

    }

    public String getName(){
        return super.getName();
    }

    public Boolean getGender(){
        return super.getGender();
    }

    @Override
    public int compareTo(Creature o) {
        if(o.gender!=gender)
            return gender?-1:1;
        switch (order){
            case 1:
                return name.compareTo(o.name);
            case 2:
                return o.name.compareTo(name);
            case 3:
                Random random = new Random(System.currentTimeMillis());
                return random.nextInt(3)-1;
            default:
                return 0;
        }
    }

    @Override
    public void selectOrder(int order) {
        super.selectOrder(order);
    }

    public static Comparator<Huluwa> getComparator(int order){
        switch (order){
            case 1:
                return new Comparator<Huluwa>() {
                    @Override
                    public int compare(Huluwa o1, Huluwa o2) {
                        if(o1.gender!=o2.gender)
                            return o1.gender?-1:1;
                        return o1.name.compareTo(o2.name);
                    }
                };
            case 2:
                return new Comparator<Huluwa>() {
                    @Override
                    public int compare(Huluwa o1, Huluwa o2) {
                        if(o1.gender!=o2.gender)
                            return o1.gender?-1:1;
                        return o2.name.compareTo(o1.name);
                    }
                };
            case 3:
                return new Comparator<Huluwa>() {
                    @Override
                    public int compare(Huluwa o1, Huluwa o2) {
                        if(o1.gender!=o2.gender)
                            return o1.gender?-1:1;
                        Random random = new Random(System.currentTimeMillis());
                        return random.nextInt(3)-1;
                    }
                };
            default:
                return new Comparator<Huluwa>() {
                    @Override
                    public int compare(Huluwa o1, Huluwa o2) {
                        return o1.compareTo(o2);
                    }
                };
        }
    }

}
