## 一、程序结构及类描述  
* 本程序的主类为LineUp类，类中包含静态数据成员model，huLuWa，sortModel,并且使用静态块对其进行初始化。其中，model为程序思想的选择，为1表示使用orchestration思想，为2表示使用choreography思想；huLuWa数组存储7个葫芦兄弟对象的引用；sortModel用于选择使用的排序算法，本次作业我实现了冒泡排序与快速排序两种排序方式，sortModel为1时使用冒泡排序，为2时使用快速排序。因此，对于不同实现思想以及不同排序算法之间的切换，只需要修改LineUp类中成员model、sortModel的值即可，可见改动很小；类中包含方法shuffle()用于实现葫芦兄弟的打乱，sort()方法用于实现葫芦兄弟之间协同排序，outPut()方法实现按照队伍中顺序报数。
* Creature类为抽象类，描述每一个生物的基本特征，它是HuLuWa类和YaoJing类的基类，包含到此次作业为止生物的基本特征name和Position。name表示生物的名字，这两个特征均被声明为protected类型，在后面的作业中不仅每一个葫芦娃有自己的名字，例如"老大""老二"...，每个妖精可能也有自己名字，例如"蛇精"...。Position表示生物的位置，因此提供了抽象方法setPosition()与已有基础实现的getPosition()方法来设置和获取position的值，在继承类中可以覆盖setPosition()方法。
* HuLuWa类继承自Creature类，描述每一个葫芦娃的特征，在基类基础上新增的数据成员rank表示葫芦娃在兄弟中的排行，1表示老大...以此类推；我覆盖了setPosition()方法使得葫芦娃的移动情况可以输出，使排序过程中葫芦娃的移动情况更明确。swap()方法用于实现葫芦娃之间的交换位置。
* YaoJing类继承自Creature类，描述每一个妖精的特征，到本次作业还不知道其余的特征和方法，因此只是定义出来并覆盖基类的抽象方法setPosition()。
* GrandFather类描述爷爷的特征，类中包含数据成员huLuWa数组，看作是七个葫芦娃属于爷爷；类中实现的方法均可以看作是爷爷向葫芦娃发出的指令，setHuLuWaPosition()方法可看作是爷爷要求指定葫芦娃移动到指定位置，getHuLuWaPosition()为爷爷要求指定葫芦娃报数；shuffle()为爷爷要求葫芦娃随意打乱顺序，bubbleSort()与quickSort()为爷爷要求葫芦娃按照某种排序方法排序。GrandFather类并没有继承Creature类，这是因为爷爷这个对象与其他Creature对象的耦合度几乎为0，与葫芦娃、妖精基本没有共同的特征。
* 程序的执行从LineUp类中的main()方法开始，在main()函数中首先创建了七个葫芦娃对象，如果使用orchestration思想，则创建一个GrandFather对象，并在创建时将葫芦娃对象设置属于GrandFather对象，之后由GrandFather对象向葫芦娃发出打乱、排序指令；如果使用choreography思想，则调用sort()方法实现葫芦兄弟之间协同排序。
  
***
### 面向作业七的修改  
* 为HuLuWa类增加属性gender(int)表示葫芦娃的性别，且为了能够按姓名的字典序排序，将作业一的命名改为“TheFirst”、“TheSecond”...，以此代替之前的“老大”、“老二”...；此外，葫芦娃类实现了Comparable接口，重写了compareTo()方法以满足能够将葫芦娃按名字的字典序排序(在HuLuWa类中加入域nameOrderModel用于确定按字典序的正序还是反序，0为正序，1为反序).
* 使用ArrayList容器来存放待排队的葫芦娃，且使用泛型机制保证容器中只能放入葫芦娃对象而非其他对象。
* 在LineUp类的main方法中我们首先设置huLuWaNum的值，以确定要随机产生多少葫芦娃(修改其初始值即可)；之后随机产生huLuWaNum个葫芦娃，每个葫芦娃的性别随机产生，其排行也随机产生(1-7)，并根据其排行确定其名字(由于葫芦娃动画片中仅7种葫芦娃，因此随机产生7种葫芦娃，允许同一种葫芦娃有多个)，并将它们加入容器huLuWa，并且根据其性别加入容器maleHuLuWa或femaleHuLuWa容器(实现按照性别分两队再按姓名排序)；由于HuLuWa类实现了Comparable接口，因此可利用Collections类的静态方法sort直接对huLuWa容器排序。

***
### 面向作业八的修改 
* 使用ArrayList容器来存放待排队的葫芦娃，且在创建的时候使用确定的类型参数HuLuWa保证容器中只能放入葫芦娃对象而非其他对象(Creature对象、YaoJing对象)。
* 修改HuLuWa类使其不再实现Comparable接口，创建包Package.MyComparator,在其中定义了两种比较器OrderCreatureComparator、ReversedOrderCreatureComparator，它们的类型参数均定义为\<T extends Creature\>，前者按照name属性升序排列，后者按照name属性降序排列，这样的好处是这两个比较器可以用于任何Creature对象按照name属性比较，包括HuLuWa对象、YaoJing对象(如果后续需要)，增强了代码的复用性，而且之后不需要修改YaoJing类也可以实现对YaoJing对象的排序。

***
### 面向作业九的修改
* 新增了测试类HuLuWaTest类，用于测试HuLuWa类与GrandFather类的主要方法是否正确。在HuLuWaTest类中定义了静态成员firstHuLuWa、secondHuLuWa用于测试HuLuWa类中的setPosition()方法与swap()方法；定义了静态成员grandFather、HuLuWa类的容器huLuWa用于测试GrandFather类中的shuffle()方法与sort()方法。
* 在HuLuWaTest类中定义了方法beforeAllTest()在所有测试方法开始执行前执行；定义方法afterALLTest()在所有的测试方法结束之后执行；定义方法beforeOneTest()在每一个测试方法开始之前执行；定义方法afterOneTest()在每一个测试方法结束之后执行；testSetPosition()方法用于测试HuLuWa类中的setPosition()方法；testSwap()用于测试HuLuWa类中的swap()方法；testSort()用于测试GrandFather类中的sort()方法。

***
### 面向作业十的修改
* 实现了对葫芦娃的自动构建:工程名为HuLuWaSortOne.在src\main\java\cn\edu\nju\目录下为此前几次作业的葫芦娃源代码，且为了满足maven自动构建对文件路径的要求，对此前的代码的包名进行了微小的修改;在src\test\java\cn\edu\nju\目录下为此前作业编写的测试代码HuLuWaTest.java;maven工程构建的jar包位于target\目录下;在与src文件夹同级的文件目录下编辑了文件pom.xml并在其中定义了maven工程的各种配置。
* src\main\java\cn\edu\nju\目录下的MyClassLoaderTest.java文件为此前作业实现的自定义的类加载器，其中需要使用第三方jar包commons-codec-1.15.jar，因此在pom.xml文件中添加依赖如下：
```xml
<dependencies>
  <dependency>
    <groupId>commons-codec</groupId>
    <artifactId>commons-codec</artifactId>
    <version>1.15</version>
    <scope>compile</scope>
  </dependency>
</dependencies>
```

## 二、解决思路
* 本次作业用到的面向对象的思想如下。   
  1. 聚合思想：在orchestration思想的实现中，可以将葫芦娃看作是“属于”一个GrandFather对象，GrandFather对象通过setPosition()等接口向指定葫芦娃对象发出指令，要求其移动或者报数，并在此基础上实现冒泡排序与快速排序方法。
  2. 继承和多态思想：创建类Creature来刻画生物共有的特征名字和位置，并提供基础的方法setPosition()等。葫芦娃在基类的基础上新增属性rank以及方法swap()等，并且覆盖setPosition()方法，在程序运行时会根据对象的实际类型来调用相应的setPosition()方法。
  3. 其他：封装的思想体现在对成员变量进行修改时必须通过向对象发送消息来实现，且变量和对变量的操作封装在同一个类里面；另外，我认为此次作业可以不使用接口，因为目前为止只有葫芦娃和妖精之间有一定的耦合度，而这可以通过设置基类的方式很好的解决，这也符合优先使用类而不是接口的原则。
  4. SRP原则：GrandFather类的职责为控制葫芦娃的行为，包括打乱、排序；Creature抽象类刻画了生物的基本特征，YaoJing和HuLuWa类的指责都是刻画某种具体生物，LineUp作为主类控制程序的运行，显然是满足SRP原则。
  5. OCP原则：Creature类目前可以看作是稳定的抽象类，YaoJing和HuLuWa类通过扩展而不是修改Creature类实现对更加具体事物的刻画，体现了封闭原则；通过覆盖基类的抽象方法体现开放原则。
  6. LSP原则：YaoJing和HuLuWa类都是覆盖基类的抽象方法而不是已有具体实现的方法，并且增加适应于具体生物的方法实现扩展，显然满足LSP原则。
  7. DIP原则：YaoJing和HuLuWa类都是依赖于抽象类Creature，且程序依赖关系都终止于此抽象类，满足DIP原则。
  8. LoD原则：在GrandFather类的各方法中仅与其直接朋友HuLuWa类通信；在主类LineUp各方法中仅与其直接朋友HuLuWa类和GrandFather类通信，且每个类的成员变量均为私有类型，并且为访问成员变量提供了合理的接口，因此满足LoD原则。
* 在choreography思想的实现中，从老大开始，每个葫芦娃检查自己在队列中的位置与自己的排行是否一致(若老大排在队列中的第一位，则老大认为自己的位置与排行一致，以此类推)，若不一致，则葫芦娃通过自身的swap()方法与自己正确位置上的葫芦娃交换位置，显然这是各个葫芦娃协作进行排序且排序结果正确。

## 三、类图
<div align=center>

![avatar](http://www.plantuml.com/plantuml/png/bLHRIzn057xFhnZqPSLLqET5B48jebLqIodYmsnsDabDCkbaueMjiCLIUb7RIakXK5h1jbkabk93lRJuPtQpwrF_Gi_C99l1LQaGmintBdFEzvsPqP1ZnYFFDG9iBcABe9uPjHYSm4juZ17C8qPwKA_52F6hnfYBmn2bUDL0gDVnEGfew727-c8_nvdZMyZ77e4jVAbthWys_KlKAQEGy9aa92VYEV62591U0hGo9nMgCWlyDYG7RCr82heLJKPtiIXdS12rT-gjtUFswxtsyo_D-dhh_UDuQxkzi_7tzyPGOgizQkv-pJTEFiVVTri_J-AjEWH2z80ubs5_CLrRn2yJbkv4JzCCW2bQ9guXQb8dTvgOXTWyKeLAG5HwZRwLrp8ESYgnz13BpEf7NecmwKebfpCrBWjLK12LNCT4mc9IBy2C56cQBz1OkuVf1DHPbOqacrnNxVzPF6HDXIuy71X89EbWI83fYMa1uq1r-IRcDc5LmV4Dnl3gf1FoWeeUGRRAWf2IjlNq5toDFwUjD_N6uMRprOPIjtdyihN_BZvus_nnr15UuOcmieDIL2gvP8uoBeXIcW8zFEl9oOl__RvEo8F8CHTbX32uT5aws8vbIwgr3dJ5r79-GTFKZYeLbsJdWcRAI-SKEQ3YIdPwUBbJlbk2XAJuqr6ykHz2pN9CWI55rLdjMVpYsuMqGLXMQTfi9uCKD-cEWefQquOmWJDX5MmID2R73NFA2iMHgj6lZM2kYEXG7dx38bttUpErcWN3UyD8kMgOSafcoH9X8IdBcvVEK-QC2aL4LZZCV_OmmTa8NN6wIdpDX5TbpABLe5-IkillwjuKlSbbcNHySYT8thZ6uV6GkWQKcJO9ESDY1kBQXtZz80_MOMKrRSe8jHWEx5LbL59NGmu1vfeSHK-8h87Tzr0tQkeZArkhkjIfvwPBFBnGKlF9Tdomemm03GleTE-izb51tOLb4sXebkxxTCu2GHV0DE8pqKK63pj-ykhDBo3ChB3F0DxrWLVK6rhdEZmAan9vxZy0)