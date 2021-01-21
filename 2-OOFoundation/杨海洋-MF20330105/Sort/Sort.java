package Sort;

import ooFoundation.GourdBaby;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：杨海洋
 * @date ：Created in 2020/9/16 19:43
 * @description：多种排序方法实现转换
 * @modified By：
 * @version: $
 */
public class Sort {
    public static List<GourdBaby> sort1(List<GourdBaby> list){
        int []a=new int[list.size()];
        for(int i=0;i<list.size();i++){
            a[i]=list.get(i).getId();
        }
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
        List<GourdBaby> list1=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            for(GourdBaby gB:list){
                if(gB.getId()==a[i]){
                    list1.add(gB);
                    break;
                }
            }
        }
        return list1;
    }
    public static List<GourdBaby> sort2(List<GourdBaby> list){
        int []a=new int[list.size()];
        for(int i=0;i<list.size();i++){
            a[i]=list.get(i).getId();
        }
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i; j < a.length; j++) {
                if (a[j] < a[minIndex])
                    minIndex = j;
            }
            int temp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = temp;
        }
        List<GourdBaby> list1=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            for(GourdBaby gB:list){
                if(gB.getId()==a[i]){
                    list1.add(gB);
                    break;
                }
            }
        }
        return list1;
    }
}
