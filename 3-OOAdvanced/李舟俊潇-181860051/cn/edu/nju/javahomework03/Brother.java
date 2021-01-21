package cn.edu.nju.javahomework03;

public class Brother extends Human{
    public int number;

    public Brother(int number,String name){
        this.number=number;
        this.name=name;
    }

    //(冒泡排序)自己的number比front的number小的时候返回true(需要交换)
    private boolean compareWithFrontBrother(Brother front){
        if(number<front.number){
            System.out.println(name+"发现"+front.name+"应该在自己后面，交换");
            return true;
        }
        else
            return false;
    }

    //(冒泡排序)自己的number比next的number大的时候返回true(需要交换)
    private boolean compareWithNextBrother(Brother next){
        if(number>next.number){
            System.out.println(name+"发现"+next.name+"应该在自己前面，交换");
            return true;
        }
        else
            return false;
    }

    //(冒泡排序)葫芦娃检查自己需不需要与下一个葫芦娃交换位置,如果需要则交换
    public boolean brotherCheckAndSwap(Brother[] temp,int self,int next){
        if(compareWithNextBrother(temp[next])){
            Brother help=temp[self];
            temp[self]=temp[next];
            temp[next]=help;
            return false;
        }
        return true;
    }

    //(选择排序)本葫芦娃与当前年龄最大的葫芦娃比大小，返回更大的葫芦娃
    public int whoIsTheOlderOne(Brother[] temp,int self,int oldest){
        return this.number<temp[oldest].number?self: oldest;
    }

    //(选择排序)本葫芦娃年龄最大，应排在队伍前面
    public void iAmTheOldestOne(Brother[] temp,int self,int first){
        if(self==first) {
            System.out.println("当前我"+name+"是年龄最大的且在正确的位置上，不需要换位置");
            return;
        }
        System.out.println("当前我"+name+"是年龄最大的，我即将与第"+(first+1)+"个葫芦娃("+temp[first].name+")换位置");
        Brother help=temp[self];
        temp[self]=temp[first];
        temp[first]=help;
    }
}
