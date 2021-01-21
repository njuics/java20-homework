import java.util.Random;

class CalabashBoys {
    private Calabash[] set;

    CalabashBoys(Calabash[] s){
        reset(s);
    }

    //打乱葫芦娃顺序
    public void shuffle() {
        int total = set.length;
        //打乱数组顺序
        Random r = new Random();
        for(int dealed = 0; dealed < total; dealed++) {
            int pos = r.nextInt(total - dealed);
            //将随机到的位置的对象交换至数组尾部
            swap(pos, total - dealed - 1);
        }
    }

    //交换Calabash[] set对应pos1、pos2处对象的数据
    public void swap(int pos1, int pos2){
        if(pos1 >= set.length || pos2 >= set.length) return;
        Calabash tempCala = new Calabash(set[pos1]);
        set[pos1].reset(set[pos2]);
        set[pos2].reset(tempCala);
    }
    
    //输出当前排序信息
    public void report(){
        System.out.println("当前葫芦娃排序为：");
        for(Calabash i:set){
            System.out.print(i.getName() + " ");
        }
        System.out.println();
    }

    //重设set数组
    public void reset(Calabash[] s){
        set = new Calabash[s.length];
        for(int i = 0; i < s.length; i++){
            set[i] = new Calabash(s[i]);
        }
    }

    //外界获取set数组信息
    public Calabash[] getSet(){
        Calabash[] newSet = new Calabash[set.length];
        for(int i = 0; i < set.length; i++){
            newSet[i] = new Calabash(set[i]);
        }
        return newSet;
    }

    //外界获取某一葫芦娃信息
    public Calabash getCalabash(int pos){
        if(pos >= set.length)return null;
        return new Calabash(set[pos].getId(), set[pos].getName());
    }

    //外界获取葫芦娃数组的长度
    public int getSetLength(){
        return set.length;
    }

}