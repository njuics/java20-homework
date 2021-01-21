package orchestration;
import  java.util.Scanner;
import java.util.ArrayList;

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

class Grandpa{
	private int num_of_brothers;
	Grandpa(int i){
		this.num_of_brothers=i;
	}
	void swap(Calabash_Brothers a,Calabash_Brothers b) {
		int temp=a.getval();a.change_val(b.getval());b.change_val(temp);
	}
	void queue(int num,int now,ArrayList<Calabash_Brothers> lis) {		
		int pre=lis.get(now).getval()-1;
		if(pre!=now) {
			swap(lis.get(now),lis.get(pre));			
			num++;
			queue(num,now,lis);
		}
		num++;
		if(num>=num_of_brothers)return;
		else if(now<num_of_brothers-1) { queue(num,now+1,lis);}
		else if(now==num_of_brothers-1) {
			queue(num,0,lis);
		}
	}
	
}

public class Orchestration {
	public static void main(String[] args) {		
		Grandpa gr=new Grandpa(7);		
		ArrayList<Calabash_Brothers> lis=new ArrayList<>();
		
		input(lis);
		gr.queue(0,0,lis);
		output(lis);	
	}
	public static void input(ArrayList<Calabash_Brothers> lis) {
		//输入为1-7的7个数字的随机组合，依次代表赤橙黄绿青蓝紫七个葫芦娃
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

