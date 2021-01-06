import java.util.*;

public class CalabashSort{
	public static void main(String[] args){
		System.out.println("随机生成10个葫芦娃");
		GenderedList<Calabash> list = new GenderedList<>();
		Collections.addAll(list, Calabash.calabashArray(10));
		System.out.println(list);
		
		System.out.println("正序排序：");
		Collections.sort(list);
		System.out.println(list);
		
		System.out.println("正序遍历：");
		for(Calabash c : list)
			System.out.println("traverse " + c.toString());
		
		System.out.println("反序遍历：");
		for(Calabash c : list.reversed())
			System.out.println("traverse " + c.toString());
		
		System.out.println("乱序遍历：");
		for(Calabash c : list.randomized())
			System.out.println("traverse " + c.toString());
		
		System.out.println("男生队伍：");
		GenderedList<Calabash> boys = list.maleList();
		System.out.println(boys);
		System.out.println("反序排序：");
		Collections.sort(boys, new NamedComparator<Calabash>().reversed());
		System.out.println(boys);
		
		System.out.println("女生队伍：");
		GenderedList<Calabash> girls = list.femaleList();
		System.out.println(girls);
		System.out.println("乱序排序：");
		Collections.shuffle(girls);
		System.out.println(girls);
	}
}
