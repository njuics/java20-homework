
public class SortHuluwa {
    public static void main(String[] args) {
        //创建葫芦家族
        HuluwaQueue huluFamily = new HuluwaQueue();
        for (int i = 0; i < 10; i++) {
            huluFamily.add(new Huluwa());
        }

        System.out.println("排序前的葫芦娃队伍：");
        for (Huluwa h: huluFamily) {
            System.out.println(h.toString());
        }

        huluFamily.sortByAsc();
        System.out.println("正序排序后的葫芦娃队伍：");
        for (Huluwa h: huluFamily) {
            System.out.println(h.toString());
        }

        huluFamily.sortByDesc();
        System.out.println("倒序排序后的葫芦娃队伍：");
        for (Huluwa h: huluFamily) {
            System.out.println(h.toString());
        }

        huluFamily.shuffle();
        System.out.println("乱序排序后的葫芦娃队伍：");
        for (Huluwa h: huluFamily) {
            System.out.println(h.toString());
        }


        //按性别分两队排序
        System.out.println("按性别分类后的葫芦娃队伍：");
        HuluwaQueue[] twoQueue = huluFamily.divideByGender();
        System.out.println("男队：");
        for (Huluwa h: twoQueue[0]) {
            System.out.println(h.toString());
        }
        System.out.println("女队:");
        for (Huluwa h: twoQueue[1]) {
            System.out.println(h.toString());
        }
    }
}