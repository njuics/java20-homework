package JavaHomework1;

import java.util.ArrayList;
import java.util.Scanner;

public class IntegerSort {
	public static void main(String[] args){
		int num;
		ArrayList<Integer> array = new ArrayList<Integer>();
		Scanner num_in=new Scanner(System.in); 
		
		System.out.println("请输入整数的个数");
		num=num_in.nextInt();
		
		System.out.println("请输入待排序的整数");
		
		for(int i=0;i<num;i++){
			array.add(num_in.nextInt());
		}
		array.sort(null);
		
		for(Integer singleNum : array){
			System.out.println(singleNum+" ");
		}
		
		num_in.close();
	}
}
