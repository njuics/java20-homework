public class Start {
    public static void main(String[] args)
    {
        Family new_family=new Family<Calabash>();
        for(int i=0;i<10;i++)
            new_family.add_member(Calabash.class);

        System.out.println("\n\nCOMMAND1:");
        new_family.display_well(new_family.iterator());


        System.out.println("\n\nCOMMAND2:");
        new_family.display_comparator(new_family.iterator());
        System.out.println("\n\nCOMMAND3:");
        new_family.display_reverse(new_family);
        System.out.println("\n\nCOMMAND4:");
        new_family.display_shuffle(new_family);
        System.out.println("\n\nCOMMAND5:");
        new_family.team(new_family.iterator());

        System.out.println("Golbin:\n");
        Family new_family1=new Family<Golbin>();
        for(int i=0;i<10;i++)
            new_family1.add_member(Golbin.class);

        System.out.println("\n\nCOMMAND6:");
        new_family1.display_well(new_family1.iterator());


        System.out.println("\n\nCOMMAND7:");
        new_family1.display_comparator(new_family1.iterator());
        System.out.println("\n\nCOMMAND8:");
        new_family1.display_reverse(new_family1);
        System.out.println("\n\nCOMMAND9:");
        new_family1.display_shuffle(new_family1);
        System.out.println("\n\nCOMMAND10:");
        new_family1.team(new_family1.iterator());

        //Map map=new Map();
        //map.init();
    }
}
