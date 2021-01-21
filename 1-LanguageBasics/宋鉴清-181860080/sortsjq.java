package hello;
import java.util.Random;

public class Hello {

	public static void main(String[] args) {
		Random r = new Random(System.currentTimeMillis());
		int arr[] = new int[15];
		
		for(int i = 0; i < 15; i++) {
			arr[i] = r.nextInt(100);
		}
		
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j + 1]){
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
        for(int i = 1; i < arr.length; i++)
            System.out.println(arr[i]);
	}
}
