package JUnitTest.characters;

import JUnitTest.utils.Utils;

public class Human {

    public static int count = 0;

    public String name = "";

    public boolean gender = true;

    public void call(){
        System.out.print(name+","+ (gender?"男" : "女")+"\t");
    }

    public Human(){
        this(Utils.getEnglishName(), Utils.getGender());
    }

    public Human(String nm, boolean g){
        count++;
        name = nm;
        gender = g;
    }
}
