import java.util.ListIterator;
import java.util.Random;
import java.util.UUID;

public class HuluGenderNameSortTest {
    private static class RandomEnum<E extends Enum<E>> {
        private static final Random RND = new Random();
        private final E[] values;

        public RandomEnum(Class<E> token) {
            values = token.getEnumConstants();
        }

        public E random() {
            return values[RND.nextInt(values.length)];
        }
    }

    public static void main(String[] args) {
        RandomEnum<Hulu.Gender> randomEnum = new RandomEnum<Hulu.Gender>(Hulu.Gender.class);
        HuluCollection huluCollection = new HuluCollection();
        HuluNameComparator huluNameComparator = new HuluNameComparator();

        for (int i = 0; i < 10; ++i) {
            Hulu hulu = new Hulu(UUID.randomUUID().toString(), randomEnum.random());
            huluCollection.iterator().add(hulu);
        }

        System.out.println("Before Sort:");
        huluCollection.printContent();
        System.out.println("");

        HuluCollection huluCollectionMale = new HuluCollection();
        HuluCollection huluCollectionFemale = new HuluCollection();

        ListIterator<Hulu> listIterator = huluCollection.iterator();
        while (listIterator.hasNext()) {
            Hulu hulu = listIterator.next();
            if (hulu.getGender() == Hulu.Gender.MALE) {
                huluCollectionMale.iterator().add(hulu);
            } else {
                huluCollectionFemale.iterator().add(hulu);
            }
        }

        huluCollectionMale.sort(huluNameComparator);
        huluCollectionFemale.sort(huluNameComparator);

        System.out.println("After Sort:");
        System.out.println("Male Hulu:");
        huluCollectionMale.printContent();
        System.out.println("Female Hulu:");
        huluCollectionFemale.printContent();
    }
}