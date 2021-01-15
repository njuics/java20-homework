import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;
import java.util.Random;
class TestData{
    String[] testName;
    String[] testGender;
    TestData(){
        String Name[]={"gmc","tyw","gyt","xzy","hht","hzy","wtq","fx","cxw","yzh"};
        String Gender[]={"male","female","female","male","male","male","female","male","female","female"};
        testName=Name;
        testGender=Gender;
        assert testName.length==testGender.length :"TestData's length is not the same!";
    }
    TestData(int len){
        testName=new String[len];
        testGender=new String[len];
        for(int i=0;i<len;i++){
            testName[i]=genRandomName();
            testGender[i]=genRandomgender();
        }
    }
    String[] getTestName(){
        return testName;
    }
    String[] getGenderName(){
        return testGender;
    }
    private String genRandomName(){
        String Alphabet="abcdefghijklmnopqrstuvwxyz";
        Random gen=new Random();
        String str=new String();
        for(int i=0;i<5;i++){
            str=str+Alphabet.charAt(gen.nextInt(26));
        }
        return str;
    }
    
    private String genRandomgender(){
        Random gen=new Random();
        int rand=gen.nextInt(2);
        String gender;
        if(rand==0){
            gender="Female";
        }
        else{
            gender="Male";
        }
        return gender;
    }
}
public class HuluwaFamilyTest {
    @Test
    public void AscendingIteratorTest() throws Exception{
        TestData TD=new TestData();
        String []testName=TD.getGenderName();
        String []testGender=TD.getTestName();
        Family<Huluwa> f=new Family<>();
        for(int i=0;i<testName.length;i++){
            f.add(new Huluwa(testName[i],testGender[i]));
        }
        Iterator<Huluwa> it=f.ascendingIterator();  
        Huluwa left;
        Huluwa right;
        if(it.hasNext()){
            left=it.next();        
            while(it.hasNext()){
                right=it.next();
                assert left.getName().compareTo(right.getName())<=0 :"Not Ascending";
                left=right;
            }
        }
    }
    @Test
    public void DecendingIteratorTest() throws Exception{
        TestData TD=new TestData();
        String []testName=TD.getGenderName();
        String []testGender=TD.getTestName();
        Family<Huluwa> f=new Family<>();
        for(int i=0;i<testName.length;i++){
            f.add(new Huluwa(testName[i],testGender[i]));
        }
        Iterator<Huluwa> it=f.decendingIterator();  
        Huluwa left;
        Huluwa right;
        if(it.hasNext()){
            left=it.next();        
            while(it.hasNext()){
                right=it.next();
                assert left.getName().compareTo(right.getName())>=0 :"Not decending";
                left=right;
            }
        }
    }

    @Test
    public void MaleDecendingIteratorTest() throws Exception{
        TestData TD=new TestData();
        String []testName=TD.getGenderName();
        String []testGender=TD.getTestName();
        Family<Huluwa> f=new Family<>();
        for(int i=0;i<testName.length;i++){
            f.add(new Huluwa(testName[i],testGender[i]));
        }
        Iterator<Huluwa> it=f.maleDecendingIterator();  
        Huluwa left;
        Huluwa right;
        if(it.hasNext()){
            left=it.next();      
            assert left.getGender()=="male" :"Not male";  
            while(it.hasNext()){
                right=it.next();
                assert right.getGender()=="male" :"Not male";
                assert left.getName().compareTo(right.getName())>=0 :"Not decending";
                left=right;
            }
        }
    }

    @Test
    public void MaleAscendingIteratorTest() throws Exception{
        TestData TD=new TestData();
        String []testName=TD.getGenderName();
        String []testGender=TD.getTestName();
        Family<Huluwa> f=new Family<>();
        for(int i=0;i<testName.length;i++){
            f.add(new Huluwa(testName[i],testGender[i]));
        }
        Iterator<Huluwa> it=f.maleAscendingIterator();  
        Huluwa left;
        Huluwa right;
        if(it.hasNext()){
            left=it.next();      
            assert left.getGender()=="male" :"Not male";  
            while(it.hasNext()){
                right=it.next();
                assert right.getGender()=="male" :"Not male";
                assert left.getName().compareTo(right.getName())<=0 :"Not decending";
                left=right;
            }
        }
    }

    @Test
    public void FemaleDecendingIteratorTest() throws Exception{
        TestData TD=new TestData();
        String []testName=TD.getGenderName();
        String []testGender=TD.getTestName();
        Family<Huluwa> f=new Family<>();
        for(int i=0;i<testName.length;i++){
            f.add(new Huluwa(testName[i],testGender[i]));
        }
        Iterator<Huluwa> it=f.femaleDecendingIterator();  
        Huluwa left;
        Huluwa right;
        if(it.hasNext()){
            left=it.next();      
            assert left.getGender()=="female" :"Not female";  
            while(it.hasNext()){
                right=it.next();
                assert right.getGender()=="female" :"Not female";
                assert left.getName().compareTo(right.getName())>=0 :"Not decending";
                left=right;
            }
        }
    }

    @Test
    public void FemaleAscendingIteratorTest() throws Exception{
        TestData TD=new TestData();
        String []testName=TD.getGenderName();
        String []testGender=TD.getTestName();
        Family<Huluwa> f=new Family<>();
        for(int i=0;i<testName.length;i++){
            f.add(new Huluwa(testName[i],testGender[i]));
        }
        Iterator<Huluwa> it=f.femaleAscendingIterator();  
        Huluwa left;
        Huluwa right;
        if(it.hasNext()){
            left=it.next();      
            assert left.getGender()=="female" :"Not female";  
            while(it.hasNext()){
                right=it.next();
                assert right.getGender()=="female" :"Not female";
                assert left.getName().compareTo(right.getName())<=0 :"Not decending";
                left=right;
            }
        }
    }

    @Test
    public void RandomAscendingIteratorTest() throws Exception{
        TestData TD=new TestData(20);
        String []testName=TD.getGenderName();
        String []testGender=TD.getTestName();
        Family<Huluwa> f=new Family<>();
        for(int i=0;i<testName.length;i++){
            f.add(new Huluwa(testName[i],testGender[i]));
        }
        Iterator<Huluwa> it=f.ascendingIterator();  
        Huluwa left;
        Huluwa right;
        if(it.hasNext()){
            left=it.next();        
            while(it.hasNext()){
                right=it.next();
                assert left.getName().compareTo(right.getName())<=0 :"Not Ascending";
                left=right;
            }
        }
    }
    @Test
    public void RandomTestDecendingIterator() throws Exception{
        TestData TD=new TestData(20);
        String []testName=TD.getGenderName();
        String []testGender=TD.getTestName();
        Family<Huluwa> f=new Family<>();
        for(int i=0;i<testName.length;i++){
            f.add(new Huluwa(testName[i],testGender[i]));
        }
        Iterator<Huluwa> it=f.decendingIterator();  
        Huluwa left;
        Huluwa right;
        if(it.hasNext()){
            left=it.next();        
            while(it.hasNext()){
                right=it.next();
                assert left.getName().compareTo(right.getName())>=0 :"Not decending";
                left=right;
            }
        }
    }

    @Test
    public void RandomMaleDecendingIteratorTest() throws Exception{
        TestData TD=new TestData(20);
        String []testName=TD.getGenderName();
        String []testGender=TD.getTestName();
        Family<Huluwa> f=new Family<>();
        for(int i=0;i<testName.length;i++){
            f.add(new Huluwa(testName[i],testGender[i]));
        }
        Iterator<Huluwa> it=f.maleDecendingIterator();  
        Huluwa left;
        Huluwa right;
        if(it.hasNext()){
            left=it.next();      
            assert left.getGender()=="male" :"Not male";  
            while(it.hasNext()){
                right=it.next();
                assert right.getGender()=="male" :"Not male";
                assert left.getName().compareTo(right.getName())>=0 :"Not decending";
                left=right;
            }
        }
    }

    @Test
    public void RandomMaleAscendingIteratorTest() throws Exception{
        TestData TD=new TestData(20);
        String []testName=TD.getGenderName();
        String []testGender=TD.getTestName();
        Family<Huluwa> f=new Family<>();
        for(int i=0;i<testName.length;i++){
            f.add(new Huluwa(testName[i],testGender[i]));
        }
        Iterator<Huluwa> it=f.maleAscendingIterator();  
        Huluwa left;
        Huluwa right;
        if(it.hasNext()){
            left=it.next();      
            assert left.getGender()=="male" :"Not male";  
            while(it.hasNext()){
                right=it.next();
                assert right.getGender()=="male" :"Not male";
                assert left.getName().compareTo(right.getName())<=0 :"Not decending";
                left=right;
            }
        }
    }

    @Test
    public void RandomFemaleDecendingIteratorTest() throws Exception{
        TestData TD=new TestData(20);
        String []testName=TD.getGenderName();
        String []testGender=TD.getTestName();
        Family<Huluwa> f=new Family<>();
        for(int i=0;i<testName.length;i++){
            f.add(new Huluwa(testName[i],testGender[i]));
        }
        Iterator<Huluwa> it=f.femaleDecendingIterator();  
        Huluwa left;
        Huluwa right;
        if(it.hasNext()){
            left=it.next();      
            assert left.getGender()=="female" :"Not female";  
            while(it.hasNext()){
                right=it.next();
                assert right.getGender()=="female" :"Not female";
                assert left.getName().compareTo(right.getName())>=0 :"Not decending";
                left=right;
            }
        }
    }

    @Test
    public void RandomFemaleAscendingIteratorTest() throws Exception{
        TestData TD=new TestData(20);
        String []testName=TD.getGenderName();
        String []testGender=TD.getTestName();
        Family<Huluwa> f=new Family<>();
        for(int i=0;i<testName.length;i++){
            f.add(new Huluwa(testName[i],testGender[i]));
        }
        Iterator<Huluwa> it=f.femaleAscendingIterator();  
        Huluwa left;
        Huluwa right;
        if(it.hasNext()){
            left=it.next();      
            assert left.getGender()=="female" :"Not female";  
            while(it.hasNext()){
                right=it.next();
                assert right.getGender()=="female" :"Not female";
                assert left.getName().compareTo(right.getName())<=0 :"Not decending";
                left=right;
            }
        }
    }
}