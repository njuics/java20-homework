共有三个代码源文件：`HuluTestCase.java`,`HuluTestJunit.java`和`HuluTestRunner.java`

其中`HuluTestCase.java`在第八次作业的基础上修改得到，其创建了一个容器来存储`Hulus`类的“葫芦娃“对象，该容器可以根据名字的字典序来进行正序/倒序/不变的排序，且可以将男/女性别分开；其中`run(int huluCnt,String[] huluName,int[] huluGender,int sortGender,int sortType)`是对外测试接口，参数列表分别表示葫芦娃个数，葫芦娃各自名字、性别以及需要排序的性别（男/女/全部）和排序类型（正序/倒序/不变），返回值为所求排序（名字）的字符串数组

>sortGender=0表示男，1表示女，2表示全性别
    sortType=0表示正序排列，1表示倒序排列，2表示原样输出

而`HuluTestJunit.java`作为测试类，导入了`org.junit.Assert`和`org.junit`相关包内容，在每次测试开始和结束时都会利用`Before/After`输出提示信息，测试方法共七种，从`test1()`到`test7()`，其中会比较`HuluTestCase.run()`返回值与期望答案，若不同则断言出错，向上一层返回出错结果

`HuluTestRunner`作为最终的运行测试类，其使用`JUnitCore.runClasses()`来对`HuluTestJunit`中的类进行运行，并将结果存在`result`中，如果出错，则会将对应的`Failure`类型对象按顺序输出，最终输出测试是否成功true/false
