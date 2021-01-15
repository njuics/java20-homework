import java.util.Random;

enum GENDER{
    MALE,FEMALE
}

public class Creature implements Comparable<Creature>{
    private static final int MIN_ASCII=65;
    private static final int MAX_ASCII=90;
    private static final int ALPHABET_LEN=MAX_ASCII-MIN_ASCII+1;
    private static final int LEN=20;

    private final String name;
    private final GENDER gender;

    Creature()
    {
        Random random=new Random();

        StringBuilder strBuilder=new StringBuilder();
        for(int i=0;i<LEN;i++){
            int tmpIndex=random.nextInt(ALPHABET_LEN);
            strBuilder.append((char)(tmpIndex+MIN_ASCII));
        }
        name=strBuilder.toString();
        gender=GENDER.values()[random.nextInt(2)];

        //System.out.println(name);
        //System.out.println(gender);
    }

    Creature(String name){
        this.name=name;
        Random random=new Random();
        gender=GENDER.values()[random.nextInt(2)];
    }

    @Override
    public int compareTo(Creature o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "<Name>" + name + "|<Gender>" + gender.toString();
    }

}
