import java.util.ArrayList;
import java.util.Comparator;

// Hulu sorter, in an orchestration manner
class HuluOrchestrationSorter {

    // Hulu Comparator, singleton
    private static class HuluComparator implements Comparator<Hulu> {
        @Override
        public int compare(final Hulu a, final Hulu b) {
            return a.compareTo(b);
        }

        private static HuluComparator instance = null;

        private HuluComparator() {
            super();
        }

        public static HuluComparator getInstance() {
            if (instance == null) {
                instance = new HuluComparator();
            }
            return instance;
        }
    }

    private ArrayList<Hulu> huluArray = new ArrayList<>();

    // add a Hulu to sorter
    private void add(Hulu hulu) {
        huluArray.add(hulu);
    }

    // print all Hulu in the sorter
    private void print() {
        for (Hulu hulu : huluArray) {
            System.out.println(hulu.toString());
        }
    }

    // to sort all Hulu
    private void sort() {
        huluArray.sort(HuluComparator.getInstance());
    }

    public static void main(String[] args) {
        HuluOrchestrationSorter sorter = new HuluOrchestrationSorter();
        final Hulu[] huluArray = { new Hulu(Hulu.INDEX.FIVE), new Hulu(Hulu.INDEX.SEVEN), new Hulu(Hulu.INDEX.SIX),
                new Hulu(Hulu.INDEX.FOUR), new Hulu(Hulu.INDEX.TWO), new Hulu(Hulu.INDEX.THREE),
                new Hulu(Hulu.INDEX.THREE), new Hulu(Hulu.INDEX.ONE), new Hulu(Hulu.INDEX.TWO),
                new Hulu(Hulu.INDEX.SIX) };
        for (Hulu hulu : huluArray) {
            sorter.add(hulu);
        }
        System.out.println("before sort: ");
        sorter.print();

        sorter.sort();
        System.out.println("after sort: ");
        sorter.print();
    }
}