import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<HuLuWa> hList = new ArrayList<>();
        List<Monster> mList = new ArrayList<>();
        List<Creature> hmList = new ArrayList<>();
        List<List<? extends Creature>> list = Arrays.asList(hList, mList, hmList);

        Random random = new Random();
        for (int i = 0; i < 12; i++) {
            hList.add(new HuLuWa());
            mList.add(new Monster());
            if (random.nextBoolean()) {
                hmList.add(new HuLuWa());
            } else {
                hmList.add(new Monster());
            }
        }

        list.forEach(l -> {
            System.out.println("--------------------");
            l.forEach(System.out::println);
        });

        list.forEach(CustomSort::quickSort);

        list.forEach(l -> {
            System.out.println("--------------------");
            l.forEach(System.out::println);
        });
    }
}
