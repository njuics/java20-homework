
public class Main {
    public static void main(String[] args) {
        final int number = 15;
        QLine<CalabashBoy> bros=new QLine<CalabashBoy>(),
        male = new QLine<>(),
        female = new QLine<>();
        
        for(int i=0;i < number;i++){
            CalabashBoy a = new CalabashBoy();
            bros.add(a);
        }
        print("#####sort#####");
        bros.Sort();
        bros.Print();
        print("#####reverse sort#####");
        bros.Reverse();
        bros.Print();
        print("#####shuffle#####");
        bros.Shuffle();
        bros.Print();
        for(CalabashBoy a:bros.brothers){
            if(a.ismale()==true)male.add(a);
            else female.add(a);
        }
        male.Sort();
        female.Sort();
        print("#####male#####");
        male.Print();
        print("#####female#####");
        female.Print();
    }
    public static void print(Object o){
        System.out.println(o);
    }
}
