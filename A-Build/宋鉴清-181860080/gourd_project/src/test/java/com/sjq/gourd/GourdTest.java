package com.sjq.gourd;

import org.junit.*;
import java.util.Random;
import java.util.HashSet;
import java.util.ArrayList;
import static org.junit.Assert.*;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.RandomStringGenerator;

import com.google.common.collect.Ordering;

public class GourdTest {
    Family<Gourd> gourdFamily = new Family<Gourd>();

    public GourdTest() {
        generate_gourd();
    }
    public void generate_gourd(){
		RandomStringGenerator stringGenerator = new RandomStringGenerator.Builder().withinRange('a', 'z').build();
		Random r = new Random(System.currentTimeMillis());
		HashSet<String> name_list = new HashSet<String>();
		String[] genders = {"Male", "Female"};
        int i = 0;
        while(i < 100) {
            String name = StringUtils.capitalize(stringGenerator.generate(2));
            if(name_list.contains(name) == true) continue;
            i++;
            name_list.add(name);
            String gender = genders[r.nextInt(2)];
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
        Ordering<Gourd> gourdposOrdering = Ordering.natural();
        assertTrue(gourdposOrdering.isOrdered(gourdFamily.get_posit_list()));
        assertTrue(gourdposOrdering.isOrdered(gourdFamily.get_male_posit_list()));
        assertTrue(gourdposOrdering.isOrdered(gourdFamily.get_female_posit_list()));
        assertTrue(gourdposOrdering.reverse().isOrdered(gourdFamily.get_nega_list()));
        assertTrue(gourdposOrdering.reverse().isOrdered(gourdFamily.get_male_nega_list()));
        assertTrue(gourdposOrdering.reverse().isOrdered(gourdFamily.get_female_nega_list()));
    }

    @Test
    public void test_iterator_validity() {
        System.out.println("测试使用迭代器的输出是否正确。");
        Ordering<Gourd> gourdposOrdering = Ordering.natural();
        assertTrue(gourdposOrdering.isOrdered(gourdFamily.positIterable()));
        assertTrue(gourdposOrdering.reverse().isOrdered(gourdFamily.negaIterable()));
    }
}
