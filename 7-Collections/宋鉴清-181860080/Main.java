public class Main {
	public static void main(String[] args) {
		GourdFamily gourdFamily = new GourdFamily();
		System.out.println("初始化的葫芦娃家庭.");
		for(Gourd obj : gourdFamily.BeginIterable()){
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
		System.out.println("\n\n" + "Male正在进行正序排序.");
		for(Gourd obj : gourdFamily.malepositIterable()){
			System.out.print(String.valueOf(obj) + ' ');
		}
		System.out.println('\n' + "Male正在进行反序排序.");
		for(Gourd obj : gourdFamily.malenegaIterable()){
			System.out.print(String.valueOf(obj) + ' ');
		}
		System.out.println('\n' + "Male正在进行乱序排序.");
		for(Gourd obj : gourdFamily.malechaosIterable()){
			System.out.print(String.valueOf(obj) + ' ');
		}
		System.out.println("\n\n" + "Female正在进行正序排序.");
		for(Gourd obj : gourdFamily.femalepositIterable()){
			System.out.print(String.valueOf(obj) + ' ');
		}
		System.out.println('\n' + "Female正在进行反序排序.");
		for(Gourd obj : gourdFamily.femalenegaIterable()){
			System.out.print(String.valueOf(obj) + ' ');
		}
		System.out.println('\n' + "Female正在进行乱序排序.");
		for(Gourd obj : gourdFamily.femalechaosIterable()){
			System.out.print(String.valueOf(obj) + ' ');
		}
	}
}
