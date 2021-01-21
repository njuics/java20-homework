package sort;
import java.util.Scanner;
import java.util.ArrayList;
public class insert_sort {
	public static void main(String[] args) {		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("please input the length of array:");
		int num=scanner.nextInt();
		ArrayList<Integer> arr=new ArrayList<Integer>(num);
		System.out.println("please input each member of array:");
		for(int i=0;i<num;i++) {
			int temp=scanner.nextInt();
			if(i==0)arr.add(0,temp);
			else {
				for(int j=0;j<i;j++) {
					if(arr.get(j)>temp) {
						arr.add(j,temp);break;
						}
					if(j==i-1)
						arr.add(temp);
				}	
			}		
		
		}
		
		for(int i=0;i<num;i++){
			int each=arr.get(i);
		    System.out.println(each);
		}
	}
}
