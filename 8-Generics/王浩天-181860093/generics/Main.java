package generics;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {	
		ArrayList<Calabash_Brothers<Myinteger>> lis=new ArrayList<>();		
		input(lis);
		
		System.out.println("\nthe result of Orchestration sort is:");		
		Orchestration orch_sort=new Orchestration();
		orch_sort.sort(lis);
		
		System.out.println("\nthe result of Choreography sort is:");
		Choreography chor_sort=new Choreography();
		chor_sort.sort(lis);								
	}
	public static void input(ArrayList<Calabash_Brothers<Myinteger>> lis) {
		//输入为1-7的7个数字的随机排列，依次代表赤橙黄绿青蓝紫七个葫芦娃
		Scanner scanner=new Scanner(System.in);
		System.out.println("please input the order of Calabash_Brothers(1-7):");
		for(int i=0;i<7;i++) {
			int temp=scanner.nextInt();
			String name = null;
			switch(temp) {
			case 1:name="Red";break;
			case 2:name="Orange";break;
			case 3:name="Yellow";break;
			case 4:name="Green";break;
			case 5:name="Cyan";break;
			case 6:name="Blue";break;
			case 7:name="Purple";break;
			default:System.out.print("Wrong input");
			}
			Calabash_Brothers<Myinteger> one=new Calabash_Brothers<Myinteger>(new Myinteger(temp),name);
			lis.add(one);			
			}
		scanner.close();
	}
}
