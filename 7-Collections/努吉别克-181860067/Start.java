public class Start {
    public static void main(String[] args)
    {
        Family new_family=new Family();
        for(int i=0;i<10;i++)
            new_family.add_member();

        Family.display_well(new_family.iterator());

        Family.display_comparator(new_family.iterator());

        Family.display_reverse(new_family);

        Family.display_shuffle(new_family);

        new_family.team(new_family.iterator());

    }
}
