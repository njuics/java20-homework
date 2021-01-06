import java.util.Random;
class Huluwa implements Comparable<Huluwa>{
    private String name;
    private String gender;

    Huluwa(){
        name = nominate();
        gender = gender();
    }
    @Override
    public int compareTo(Huluwa o) {
        return  this.name.compareTo(o.name);
    }

    public String getName(){
        return name;
    }
    public String getGender(){
        return gender;
    }
    //public static Comparator compare(Huluwa a,Huluwa b){
        //return a.name.compareTo(b.name);
    //}
    @Override
    public String toString(){
        return name + " " + gender + " ";
    }
    //随机取名
    private String nominate(){
        String name = "";
        Random r = new Random();
        Random r1 = new Random();
        int length = r.nextInt(20) + 2;
        String words = "abcdefghijklmnopqrstuvwxyz";
        
        for(int i = 0;i < length; i++){
            name += words.charAt(r1.nextInt(25));
        }
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        return name;
    }
    //性别随机生成
    private String gender(){
        String gender = "";
        Random r = new Random();
        int bool = r.nextInt(2);
        if(bool == 1){
            gender = "male";
        }
        else gender = "female";
        return gender;
    }
}