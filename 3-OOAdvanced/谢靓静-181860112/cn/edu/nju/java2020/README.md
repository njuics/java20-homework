# homework3 OOAdvanced

### 1. 设计思路
本次作业在homework2三个模块的基础上增加了CartoonCharacter模块和Sort模块，进一步强调了面向对象程序设计封装、继承、多态等特性，并使用到了Java中的接口、抽象类、构造器、静态变量、静态块、包、修饰符等语言机制。<br>
### 2. UML图
![UML](http://www.plantuml.com/plantuml/png/dL3BRi903BplLrZq4aH1Y2z0vT2UUk5OzU1i71BOUADzG2N4lzT9bZP2hVf8f2YsPpmpNlk0BiJ6g1Rr0NS44yqBAkA2zt6nnoEkbglbvAmKvZuur06qGUzX8pHhULDXroG7PmNot6s3gta7Z0trZTajC1iXfkgYLCtIBL4JRAqBQS_HrWLugRDR_iihwEk_dweUNL29qOJ4gc9P6lg9ACf3agTe8j1R82w-Y5KthQ66EFYnlLb76YUv1ua13lam7G2_3Z12dx3DUZULV4wOPad5KIlRdaKhIuFSMaF8e6tJegE1cbZpVcCUyznGvxiVYdAt-S7PK7repw_6Fo_oA6NHuf-FadZPVqum7z1aI8VQylUUB_AkYOlOc7S0) <br>
### 3. 模块说明
所有模块代码被置于包cn.edu.nju.java2020中。
* CartoonCharacter模块(CartoonCharacter.java):被声明为一个**抽象类**，作为访问所有动漫人物的公共接口。其中定义了其所代表的动漫人物的姓名，用protected**修饰符**修饰。同时定义了**构造器**用于赋初值。
```java
public abstract class CartonCharacter {
    protected String name;
    CartonCharacter(String name){
        this.name = name;
    }
}
```
* Sort模块(Sort.java):被声明为**接口**，为对传入的CartoonCharacter对象数组进行序列操作的接口规范。包括abstract方法sort，用于将传入对象按升序排列。default方法shuffle，用于随机打乱序列。
```java
public interface Sort {
    void sort(CartonCharacter[] characters);

    default void shuffle(CartonCharacter[] characters) {
        List huluList = new ArrayList();
        for (int i = 0; i < characters.length; ++i) {
            huluList.add(characters[i]);
        }
        Collections.shuffle(huluList);
        for (int i = 0; i < huluList.size(); ++i) {
            characters[i] = (Hulu) huluList.get(i);
        }
    }
}
```
* Hulu模块(Hulu.java):**继承**自CartoonCharacter类，实现了Sort接口。定义了compare和swap方法，用于模拟葫芦娃在以**choreography方式**排序过程中的比较和交换位置过程。定义了bubbleSort方法，在sort方法中调用，模拟以choreography方式排序过程。如果要更改排序函数，只需要在sort中将bubbleSort替换为所需算法，若更改排序策略，只需要定义新的compare函数，保证了**更改代码量最小**的原则。
```java
public class Hulu extends CartonCharacter implements Sort {
    @Override
    public void sort(CartonCharacter[] characters) {
        if (characters.length <= 0) return;
        if (!(characters[0] instanceof Hulu)) return;
        bubbleSort((Hulu[]) characters);
    }

    public Hulu(String name, int rank) {
        super(name);
        this.rank = rank;
    }

    public void swap(Hulu huluwa) {
        int tempRank = huluwa.rank;
        String tempName = huluwa.name;
        huluwa.name = this.name;
        huluwa.rank = this.rank;
        this.name = tempName;
        this.rank = tempRank;
    }

    public String reportName() {
        return name;
    }

    public boolean compare(Hulu a) {
        return this.rank > a.rank;
    }

    private void bubbleSort(Hulu[] huluBrothers) {
        for (int i = 0; i < huluBrothers.length - 1; ++i) {
            for (int j = 0; j < huluBrothers.length - 1 - i; ++j) {
                if (huluBrothers[j].compare(huluBrothers[j + 1])) {
                    huluBrothers[j].swap(huluBrothers[j + 1]);
                }
            }
        }
    }

    private int rank;
}
```
* Grandpa模块(Grandpa.java): 与Hulu类相似，继承自CartoonCharacter类，实现了Sort接口。定义了selectonSort方法，在sort中调用，模拟了以**orchestration方式**排序过程中，爷爷指挥葫芦娃站队的过程。
```java
public class Grandpa extends CartonCharacter implements Sort {
    @Override
    public void sort(CartonCharacter[] characters) {
        if (characters.length <= 0) return;
        if (!(characters[0] instanceof Hulu)) return;
        selectionSort((Hulu[]) characters);
    }

    public Grandpa() {
        super("爷爷");
    }

    private void selectionSort(Hulu[] huluBrothers) {
        for (int i = 0; i < huluBrothers.length - 1; ++i) {
            int min = i;
            for (int j = i + 1; j < huluBrothers.length; j++) {
                if (!huluBrothers[j].compare(huluBrothers[min])) {
                    min = j;
                }
            }
            huluBrothers[i].swap(huluBrothers[min]);
        }
    }
}
```
* Main模块：定义了**静态变量**Hulu类型数组和Grandpa类型变量，在**静态块**中初始化。定义了两个**静态方法**sortBy和countOff分别用于对葫芦娃队列排序和葫芦娃报数。其中，sortBy方法强调了**多态**的运用，要求传入CartoonCharacter类型(抽象类)的参数，实际调用哪个sort方法将**动态绑定**，由实际传入的参数类型决定。
```java
public class Main {
    private static Hulu[] huluBrothers;
    private static Grandpa grandpa;

    static {
        huluBrothers = new Hulu[]{
                new Hulu("老大", 1), new Hulu("老二", 2),
                new Hulu("老三", 3), new Hulu("老四", 4),
                new Hulu("老五", 5), new Hulu("老六", 6),
                new Hulu("老七", 7)
        };
        grandpa = new Grandpa();
    }

    public static void main(String[] args) {
        System.out.println("【以orchestration方式排序】");
        sortBy(grandpa);
        System.out.println("【以choreography方式排序】");
        sortBy(huluBrothers[0]);
    }

    private static void sortBy(Sort s) {
        s.shuffle(huluBrothers);
        System.out.print("排序前：");
        countOff();
        s.sort(huluBrothers);
        System.out.print("排序后：");
        countOff();
        System.out.println();
    }

    private static void countOff() {//报数
        for (int i = 0; i < huluBrothers.length; ++i) {
            System.out.print(huluBrothers[i].reportName() + " ");
        }
        System.out.println();
    }
}
```
### 4. 运行结果
        【以orchestration方式排序】
        排序前：老三 老七 老六 老大 老二 老五 老四 
        排序后：老大 老二 老三 老四 老五 老六 老七 
        
        【以choreography方式排序】
        排序前：老二 老七 老五 老六 老大 老三 老四 
        排序后：老大 老二 老三 老四 老五 老六 老七 
### 5. 总结
程序通过定义Sort接口和抽象类CartoonCharacter，并设计合理的继承和实现关系，进一步提高了代码的抽象性。在此基础上，通过在Main类中sortBy方法的运用，体现了使用多态特性给程序设计带来的优雅性。综合运用了面向对象程序设计的静态变量、静态块、包、修饰符等机制，使代码提供了更加良好的封装性。
