import java.util.Random;

import java.util.HashSet;

public class Main {
	Family<Gourd> gourdFamily = new Family<Gourd>();
	public void generate_gourd(){
		Random r = new Random(System.currentTimeMillis());
        HashSet<String> name_list = new HashSet<String>();
        for(int i = 0; i < 20; i++){
            String name = "";
            char t = (char)(r.nextInt(26) + 'a');
            name += t;
            t = (char)(r.nextInt(26) + 'a');
            name += t;
            if(name_list.contains(name) == true) continue;
            name_list.add(name);
            int randnum = r.nextInt(2);
            String gender = "";
            if(randnum == 0) gender = "Male";
            else gender = "Female";
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
