/**
 * @author ：杨海洋
 * @date ：Created in 2020/9/14 16:16
 * @description：Java20-第一次作业
 * @modified By：
 * @version: $
 */
public class Sort {
    public static void main(String[] args) {
        int []a={2,4,10,3,6,9,7};
        System.out.print("排序前的数组是：");
        System.out.print("[");
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]);
            if(i!=a.length-1)
                System.out.print(",");
        }
        System.out.println("]");
        sort(a);
        System.out.print("排序后的数组是：");
        System.out.print("[");
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]);
            if(i!=a.length-1)
                System.out.print(",");
        }
        System.out.println("]");
    }
    public static void sort(int[]a){
        /**
         * create by: 杨海洋
         * description: 输出的数组按照升序的方式排列
         * create time: 2020/9/14 16:32
         *
         * @param a
         * @return void
         */
        boolean flag;
        for(int i=0;i<a.length;i++){
            flag=true;
            for(int j=a.length-1;j>i;j--){
                if(a[j]<a[j-1]){
                    flag=false;
                    int temp;
                    temp=a[j];
                    a[j]=a[j-1];
                    a[j-1]=temp;
                }
            }
            if(flag==true)
                break;
        }
    }
}
