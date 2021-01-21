import org.junit.Test;

import factory.CalabashFactory;

import static org.junit.Assert.*;
import model.*;
public class CalabashTest{
    @Test
    public void testCalabashProperty() throws Exception {
        boolean male = true;
        String name = "LGT";
        Calabash calabash = new Calabash(name,male);
        // test property 
        assertEquals(name,calabash.getName());
        assertEquals(male, calabash.getGender());
    }

    @Test
    public void testFactoryCreate() throws Exception {
        String[] params = {"Calabash","LGT","male"};
        CalabashFactory factory = new CalabashFactory();
        Calabash calabash_expected = null;
        Calabash calabash_actual = null;
        for(String calabashType : factory.getCalabashTypes()){
            params[0] = calabashType;
            params[2] = "male";
            calabash_actual = factory.create(params);
            if(calabashType.equalsIgnoreCase("StrongCalabash")){
                calabash_expected = new StrongCalabash(params[1], true);
            }
            else if(calabashType.equalsIgnoreCase("FireCalabash")){
                calabash_expected = new FireCalabash(params[1], true);
            }
            else if(calabashType.equalsIgnoreCase("WaterCalabash")){
                calabash_expected = new WaterCalabash(params[1], true);
            }
            else{
                calabash_expected = new Calabash(params[1], true);
            }
            assertEquals(calabash_expected.getClass(), calabash_actual.getClass());
            assertEquals(calabash_expected.getGender(), calabash_actual.getGender());
            assertEquals(calabash_expected.getName(), calabash_actual.getName());
            params[2] = "female";
            calabash_actual = factory.create(params);
            if(calabashType.equalsIgnoreCase("StrongCalabash")){
                calabash_expected = new StrongCalabash(params[1], false);
            }
            else if(calabashType.equalsIgnoreCase("FireCalabash")){
                calabash_expected = new FireCalabash(params[1], false);
            }
            else if(calabashType.equalsIgnoreCase("WaterCalabash")){
                calabash_expected = new WaterCalabash(params[1], false);
            }
            else{
                calabash_expected = new Calabash(params[1], false);
            }
            assertEquals(calabash_expected.getClass(), calabash_actual.getClass());
            assertEquals(calabash_expected.getGender(), calabash_actual.getGender());
            assertEquals(calabash_expected.getName(), calabash_actual.getName());
        }
    }

    @Test
    public void testEqualsMethod(){
        Calabash sc0 = new StrongCalabash("1",true);
        Calabash sc1 = new StrongCalabash("1", true);
        Calabash fc = new FireCalabash("1", true);
        Calabash sc2 = new StrongCalabash("2", true);
        Calabash sc3 = new StrongCalabash("1", false);

        assertEquals("sc0 should be eqaul to sc1",sc0, sc1);
        assertNotEquals("class not equal",sc0, fc);
        assertNotEquals("name not equal",sc0, sc2);
        assertNotEquals("gender not equal",sc0, sc3);

    }
}