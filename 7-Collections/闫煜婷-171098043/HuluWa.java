import java.util.ArrayList;
import java.util.Random;

enum Gender {
    MALE, FEMALE;
    public static Gender get(){
        Random r = new Random();
        return values()[r.nextInt(2)];
    }
};

public class HuluWa implements Comparable<HuluWa>{
    private int seniority;
    private String name;
    private int pos;
    private Gender gender;
    HuluWa(int seniority, String name, int pos, Gender gender){
        this.seniority = seniority;
        this.name = name;
        this.pos = pos;
        this.gender = gender;
    }

    public static String genRandomName(){
        Random r = new Random();
        int namelen = r.nextInt(4) + 1;
        String name = "";
        for(int i = 0; i < namelen; ++i){
            name += (char)(r.nextInt(26) + 'a');
        }
        return name;
    }

    public int getSeniority() {
        return seniority;
    }

    public int getPos() {
        return pos;
    }

    public String getName() {return name;}

    public Gender getGender() {
        return gender;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    private void exchangePos(HuluWa huluWa, ArrayList<HuluWa> huluArray){
        int tmp = this.pos;
        this.pos = huluWa.getPos();
        huluWa.setPos(tmp);
        huluArray.set(this.pos, this);
        huluArray.set(huluWa.getPos(), huluWa);
    }

    public void goToCorrectPos(ArrayList<HuluWa> huluArray){
        while(this.pos > 0){
            if(this.compareTo(huluArray.get(this.pos-1)) < 0){
                this.exchangePos(huluArray.get(this.pos-1), huluArray);
            }
            else break;
        }
    }

    public void tellName(){
        System.out.print(this.name + " ");
    }

    @Override
    public int compareTo(HuluWa h2){
        return name.compareTo(h2.name);
    }
}
