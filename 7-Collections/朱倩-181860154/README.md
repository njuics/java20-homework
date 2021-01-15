# 7-Collections

## 一、类的设计

**HuLuWa.java：**

1. **HuLuWa类**

   数据成员：name（名字），gender（性别）

   方法：

   ```java
   HuLuWa(String name, Gender gender);//构造函数
   public static HuLuWa getNewHuluwa();//返回新生成的葫芦娃，名字性别随机
   public String getName();//获取葫芦娃名字
   public Gender getGender();//获取葫芦娃性别
   public String toString();//override
   ```

2. **枚举类型Gender**

   表示性别，包含MALE、FEMALE

3. **AscComparator类**

   用于升序排序，重载compare()函数

4. **DescComparator类**

   用于降序排序，重载compare()函数

5. **RandomComparator类**

   用于乱序排序，重载compare()函数

   

**Control.java:**

​	**Control类**

​		包含main函数，用于演示排序过程

​		方法：

```java
private static void initQueue(List<HuLuWa> queue, int num);//构造葫芦娃队列，num表示队列中葫芦娃总数量
private static void printQueue(List<HuLuWa> queue);//打印葫芦娃队列
private static void sort(List<HuLuWa> queue);//对葫芦娃进行排序
public static void main(String[] args);
```



## 二、运行结果

在`java20-homework\7-Collections\朱倩-181860154`目录下运行如下指令：

```
javac -encoding UTF8 cn/edu/nju/zq/homework7/*.java

java cn/edu/nju/zq/homework7/Control
```

输出结果：

```
Original queue:
zimr(FEMALE)  yh(FEMALE)  az(FEMALE)  g(MALE)  unxu(MALE)  hpy(FEMALE)  vnkqc(FEMALE)  ahtrk(MALE)  mf(MALE)  x(MALE)  
----------Total sort----------
After sorting in ascending order:
ahtrk(MALE)  az(FEMALE)  g(MALE)  hpy(FEMALE)  mf(MALE)  unxu(MALE)  vnkqc(FEMALE)  x(MALE)  yh(FEMALE)  zimr(FEMALE)
After sorting in descending order:
zimr(FEMALE)  yh(FEMALE)  x(MALE)  vnkqc(FEMALE)  unxu(MALE)  mf(MALE)  hpy(FEMALE)  g(MALE)  az(FEMALE)  ahtrk(MALE)
After sorting in random order:
zimr(FEMALE)  yh(FEMALE)  x(MALE)  vnkqc(FEMALE)  unxu(MALE)  mf(MALE)  hpy(FEMALE)  ahtrk(MALE)  g(MALE)  az(FEMALE)

----------Male sort----------
After sorting in ascending order:
ahtrk(MALE)  g(MALE)  mf(MALE)  unxu(MALE)  x(MALE)
After sorting in descending order:
x(MALE)  unxu(MALE)  mf(MALE)  g(MALE)  ahtrk(MALE)
After sorting in random order:
unxu(MALE)  ahtrk(MALE)  x(MALE)  mf(MALE)  g(MALE)

----------Female sort----------
After sorting in ascending order:
After sorting in ascending order:
ahtrk(MALE)  g(MALE)  mf(MALE)  unxu(MALE)  x(MALE)
After sorting in descending order:
x(MALE)  unxu(MALE)  mf(MALE)  g(MALE)  ahtrk(MALE)
After sorting in random order:
unxu(MALE)  ahtrk(MALE)  x(MALE)  mf(MALE)  g(MALE)

----------Female sort----------
After sorting in ascending order:
az(FEMALE)  hpy(FEMALE)  vnkqc(FEMALE)  yh(FEMALE)  zimr(FEMALE)
After sorting in descending order:
zimr(FEMALE)  yh(FEMALE)  vnkqc(FEMALE)  hpy(FEMALE)  az(FEMALE)
After sorting in random order:
zimr(FEMALE)  yh(FEMALE)  vnkqc(FEMALE)  hpy(FEMALE)  az(FEMALE)
```

