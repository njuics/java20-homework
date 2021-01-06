package choreography;
import java.util.ArrayList;
import java.util.Scanner;

class Calabash_Brothers{
	//根据value值区分葫芦娃
	//Red(1),Orange(2),Yellow(3),Green(4),Cyan(5),Blue(6),Purple(7);
	private int value;
	
	Calabash_Brothers(int i){
		this.value=i;
	}
	void change_val(int i) {
		this.value=i;
	}
	int getval() {
		return value;
	}
	void print() {
		System.out.print(value+"-");
		switch(value) {
		case 1:System.out.print("Red  ");break;
		case 2:System.out.print("Orange  ");break;
		case 3:System.out.print("Yellow  ");break;
		case 4:System.out.print("Green  ");break;
		case 5:System.out.print("Cyan  ");break;
		case 6:System.out.print("Blue  ");break;
		case 7:System.out.print("Purple  ");break;
		default:System.out.print("Wrong input");
		}
	}
}


public class choreography {
	public static void main(String[] arrgs) {
		ArrayList<Calabash_Brothers> lis=new ArrayList<>();
		input(lis);
		queue(7,lis);
		output(lis);
			
	}
	public static void swap(Calabash_Brothers a,Calabash_Brothers b) {
		int temp=a.getval();a.change_val(b.getval());b.change_val(temp);
	}
	public static void queue(int num,ArrayList<Calabash_Brothers> lis) {		
		for(int i=0;i<num-1;i++) {
			for(int j=0;j<num-1;j++) {
				if(lis.get(j).getval()>lis.get(j+1).getval()) {
					swap(lis.get(j),lis.get(j+1));
				}
			}			
		}		
	}
	public static void input(ArrayList<Calabash_Brothers> lis) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("please input the order of Calabash_Brothers(1-7):");
		for(int i=0;i<7;i++) {
			int temp=scanner.nextInt();	
			Calabash_Brothers one=new Calabash_Brothers(temp);
			lis.add(one);			
			}
		scanner.close();
	}
	public static void output(ArrayList<Calabash_Brothers> lis) {
		System.out.println("the result of sorting Calabash_Brothers is:");
		for(int j=0;j<7;j++) {
			lis.get(j).print();			
			}	
	}
}




