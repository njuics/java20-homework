/*
 * @Author: zb-nju
 * @Date: 2020-09-09 10:59:54
 * @LastEditors: zb-nju
 * @LastEditTime: 2020-11-05 17:39:34
 */
public class BubbleSort {
    public static void main(String[] args){
        int arr[]={5,6,3,7,5,7,97,56,32,234,1},t;
        for(int i=arr.length-1;i>=0;i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
        for(int i:arr){
            System.out.println(i);
        }
    }
}