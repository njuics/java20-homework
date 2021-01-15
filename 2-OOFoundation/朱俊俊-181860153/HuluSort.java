public class HuluSort {

    public static void main(String[] args) {
        Hulu[] hulu1 = new Hulu[7];
        Hulu[] hulu2 = new Hulu[7];

        int[] tmp = {1, 4, 0, 2, 6, 5, 3};
        for (int i = 0; i < 7; i++) {
            hulu1[i] = new Hulu(tmp[i]);
            hulu2[i] = new Hulu(tmp[i]);
        }

        Orchestration.sort(hulu1);
        Choreography.sort(hulu2);

        System.out.println("Orchestration:");
        for (Hulu hulu : hulu1)
            hulu.countOff();

        System.out.println("\nChoreography:");
        for (Hulu hulu : hulu2)
            hulu.countOff();
    }

}
