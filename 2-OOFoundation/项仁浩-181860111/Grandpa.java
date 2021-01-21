public class Grandpa {
    private Grandpa(){
        
    }
    public static boolean observe(Calabash a,Calabash b){
        if(a.identifier>b.identifier)
            return true;
        return false;
    }

    public static void exchange(Calabash a, Calabash b){
        int temp=a.pos;
        a.pos=b.pos;
        b.pos=temp;
    }
}
