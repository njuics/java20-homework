package homework_9;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {	
		ArrayList<Calabash_Brothers> lis=new ArrayList<>();		
		input(lis);
		
		System.out.println("\nthe result of Orchestration sort is:");		
		Orchestration orch_sort=new Orchestration();
		orch_sort.sort(lis);
		
		System.out.println("\nthe result of Choreography sort is:");
		Choreography chor_sort=new Choreography();
		chor_sort.sort(lis);								
	}
	public static void input(ArrayList<Calabash_Brothers> lis) {
		//����Ϊ1-7��7�����ֵ�������У����δ����Ȼ����������߸���«��
		Scanner scanner=new Scanner(System.in);
		System.out.println("please input the order of Calabash_Brothers(1-7):");
		for(int i=0;i<7;i++) {
			int temp=scanner.nextInt();	
			Calabash_Brothers one=new Calabash_Brothers(temp);
			lis.add(one);			
			}
		scanner.close();
	}
}
