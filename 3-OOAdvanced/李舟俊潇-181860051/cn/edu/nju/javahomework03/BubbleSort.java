package cn.edu.nju.javahomework03;

public class BubbleSort implements Sort{
    public Brother[] beginSort(Brother[] bro){
        System.out.println("冒泡排序开始");
        for(int i=0;i<7-1;++i) {
            System.out.println("第"+(i+1)+"轮冒泡排序");
            boolean jumpflag=true;
            for (int j = 0; j < 7 - 1 - i; ++j) {
                //第j个葫芦娃检查自己需不需要与下一个葫芦娃交换位置,如果需要则交换
                boolean tempflag=bro[j].brotherCheckAndSwap(bro,j,j+1);
                jumpflag=jumpflag&&tempflag;
            }
            if(jumpflag){
                System.out.println("此时所有葫芦娃已完成排序，不再继续排序");
                break;
            }
        }
        System.out.println("冒泡排序结束");
        return bro;
    }

    public Brother[] beginSort(GrandFather grandpa,Brother[] bro){
        System.out.println("冒泡排序开始");
        for(int i=0;i<7-1;++i){
            System.out.println("第"+(i+1)+"轮冒泡排序");
            boolean jumpflag=true;
            for(int j=0;j<7-1-i;++j){
                if(grandpa.conduct(bro[j],bro[j+1])){
                    jumpflag=false;
                    Brother help=bro[j];
                    bro[j]=bro[j+1];
                    bro[j+1]=help;
                }
            }
            if(jumpflag){
                System.out.println("此时所有葫芦娃已完成排序，不再继续排序");
                break;
            }
        }
        System.out.println("冒泡排序结束");
        return bro;
    }

}
