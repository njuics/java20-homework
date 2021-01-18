import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {

    public static <T extends Comparable<? super T>> void quickSort(List<T> list) {
        quickSort(list, 0, list.size() - 1);
    }

    private static <T extends Comparable<? super T>> void quickSort(List<T> list, int i1, int i2) {
        if (i1 < i2) {
            T pivot = list.get(i2);
            int i = i1 - 1;
            for (int j = i1; j < i2; j++) {
                if (list.get(j).compareTo(pivot) < 0) {
                    i++;
                    Collections.swap(list, i, j);
                }
            }
            Collections.swap(list, i + 1, i2);
            int mid = i + 1;
            quickSort(list, i1, mid - 1);
            quickSort(list, mid + 1, i2);
        }
    }

    public static void main(String[] args) {
        final int TEST_LEN=10;

        List<Creature> creatures=new ArrayList<>();
        List<Calabash> calabashes=new ArrayList<>();
        List<Monster> monsters =new ArrayList<>();

        Random random=new Random();
        for(int i=0;i<TEST_LEN;i++){
            monsters.add(new Monster());
            calabashes.add(new Calabash());
            if(random.nextInt()>0){
                creatures.add(new Monster());
            }else{
                creatures.add(new Calabash());
            }
        }

        System.out.println("----------Creatures queue before sort:------------");
        creatures.forEach(System.out::println);
        quickSort(creatures);
        System.out.println("----------Creatures queue after sort:-------------");
        creatures.forEach(System.out::println);

        System.out.println("----------Calabashes queue before sort:-----------");
        calabashes.forEach(System.out::println);
        quickSort(calabashes);
        System.out.println("----------Calabashes queue after sort:------------");
        calabashes.forEach(System.out::println);

        System.out.println("----------Monsters queue before sort:-------------");
        monsters.forEach(System.out::println);
        quickSort(monsters);
        System.out.println("----------Monsters queue after sort:--------------");
        monsters.forEach(System.out::println);

    }
}
