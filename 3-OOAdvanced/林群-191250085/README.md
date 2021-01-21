# 作业：面向葫芦娃编程
---
## 类的创建 
**所有的类保存在包`cn.edu.nju.java2020.lq.homework03`中**

类`Huluwa`：保存葫芦娃对象  
数据职责包括：每个葫芦娃的排名`order`：1~7的整数，每个葫芦娃的名字`name`：String类型数据   
行为职责包括：每个葫芦娃可以进行报数，可以和另一个葫芦娃进行排名的比较，可以和另一个葫芦娃交换在队列中的位置

类`Grandpa`：用于创建Grandpa的实例  
行为职责包括：比较两个葫芦娃之间的排名大小，交换两个葫芦娃在队列中的位置  


类`HuluwaSort`：保存主方法入口
数据职责有：保存设定队列长度的私有静态变量`lengthOfQueue`，保存葫芦娃名字的静态String类数组`huluwaName`      
行为职责有：提供队列初始化方法`initialize()`，实现程序入口`main()`

### 使用多态的思想实现排序：
类`SortAlgoritmByPolymorphism`：作为所有排序算法的父类，保存有用于子类覆写的方法`orchestration()`和`choreography()`

类`BubbleSortByPolymorphism`：继承类`SortAlgorithmByPolymorphism`，用于实例化排序算法

类图如下：    
![Polymorphism](http://www.plantuml.com/plantuml/png/lLBBRjim4BplLn3fnO5DmNLlGL6aGO7sr0To379OIskI2SbLA3AkgzhVNZqKDrLWeQVeGf4pipCOx6KLCSJaB9IOtwCYSPRxZ8gK-RkKtU4ZhfQhPMOVCisEjXpkb-_En9jFtLT3Rh6gn9TaqnP53P93GK5S2ECZI8-Ecl_h68nNCEzPimOI7Mqn8ABbdSF19xUcC3jl98zi2ZZax4eCD1l6w-veuJMp9VHmgBPOZk51lH-oVGxeYn95VMBUsuNuvxvwQJ3D7piEy3M7s3PYoQkelsr-94hqr4ml_VgydvjRaCQRQD2QNpHutjoAXrPtz9WxD7xsmh8r-sWL1nErkzfzPxjp74fjAYTgc7F8DLKnO3JiHwCNnuPKV_xroZK7ukQvrBjne7e_pd2LrcjBRP9N3Y3xnU7DvbHhUu0d3vPIzAm6HAK2gIuKd8mlvUyFamLV2FePoHSLJB7UPzcppJZcQPydPD1B_fCsDjd39VaYEVi7)

### 使用接口的方法实现排序：
接口`SortAlgorithmByInterface`：作为排序算法的接口，保存有用于实现的方法`orchestration()`和`choreography()`

类`BubbleSortByInterface`：实现接口`SortAlgorithmByInterface`

类图如下：   
![Interface](http://www.plantuml.com/plantuml/png/lL9BRzD04BxFhrYLIwh4gn1k25MbGW8k8DHZrSF4dgottOSxtcrKGlBRyVhX5Ak-uilQ-kPx-9kzhWDoYDP0XVaZAX8NkPDKHEaUedp0PzoiDsjfdcJfBUqzFwu_N8XtNzhd0Bd1kXRVeebx50V8F1V4ugFGBa3cq5BpVXjOEmNBRchHGA8TM_M8I7ENS7BHReaNbmtbsUi2Jhct5J8jUlcoFHAyzTuGEZZLUwocSCy-zjc-ChgYQiBDwBrVYN--DpC6i_DJnnw-zHnI8uQS2kNFtQz8aOPcEkgFr_tStKEcdGuQZVuzPBox5q-9DteiBMgtU6NPo17lC2UH33yRvLc7qjwyV1-10omzvoNLWJ5exoRQgx4YrPrdixpqJ5unLkNBDD7XEFtlcxZT6aen_gTxrbqRlzlDTNO463nyblNhQK1KYacreU3jx5B-kPhjDUtILeOikL33UUaDw-hjBiOOdwISbOKv8EaEuJkxJkZi34Uu9bT4Q_u2)



## **orchestration**的方法：  
实例化对象`Grandpa`，作为葫芦娃排队的指挥官。它的行为职责有：比较当前的两个葫芦娃的排名大小，交换这两个葫芦娃在队列中的位置。采用冒泡排序算法，每次由爷爷对葫芦娃的排名进行比较，交换位置，以完成排序。

## **choreography**的方法：  
葫芦娃之间通过协作完成排序。这里采用了冒泡排序算法，每个葫芦娃可以通过调用`compare()`方法，判断自己和另一个葫芦娃的排名谁大谁小，然后通过`swap()`方法（如果需要的话），交换与另一个葫芦娃在队列中的位置，实现排序。    

## 排序算法的替换
编写新的排序算法，可以继承`SortAlgorithmByPolymorphism`类，用多态的方法实现，或者实现接口`SortAlgorithmByInterface`
