package cn.edu.nju.java.actor;

import cn.edu.nju.java.Human;

public class CalabashBrother extends Human implements Comparable<CalabashBrother>{
    private int idx;

    public CalabashBrother(String name, int idx) {
        this.nickname = name;
        this.idx = idx;
    }

    @Override
    public int compareTo(CalabashBrother other) {
        if (this.idx < other.idx) {
            say();
            other.reportName();
            return -1;
        } else if (this.idx > other.idx) {
            other.say();
            reportName();
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    protected void lines() {
        System.out.print("I should be in front of you, ");
    }
}
