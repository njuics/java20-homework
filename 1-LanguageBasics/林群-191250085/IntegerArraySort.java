public class IntegerArraySort {
    public static void main(String[] args) {
        int[] newArray = {0,2,3,1,4,5,6,9}; //创建整型数组
        int length = newArray.length;

        //冒泡排序，升序排列数组
        for (int i = 0; i < length - 1;i++)
            for (int j = 0; j < length - i - 1;j++){
                if (newArray[j] > newArray[j + 1]){
                    newArray[j] ^= newArray[j + 1];
                    newArray[j + 1] ^= newArray[j];
                    newArray[j] ^= newArray[j + 1];
                }
            }

        //输出排序后的数组
        for (int i : newArray){
            System.out.print(i + " ");
        }
    }
}
