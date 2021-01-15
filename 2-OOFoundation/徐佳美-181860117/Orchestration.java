
import java.util.Random;

public class Orchestration{
    public static void main(String[] args) {
        Grandpa grandpa = new Grandpa();
        Calabash grandsons[] = grandpa.createCalabash();
        System.out.println("Orchestration");
        grandpa.randLine(grandsons);
        System.out.println("排序前  ");
        grandpa.report(grandsons);
        grandpa.newSort(grandsons);
        System.out.println("排序后  ");
        grandpa.report(grandsons);

    }
};

class Calabash {

    String name;
    int age;

    Calabash(String inName, int inAge) {
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
};

class Grandpa {

    public Calabash[] createCalabash() {
        Calabash[] grandsons = new Calabash[] { new Calabash("大娃", 7), new Calabash("二娃", 6), new Calabash("三娃", 5),
                new Calabash("四娃", 4), new Calabash("五娃", 3), new Calabash("六娃", 2), new Calabash("七娃", 1), };
        return grandsons;
    }

    void swap(Calabash[] grandsons, int a, int b) {
        Calabash temp = grandsons[a];
        grandsons[a] = grandsons[b];
        grandsons[b] = temp;
    }

    public void randLine(Calabash[] grandsons) {
        Random rand = new Random();
        int len = grandsons.length;
        for (int i = len; i > 0; i--) {
            int randInd = rand.nextInt(i);
            swap(grandsons, randInd, i - 1);
        }
    }

    public void report(Calabash[] grandsons) {
        for (Calabash huluwa : grandsons) {
            huluwa.sayName();
        }
        System.out.println();
    }

    public void newSort(Calabash[] grandsons) {
        int len = grandsons.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (grandsons[i].getAge() < grandsons[j].getAge()) {
                    swap(grandsons, i, j);
                }
            }
        }
    }

};