public class Mysort{
    
    public static void main(String[] args){
        int[] num = {5,9,77,89,15,33,14,74,32,11,1};
        int len = num.length;
        System.out.println("初始数组为：");
        for(int x : num){
            System.out.print(x + ",");
        }
        for(int i = 0;i < len-1;i++){
            for(int j = i + 1; j < len - i-1;j++){
                if(num[i] > num[j+1]){
		int temp = num[j+1];
        		num[j+1] = num[i];
        		num[i] = temp;
	}
                    change(num[i],num[j+1]);
            }
        }
        System.out.println("有序数组为：");
        for(int x : num){
            System.out.print(x + ",");
        }
    }
}