package homework_7;
import java.util.ArrayList;

public class Main {
	public static void main(String args[]) {
		Calabash_Brothers_Collection all=new Calabash_Brothers_Collection();
		all.Random_Calabash_Brothers(5);
		System.out.println("the random order of Calabash_Brothers is");
		all.output(all.collection);
		System.out.println("------------------------------------");
		three_kind_of_order(all,all.collection);
		ArrayList<Calabash_Brothers> male_co=new ArrayList<>();
		ArrayList<Calabash_Brothers> female_co=new ArrayList<>();
		all.get_two_part(male_co, female_co);
		System.out.println("Here are the sort of male Calabash_Brothers :");
		three_kind_of_order(all,male_co);
		System.out.println("Here are the sort of female Calabash_Brothers :");
		three_kind_of_order(all,female_co);
	}
	
	public static void three_kind_of_order(Calabash_Brothers_Collection all,ArrayList<Calabash_Brothers> arr) {
		String temp = null;
		for(int i=0;i<3;i++) {
			if(i==0) { temp="asc_order";}
			else if(i==1){ temp="des_order";}
			else if(i==2){ temp="dis_order";}
			all.sort(arr,i);
			System.out.println("the "+temp+" of Calabash_Brothers is");
			all.output(arr);
			System.out.println("------------------------------------");
		}
	}
	
	
}
