package creature.calabash;

import creature.Creature;

public class Calabash extends Creature {
    private boolean gender;

    /**
     * Initialize this Calabash
     * @param name A String For this new Calabash.
     * @param gender A boolean that represents the gender of this Calabash, in which true is for male, and false is for female.
    */
    public Calabash(String name, boolean gender){
        super(name);
        reset(name, gender);
    }
    
    /**
     * Initialize this Calabash with a Calabash that already exists.
     * <p>The name and gender will be copyed.
     * @param cBoys A Calabash that already exists
    */
    Calabash(Calabash cBoys){
        super(cBoys);
        reset(cBoys);
    }

    /**
     * Get the gender of this Calabash.
     * @return A boolean that represents the gender of this Calabash, in which true is for male, and false is for female.
    */
    public boolean getGender(){
        return gender;
    }

    /**
     * Reset this Calabash with newly given name and gender.
     * @param name A new String For this Calabash.
     * @param gender A new boolean that represents the gender of this Calabash, in which true is for male, and false is for female.
    */
    public void reset(String name, boolean gender){
        this.name = name;
        this.gender = gender;
    }

    /**
     * Reset this Calabash with a Calabash that already exists.
     * <p>The name and gender will be copyed.
     * @param c A Calabash that already exists
    */
    public void reset(Calabash cBoys){
        reset(cBoys.name, cBoys.gender);
    }

    /**
     * Report the name and gender of this Calabash. The info will be printed on your screen.
     * <p>For example, the Calabash(name: a, gender: true) will be displayed as "a(B)", if it is a female, the text will be "a(G)".
    */
    public void report(){
        report(true);
    }

    /**
     * Report the name or gender of this Calabash. The info will be printed on your screen.
     * <p>For example, when isReportGender is true, the Calabash(name: a, gender: true) will be displayed as "a(B)", if it is a female, the text will be "a(G)".
     * @param isReportGender A boolean that decides whether to display the gender. If it is false, only name will be displayed.
    */
    public void report(boolean isReportGender){
        if (isReportGender) {
            String genderName = "G";
            if(gender){
                genderName = "B";
            }
            System.out.print(name + "(" + genderName + ")");
        }
        else System.out.print(name);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(this == obj){
            return true;
        }
        if(obj instanceof Calabash){
            Calabash test = (Calabash)obj;
            if(test.gender == this.gender && test.name == this.name) return true;
            else return false;
        }
        return false;
    }
}
