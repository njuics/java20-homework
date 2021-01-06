import java.util.*;

public class Hulu implements Comparable<Hulu>{
    private String name;
    private Boolean gender;  // 1 for male, 0 for female
    private final int nameLength = 8;

    public Hulu(){
        Random random = new Random();
        char[] tmpname = new char[nameLength];
        tmpname[0] = (char)(random.nextInt(26)+65);
        for(int i=1;i<nameLength;i++) {
          tmpname[i] = (char)(random.nextInt(26)+97);
        }
        this.name = new String(tmpname);

        this.gender = random.nextInt(2)==1;
    }

    public String getName(){
        return this.name;
    }
    public Boolean getGender(){
        return this.gender;
    }

    public int compareTo(Hulu h) {
        if (h.getName().compareTo(this.name)<0)
          return 1;
        else if (h.getName().compareTo(this.name)==0)
          return 0;
        else
          return -1;
    }

}
