import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MyIntegerSort {
	public static void main(String[] args) {
		System.out.print("Give me a valid path of input file : \n");
		Scanner temScan = new Scanner(System.in);
		String filePath = temScan.next();
		// 输入测试文件路径，请确保数据正确性合法性。
		//System.out.print(filePath + "\n");
		BufferedReader bufRead = null;
		try {
			bufRead = new BufferedReader(new FileReader(filePath));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String tem;
		ArrayList<Integer> ar = new ArrayList<Integer>();
		try {
			while ((tem = bufRead.readLine()) != null)
			{
				
			    //System.out.print(tem + " ");
				int temInt = Integer.parseInt(tem);
				//System.out.print(temInt + " ");
				ar.add(temInt);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ar.sort(null);
		// 按默认大小规则排序
		for (int i : ar)
		{
			System.out.print(i + " ");
		}
	}
}
