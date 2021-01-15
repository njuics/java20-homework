public class Position <T extends Creature> {

    private T holder;       /* HuLuWa or Monster */

    private int line;       /* position 所在行 */

    private int cow;        /* position 所在列 */

    Position(int line,int cow,T holder) {
        this.line = line;
        this.cow = cow;
        this.holder = holder;
    }

    public T get_creature() {       /* 获得该位置的creature */
        return this.holder;
    }

    public int get_line() {     /* 获得该位置的行 */
        return this.line;
    }

    public int get_cow() {      /* 获得该位置的列 */
        return this.cow;
    }
    
    public void position_replace(T replacer) {
        this.holder = replacer;
    }
}
