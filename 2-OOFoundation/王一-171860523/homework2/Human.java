package homework2;

public class Human {
    protected String name;    //人类实体的姓名
    protected int index;      //人类实体的编号

    Human(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 该函数中该实体输出自己的姓名
     */
    public void sayOutName() {
        System.out.println(name);
    }

    /**
     * 该函数返回该实体的编号
     * @return index
     */
    public int getIndex() {
        return index;
    }
}
