package cn.edu.nju.javahomework03;

public class GrandFather extends Human {
    public GrandFather(){
        name="爷爷";
    }

    //(冒泡排序)爷爷指挥，bro1的number大于bro2的number时返回true(需要交换)
    public boolean conduct(Brother bro1, Brother bro2){
        if(bro1.number> bro2.number){
            System.out.println("爷爷发现"+bro1.name+"与"+bro2.name+"的顺序错误，两者交换");
            return true;
        }
        else
            return false;
    }

    //(选择排序)爷爷在剩余乱序葫芦娃中找到年龄最大的并将他排在第一个
    public void findOldestAndSwap(Brother[] temp,int first){
        int oldest=first;
        for(int j=first;j<7;j++){
            if(temp[j].number<temp[oldest].number)
                oldest=j;
        }
        if(oldest==first){
            System.out.println("爷爷发现"+temp[oldest].name+"是当前年龄最大的且在正确的位置上，不需要换位置");
            return;
        }
        System.out.println("爷爷发现"+temp[oldest].name+"是年龄最大的，将他与第"+(first+1)+"个葫芦娃("+temp[first].name+")换位置");
        Brother help=temp[oldest];
        temp[oldest]=temp[first];
        temp[first]=help;
    }
}
