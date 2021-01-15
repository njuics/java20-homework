# 第二次作业 OOFoundation

![Package homework2.png](https://gitee.com/yyt1218/tuchuang/raw/master/img/H5654c3b512ad4cdcb28114dca6fcb3f5j.png)

## 类的说明

### 葫芦娃类HuluWa

用来表示葫芦娃对象。

##### 属性：

`seniority`：辈分，老大为1，老二为2，以此类推

`name`：名字

`pos`：当前在队列中的位置

##### 方法：

`exchangePos`：和另一个葫芦娃交换位置，既要改变队列中的实际位置，也要改变pos属性的值。

`goToCorrectPos`：不断询问前一个葫芦娃的辈分，通过传入的比较器进行比较并交换位置，直到前面的葫芦娃的seniority小于当前葫芦娃为止。

`tellname`：输出葫芦娃的名字。

### 爷爷类GrandFather

用来表示爷爷对象。

##### 方法：

`sortHuluWas`：根据比较器Comparator的compare方法结合冒泡排序给葫芦娃排序，**由爷爷直接改变葫芦娃的位置（在队列中进行交换，并使葫芦娃的pos属性改变）**。

```java
    public void sortHuluWas(ArrayList<HuluWa> huluArray, Comparator<HuluWa> comparator){
        int size = huluArray.size();
        for(int i = 0; i < size; ++i){
            for(int j = i; j > 0; --j){
                if(comparator.compare(huluArray.get(j), huluArray.get(j-1)) > 0){
                    HuluWa tmp = huluArray.get(j);
                    huluArray.set(j, huluArray.get(j-1));
                    huluArray.set(j-1, tmp);
                    huluArray.get(j).setPos(j);
                    huluArray.get(j-1).setPos(j-1);
                }
                else break;
            }
        }
    }
```

### 队列类HuluWaQueue

用来存储一个葫芦娃队列，并进行队列的排序、打乱、报数操作。

##### 属性：

`huluArray`：一个存储HuluWa对象的ArrayList容器，表示当前的葫芦娃队列。

##### 方法：

构造函数：新建一个有7个葫芦娃的队列，并打乱。

`numberOff`：报数，队列里的每个葫芦娃依次通过`tellName`输出自己的名字。

`shuffle`：打乱葫芦娃队列。

`autoSort`：从站在队头的葫芦娃开始，第i轮中队伍的第i个葫芦娃执行goToCorrectPos来保证自己在前i个葫芦娃中处于正确的位置，即前i个葫芦娃是有序的（即冒泡排序的原理），**仅通过葫芦娃间进行消息传递就完成了排序**。

### 主类HuluSort

##### 属性：

包含一个比较器`seniorityComparator`，重写了`compare`方法来对葫芦娃的辈分进行比较。

```java
public static Comparator<HuluWa> seniorityComparator = new Comparator<HuluWa>() {
    @Override
    public int compare(HuluWa o1, HuluWa o2) {
        if(o1.getSeniority() < o2.getSeniority()) return 1;
        else if (o1.getSeniority() == o2.getSeniority()) return 0;
        else return -1;
    }
};
```

##### 方法：

包含程序入口main，创建了葫芦娃队列对象和爷爷对象，并依次完成了orchestration和choreography排序以及报数。

#### 排序算法的更换

需要按照其他属性进行排序，只需要再写一个比较器，并将新的比较器作为参数传入`grandFather.sortHuluWas`方法和`queue.autoSort`方法中，通过参数的传入就可以自由切换要比较的字段。

## 输出结果

![image-20200920182001335](https://gitee.com/yyt1218/tuchuang/raw/master/img/image-20200920182001335.png)