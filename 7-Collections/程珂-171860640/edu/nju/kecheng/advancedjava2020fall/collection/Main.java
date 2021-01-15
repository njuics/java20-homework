package edu.nju.kecheng.advancedjava2020fall.collection;

public class Main {
    private static BrosList bl=new BrosList();

    private static void testOrderPrintBros(){
        bl.orderPrintBros();
        bl.orderPrintMaleBros();
        bl.orderPrintFemaleBros();
    }

    private static void testReversePrintBros(){
        bl.reversePrintBros();
        bl.reversePrintMaleBros();
        bl.orderPrintFemaleBros();
    }

    private static void testShufflingPrintBros(){
        bl.shufflingPrintBros();
        bl.shufflingPrintMaleBros();
        bl.shufflingPrintFemaleBros();
    }

    public static void main(String[] args){
        System.out.println("Test Order Print Bros:");
        testOrderPrintBros();

        System.out.println("Test Reverse Print Bros :");
        testReversePrintBros();

        System.out.println("Test Shuffling Print Bros :");
        testShufflingPrintBros();
    }
}
