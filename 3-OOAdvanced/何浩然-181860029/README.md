# java20-homework
3-OOAdvanced:

1.我设了一个主类Main，一个父类Creature（表示生物）以及它的两个子类Human与Huluwa，然后还有一个专门用于排序的接口Sorting。
2.父类creature指的是生物，是所有物种的抽象，而human子类指的正是人类，huluwa子类指的正是葫芦娃，这用race的静态变量来表示种族。用静态块在两个子类中指定它们的种族类型。
3.这里用到了两种排序方式，orchestration和choreography两种形式，所以就将两种排序抽象为一个sorting接口，然后由human类和huluwa类来implement这个接口，并在这两个类中来实现sort这个抽象方法
4.然后在Main类中定义people，作为human子类的对象，并命名为爷爷；定义huluwa[7]这个huluwa子类的对象数组来表示7个葫芦娃。然后调用两个排序算法。
5.类图代码：
@startuml test
interface Sorting {
sort()
}
class Creature{
    name
    race
    range
    pos
}
class Human{
    sort()
}
class Huluwa{
    sort()
}
 
Creature <|-down- Human: is a
Creature <|-down- Huluwa:is a
Human ..|>Sorting
Huluwa ..|>Sorting
@enduml

URL:http://www.plantuml.com/plantuml/png/ROz1geD044JtVOfQ9WizW8GWP9DzJj1eHuIn3TCzkD3SFUB4y1F-xZ5lgfggpJbw6W9SpAbNbtZdHd0Re_VQOIPRwN2a9pM1pN29mfwYp0G0oeDi4BdPGRjCZz4-gMiQM7Caz_qn8Ktyeq3x6PoMeXqdBN95XTx0_zXSKsrs-ucoNCxl5PJjrrCjsgwxNm00