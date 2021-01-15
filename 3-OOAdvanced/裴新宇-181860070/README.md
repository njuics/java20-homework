# 面向葫芦娃编程

学号：181860070

姓名：裴新宇



### PlantUML 类图

![](http://www.plantuml.com/plantuml/png/bL71JiCm33stNn7jr6biNy1XqYJWCd7O4Q7Af5vRqIILcp2XiN_7nKkthXmWjppRxptxhJiFv8DfqXRqEvIePWT7JR7IXE03uKmTqoJH3NITsfonOwhu9SbYvwcsfR9WC4An9vjFa1tvs3rdpjF0-qXWYmVm5T90tJdosLDemW5UNiVjWh8jVilQUcM3aJ7vEYgG8eyqPumFXlgU4dtEOza4_1cESDnGsi78LemhjVXmTQ6wE34IY2KP4OfnKRjWUNA_loYzETSWM2wP5WZFj6B_Xla0xKrPpXClhUw_baibjGbyTUpqT9jwVtL9dFT1seD6jMDiYxvoHHzEChXWEBiYk_izh4tb25r9q5QV4kxV29A1uPbqXPqdyBMp_wMucEVjLwkHdMbvhCNd4GTRg5auYXh-dKCL8O5rVsNCUpFEv40ndEiUHlDBz4ETXTPeYs2QRm00)



### 运行入口：Main.java

main 操作过程：

- 创建七个 Huluwa 对象，调用 create_random_arr() 方法随机排序，形成队列 arr
- 创建一个 Orchestartion 对象，调用该对象的 sort() 方法对 arr 排序。
- 调用 arr_count_off() 方法输出排序结果。
- 调用 create_random_arr() 方法随机排序，形成队列 arr
- 创建一个 Choreography 对象，调用该对象的 sort() 方法对 arr 排序。
- 调用 arr_count_off() 方法输出排序结果。



### Orchestration 方法：

 调用 GrandFather 对象的 sort() 方法，直接对 arr 进行冒泡排序



### Choreography 方法：

冒泡排序，每次调用 Huluwa 对象的 compare_order() 方法比较其与相邻兄弟的顺序，然后调用 swap_order() 方法进行交换。



### 继承与多态

- 父类：Creature
- 子类：
  - Huluwa
  - GrandFather



### 接口

- 接口：SortMethod
- 成员 sort()，被类 Orchestration、Choreography 实现。



### 包

- world.sort：接口 SortMethod、类 Orchestration、Choreography 
- world.creature：类 Creature、Huluwa、GrandFather

