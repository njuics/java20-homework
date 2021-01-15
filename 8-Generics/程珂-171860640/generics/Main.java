package generics;

public class Main {
    private static BattleField bf=new BattleField();

    private static void testOrderPrintBros(){
        bf.orderPrintCretures();
    }

    private static void testReversePrintBros(){
        bf.reversePrintCretures();
    }

    public static void main(String[] args){
        System.out.println("Test Order Print Bros:");
        testOrderPrintBros();

        System.out.println("Test Reverse Print Bros :");
        testReversePrintBros();
    }
}
