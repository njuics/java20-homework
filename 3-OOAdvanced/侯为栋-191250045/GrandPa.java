// package java20homework.ooadvanced;

import java.util.Comparator;

public class GrandPa {
    private Calabash[] queue;
    private Comparator<Calabash> sortStandard;
    private Sort sortMethod;

    public GrandPa() {
        String[] names = {"老大", "老二", "老三", "老四", "老五", "老六", "老七"};
        this.queue = new Calabash[7];
        for (int i = 0; i < 7; ++i) queue[i] = new Calabash(i, names[i]);
        this.sortStandard = (one, two) -> one.getSeniority() - two.getSeniority();
        this.sortMethod = new SortMethodA();
    }

    public Comparator<Calabash> getSortStandard() {
        return this.sortStandard;
    }

    public Calabash[] getQueue() {
        return this.queue;
    }

    public void setSortMethod(Sort sortMethod) {
        this.sortMethod = sortMethod;
    }

    public void exchangePositions(Calabash one, Calabash two) {
        int onePos = one.getPosition();
        int twoPos = two.getPosition();
        this.queue[onePos] = two;
        this.queue[twoPos] = one;
        one.setPosition(twoPos);
        two.setPosition(onePos);
    }

    public void setPositions() {
        //让葫芦娃们重新选择顺序
        Calabash[] newQueue = new Calabash[7];
        boolean[] pos = new boolean[7];
        for (int i = 0; i < 7; ++i) {
            int index = this.queue[i].pickPosition(pos);
            newQueue[index] = this.queue[i];
        }
        this.queue = newQueue;
    }

    public void numberOff() {
        for (Calabash cur : this.queue) cur.callName();
        System.out.println("完毕~~~");
    }

    public void lineUp(QueueType type) {
        switch (type) {
            case CHOREOGRAPHY:
                //葫芦娃们自己排序
                this.sortMethod.sort(this.queue);
                break;
            case ORCHESTRATION:
                //爷爷指挥排序
                this.sortMethod.sort(this);
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        GrandPa grandPa = new GrandPa();
        grandPa.setPositions();
        grandPa.numberOff();
        grandPa.setSortMethod(new SortMethodB());
        grandPa.lineUp(QueueType.CHOREOGRAPHY);
        grandPa.numberOff();
    }
}
