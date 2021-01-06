public class Human extends Creature implements Sorting{
    static{
        race="Huluwa";
    }
    Human(String n){
        this.name=n;
    }
    @Override
    public void sort(Huluwa[] h){//orchestration_sort
        int minpos=0;
        Huluwa mintemp=h[0];
        int j=h.length;
        while(j>1){//选择排序,爷爷每次找到葫芦娃中年纪最小的，也就是排行最末的葫芦娃放到最后面去
            for(int i=0;i<j;i++){
                if(h[i].range > mintemp.range) {
                    mintemp=h[i];
                    minpos=i;
                }
            }
            j--;
            h[minpos]=h[j];
            h[j]=mintemp;
            mintemp=h[0];
            minpos=0;
        }
    }
}