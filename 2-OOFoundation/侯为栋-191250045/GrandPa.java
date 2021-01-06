import java.util.ArrayList;

public class GrandPa {
    private ArrayList<Calabash> calabashes;
    int[] positions;

    public GrandPa() {
        this.calabashes = new ArrayList<>();
        calabashes.add(new Calabash(0, "大娃", "力大无穷"));
        calabashes.add(new Calabash(1, "二娃", "千里眼顺风耳"));
        calabashes.add(new Calabash(2, "三娃", "金刚不坏"));
        calabashes.add(new Calabash(3, "四娃", "喷火"));
        calabashes.add(new Calabash(4, "五娃", "喷水"));
        calabashes.add(new Calabash(5, "六娃", "隐身"));
        calabashes.add(new Calabash(6, "七娃", "宝葫芦"));
        this.positions = new int[]{-1, -1, -1, -1, -1, -1, -1};
    }

    public void setPositions() {
        //让葫芦娃们随意站队
        for (Calabash cur : this.calabashes) cur.pickPosition(this.positions);
    }

    public void numberOff() {
        //让葫芦娃们按照自己当前次序报数
        for (int i = 0; i < 7; ++i) this.calabashes.get(positions[i]).callSelfName();
        System.out.println("完毕~");
    }

    public void exchangePosition(Calabash one, Calabash two) {
        //让俩葫芦娃交换次序
        int tmpOne = one.getPosition();
        int tmpTwo = two.getPosition();
        int tmpVal = this.positions[tmpOne];
        this.positions[tmpOne] = this.positions[tmpTwo];
        this.positions[tmpTwo] = tmpVal;
        one.setPosition(tmpTwo);
        two.setPosition(tmpOne);
    }

    public void lineThemUp(QueueType type, Sort solution) {
        switch (type) {
            case CHOREOGRAPHY:
                solution.sort(this.calabashes, this.positions);
                break;
            case ORCHESTRATION:
                solution.sort(this, this.calabashes, this.positions);
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        GrandPa grandPa = new GrandPa();
        grandPa.setPositions();
        grandPa.numberOff();
        grandPa.lineThemUp(QueueType.CHOREOGRAPHY, new SortMethodB());
        grandPa.numberOff();
    }
}
