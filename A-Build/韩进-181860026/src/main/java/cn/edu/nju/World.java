package cn.edu.nju;
import java.util.*;
import org.apache.commons.text.RandomStringGenerator;

public class World
{
    CreatureFamily<GourdBrother> gourdFamily = new CreatureFamily<>();

    World()
    {
        random_generate();
    }

    void random_generate()
    {
        RandomStringGenerator ranGen = new RandomStringGenerator.Builder().withinRange('a','z').build();            
        Random r = new Random();
        final int gourdNum = 6;
        for (int i = 0; i < gourdNum; i++)
        {
            boolean gender = r.nextBoolean();                        
            String randomStr=ranGen.generate(5); 
            GourdBrother gb = new GourdBrother(randomStr, gender);
            gourdFamily.add(gb);
        }
    }

    public void start()
    {
        System.out.println("positive sort...");
        for (GourdBrother gourdBrother : gourdFamily)
        {
            System.out.println(gourdBrother);
        }
        System.out.println("negative sort...");
        for (GourdBrother gourdBrother : gourdFamily.reverseIterator())
        {
            System.out.println(gourdBrother);
        }
        System.out.println("random sort...");
        for (GourdBrother gourdBrother : gourdFamily.mixIterator())
        {
            System.out.println(gourdBrother);
        }
        System.out.println("sort by gender...");
        System.out.println("male...");
        for (GourdBrother gourdBrother : gourdFamily.maleIterator())
        {
            System.out.println(gourdBrother);
        }
        System.out.println("female...");
        for (GourdBrother gourdBrother : gourdFamily.femaleIterator())
        {
            System.out.println(gourdBrother);
        }
    }

}
