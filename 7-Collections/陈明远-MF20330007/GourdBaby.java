import java.util.*;

public class GourdBaby {
    private String name;
    private boolean gender;
    public GourdBaby() {
        this.name = randomGetName();
        this.gender = randomGetGender();
    }
    public String randomGetName() {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<5;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
    public boolean randomGetGender() {
        Random random = new Random();
        return random.nextBoolean();
    }
    public String getName() {
        return this.name;
    }
    public boolean getGender() {
        return this.gender;
    }
    public void report() {
        System.out.println(this.name + " " + this.gender);
    }

    public static void main(String[] args) {
        GourdBaby gourdBaby = new GourdBaby();
        gourdBaby.report();
    }
}
