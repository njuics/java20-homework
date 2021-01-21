# 作业：面向葫芦娃编程

## 第三次作业



### 一：类设计

##### 1：`World`类

​	初始化场景中的各个元素，包括七个葫芦娃、爷爷、以及全局接收到的指令、main函数启动世界

##### 2：`Being`类

​	为葫芦娃和爷爷的父类，数据成员为名字

##### 3：`CalabashBrothers`类

​	葫芦娃类，数据成员为该葫芦娃的等级，函数成员为返回自己的名字、获得的“排序”的思想、返回自己的等级、与另一个葫芦娃比较等级、交换位置

##### 4:`GrandFather`类

​	爷爷类，数据成员：获得的对葫芦娃排序的“智慧”、对外提供调用他的智慧的接口

##### 5：接口`Wisdom`

​	管理世界中存在的智慧即通用的思想方法的接口，比如排序、统计等等

##### 6：`Sort_orchestration类`

​	对Wisdom接口中排序思想的实现类

##### 7：`Sort_choreography`类

​	对Wisdom接口中排序思想的实现类

##### 其他：

​	使用了`ArrayList`存放葫芦娃引用，利用`import java.util.Random`生成随机数打乱葫芦娃的位置顺序

### 二：面向对象编程思想

##### 1：封装

​	封装了葫芦娃类、爷爷类、Being类、World类等，每个类的数据成员访问权限为private，封装了数据和对数据操作的方法，对外仅提供调用的接口。

##### 2：继承

​	爷爷类和葫芦娃类继承了存在类Being类。

##### 3：多态

​	待拓展，可以根据进一步要求在Being类添加一些新的方法比如走路等，葫芦娃类和爷爷类根据自己的情况比如走路的速度不同重新定义走方法，将爷爷对象或葫芦娃对象引用复制给Being类，运行时会动态绑定，根据Being引用指向 的对象类型调用各自实现的走方法。

##### 4：接口

​	Wisdom接口，Wisdom接口中有抽象Sort_Wisdom方法，`Sort_orchestration与``Sort_choreography`根据排序方法的不同实现了Sort方法。

##### 5：构造器	

​	各个定义的类都定义了构造器

```
GrandFather()
{
    name="爷爷";
    sort_calabash=new Sort_choreography();
}
    World()
    {
        brothers=new ArrayList<CalabashBrothers>();
        CalabashBrothers Eldest =new CalabashBrothers("老大 ",0);
...
    }
    Being()
    {
        name="";
    }
    Being(String its_name)
    {
        this.name=its_name;
    }
        CalabashBrothers()
    {
        rank=0;
        this.name="";
        sorting=new Sort_orchestration();
        count++;
    }
    CalabashBrothers(String name,int age)
    {
        this.name=name;
        this.rank=age;
        sorting=new Sort_orchestration();
        count++;
        System.out.println("count="+count);
    }
```

##### 6：静态变量

葫芦娃类定义了一个静态变量计数出生的葫芦娃的个数

```
static int count;
```

##### 7：静态块

初始化葫芦娃的数量

```
static {
    count=0;
}
```

##### 8：包

```
package cn.edu.nju.java;
```

##### 9：修饰符

对外公开的接口用public修饰，子类可用的接口用protected修饰，仅自己可用的方法和数据成员用private修饰



### 三：类图

![](http://www.plantuml.com/plantuml/png/XLDDRy8m3BtdL-HO9hL_80WnaBOB9tRWM8KsjD6QfdB24Dhuxyj7AOOmZGCnVdxlsKvO6il17bL7P6y577Wbw4wQMYloJRwqhEc71bkUGYgRCN8XfEguCI6_rahnlhwMLgq6eHlWGtlEYg9mvJG06gfM60lSIjsFo0Nfb7S5JeucrYE9OXRs-vCq6Rs3Q_MDsrQ0AquLg0aPtl4zDoqZcE0ddzJlPNSQEh-1Lm1-taXZv-jHOWNQSys2xiU84QH96nyVGim8MYUjuid8rdrhHI4SZ0IhgPK1t9MLdNFCPcGuxZjPqG14rYO0x8eOo-srG77PP-WALaBsJTY91HVHdYl1I4pxkXYCeBIcz0M8_pYmbt8Vrvvl_PE5N-azXuKxoO0d8jwOuh6S01x8gpV2Rft1j19puaCS32zw_fFdSSH7ZnkIleOyrtTF9ktVbwIpa_ZtyT8f1O7f2uxtIr_o7FjEIVH2Rid47bNHebZyXsEdT0bF5H3b6RmKVNrKtIy0)

### 四：结果

```
count=1
count=2
count=3
count=4
count=5
count=6
count=7
Before orchestration:
老七 老五 老大 老六 老四 老三 老二 
After orchestration:
老大 老二 老三 老四 老五 老六 老七 
Before choreography:
老大 老四 老五 老三 老七 老六 老二 
After choreography:
老大 老二 老三 老四 老五 老六 老七 

Process finished with exit code 0
```

