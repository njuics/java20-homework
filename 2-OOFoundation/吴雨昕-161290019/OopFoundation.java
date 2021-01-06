class OopFoundation{
    public static void main(String[] args) {
        System.out.println("初始队列顺序：");
        BoyQueue queue = new BoyQueue();
        queue.shuffle();
        queue.show();
        LineUp oneSort = new LineUp();
        System.out.println("choreography模式排序后：");
        oneSort.choreography(queue);
        queue.show();

        System.out.println("重新打乱顺序：");
        queue.shuffle();
        queue.show();
        Grandpa grandpa = new Grandpa();
        System.out.println("orchestration模式排序后：");
        oneSort.orchestration(grandpa,queue);
        queue.show();
    }
}