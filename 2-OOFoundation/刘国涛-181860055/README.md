# OOFoundation

## 实现方式

### orchestration

在`orchestration`的世界里，葫芦娃的排序过程由爷爷指挥，那么就需要设计两个类葫芦娃类`Huluwa`和爷爷类`GrandFather`

![](http://47.103.197.224/img/orchestration.png)

`GrandFather`对葫芦娃的排序中的比较通过一个类型为`Comparator<Huluwa>`的静态成员变量`observer`实现，爷爷通过`observer`来比较葫芦娃的年龄大小

```java
class GrandFather{
    private static Comparator<Huluwa> observer = new Comparator<Huluwa>(){
        @Override
        public int compare(Huluwa a,Huluwa b){
            return b.getAge() - a.getAge();
        }
    };
    
    public void sortHuluwa(Huluwa[] grandsons){
        //Arrays.sort(grandsons, observer);
        mySort(grandsons, observer);
    }

    private void mySort(Huluwa[] grandsons, Comparator<Huluwa> cmp){
        int n = grandsons.length;
        for(int i=0;i<n;++i){
            for(int j=0;j<n-1;++j){
                if(cmp.compare(grandsons[j], grandsons[j+1])>0){
                    Huluwa tmp = new Huluwa();
                    tmp = grandsons[j];
                    grandsons[j] = grandsons[j+1];
                    grandsons[j+1] = tmp;
                }
            }
        }
    }
}
```

因此在**替换排序算法的时候**，仅需要实现一个`sort(Huluwa[],Comparator<Huluwa>)`的方法，并在`sortHuluwa`中替换即可

如此设计后，在主要逻辑中就能做到全部过程由爷爷来控制了：

```java
class OrchestrationWorld{
    public void run(){
        System.out.println("Orchestration World run");
        GrandFather grandFather = new GrandFather();
        Huluwa[] huluwas = grandFather.plantHuluwa();// 爷爷构造七个葫芦娃
        grandFather.randomShuffle(huluwas, 10);		// 爷爷让七个葫芦娃随机站队
        grandFather.reportInOrder(huluwas);			// 爷爷让七个葫芦娃报数
        grandFather.sortHuluwa(huluwas);			// 爷爷将七个葫芦娃排序
        grandFather.reportInOrder(huluwas);			// 爷爷让七个葫芦娃报数
    }
}
```





### choreography

在choreography的世界里七个葫芦娃相互协作完成排序过程，为了完成这个过程，**葫芦娃需要一个能够比较自己与其他葫芦娃大小的方法**，因此在上面实现的葫芦娃类`Huluwa`中引入`java.lang.Comparable`接口，并实现`compareTo`方法

```java
class Huluwa implements Comparable<Huluwas>{
    @Override
    public int compareTo(Huluwa bro){
        return bro.getAge() - this.age;
    }
}
```



另外葫芦娃还需要一个与其他葫芦娃交换位置的方法，因此再向`Huluwa`中加入`swapWith(Huluwa)`

```java
class Huluwa implements Comparable<Huluwas>{
    public void swapWith(Huluwa bro){
        String tmp_name = this.name;
        this.name = bro.name;
        bro.name = tmp_name;
        int tmp_age = this.age;
        this.age = bro.age;
        bro.age = tmp_age;
    }
}
```

这样在后续的shuffle和sort过程中，比较和交换两个过程都是以葫芦娃为主体发起的了

```java
class ChoreographyWorld{
    
    private void randomShuffle(Huluwa[] huluwas,int shuffle_times){ // 随机站队
        Random random = new Random();
        for(int i=0; i<shuffle_times; ++i){
            int a = random.nextInt(7);
            int b = random.nextInt(7);
            if(a == b)continue;
            huluwas[a].swapWith(huluwas[b]);
        }
    }


    private void HuluwaSort(Huluwa[] huluwas){  //排序
        int n = huluwas.length;
        for(int i=0;i<n;++i){
            for(int j=0;j<n-1;++j){
                if(huluwas[j].compareTo(huluwas[j+1])>0){
                    huluwas[j].swapWith(huluwas[j+1]);
                }
            }
        }
    }
}
```





### 运行方式

**cmd**执行

```
java HuluwaSort.java
```



输出内容用到了中文字符，需要注意编码方式的一致



### 运行结果

> 第一次报数是随机站队
>
> 第二次报数是排序后的结果

```
D:\github\java20-homework\2-OOFoundation\刘国涛-181860055>java HuluwaSort.java
Orchestration World run
三娃 四娃 二娃 五娃 大娃 六娃 七娃 
大娃 二娃 三娃 四娃 五娃 六娃 七娃 
Choreography World run
二娃 三娃 大娃 五娃 六娃 四娃 七娃 
大娃 二娃 三娃 四娃 五娃 六娃 七娃 
```

