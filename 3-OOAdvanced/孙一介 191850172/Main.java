public class Main {
    public static void main(String[] args) {
        GrandFather grandFather = new GrandFather();
        GourdBaby[] gourdBabies = new GourdBaby[7];
        for(int i=0;i<7;i++){
            gourdBabies[i] = new GourdBaby();
        }
        set_unorder_arry(gourdBabies);
        Orchestration orc = new Orchestration();
        orc.sort(grandFather,gourdBabies);
        all_count_off(gourdBabies);
        set_unorder_arry(gourdBabies);
        Choreography cho = new Choreography();
        cho.sort(grandFather,gourdBabies);
        all_count_off(gourdBabies);
    }
    public static void all_count_off(GourdBaby[] gourdBabies){
        for(int i=0;i<7;i++){
            gourdBabies[i].countoff();
        }
    }
    public static void set_unorder_arry(GourdBaby[] gourdBabies){
        ;
    }
}

