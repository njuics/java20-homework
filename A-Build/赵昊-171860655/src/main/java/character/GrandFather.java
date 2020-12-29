package character;

import java.util.ArrayList;


public class GrandFather extends Character{
    private static final int sortMode = 1;
    public GrandFather(){
        this.name = "爷爷";
    }

    public void SortBrothers(ArrayList<CalabashBrother> brothersArray){
        System.out.println("爷爷指挥排序，排序前点名：");
        for (CalabashBrother calabashBrother : brothersArray)
            System.out.print(calabashBrother.getName()+" ");
        System.out.println();
        switch (sortMode){
            case 1:selectSort(brothersArray);System.out.println("使用选择排序");break;
            case 2:bubbleSort(brothersArray);System.out.println("使用冒泡排序");break;
            case 3:quickSort(brothersArray,0,brothersArray.size()-1);System.out.println("使用快速排序");break;
            default:System.out.println("不存在的排序模式");
        }
        System.out.println("排好序后点名：");
        for (CalabashBrother calabashBrother : brothersArray)
            System.out.print(calabashBrother.getName()+" ");
        System.out.println();
    }
    private void quickSort(ArrayList<CalabashBrother> brothersArray,int left,int right) {
        if(left>=right)
            return;
        int i = left;
        int j = right;
        CalabashBrother key = brothersArray.get(left);//选择第一个数为key
        while(i<j) {
            while(i<j && brothersArray.get(j).compare(key)>=0)//从右向左找第一个小于key的值
                j--;
            if(i<j) {
                brothersArray.set(i,brothersArray.get(j));
                i++;
            }
            while(i<j && brothersArray.get(i).compare(key)<0)//从左向右找第一个大于key的值
                i++;
            if(i<j) {
                brothersArray.set(j,brothersArray.get(i));
                j--;
            }
        }
        brothersArray.set(i,key);
        quickSort(brothersArray, left, i-1);//继续排左部分，递归调用
        quickSort(brothersArray, i+1, right);//继续排右部分，递归调用
    }

    public void selectSort(ArrayList<CalabashBrother> brothersArray){
        for(int i=0;i<brothersArray.size();i++)
        {
            int mark = i;
            for(int j=i+1;j<brothersArray.size();j++)
            {
                if(brothersArray.get(j).compare(brothersArray.get(mark))<0){

                    mark = j;
                }
            }
            if(i!=mark){
                CalabashBrother temp = brothersArray.get(i);
                brothersArray.set(i,brothersArray.get(mark));
                brothersArray.set(mark,temp);
            }
        }
    }
    public void bubbleSort(ArrayList<CalabashBrother> brothersArray){
        for(int i = 0;i<brothersArray.size()-1;i++){
            for(int j = 0;j<brothersArray.size()-1-i;j++){
                if(brothersArray.get(j).compare(brothersArray.get(j+1))>0) {
                    CalabashBrother temp = brothersArray.get(j+1);
                    brothersArray.set(j+1,brothersArray.get(j));
                    brothersArray.set(j,temp);
                }
            }
        }
    }

}
