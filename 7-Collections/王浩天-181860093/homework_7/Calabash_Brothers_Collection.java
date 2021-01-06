package homework_7;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class Calabash_Brothers_Collection {
	ArrayList<Calabash_Brothers> collection=new ArrayList<>();
	
	public void Random_Calabash_Brothers(int num){
		String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	     Random random=new Random();
	     for(int i=0;i<num;i++) {
	    	String one_name;
	    	boolean one_gender;
	    	StringBuffer na=new StringBuffer();
	     	for(int j=0;j<5;j++){
	     		int number=random.nextInt(62);
	     		na.append(str.charAt(number));
	     	}
	     	one_gender=random.nextBoolean();
	     	one_name=na.toString();
	     	Calabash_Brothers one=new Calabash_Brothers(one_name,one_gender);
	     	collection.add(one);
	     }
	}
	
	public void get_two_part(ArrayList<Calabash_Brothers> male_co,ArrayList<Calabash_Brothers> female_co) {
		Iterator<Calabash_Brothers> it=collection.iterator();
		while(it.hasNext()) {
			Calabash_Brothers temp=it.next();
			if(temp.get_gender()) {//0-female 1-male
				male_co.add(temp);
			}
			else {
				female_co.add(temp);
			}
		}
	}
	public void output(ArrayList<Calabash_Brothers> one) {
		Iterator<Calabash_Brothers> it=one.iterator();
		while(it.hasNext()) {
			Calabash_Brothers temp=it.next();
			temp.print_name();temp.print_gender();
			System.out.println("");
		}
	}

	public void sort(ArrayList<Calabash_Brothers> one,int index) {//0-ÕýÐò 1-µ¹Ðò 2-ÂÒÐò
		if(index==0) {
			Collections.sort(one,new Asc_Comparator());
		}
		else if(index==1) {
			Collections.sort(one,new Des_Comparator());
		}
		else if(index==2) {
			Collections.shuffle(one);
		}
		
	}
}
