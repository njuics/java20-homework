import java.util.Random;

public class CalabashBoysSort {
    public static void main(String[] args) {
        Orchestration orchestration = new Orchestration();
        orchestration.run();

        Choreography choreography = new Choreography();
        choreography.run();
    }
}

class CalabashBoy{
    private String name;
    private int ID;

    CalabashBoy(String name,int ID){
        this.name = name;
        this.ID = ID;
    }

    public int getID(){
        return this.ID;
    }

    public String getName(){
        return this.name;
    }

    public void report(){
        System.out.println("我是"+name);
    }

    public boolean cmp(CalabashBoy bro){
        return this.ID>bro.ID;
    }

    public void swap(CalabashBoy bro){
        String tStr = bro.name;
        bro.name = this.name;
        this.name = tStr;
        int tInt = bro.ID;
        bro.ID = this.ID;
        this.ID = tInt;
    }
}

class Grandpa{
    public boolean cmp(CalabashBoy a,CalabashBoy b){
        return a.getID()>b.getID();
    }

    public void swap(CalabashBoy[] calabashBoys,int i,int j){
        CalabashBoy t = calabashBoys[i];
        calabashBoys[i] = calabashBoys[j];
        calabashBoys[j] = t;
    }

    public void sort(CalabashBoy[] calabashBoys){
        for(int i=calabashBoys.length-1;i>=0;i--){
            for(int j=0;j<i;j++){
                if(cmp(calabashBoys[j], calabashBoys[j+1])){
                    swap(calabashBoys,j,j+1);
                    System.out.println(calabashBoys[j].getName()
                                    + "和"
                                    + calabashBoys[j+1].getName()
                                    + "换了位置"
                    );
                }
            }
        }
    }

}

class Orchestration{
    public void run(){
        CalabashBoy[] calabashBoys = new CalabashBoy[]{
            new CalabashBoy("大娃", 1),
            new CalabashBoy("二娃", 2),
            new CalabashBoy("三娃", 3),
            new CalabashBoy("四娃", 4),
            new CalabashBoy("五娃", 5),
            new CalabashBoy("六娃", 6),
            new CalabashBoy("七娃", 7)
        };

        System.out.println("orchestration:");
        System.out.println();

        Grandpa grandpa = new Grandpa();
        shuffle(calabashBoys);
        System.out.println("排序前：");
        for(CalabashBoy c:calabashBoys)
            c.report();

        System.out.println();
        grandpa.sort(calabashBoys);
        System.out.println();
        System.out.println("排序后：");
        for(CalabashBoy c:calabashBoys)
            c.report();
    }

    public void shuffle(CalabashBoy[] calabashBoys){
        Random random = new Random();
        for(int i=0;i<calabashBoys.length;i++){
            int r = random.nextInt(7);
            if(r!=i)
                calabashBoys[i].swap(calabashBoys[r]);
        }
    }
}

class Choreography{
    public void run(){
        CalabashBoy[] calabashBoys = new CalabashBoy[]{
            new CalabashBoy("大娃", 1),
            new CalabashBoy("二娃", 2),
            new CalabashBoy("三娃", 3),
            new CalabashBoy("四娃", 4),
            new CalabashBoy("五娃", 5),
            new CalabashBoy("六娃", 6),
            new CalabashBoy("七娃", 7)
        };

        System.out.println("choreography:");
        System.out.println();

        shuffle(calabashBoys);
        System.out.println("排序前：");
        for(CalabashBoy c:calabashBoys)
            c.report();

        System.out.println();
        sort(calabashBoys);
        System.out.println();
        System.out.println("排序后：");
        for(CalabashBoy c:calabashBoys)
            c.report();
    }

    public void shuffle(CalabashBoy[] calabashBoys){
        Random random = new Random();
        for(int i=0;i<calabashBoys.length;i++){
            int r = random.nextInt(7);
            if(r!=i)
                calabashBoys[i].swap(calabashBoys[r]);
        }
    }

    public void sort(CalabashBoy[] calabashBoys){
        for(int i=calabashBoys.length-1;i>=0;i--){
            for(int j=0;j<i;j++){
                if(calabashBoys[j].cmp(calabashBoys[j+1])){
                    calabashBoys[j].swap(calabashBoys[j+1]);
                    System.out.println(calabashBoys[j].getName()
                                    + "和"
                                    + calabashBoys[j+1].getName()
                                    + "换了位置"
                    );
                }
            }
        }
    }
}