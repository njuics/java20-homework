package cn.edu.nju.java2020;

public class Grandpa extends CartonCharacter implements Sort {
    @Override
    public void sort(CartonCharacter[] characters) {
        if (characters.length <= 0) return;
        if (!(characters[0] instanceof Hulu)) return;
        selectionSort((Hulu[]) characters);
    }

    public Grandpa() {
        super("爷爷");
    }

    private void selectionSort(Hulu[] huluBrothers) {
        for (int i = 0; i < huluBrothers.length - 1; ++i) {
            int min = i;
            for (int j = i + 1; j < huluBrothers.length; j++) {
                if (!huluBrothers[j].compare(huluBrothers[min])) {
                    min = j;
                }
            }
            huluBrothers[i].swap(huluBrothers[min]);
        }
    }

}
