class Grandpa{        
    public static int partition(CalabashBoys boys, int ppos, int s, int e) {
        int div = s;
        for(int i = s; i <= e; i++) {
            if(boys.getCalabash(i).getId() < boys.getCalabash(ppos).getId()) {
                BaseSort.swap(boys, i, div);
                if(div == ppos) ppos = i;
                div++;
            }
        }
        BaseSort.swap(boys, div, ppos);
        return div;
    }
    
    public static void quickSort(CalabashBoys boys, int s, int e) {
        if(s < e) {
            int ppos = s;
            ppos = partition(boys, ppos, s, e);
            Calabash calaPivot = boys.getCalabash(ppos);
            System.out.println("Grandpa：葫芦娃们，对于队列中位于第"+ (s + 1) +"到第"+ (e + 1) + "位的葫芦娃，比"
                                + calaPivot.getName() + "地位高的葫芦娃请站在他左边，比"
                                + calaPivot.getName() + "地位低的葫芦娃请站在他右边！");
            quickSort(boys, s, ppos - 1);
            quickSort(boys, ppos + 1, e);
        }
    }
}

class Orchestration extends BaseSort{
    public void sort(CalabashBoys c){
        System.out.println("---------------------------------------------------------------");
        System.out.println("Orchestration排序：");
        Grandpa.quickSort(c, 0, c.getSetLength() - 1);
        System.out.println("Orchestration排序完成，结果如下：");
        for(Calabash i:c.getSet()){
            System.out.print(i.getName() + " ");
        }
        System.out.println();
    }

}