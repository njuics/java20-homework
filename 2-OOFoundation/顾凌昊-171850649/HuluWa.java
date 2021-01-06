package OOFoundation;

public class HuluWa implements Comparable<HuluWa>{

    public String name;
    public int num;

    public HuluWa(int n, String nm){
        num = n;
        name = nm;
    }

    @Override
    public int compareTo(HuluWa o) {
        return num-o.num;
    }

    /**
     * 获得自己在一个队伍里的位置
     * @param array
     * @return
     */
    public int getIndex(HuluWa[] array){
        int index = 0;
        for(int i = 0 ;i<array.length;i++){
            if(compareTo(array[i])>0) index++;
        }
        return index;
    }

    public void call(){
        System.out.print(name+"\t");
    }
}
