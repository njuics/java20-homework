public class GrandFather {
    private int[] idx;
    private CalabashBrothers[] brothers;

    public CalabashBrothers[] getBrothers() {
        return brothers;
    }

    public void lineUpByGrandfather(CalabashBrothers[] brothers) {
        Sort sort = new QuickSort();
        sort.concreteSort(brothers, 0, 6);
    }

    public GrandFather(int[] idx) {
        this.idx = idx;
        brothers = new CalabashBrothers[7];

        for (int i = 0; i < 7; i++) {
            brothers[i] = new CalabashBrothers(idx[i]);
        }
    }

    public static void main(String[] args) {
        int[] idx = {5, 1, 4, 3, 2, 6, 7};
        GrandFather grandfather = new GrandFather(idx);
        CalabashBrothers[] brothers = grandfather.getBrothers();

        for (int i = 0; i < 7; i++) {
            System.out.println(brothers[i].getName());
        }

        grandfather.lineUpByGrandfather(brothers);
        System.out.println("---");

        for (int i = 0; i < 7; i++) {
            System.out.println(brothers[i].getName());
        }
    }
}
