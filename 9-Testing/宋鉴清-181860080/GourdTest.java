import org.junit.*;
import java.util.Random;
import java.util.HashSet;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class GourdTest {
    Family<Gourd> gourdFamily = new Family<Gourd>();

    public GourdTest() {
        generate_gourd();
    }
    public void generate_gourd(){
		Random r = new Random(System.currentTimeMillis());
        HashSet<String> name_list = new HashSet<String>();
        int i = 0;
        while(i < 100) {
            String name = "";
            char t = (char)(r.nextInt(26) + 'a');
            name += t;
            t = (char)(r.nextInt(26) + 'a');
            name += t;
            if(name_list.contains(name) == true) continue;
            i++;
            name_list.add(name);
            int randnum = r.nextInt(2);
            String gender = "";
            if(randnum == 0) gender = "Male";
            else gender = "Female";
            gourdFamily.add_member(new Gourd(name, gender));
		}
	}
    @Test
    public void test_same_name(){
        System.out.println("测试是否一个葫芦娃家族有两个相同的名字。");
        ArrayList<Gourd> list = gourdFamily.memberlist;
        for(int i = 0; i < list.size(); i++){
            for(int j = i + 1; j < list.size(); j++){
                assertEquals(false, list.get(i).get_name().equals(list.get(j).get_name()));
            }
        }
    }

    @Test
    public void test_classify_validity(){
        System.out.println("测试葫芦娃根据性别分类是否正确。");
        for(Gourd obj : gourdFamily.malepositIterable()){
			assertEquals(true, obj.get_gender().equals("Male"));
        }
        
        for(Gourd obj : gourdFamily.femalepositIterable()){
			assertEquals(true, obj.get_gender().equals("Female"));
		}
    }

    public void test_sort_assert(ArrayList<Gourd> list, int flag){
        for(int i = 0; i < list.size() - 1; i++){
            if(flag == -1)
                assertTrue(list.get(i).compareTo(list.get(i + 1)) < 0);
            else
                assertTrue(list.get(i).compareTo(list.get(i + 1)) > 0);
        }
    }

    @Test(timeout = 50)
    public void test_sort_validity(){
        System.out.println("测试葫芦娃排序是否正确，以及排序性能。");
        ArrayList<Gourd> list = gourdFamily.get_posit_list();
        test_sort_assert(list, -1);
        list = gourdFamily.get_nega_list();
        test_sort_assert(list, 1);
        list = gourdFamily.get_male_posit_list();
        test_sort_assert(list, -1);
        list = gourdFamily.get_male_nega_list();
        test_sort_assert(list, 1);
        list = gourdFamily.get_female_posit_list();
        test_sort_assert(list, -1);
        list = gourdFamily.get_female_nega_list();
        test_sort_assert(list, 1);
    }

    @Test
    public void test_iterator_validity() {
        System.out.println("测试使用迭代器的输出是否正确。");
        ArrayList<Gourd> list = new ArrayList<>();
        for(Gourd obj : gourdFamily.positIterable()) {
            list.add(obj);
        }
        ArrayList<Gourd> positlist = gourdFamily.get_posit_list();
        for(int i = 0; i < positlist.size(); i++) {
            assertEquals(list.get(i), positlist.get(i));
        }

        list = new ArrayList<>();
        for(Gourd obj : gourdFamily.negaIterable()) {
            list.add(obj);
        }
        ArrayList<Gourd> negalist = gourdFamily.get_nega_list();
        for(int i = 0; i < negalist.size(); i++) {
            assertEquals(list.get(i), negalist.get(i));
        }
    }
}
