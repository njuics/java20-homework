import java.util.ArrayList;

public class SortMethodB implements Sort {
    //本类实现选择排序

    @Override
    public void sort(ArrayList<Calabash> calabashes, int[] positions) {
        for (int i = 0; i < 6; ++i) {
            int min = i;
            for (int j = i + 1; j < 7; ++j) {
                Calabash tmpA = calabashes.get(positions[min]);
                Calabash tmpB = calabashes.get(positions[j]);
                if (!tmpA.isSenior(tmpB)) min = j;
            }
            if (min != i) calabashes.get(positions[i]).exchangePosition(calabashes.get(positions[min]), positions);
        }
    }

    @Override
    public void sort(GrandPa grandPa, ArrayList<Calabash> calabashes, int[] positions) {
        for (int i = 0; i < 6; ++i) {
            int min = i;
            for (int j = i + 1; j < 7; ++j) {
                Calabash tmpA = calabashes.get(positions[min]);
                Calabash tmpB = calabashes.get(positions[j]);
                if (!tmpA.isSenior(tmpB)) min = j;
            }
            if (min != i) grandPa.exchangePosition(calabashes.get(positions[i]), calabashes.get(positions[min]));
        }
    }
}
