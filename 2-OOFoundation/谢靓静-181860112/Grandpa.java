public class Grandpa {
    private static HuluList huluSons;

    public Grandpa(){
        huluSons = new HuluList();
    }

    public void shuffle() {
        huluSons.shuffle();
    }

    public void orchestration() {
        selectionSort();
        huluSons.countOff();
        System.out.println();
    }

    private void selectionSort() {
        for (int i = 0; i < huluSons.huluBrothers.length - 1; ++i) {
            int min = i;
            for (int j = i + 1; j < huluSons.huluBrothers.length; j++) {
                if (!huluSons.huluBrothers[j].compare(huluSons.huluBrothers[min])) {
                    min = j;
                }
            }
            huluSons.swap(i, min);
        }
    }
}
