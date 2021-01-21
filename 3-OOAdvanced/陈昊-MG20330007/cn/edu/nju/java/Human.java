package cn.edu.nju.java;

public abstract class Human {
    protected String nickname;

    public void reportName() {
        System.out.println(this.nickname);
    }

    abstract protected void lines();

    public void say() {
        System.out.print(this.nickname + " said: ");
        lines();
    }
}
