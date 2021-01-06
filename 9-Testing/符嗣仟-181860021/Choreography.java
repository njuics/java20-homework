public class Choreography extends World {
    
    public void divide_sort(){
        CreatureList<Calabash> boys = new CreatureList<>();
        CreatureList<Calabash> girls = new CreatureList<>();
        for(Calabash c:huluwas){
            if(c.getsex()==Sexual.MALE){
                boys.add(c);
            }
            else{
                girls.add(c);
            }
        }
        // sort boys
        System.out.println("----Boys Sort----");
        System.out.println("Before:");
        for(Calabash c:boys){
            System.out.print(c);
        }
        System.out.println(" ");
        boys.Negsort();
        System.out.println("After:");
        for(Calabash c:boys){
            System.out.print(c);
        }
        System.out.println(" ");
        //sort girls
        System.out.println("----Girls Sort----");
        System.out.println("Before:");
        for(Calabash c:girls){
            System.out.print(c);
        }
        System.out.println(" ");
        girls.Negsort();
        System.out.println("After:");
        for(Calabash c:girls){
            System.out.print(c);
        }
        System.out.println(" ");
    }
    void run(){
        System.out.println("choreography world:");

        System.out.println("----all sort positive----");
        System.out.println("Before:");
        for(Calabash c:huluwas){System.out.print(c);}
        System.out.println(" ");
        System.out.println("After:");
        huluwas.Possort();
        for(Calabash c:huluwas){System.out.print(c);}
        System.out.println(" ");

        System.out.println("----all sort negative----");
        System.out.println("After:");
        huluwas.Negsort();
        for(Calabash c:huluwas){System.out.print(c);}
        System.out.println(" ");

        System.out.println("----all sort random----");
        System.out.println("After:");
        huluwas.Randsort();
        for(Calabash c:huluwas){System.out.print(c);}
        System.out.println(" ");
        divide_sort();        
    }
}
