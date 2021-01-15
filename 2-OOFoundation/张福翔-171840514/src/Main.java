public class Main {
    public static void main(String[] args) {
        PlayGround playGround = new PlayGround();

        System.out.println("Now Hulu Sort by Grandpa!!");
        HuluSorter sorter = new HuluSorter(HuluSorter.SortMode.ORCHESTRATION);
        // NOTE: you can modify the sort algorithm here
        sorter.quickSort(playGround.getHulus());
        playGround.hulusGreeting();

        System.out.println("Shuffle Again!");
        playGround.shuffleHuluBaby();
        playGround.hulusGreeting();

        System.out.println("Now Hulu Sort by Yourself!!");
        sorter.setMode(HuluSorter.SortMode.CHOREOGRAPHY);
        // NOTE: you can modify the sort algorithm here
        sorter.bubbleSort(playGround.getHulus());
        playGround.hulusGreeting();
    }
}
