import java.util.Random;

enum Gender{
    MALE, FEMALE
}

public class CalabashBoy implements Comparable<CalabashBoy> {
    private String name;
    private Gender gender;
    CalabashBoy(){
        Random r = new Random();
        final String alphabet = "abcdefghijklmnopqrstuvwxyz";
        final int length = 3;
        this.name = new String();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++){
            int index = r.nextInt(26);
            sb.append(alphabet.charAt(index));
        }
        this.name = sb.toString();
        
        int gen = r.nextInt(2);
        if(gen==0)this.gender=Gender.MALE;
        else this.gender=Gender.FEMALE;
    }
    public boolean ismale(){
        return this.gender==Gender.MALE;
    }

    @Override
    public String toString(){
        return this.name+" "+this.gender;
    }

    @Override
    public int compareTo(CalabashBoy c){
        return this.name.compareTo(c.name);
    }
}
