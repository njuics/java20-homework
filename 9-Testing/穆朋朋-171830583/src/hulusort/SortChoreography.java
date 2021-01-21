package src.hulusort;
public class SortChoreography implements SortHuluwaList{

    @Override
    public void sort(HuluwaList<Huluwa> list) {
        System.out.println("Choreography排序：");
        for (int i = 0; i < list.size(); i++) {
            int iColor=list.get(i).getColor();
            for (int j = 0; j < list.size(); j++) {
                if(j!=i)
                    list.get(j).message(iColor);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(j).getRank()==i) {
                    list.swap(i, j);
                }
            }
        }
    }
    
}