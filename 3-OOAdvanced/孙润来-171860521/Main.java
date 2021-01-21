package homework_3;

public class Main {
    static BroQue broQue = new BroQue();
    public static void quePrint(){
        for(int i=0;i<broQue.que.size();++i){
            broQue.que.get(i).print();
        }
        System.out.print("\n");
    }
    public static void main(String []args){
        System.out.print("编排排序：\n");
        System.out.print("排序前：");
        quePrint();
        GrandFather gd = (GrandFather) broQue.que.get(0);
        gd.sort(broQue.que);
        System.out.print("排序后：");
        quePrint();
        broQue.myShuffle();
        System.out.print("协同排序：\n");
        System.out.print("排序前：");
        quePrint();
        broQue.quickSort(1,broQue.que.size());
        System.out.print("排序后：");
        quePrint();
    }
}
