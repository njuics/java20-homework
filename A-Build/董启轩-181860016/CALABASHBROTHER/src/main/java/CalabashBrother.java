public class CalabashBrother extends Creature{
    CalabashBrother(){
        super();
    }
    CalabashBrother(String Name,Gender sex){
        super(Name, sex);
    }
    @Override
    public void printInformation(){
        System.out.print("CalabashBrother ");
        super.printInformation();
    }
}