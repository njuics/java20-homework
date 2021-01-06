
package object;



public class Calabash extends Object{

 
    static int objCount;
    static{
       objCount = 0;
    }

    public Calabash() {    //default constructor
        Calabash.objCount++;
        name = "";
        age = 0;
    }

    public Calabash(String inName, int inAge) {    //overloading
        Calabash.objCount++;
        this.name = inName;
        this.age = inAge;
    }

 

    public boolean compare(Calabash b) {
        return this.age < b.getAge();

    }

    public void swap(Calabash b) {
        String tempName = name;
        int tempAge = age;
        this.name = b.getName();
        this.age = b.getAge();
        b.name = tempName;
        b.age = tempAge;
    }

};
