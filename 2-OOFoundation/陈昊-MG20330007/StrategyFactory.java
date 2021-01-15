import java.util.Scanner;

public class StrategyFactory {
    private Story ctx;
    private String[] strategies = {"Orchestration", "CalabashBrother"};
    
    StrategyFactory(Story stroy) {
        ctx = stroy;
    }

    private void echo() {
        System.out.println("What strategy you want to use in sort process?");
        System.out.println("[0]: Orchestration");
        System.out.println("[1]: CalabashBrother");
    }

    private void alarm() {
        System.out.println("Please enter legal input!");
        System.out.println();
    }
    
    public SortStrategy getStrategy(String opt) {
        switch (opt) {
            case "Orchestration":
                return new Orchestration(ctx.getGrandFather());
            case "CalabashBrother":
                return new Choreography();
            default:
                return null;
        }
    }

    public SortStrategy getStrategyFromInput() {
        SortStrategy strategy = null;
        Scanner scanner = new Scanner(System.in);
        int opt;
        boolean redo = true;
        while (redo) {
            echo();
            opt = scanner.nextInt();
            try {
                strategy = getStrategy(strategies[opt]);
            } catch (Exception e) {

            }
            
            if (strategy != null) {
                redo = false;
            } else {
                alarm();
            }
        }
        scanner.close();
        return strategy;
    }
}
