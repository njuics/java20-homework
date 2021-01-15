
import java.util.Random;

public class Choreography{

    public static void main(String[] args) {
        Calabash2[] grandsons = new Calabash2[] { new Calabash2("大娃", 7), new Calabash2("二娃", 6),
                new Calabash2("三娃", 5), new Calabash2("四娃", 4), new Calabash2("五娃", 3), new Calabash2("六娃", 2),
                new Calabash2("七娃", 1), };
        System.out.println("Choreography");
        randLine(grandsons);
        System.out.println("排序前  ");
        report(grandsons);
        newSort(grandsons);
        System.out.println("排序后  ");
        report(grandsons);
    }

    static void newSort(Calabash2 grandsons[]) {
        int len = grandsons.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (grandsons[i].compare(grandsons[j])) {
                    grandsons[i].swap(grandsons[j]);
                }
            }
        }
    }

    static void swap(Calabash2[] grandsons, int a, int b) {
        Calabash2 temp = grandsons[a];
        grandsons[a] = grandsons[b];
        grandsons[b] = temp;
    }

    static void randLine(Calabash2[] grandsons) {
        Random rand = new Random();
        int len = grandsons.length;
        for (int i = len; i > 0; i--) {
            int randInd = rand.nextInt(i);
            swap(grandsons, randInd, i - 1);
        }
    }

    static void report(Calabash2[] grandsons) {
        for (Calabash2 huluwa : grandsons) {
            huluwa.sayName();
        }
        System.out.println();
    }

};

class Calabash2 {

    private String name;
    private int age;

    Calabash2(String inName, int inAge) {
        name = inName;
        age = inAge;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void sayName() {
        System.out.print(name + "  ");
    }

    public boolean compare(Calabash2 b) {
        return age < b.getAge();

    }

    public void swap(Calabash2 b) {
        String tempName = name;
        int tempAge = age;
        this.name = b.getName();
        this.age = b.getAge();
        b.name = tempName;
        b.age = tempAge;
    }

};
