import cn.edu.nju.hulusort.*;
public class Main {
    public static void main(String[] args) {
        HuluwaList huluwaList=new HuluwaList();
        SortHuluwaList sortByAlgo=new SortByAlgo(); //算法排序；
        SortHuluwaList grandpa=new Grandpa(); // Orchestration排序
        SortHuluwaList sortChoreography=new SortChoreography(); // Choreography排序

        System.out.println("\n阶段1：");
        huluwaList.shuffle();
        huluwaList.printList();
        sortByAlgo.sort(huluwaList);
        huluwaList.printList();

        System.out.println("\n阶段2：");
        huluwaList.shuffle();
        huluwaList.printList();
        grandpa.sort(huluwaList);
        huluwaList.printList();

        System.out.println("\n阶段3：");
        huluwaList.shuffle();
        huluwaList.printList();
        sortChoreography.sort(huluwaList);
        huluwaList.printList();
    }
}