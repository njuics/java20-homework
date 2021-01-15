package OopFoundation;
import java.util.Random;

enum MyColor{
    RED,
    ORANGE,
    YELLOW,
    GREEN,
    CYAN,
    BLUE,
    PURPLE;
}

class LocationController{
    //"Loc" means "Location"
    private static boolean[] locations=new boolean[MyColor.values().length];
    private static int currentLocNum;
    private int location;
    LocationController(){
        location=-1;
        //the num of objects must not be more than totoalLocNum
        if(currentLocNum==MyColor.values().length)return;
        else currentLocNum+=1;
        Random LocationGenerator=new Random();
        while (location==-1){
            int rand=LocationGenerator.nextInt(MyColor.values().length);
            if(!locations[rand]){
                location=rand;
                locations[rand]=true;
            }
        }
        //System.out.println("test location:"+location);
    }
    public static void refresh(){
        currentLocNum=0;
        for(int i=0;i<locations.length;i++)locations[i]=false;
    }
    public boolean setLocation(int newLoc){
        if(location<0||newLoc<0 || newLoc>=MyColor.values().length)return false;
        else location=newLoc;
        return true;
    }
    public int getLocation(){
        return location;
    }
}

class CalabashBrother {
   LocationController loc;
   MyColor color;
   CalabashBrother(MyColor c){
       loc=new LocationController();
       color=c;
   }
   public int getLocation(){
       return loc.getLocation();
   }
   public boolean setLocation(int newLoc){
       return loc.setLocation(newLoc);
   }
   public int getColorByRank(){
       return color.ordinal();
   }

   public boolean compareRank(CalabashBrother cb){
        if(this.color.ordinal()>cb.color.ordinal()) return true;
        else return false;
   }

    public boolean compareLoc(CalabashBrother cb){
        if(this.loc.getLocation()>cb.loc.getLocation()) return true;
        else return false;
    }

   public boolean exchangeLocation(CalabashBrother cb){
        int tempLoc=cb.getLocation();
        cb.setLocation(this.getLocation());
        this.setLocation(tempLoc);
        return true;
   }
   public void printInfo(){
       System.out.println("I am "+color.toString()+","
               +"My Location is:"+loc.getLocation());
   }
}

abstract class AbstractBrothers{
    protected CalabashBrother[] CalabashBroList;
    AbstractBrothers(){
        CalabashBroList=new CalabashBrother[MyColor.values().length];
        int i=0;
        for(MyColor c:MyColor.values()){
            CalabashBrother calBro=new CalabashBrother(c);
            CalabashBroList[i]=calBro;
            i++;
        }
    }
    public void printLocs(){
        for(CalabashBrother calbro:CalabashBroList)
            calbro.printInfo();
    }
    abstract public void sort();
}

class BrothersByOrcSort extends AbstractBrothers{
    public void sort(){
        for(int i=0;i<CalabashBroList.length;i++){
            for(int j=0;j< CalabashBroList.length;j++){
                if(CalabashBroList[i].getColorByRank()>CalabashBroList[j].getColorByRank() &&
                CalabashBroList[i].getLocation()<CalabashBroList[j].getLocation()){
                    int loci=CalabashBroList[i].getLocation();
                    int locj=CalabashBroList[j].getLocation();
                    CalabashBroList[i].setLocation(locj);
                    CalabashBroList[j].setLocation(loci);
                }
            }
        }
    }
}

class BrothersByChoSort extends AbstractBrothers{
    public void sort(){
        for(CalabashBrother calbroi:CalabashBroList){
            for(CalabashBrother calbroj:CalabashBroList){
                //比他序号大但是比他位置小，那么就和他进行替换
                if(calbroi.compareRank(calbroj) && !calbroi.compareLoc(calbroj))
                    calbroi.exchangeLocation(calbroj);
            }
        }
    }
}




class OopFoundation{
    static public void main(String[] args){
        System.out.println("Orchestration:\n");
        BrothersByOrcSort o=new BrothersByOrcSort();
        System.out.println("Before sort:");
        o.printLocs();
        o.sort();
        System.out.println("After sort:");
        o.printLocs();

        LocationController.refresh();
        System.out.println("\nChoreography:\n ");
        BrothersByChoSort c=new BrothersByChoSort();
        System.out.println("Before sort:");
        c.printLocs();
        c.sort();
        System.out.println("After sort:");
        c.printLocs();
    }
}
