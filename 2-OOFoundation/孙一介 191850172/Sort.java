public class Sort {
    public static void main(String[] args) {
        GourdBaby[] baby = new GourdBaby[7];
        GourdBaby one = new GourdBaby("老大",1);
        GourdBaby two = new GourdBaby("老二",2);
        GourdBaby three = new GourdBaby("老三",3);
        GourdBaby four = new GourdBaby("老四",4);
        GourdBaby five = new GourdBaby("老五",5);
        GourdBaby six = new GourdBaby("老六",6);
        GourdBaby seven = new GourdBaby("老七",7);
        baby[0] = one;
        baby[1] = two;
        baby[2] = three;
        baby[3] = four;
        baby[4] = five;
        baby[5] = six;
        baby[6] = seven;
        Choreography sort1 = new Choreography();
        sort1.choreography(baby);
       GourdGrandfather sort2 = new GourdGrandfather();
        sort2.orchestration(baby);
    }
}
