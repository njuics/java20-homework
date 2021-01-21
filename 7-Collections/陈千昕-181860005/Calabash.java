public class Calabash implements Comparable <Calabash>{
    private String name;
    private boolean gender;

    public Calabash(String name, boolean gender){
        reset(name, gender);
    }
    Calabash(Calabash c){
        reset(c);
    }

    public String getName(){
        return name;
    }

    public boolean getGender(){
        return gender;
    }


    public void reset(String name, boolean gender){
        this.name = name;
        this.gender = gender;
    }

    public void reset(Calabash c){
        reset(c.name, c.gender);
    }

    public void report(){
        String genderName = "G";
        if(gender){
            genderName = "B";
        }
        System.out.print(name + "(" + genderName + ")");
    }

    @Override
	public int compareTo(Calabash c) {
		return name.compareTo(c.name);
	}
}
