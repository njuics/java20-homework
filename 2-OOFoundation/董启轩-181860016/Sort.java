import java.util.Random;


public class Sort {
    CalabashBrother bro[];
    GrandFather grandpa;
    final int NUM_OF_BROTHERS=7;
    private static Random rand=new Random();
    public static void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public static void shuffle(int[] arr){
        int length=arr.length;
        for(int i=length;i>0;i--){
            int randInt=rand.nextInt(i);
            swap(arr,randInt,i-1);
        }
    }
    Sort(){
        bro=new CalabashBrother[NUM_OF_BROTHERS];
        grandpa=new GrandFather();
        int pri[]=new int[NUM_OF_BROTHERS];
        int pos[]=new int[NUM_OF_BROTHERS];
        String[] Names={"大娃","二娃","三娃","四娃","五娃","六娃","七娃"};
        for(int i=0;i<NUM_OF_BROTHERS;i++)
        {
            pri[i]=i;
            pos[i]=i+1;
        }
        shuffle(pri);
        shuffle(pos);
        for(int i=0;i<NUM_OF_BROTHERS;i++)
        {
            bro[i]=new CalabashBrother(Names[i], pri[i], pos[i]);
        }
    }
    public void do_Shuffle(){
        int pri[]=new int[NUM_OF_BROTHERS];
        int pos[]=new int[NUM_OF_BROTHERS];
        for(int i=0;i<NUM_OF_BROTHERS;i++)
        {
            pri[i]=i;
            pos[i]=i+1;
        }
        shuffle(pri);
        shuffle(pos);
        for(int i=0;i<NUM_OF_BROTHERS;i++)
        {
            bro[i].position=pos[i];
            bro[i].priority=pri[i];
        }
    }
    public void printInformation(){
        for(int i=0;i<bro.length;i++)
        {
            System.out.println(bro[i].name+":  priority:"+bro[i].priority+"  position:"+bro[i].position);
        }
    }
    public static void main(String[] args){
        Sort s=new Sort();
        s.printInformation();
        System.out.println("orchestration Sort result:");
        s.grandpa.simplesort(s.bro);
        s.printInformation();
        System.out.println("do shuffle, then:");
        s.do_Shuffle();
        s.printInformation();
        System.out.println("choreography Sort result:");
        for(int i=0;i<s.bro.length;i++){
            s.bro[i].find_position(s.bro);
        }
        s.printInformation();
    }
}