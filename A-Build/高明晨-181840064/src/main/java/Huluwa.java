import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
public class Huluwa extends Character{
    private String name;
    private String gender;
    Huluwa(){
        name=genRandomName();
        gender=genRandomgender();
    }
    Huluwa(String name,String gender){
        this.name=name;
        this.gender=gender;
    }
    private String genRandomName(){
        return RandomStringUtils.randomAlphabetic(5);
    }
    
    private String genRandomgender(){
        Random gen=new Random();
        int rand=gen.nextInt(2);
        if(rand==0){
            gender="Female";
        }
        else{
            gender="Male";
        }
        return gender;
    }
    
    public String getName(){
        return name;
    }

    public String getGender(){
        return gender;
    }

    public String getInfo(){
        return name+"  "+gender;
    }
    public int compareTo(Character o){
        return name.compareTo(o.getName());
    }

    public String toString(){
        return getInfo();
    }


}