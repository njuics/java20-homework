public class Main {
    public static void main(String[] args) {
        HuluCollection huluCol = new HuluCollection();

        System.out.println("===Before order===");
        huluCol.printInfo();
        System.out.println();

        System.out.println("===Out-of-order===");
        huluCol.outOfOrder();
        System.out.println();

        System.out.println("===Positive-order===");
        huluCol.positiveOrder();
        System.out.println();

        System.out.println("===Negative-order===");
        huluCol.negativeOrder();
        System.out.println();

        System.out.println("===Positive-order-by-gender===");
        huluCol.genderSort(false);
        System.out.println();

        System.out.println("===Negative-order-by-gender===");
        huluCol.genderSort(true);
        System.out.println();
    }
}
