package cn.edu.nju.java.actor;

import java.util.Arrays;
import java.util.List;
import cn.edu.nju.java.Human;

public class GrandFather extends Human{
    static int childrenNum = 0;
    static {
        childrenNum = 7;
    }
    
    private CalabashBrother[] children;
    static private String[] nicknames = {"老大", "老二", "老三", "老四", "老五", "老六", "老七"};

    public GrandFather() {
        this.nickname = "爷爷";
    }

    public void instruct(List<CalabashBrother> queue) {
        say();
        for (int i = 0; i < GrandFather.childrenNum; i++) {
            queue.set(i, children[i]);
        }
    }

    public CalabashBrother[] plantCalabsh() {
        children = new CalabashBrother[childrenNum];
        for (int i = 0; i < GrandFather.childrenNum; i++) {
            var brother = new CalabashBrother(nicknames[i], i);
            children[i] = brother;
        }
        return Arrays.copyOf(children, childrenNum);
    }

    @Override
    protected void lines() {
        System.out.print("You should all stand in the order when you were born!\n");
    }
}
