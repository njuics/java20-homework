package cn.edu.nju.java2020;

public class Hulu extends CartonCharacter implements Sort {
    @Override
    public void sort(CartonCharacter[] characters) {
        if (characters.length <= 0) return;
        if (!(characters[0] instanceof Hulu)) return;
        bubbleSort((Hulu[]) characters);
    }

    public Hulu(String name, int rank) {
        super(name);
        this.rank = rank;
    }

    public void swap(Hulu huluwa) {
        int tempRank = huluwa.rank;
        String tempName = huluwa.name;
        huluwa.name = this.name;
        huluwa.rank = this.rank;
        this.name = tempName;
        this.rank = tempRank;
    }

    public String reportName() {
        return name;
    }

    public boolean compare(Hulu a) {
        return this.rank > a.rank;
    }

    private void bubbleSort(Hulu[] huluBrothers) {
        for (int i = 0; i < huluBrothers.length - 1; ++i) {
            for (int j = 0; j < huluBrothers.length - 1 - i; ++j) {
                if (huluBrothers[j].compare(huluBrothers[j + 1])) {
                    huluBrothers[j].swap(huluBrothers[j + 1]);
                }
            }
        }
    }

    private int rank;
}
