import java.util.Random;
import java.util.Comparator;
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
        String Alphabet="abcdefghijklmnopqrstuvwxyz";
        Random gen=new Random();
        String str=new String();
        for(int i=0;i<5;i++){
            str=str+Alphabet.charAt(gen.nextInt(26));
        }
        return str;
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