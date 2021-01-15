import java.util.Random;
enum Gender{
    MALE,FEMALE,UNKNOWN
}

public class Creature implements Comparable<Creature>{
    private static final String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int NAME_LENGTH=7;
    private String name;
    private Gender gender;
    Creature(){
        Random random=new Random();
        StringBuffer stringBuffer=new StringBuffer();
        for(int i=0;i<NAME_LENGTH;i++){
            int num=random.nextInt(str.length());
            stringBuffer.append(str.charAt(num));
        }
        name=stringBuffer.toString();
        Random r=new Random();
        int i=r.nextInt(2);
        switch(i){
            case 0:
            gender=Gender.MALE;
            break;
            case 1:
            gender=Gender.FEMALE;
            break;
            default:
            gender=Gender.UNKNOWN;
        }
    }
    Creature(String Name,Gender sex){
        name=Name;
        gender=sex;
    }
    public String getName(){
        return name;
    }
    public Gender getGender(){
        return gender;
    }
    public boolean is_male(){
        return gender.equals(Gender.MALE);
    }
    public boolean is_female(){
        return gender.equals(Gender.FEMALE);
    }
    public void printInformation(){
        System.out.println("Name:"+name+"  "+"Gender:"+gender);
    }
    @Override
    public int compareTo(Creature bro){
        String broname=bro.getName();
        return name.compareTo(broname);
    }
}