import java.util.ArrayList;

public class SortMethodA implements Sort {
    //本类实现冒泡排序

    @Override
    public void sort(ArrayList<Calabash> calabashes, int[] positions) {
        for (int i = 6; i >= 0; --i) {
            for (int j = 0; j < i; ++j) {
                Calabash tmpA = calabashes.get(positions[j]);
                Calabash tmpB = calabashes.get(positions[j + 1]);
                if (tmpA.isSenior(tmpB)) continue;
                tmpA.exchangePosition(tmpB, positions);
            }
        }
    }

    @Override
    public void sort(GrandPa grandPa, ArrayList<Calabash> calabashes, int[] positions) {
        for (int i = 6; i >= 0; --i) {
            for (int j = 0; j < i; ++j) {
                Calabash tmpA = calabashes.get(positions[j]);
                Calabash tmpB = calabashes.get(positions[j + 1]);
                if (tmpA.isSenior(tmpB)) continue;
                grandPa.exchangePosition(tmpA, tmpB);
            }
        }
    }
}
