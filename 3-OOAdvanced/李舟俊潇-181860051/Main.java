import java.util.Random;
import java.util.Scanner;
import cn.edu.nju.javahomework03.*;

public class Main {
    //由葫芦娃们的爷爷来指挥葫芦娃们行动
    private static Brother[] orchestration(Brother[] temp){
        System.out.println("\n现在由葫芦娃们的爷爷来指挥葫芦娃们行动");
        GrandFather grandpa=new GrandFather();

        //爷爷开始为葫芦娃排序
        //冒泡排序
        /*
        Sort method=new BubbleSort();
        return method.beginSort(grandpa,temp);
         */
        //选择排序
        Sort method=new SelectSort();
        return method.beginSort(grandpa,temp);
    }

    //葫芦娃相互协作，完成排队过程
    private static Brother[] choreography(Brother[] temp){
        System.out.println("\n现在由葫芦娃相互协作，完成排队过程");

        //葫芦娃开始自己排序
        //冒泡排序
        /*
        Sort method=new BubbleSort();
        return method.beginSort(temp);
         */
        Sort method=new SelectSort();
        return method.beginSort(temp);
    }

    //初始化七个葫芦娃
    private static void initialBros(Brother[] brothers){
        String[] name={"老大","老二","老三","老四","老五","老六","老七"};
        for(int i=0;i<7;++i)
            brothers[i]=new Brother(i,name[i]);
    }

    //将七个葫芦娃随机排列
    private static Brother[] randomSort(Brother[] brothers){
        Brother[] temp=new Brother[7];
        boolean[] flag={false,false,false,false,false,false,false};
        int count=0;
        Random r=new Random();
        while(count<7){
            int cur=r.nextInt(7);
            while(flag[cur])
                cur=(cur+1)%7;
            temp[count]=brothers[cur];
            flag[cur]=true;
            count++;
        }
        System.out.print("葫芦娃的初始顺序为：");
        numberOff(temp);
        System.out.println("\n");
        return temp;
    }

    //选择排序形式并排序
    private static Brother[] selectSortMethod(Brother[] temp){
        Brother[] result=new Brother[7];
        int choice=0;
        while(true){
            System.out.print("请选择排队方式——1 让爷爷帮忙，2 内部解决：");
            Scanner scan=new Scanner(System.in);
            choice=scan.nextInt();
            if(choice==1)
                result=orchestration(temp);
            else if(choice==2)
                result=choreography(temp);
            else{
                System.out.println("输入错误，请重试。");
                continue;
            }
            return result;
        }
    }

    //报数
    private static void numberOff(Brother[] result){
        System.out.println("开始报数");
        for(Brother bro:result){
            bro.shoutOutName();
            System.out.print(" ");
        }
    }

    public static void main(String[] argv){
        //初始化七个葫芦娃
        Brother[] brothers=new Brother[7];
        initialBros(brothers);

        //将七个葫芦娃随机排列
        Brother[] temp=randomSort(brothers);

        //选择排序形式并排序
        Brother[] result=selectSortMethod(temp);

        //报数
        System.out.println("\n");
        numberOff(result);
    }
}
