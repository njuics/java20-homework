class Choreography extends BaseSort{
    public void sort(CalabashBoys c){
        System.out.println("---------------------------------------------------------------");
        System.out.println("Choreography排序：");
        for(int i = 0; i < c.getSetLength() - 1; i++){
            for(int j = c.getSetLength() - 1; j > i; j--){
                Calabash s1 = c.getCalabash(j), s2 = c.getCalabash(j - 1);
                if(s1.getId() < s2.getId()){
                    System.out.println(s1.getName() + "说：" + s2.getName() + "，你比我小，我们俩换一下位置！");
                    swap(c, j, j - 1);
                }
            }
        }
        System.out.println("Choreography排序完成，结果如下：");
        for(Calabash i:c.getSet()){
            System.out.print(i.getName() + " ");
        }
        System.out.println();
    }
}