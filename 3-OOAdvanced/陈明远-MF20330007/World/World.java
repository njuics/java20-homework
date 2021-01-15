package World;

import Gourd.GourdBrother;
import GrandFather.GrandFather;

public class World {
    public static void main(String[] args) {
        GrandFather grandFather = new GrandFather();
        GourdBrother gourdBrother = new GourdBrother();
        gourdBrother.brith();
        grandFather.callSort();
        gourdBrother.sort();
        gourdBrother.finishSort();
        grandFather.callReport();
        gourdBrother.reportName();
    }
}
