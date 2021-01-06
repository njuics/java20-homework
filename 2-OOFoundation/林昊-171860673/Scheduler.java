public class Scheduler {
    public static void main(String[] args){
        // sort in algorithm
        System.out.println("排序算法结果：");
        ManageHuLuWa manageHuLuWa = new ManageHuLuWa();
        manageHuLuWa.algorithmSort();
        manageHuLuWa.print();

        System.out.println("Orchestration结果：");
        ManageHuLuWa manageHuLuWa2 = new ManageHuLuWa();
        Grandpa grandpa = new Grandpa(manageHuLuWa2);
        grandpa.grandpaSort();
        manageHuLuWa2.print();

        System.out.println("Choreography结果：");
        ManageHuLuWa manageHuLuWa3 = new ManageHuLuWa();
        manageHuLuWa3.cooperationSort();
        manageHuLuWa3.print();
    }
}
