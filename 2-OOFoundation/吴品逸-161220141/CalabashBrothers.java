package CalabashBrother;

public class CalabashBrothers {
    public static CalabashBrother[] init(){
        return new CalabashBrother[]{
                new CalabashBrother(4),
                new CalabashBrother(2),
                new CalabashBrother(3),
                new CalabashBrother(6),
                new CalabashBrother(7),
                new CalabashBrother(1),
                new CalabashBrother(5)
        };
    }

    public static void main(String[] args){
        CalabashBrother[] calabashBrothers1 = init();
        System.out.println("orchestration方式");
        CalabashBrother.print(calabashBrothers1);
        System.out.print("\n");
        Sort.bubbleSort(calabashBrothers1);
        CalabashBrother.print(calabashBrothers1);
        System.out.print("\n");

        CalabashBrother[] calabashBrothers2 = init();
        System.out.println("choreography方式");
        CalabashBrother.print(calabashBrothers2);
        System.out.print("\n");
        calabashBrothers2[0].Sort(calabashBrothers2);
        CalabashBrother.print(calabashBrothers2);

    }
}
