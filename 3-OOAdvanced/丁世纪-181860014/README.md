start hw3




I.使用的面向对象中的特性

封装
通过封装,限制不同类的对象间的交互更可控.例如Human对象的名字仅支持读取而无法修改.

继承
Grandpa和HuluBro继承Human,更好地复用了代码.

多态
多态是对象具有多种形态,例如gp是Human,也是Grandpa,gp继承Human的方法和变量,重写了部分特定的方法并复用了多数代码


II.使用的语言特性
接口
Communicate和Fight两个接口,被Human类使用

构造器
在初始化对象时自动调用,	
HuluBrother的constructor  HuluBrother(String s,int i)在构造的时候指定他的名字和序号

静态变量
葫芦娃的数量  HULU_NUM 在world类中给出,这样在七个葫芦娃还没全生出来(or来了第八个)时,只改动一处即可.
Human类的population

静态块
Human类中的static block用于统计总人数
Sort类的方法也是static,不需要创建对象即可调用



修饰符
public  所有类都可以访问  
protected 仅自己和子类可用,例如Human类的Speak和Ask2swap两个方法,Grandpa和葫芦娃都可以调用. Human的name也是protected,别的类只能get_name()读取而不能修改name.
private 仅同一类内可用,例如葫芦娃的rank定义为private的,外界仅能通过get_rank()获取而不能修改.

III.如何使用面向对象编程思想和抽象思维
1. 将需要完成的程序抽象为World和Human的交互,用一系列的变量和方法描述每个对象.
2. 首先World对象初始化各个Human对象,葫芦娃在Hulu[]中的位置即为他们在队列中的位置.两种排序分别调用葫芦娃和爷爷的排序算法.
3. 葫芦娃自行排序,考虑到现实,应为不需要额外空间,每个葫芦娃也不需要记录额外数据,仅采用各自向最前方冒泡的方法即可.而爷爷的排序则可以调用各种不同的排序算法.
