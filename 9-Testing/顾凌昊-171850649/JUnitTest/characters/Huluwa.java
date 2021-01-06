package JUnitTest.characters;

public class Huluwa extends Human {

    //public int num;

    public Huluwa(){
        super();
    }

    public Huluwa(String name, boolean gender){
        super(name,gender);
    }

    public void swapWith(Huluwa o){

        boolean temp = gender;
        gender = o.gender;
        o.gender = temp;

        String nm = name;
        name = o.name;
        o.name = nm;

    }
}
