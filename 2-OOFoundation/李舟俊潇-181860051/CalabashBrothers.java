import java.util.Random;
import java.util.Scanner;

public class CalabashBrothers {
    //由葫芦娃们的爷爷来指挥葫芦娃们行动
    private static Brother[] orchestration(Brother[] temp){
        System.out.println("\n现在由葫芦娃们的爷爷来指挥葫芦娃们行动");
        Grandfather grandpa=new Grandfather();
        //爷爷开始为葫芦娃排序
        grandpa.grandfatherSort(temp);

        return temp;
    }

    //葫芦娃相互协作，完成排队过程
    private static Brother[] choreography(Brother[] temp){
        System.out.println("\n现在由葫芦娃相互协作，完成排队过程");

        //冒泡排序
        System.out.println("冒泡排序开始");
        for(int i=0;i<7-1;++i) {
            System.out.println("第"+(i+1)+"轮冒泡排序");
            boolean jumpflag=true;
            for (int j = 0; j < 7 - 1 - i; ++j) {
                //第j个葫芦娃检查自己需不需要与下一个葫芦娃交换位置,如果需要则交换
                boolean tempflag=temp[j].brotherCheckAndSwap(temp,j,j+1);
                jumpflag=jumpflag&&tempflag;
            }
            if(jumpflag){
                System.out.println("此时所有葫芦娃已完成排序，不再继续排序");
                break;
            }
        }
        System.out.println("冒泡排序结束");

        return temp;
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
        for(Brother bro:result)
            System.out.print(bro.name+" ");
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

class Grandfather{
    //爷爷指挥，bro1的number大于bro2的number时返回true(需要交换)
    private boolean conduct(Brother bro1, Brother bro2){
        if(bro1.number> bro2.number){
            System.out.println("爷爷发现"+bro1.name+"与"+bro2.name+"的顺序错误，两者交换");
            return true;
        }
        else
            return false;
    }

    //爷爷开始为葫芦娃排序
    public void grandfatherSort(Brother[] temp){
        //冒泡排序
        System.out.println("冒泡排序开始");
        for(int i=0;i<7-1;++i){
            System.out.println("第"+(i+1)+"轮冒泡排序");
            boolean jumpflag=true;
            for(int j=0;j<7-1-i;++j){
                if(conduct(temp[j],temp[j+1])){
                    jumpflag=false;
                    Brother help=temp[j];
                    temp[j]=temp[j+1];
                    temp[j+1]=help;
                }
            }
            if(jumpflag){
                System.out.println("此时所有葫芦娃已完成排序，不再继续排序");
                break;
            }
        }
        System.out.println("冒泡排序结束");
    }
}

class Brother{
    public int number;
    public String name;

    public Brother(int num,String myname){
        number=num;
        name=myname;
    }

    //自己的number比front的number小的时候返回true(需要交换)
    private boolean compareWithFrontBrother(Brother front){
       if(number<front.number){
           System.out.println(name+"发现"+front.name+"应该在自己后面，交换");
           return true;
       }
       else
           return false;
    }

    //自己的number比next的number大的时候返回true(需要交换)
    private boolean compareWithNextBrother(Brother next){
        if(number>next.number){
            System.out.println(name+"发现"+next.name+"应该在自己前面，交换");
            return true;
        }
        else
            return false;
    }

    //葫芦娃检查自己需不需要与下一个葫芦娃交换位置,如果需要则交换
    public boolean brotherCheckAndSwap(Brother[] temp,int self,int next){
        if(compareWithNextBrother(temp[next])){
            Brother help=temp[self];
            temp[self]=temp[next];
            temp[next]=help;
            return false;
        }
        return true;
    }
}