package cn.edu.nju.javahomework03;

public class SelectSort implements Sort {
    public Brother[] beginSort(Brother[] bro){
        System.out.println("选择排序开始");
        for(int i=0;i<7;++i){
            System.out.println("第"+(i+1)+"轮选择排序");
            int oldest=i;
            for(int j=i;j<7;++j)
                oldest=bro[j].whoIsTheOlderOne(bro,j,oldest);
            bro[oldest].iAmTheOldestOne(bro,oldest,i);
        }
        System.out.println("选择排序结束");

        return bro;
    }

    public Brother[] beginSort(GrandFather grandpa,Brother[] bro){
        System.out.println("选择排序开始");
        for(int i=0;i<7;++i){
            System.out.println("第"+(i+1)+"轮选择排序");
            grandpa.findOldestAndSwap(bro,i);
        }
        System.out.println("选择排序结束");

        return bro;
    }
}
