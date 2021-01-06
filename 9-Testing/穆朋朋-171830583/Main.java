import src.hulusort.*;
public class Main {
    public static void main(String[] args) {
        HuluwaList<Huluwa> huluwaList=new HuluwaList<>();
        
        // 创造7个葫芦娃出来；
        for (int i = 0; i < 7; i++) {
            switch(i) {
                case 0: huluwaList.add(new Huluwa(i,"老大"));break;
                case 1: huluwaList.add(new Huluwa(i,"老二"));break;
                case 2: huluwaList.add(new Huluwa(i,"老三"));break;
                case 3: huluwaList.add(new Huluwa(i,"老四"));break;
                case 4: huluwaList.add(new Huluwa(i,"老五"));break;
                case 5: huluwaList.add(new Huluwa(i,"老六"));break;
                case 6: huluwaList.add(new Huluwa(i,"老七"));break;
                default: huluwaList.add(new Huluwa(i,"老大"));break;
            }
        }
        System.out.println("葫芦娃队列初始化完毕!\n共创建的葫芦娃数量为"+huluwaList.size());
        huluwaList.printList();
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