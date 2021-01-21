import java.util.*;
public class CalabashBoy implements Comparable {
    private boolean gender;
    private String name;
    public CalabashBoy(){
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

    public boolean getGender(){
        return gender;
    }

    @Override
    public String toString(){
        return "Name: "+name+" Gender: "+(gender?"Male":"Female");
    }

    @Override
    public int compareTo(Object boy) throws NullPointerException{
        if(boy==null){
            throw new NullPointerException();
        }
        return this.name.compareTo(((CalabashBoy)boy).name);
    }

    @Override
    public boolean equals(Object boy){
        if(boy==null){
            return false;
        }
        if(!boy.getClass().getName().equals(this.getClass().getName())){    //compare class name
            return false;
        }
        CalabashBoy h=(CalabashBoy)boy;
        return this.gender==h.gender&&this.name.equals(h.name);
    }
}