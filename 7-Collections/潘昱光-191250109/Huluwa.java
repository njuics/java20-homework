import java.util.Random;

public class Huluwa implements Comparable{
    private String name;
    private boolean sex;
    Huluwa(){
        Random r=new Random();
        name=randomName();
        sex=r.nextInt(2)==1;
    }
    Huluwa(String name,boolean sex){
        this.name=name;
        this.sex=sex;
    }
    private String randomName(){
        StringBuffer buffer=new StringBuffer();
        Random rand=new Random();
        int i=rand.nextInt(30);
        while(i==0){
            i=rand.nextInt(30);
        }
        for(int j=0;j<i;++j){
            int temp=rand.nextInt(26);
            buffer.append((char)('a'+temp));
        }
        String str=new String(buffer);
        return str;
    }

    public boolean getSex(){
        return sex;
    }
    public String getName(){
        return name;
    }
    
    @Override
    public int compareTo(Object o) throws NullPointerException{
        // TODO Auto-generated method stub
        if(o==null){
            throw new NullPointerException();
        }
        return this.name.compareTo(((Huluwa)o).name);
    }

    @Override
    public boolean equals(Object o){
        if(o==null){
            return false;
        }
        if(!o.getClass().getName().equals(this.getClass().getName())){
            return false;
        }
        Huluwa h=(Huluwa)o;
        return this.sex==h.sex&&this.name.equals(h.name);
    }
}