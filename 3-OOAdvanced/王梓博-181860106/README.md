# 第三次作业



uml 类图：

![avatar](http://www.plantuml.com/plantuml/png/pL8zZ-8m5EppArm62LVNNi41qa431ULgYnV795vYE_8726NptnV7mZW45hJRa2BWcPV9lCbCj05bBA_GUlqltuF8QPuaDP0T51GjB0VH9EXqaGgqHZEe80DTJkNHmVx2k5Pi3uPY7B2DKKmKI02d0MF2eEKy7BK1mqY72ijZDPjLZ61yFUbnj9SiHuhMKfcLvUaeZ7a-zfX6DiR-zODn1nVKBET39V-qOrSdWG4VEncIcPGL1O48hzF84igKl2sa3p2O_D5oRH9ziVyAH5v3ywmz6FSiF6VrxHsHoqbtRbXt_xWZu2AxBn3sQ2zTt4Xb_1Rktr8OghP0wDzFZ1qm1Kq3wmwEc9LIKLaegClZW5mhKb9j51WcHSUoisZ_5Stj5KgxtLRquHQ3lbZnNNJd3uOA__jyVezLskuEcLkQ65-G4CdljcoZoiMfDw-PWJVQQy3hENNjNqXE3rBj_Y2CvNdk2esKhvcu_tsgt_x41n96V1WSc4X7piQ4YjpowWi0)

本次作业在上次作业的基础上进行改进，首先是将原先放于同一个  .java 文件中的类取出，为每个类创建一个文件，然后再引入以下语言机制：

### 包

由上述类图可见，我将葫芦娃类 CalabashBoy 和爷爷类 Grandpa 划归包 Human，将接口 SortInterface，抽象类 SortBase 和两种方式实现排序的类 Choreography 和 Orchestration 划归包 Sort，然后在主类 Homework3 中引入这两个包中相应的类。



### 接口

将 Choreography 和 Orchestration 两种方式向外的接口进行统一如下：

~~~java
public void shuffle(CalabashBoy[] calabashBoys);
public void run(CalabashBoy[] calabashBoys, Grandpa grandpa);
public void sort(CalabashBoy[] calabashBoys, Grandpa grandpa);
~~~

并将其定义为接口 SortInterface。



### 抽象类

由于 Choreography 和 Orchestration 两种方式实现对葫芦娃排序都需要先将葫芦娃打乱，用到同一个 shuffle 方法，因此我引入一个抽象类 SortBase，在实现了 shuffle 方法，后续 Choreography 和 Orchestration 两类均继承改抽象类，也能实现对多态的运用。



### 多态

由于 Choreography 和 Orchestration 两类均继承于 SortBase，因此可通过父类引用指向子类对象，实现运用多态完成对两类的 run 方法的调用。

~~~java
SortBase[] sort = new SortBase[]{
    new Orchestration(),
    new Choreography()
};
for(SortBase s:sort){
    s.run(calabashBoys,grandpa);
}
~~~



### 构造器

在完成第二次作业时已经实现在葫芦娃类 CalabashBoy 中利用构造器实现对葫芦娃赋名字及编号的作用，同时将静态变量 num 递增，表示当前生成的葫芦娃数加一。

~~~java
public CalabashBoy(String name,int ID){
    this.name = name;
    this.ID = ID;
    CalabashBoy.num++;
}
~~~



### 静态变量、静态块

为了引入这两个语言机制，我在葫芦娃类 CalabashBoy 中引入了一个用于记录当前生成的葫芦娃总数的静态变量 num，将其初始化为 0，并在构造函数中将该变量递增。同时，设置一静态函数 reportNum 用于汇报当前生成的葫芦娃数。

~~~java
static int num;
static{
    num=0;
}
static public void reportNum(){
    System.out.println("一共有" + num + "个葫芦娃");
}
~~~



### 修饰符

* 将葫芦娃的姓名、编号设置为 private，表示葫芦娃的姓名和编号不可以由其他人修改
* 将葫芦娃的构造器设置为 public，否则主类在生成葫芦娃时会发生错误