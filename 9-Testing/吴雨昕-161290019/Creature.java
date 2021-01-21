import java.util.*;
public class Creature implements Comparable<Creature>{
    protected boolean gender;
    protected String name;
    public Creature(){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random rand=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<10;i++){
            int number=rand.nextInt(62);
            sb.append(str.charAt(number));
        }
        name = sb.toString();
        gender = rand.nextBoolean();
    }

    @Override
    public int compareTo(Creature boy) throws NullPointerException{
        if(boy==null){
            throw new NullPointerException();
        }
        return this.name.compareTo(boy.name);
    }

    @Override
    public boolean equals(Object boy){
        if(boy==null){
            return false;
        }
        if(!boy.getClass().getName().equals(this.getClass().getName())){    //compare class name
            return false;
        }
        Creature h=(Creature)boy;
        return this.gender==h.gender&&this.name.equals(h.name);
    }

    public String getName() {
        return name;
    }

    public Boolean getGender() {
        return gender;
    }

    @Override
    public String toString(){
        return "Name: "+name+" Gender: "+(gender?"Male":"Female");
    }
}