import java.util.Arrays;
import java.util.List;

public class GrandFather extends Human{
    int childrenNum = 7;
    CalabashBrother[] children;
    static private String[] nicknames = {"老大", "老二", "老三", "老四", "老五", "老六", "老七"};

    public GrandFather() {
        this.nickname = "爷爷";
    }

    public void instruct(List<CalabashBrother> queue) {
        System.out.println(this.nickname + " said: You should all stand in the order when you were born!");
        for (int i = 0; i < this.childrenNum; i++) {
            queue.set(i, children[i]);
        }
    }

    CalabashBrother[] plantCalabsh() {
        children = new CalabashBrother[childrenNum];
        for (int i = 0; i < this.childrenNum; i++) {
            var brother = new CalabashBrother(nicknames[i], i);
            children[i] = brother;
        }
        return Arrays.copyOf(children, childrenNum);
    }
}
