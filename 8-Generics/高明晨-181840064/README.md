## 泛型作业  
---
###  泛型目标
#### Family类泛型  
在上一次作业，实现迭代器排序的基础上，将Family类（即储存葫芦娃的容器）改写为泛型的形式：  

    public class Family<T extends Character>
  
其中Character类为Huluwa类的一个抽象基类，加上该类后，可以约束泛型的类型选择，也可以抽象出泛型的一些方法，以供在Family类中使用。  
具体来说Character类：  

    abstract public class Character implements Comparable<Character>{
        abstract public String getName();

        abstract public String getGender();
    }
      
从而在Family类中，泛型T就可以调用getName(),getGender()和compareTo(Character)方法。  

#### 为什么泛型要继承Character
由于Java的泛型不是真正的泛型（将泛型符号T替换成对应的类型），存在类型擦除，所有如果不限定其基类，则在Family中，无法调用Huluwa类中的相应方法（即使我们知道实例化的结果就是Huluwa类），也就无法完成相应的任务。故而，我们需要在Family中调用的Huluwa类方法抽象出来，成为Huluwa类的基类Character，并令\<T extends Character\>,这样才可以在Family中使用Huluwa类（严格意义上是Character类）的方法。  

---
###  代码的修改
除了上述的为Huluwa类添加了Character基类外，由于要实现Family泛型类的迭代器排序，故而将原先只适用于Huluwa类比较器HuluwaAscendingComparator和HuluwaDecendingComparator改写为基于Character基类的比较器CharcaterAscendingComparator和CharacterDecendingComparator，以供Family类中排序使用。  

---
### 使用泛型的好处
将Family改写为Family\<T extends Character\>最大的好处，就是实现了代码的复用。比如将来如果要实现蛇精、蝎子精的排序，只需要实现继承于Character类的蛇精、蝎子精类，再使用Family\<蛇精\>、Family\<蝎子精\>实例化，就可以实现当前Family代码对Huluwa类的所有功能。这也是一种抽象的体现。  
使用泛型的第二个好处，就是可以在编译期检查类型的安全，减少强制类型转换的不安全因素。在此例中，只要满足Family可以实例化的要求，成功通过编译，即类型继承于Character，就可以保证该类型一定可以进行成功的排序等，而不是会在运行期间发生错误。