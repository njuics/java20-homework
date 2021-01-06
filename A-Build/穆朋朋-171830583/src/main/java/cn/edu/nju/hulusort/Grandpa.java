package cn.edu.nju.hulusort;
public class Grandpa implements SortHuluwaList{

    @Override
    public void sort(HuluwaList<Huluwa> list) {
        for (int i = 0; i < list.size(); i++) {
            int minHuluwaIndex=i;
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(j).compareTo(list.get(minHuluwaIndex))<0) {
                    minHuluwaIndex=j;
                }
            }
            list.swap(i, minHuluwaIndex);
        }
    }
    
}