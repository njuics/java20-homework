# 作业：面向葫芦娃编程说明

该程序中主要实现了葫芦娃及排序方法两个类别，葫芦娃通过index和color两个类型的成员描述自身属性，排序方法根据要求实现为外部方法调用及内部方法调用。
# 排序类说明
两种排序均使用冒泡排序，但二者调用方式不同。
1. 冒泡排序
```
public class Sort {
        public static void bubbleSort(CalabashBrother[] calabashBrothers){
        for(int i = 0;i < (calabashBrothers.length);i++){
            for(int j = 0;j < calabashBrothers.length -1 - i;j++){
                if(calabashBrothers[j].getColor() > calabashBrothers[j + 1].getColor()){
                    CalabashBrother temp = calabashBrothers[j + 1];
                    calabashBrothers[j+1] = calabashBrothers[j];
                    calabashBrothers[j] = temp;
                }
            }
        }
    }
}
```
2. orchestration方法
是通过Sort类中实现的冒泡排序法在数组上操作
```
    Sort.bubbleSort(calabashBrothers1);
```

3. choreography方法 
是通过数组内对象进行函数调用
```
    calabashBrothers2[0].Sort(calabashBrothers2);
```
# 葫芦娃类说明
1. 类构成
主要使用index描述在数组中的位置，color 表示葫芦娃的自身属性，并以此进行输出等操作。
```
public class CalabashBrother {
    private int color;
    private int index;
    private static int count = 0;
    private String[] calabashbrothernames={"老大","老二","老三","老四","老五","老六","老七"};

    public CalabashBrother(int index){
        this.index = count++%7;
        this.color = index;
    }//index生成

    public  void Sort(CalabashBrother[] calabashBrothers){
        ...
    }//通过对象调用排序函数
}
``` 

完成后按照作业提交要求和流程，完成作业提交。
