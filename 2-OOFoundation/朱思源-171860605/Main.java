public class Main {

    public static void initial(Boy[]b,Queue que){
        b[0]=new Boy("老大","红色",1);
        b[1]=new Boy("老二","橙色",2);
        b[2]=new Boy("老三","黄色",3);
        b[3]=new Boy("老四","绿色",4);
        b[4]=new Boy("老五","青色",5);
        b[5]=new Boy("老六","蓝色",6);
        b[6]=new Boy("老七","紫色",7);
        for(int i=0;i<7;i++)
            b[i].gotoQueue(que);

        System.out.println("before sort, the queue is:");
        que.show();
    }

    public static void orchestration() {
        System.out.println("| orchestration sort |");
        Boy[]b=new Boy[7];
        Queue que=new Queue(7);
        initial(b,que);
        Grandpa grandpa=new Grandpa();
        grandpa.sort(que);
        System.out.println("after sort, the queue is:");
        que.show();
        System.out.println("---------------------------------------------------");
    }

    public static void choreography() {
        System.out.println("| choreography sort process |");
        Boy[]b=new Boy[7];
        Queue que=new Queue(7);
        initial(b,que);
        for(int i=0;i<7;i++)
        {
            b[i].findPos();
        }
        System.out.println("after sort, the queue is:");
        que.show();
        System.out.println("---------------------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("The initial sequence is generated randomly.");
        System.out.println("---------------------------------------------------");
        orchestration();
        choreography();
    }
}
