package cf.moegirl.hulu;
import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

import org.junit.Test;

public class HuluCollectionTest {
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

    @Test
    public void genderNameSortTest() {
        RandomEnum<Hulu.Gender> randomEnum = new RandomEnum<Hulu.Gender>(Hulu.Gender.class);
        HuluCollection<Hulu> huluCollection = new HuluCollection<>();
        HuluNameComparator<Hulu> huluNameComparator = new HuluNameComparator<>();
        final int LENGTH = 100;

        for (int i = 0; i < LENGTH; ++i) {
            Hulu hulu = new Hulu(RandomStringUtils.randomAlphanumeric(10), randomEnum.random());
            huluCollection.iterator().add(hulu);
        }

        HuluCollection<Hulu> huluCollectionMale = new HuluCollection<>();
        HuluCollection<Hulu> huluCollectionFemale = new HuluCollection<>();

        List<Hulu> huluListMale = new LinkedList<>();
        List<Hulu> huluListFemale = new LinkedList<>();

        ListIterator<Hulu> listIterator = huluCollection.iterator();
        while (listIterator.hasNext()) {
            Hulu hulu = listIterator.next();
            if (hulu.getGender() == Hulu.Gender.MALE) {
                huluCollectionMale.iterator().add(hulu);
                huluListMale.add(hulu);
            } else {
                huluCollectionFemale.iterator().add(hulu);
                huluListFemale.add(hulu);
            }
        }

        int huluCollectionMaleLength = 0;
        for (Hulu hulu : huluCollectionMale) {
            ++huluCollectionMaleLength;
        }

        int huluCollectionFemaleLength = 0;
        for (Hulu hulu : huluCollectionFemale) {
            ++huluCollectionFemaleLength;
        }

        assertEquals(LENGTH, huluCollectionMaleLength + huluCollectionFemaleLength);

        huluCollectionMale.sort(huluNameComparator);
        huluCollectionFemale.sort(huluNameComparator);
        huluListMale.sort(huluNameComparator);
        huluListFemale.sort(huluNameComparator);

        Iterator<Hulu> huluCollectionMaleIterator = huluCollectionMale.iterator();
        Iterator<Hulu> huluListMaleIterator = huluListMale.iterator();
        while (huluCollectionMaleIterator.hasNext()) {
            Hulu huluFromCollection = huluCollectionMaleIterator.next();
            Hulu huluFromList = huluListMaleIterator.next();
            assertEquals(huluFromCollection, huluFromList);
        }

        Iterator<Hulu> huluCollectionFemaleIterator = huluCollectionFemale.iterator();
        Iterator<Hulu> huluListFemaleIterator = huluListFemale.iterator();
        while (huluCollectionFemaleIterator.hasNext()) {
            Hulu huluFromCollection = huluCollectionFemaleIterator.next();
            Hulu huluFromList = huluListFemaleIterator.next();
            assertEquals(huluFromCollection, huluFromList);
        }
    }
}