import java.util.Random;
import java.util.Comparator;
// public static void randomShuffle(Huluwa array[]){
//     System.out.println("Random Shuffle:");
//     Random gen=new Random();
//     for(int i=6;i>=0;i--){
//         Huluwa temp=new Huluwa();
//         int index=gen.nextInt(7);
//         array[i].exchange(array[index]);
//     } 
//     numberoff(array);
// }
public class Huluwa implements Comparable<Huluwa>{
    private String name;
    private String gender;
    Huluwa(){
        name=genRandomName();
        gender=genRandomgender();
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
    public int compareTo(Huluwa o){
        return name.compareTo(o.getName());
    }


}