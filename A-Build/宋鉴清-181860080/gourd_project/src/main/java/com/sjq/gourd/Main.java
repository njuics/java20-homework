package com.sjq.gourd;
import java.util.HashSet;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.RandomStringGenerator;

public class Main {
	Family<Gourd> gourdFamily = new Family<Gourd>();
	public void generate_gourd(){
		RandomStringGenerator stringGenerator = new RandomStringGenerator.Builder().withinRange('a', 'z').build();
		Random r = new Random(System.currentTimeMillis());
		HashSet<String> name_list = new HashSet<String>();
		String[] genders = {"Male", "Female"};
        for(int i = 0; i < 20; i++){
            String name = StringUtils.capitalize(stringGenerator.generate(2));
            if(name_list.contains(name) == true) {
				i--;
				continue;
			}
			name_list.add(name);
            String gender = genders[r.nextInt(2)];
            gourdFamily.add_member(new Gourd(name, gender));
		}
		System.out.println("初始化的葫芦娃家庭.");
		for(Gourd obj : gourdFamily.beginIterable()){
			System.out.print(String.valueOf(obj) + ' ');
		}
		System.out.println("\n\n" + "所有葫芦娃正在进行正序排序.");
		for(Gourd obj : gourdFamily.positIterable()){
			System.out.print(String.valueOf(obj) + ' ');
		}
		System.out.println('\n' + "所有葫芦娃正在进行反序排序.");
		for(Gourd obj : gourdFamily.negaIterable()){
			System.out.print(String.valueOf(obj) + ' ');
		}
		System.out.println('\n' + "所有葫芦娃正在进行乱序排序.");
		for(Gourd obj : gourdFamily.chaosIterable()){
			System.out.print(String.valueOf(obj) + ' ');
		}
	}
	public static void main(String[] args) {
		Main main = new Main();
		main.generate_gourd();
	}
}
