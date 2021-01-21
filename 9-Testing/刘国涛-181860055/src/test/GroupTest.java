import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;
import java.util.ArrayList;
import java.util.Collections;

import model.*;
import factory.CalabashFactory;
public class GroupTest {
    private CalabashGroup calabashGroup = new CalabashGroup();
    @Before
    public void initGroup(){
        CalabashFactory f = new CalabashFactory();
        String[] nameList = {"0","1","2","3","4","5","6","7","8","9"};
        String[] typeList = {"FireCalabash","StrongCalabash","FireCalabash","WaterCalabash","Calabash","StrongCalabash","FireCalabash","WaterCalabash","Calabash","Calabash"};
        String[] genderList = {"male","female","male","female","male","female","male","female","male","female"}; 
        String[] params = new String[3];
        for(int i=0;i<nameList.length;i++){
            params[0] = typeList[i];
            params[1] = nameList[i];
            params[2] = genderList[i];
            calabashGroup.insert(f.create(params));
        }
        
        calabashGroup.print();
    }
    @Test
    public void testGroupInsert(){
        String[] nameList = {"0","1","2","3","4","5","6","7","8","9"};
        String[] typeList = {"FireCalabash","StrongCalabash","FireCalabash","WaterCalabash","Calabash","StrongCalabash","FireCalabash","WaterCalabash","Calabash","Calabash"};
        Boolean[] genderList = {true,false,true,false,true,false,true,false,true,false}; 
        ArrayList<Calabash> expected_group = new ArrayList<>();
        for(int i=0;i<nameList.length;++i){
            Calabash calabash_expected = null;
            String calabashType = typeList[i];
            if(calabashType.equalsIgnoreCase("StrongCalabash")){
                calabash_expected = new StrongCalabash(nameList[i], genderList[i]);
            }
            else if(calabashType.equalsIgnoreCase("FireCalabash")){
                calabash_expected = new FireCalabash(nameList[i], genderList[i]);
            }
            else if(calabashType.equalsIgnoreCase("WaterCalabash")){
                calabash_expected = new WaterCalabash(nameList[i], genderList[i]);
            }
            else{
                calabash_expected = new Calabash(nameList[i], genderList[i]);
            }
            expected_group.add(calabash_expected);
        }
        
        ArrayList<Calabash> actual_group = this.calabashGroup.getGroup(); 
        assertEquals(expected_group, actual_group);

    }
    @Test
    public void testGroupSortByRAN(){
        ArrayList<Calabash> actual = calabashGroup.getGroup();
        ArrayList<Calabash> unexpected = new ArrayList<>(actual); 
        calabashGroup.sort(2);
        assertNotEquals(unexpected, actual);
    }
    @Test
    public void testGroupSortByASC(){
        ArrayList<Calabash> actual = calabashGroup.getGroup();
        ArrayList<Calabash> expected = new ArrayList<>(actual); 
        calabashGroup.sort(0);
        assertEquals(expected, actual);
    }
    @Test
    public void testGroupSortByDEC(){
        ArrayList<Calabash> actual = calabashGroup.getGroup();
        ArrayList<Calabash> expected = new ArrayList<>(actual); 
        Collections.reverse(expected);
        calabashGroup.sort(1);
        assertEquals(expected, actual);
    } 

    @Test
    public void testGroupGenderDivide() throws Exception{
        ArrayList<CalabashGroup> gender_groups = calabashGroup.divideByGender();
        ArrayList<Calabash> actual_male_group = gender_groups.get(0).getGroup();
        ArrayList<Calabash> actual_female_group = gender_groups.get(1).getGroup();
        //String[] nameList = {"0","1","2","3","4","5","6","7","8","9"};
        String[] typeList = {"FireCalabash","StrongCalabash","FireCalabash","WaterCalabash","Calabash","StrongCalabash","FireCalabash","WaterCalabash","Calabash","Calabash"};
        Boolean[] genderList = {true,false,true,false,true,false,true,false,true,false};
        for(Calabash calabash : actual_male_group){
            int index = Integer.valueOf(calabash.getName()).intValue();
            assertEquals(true, genderList[index]);
            assertEquals(Class.forName("model."+typeList[index]), calabash.getClass());
        }
        
        for(Calabash calabash : actual_female_group){
            int index = Integer.valueOf(calabash.getName()).intValue();
            assertEquals(false, genderList[index]);
            assertEquals(Class.forName("model."+typeList[index]), calabash.getClass());
        }

    }
}
