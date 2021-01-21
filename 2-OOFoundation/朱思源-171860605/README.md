# OOFoundation

## 1.类设计

### Boy类
    - 葫芦娃类
    - 包含名字、颜色、排序属性
    - 包含交换、找位置、报出姓名等方法

```
public class Boy{
    
    private final String name;
    private final String color;
    private final int rank;
    private int position;
    private Queue que;

    Boy(String name, String color, int rank) {...}

    void gotoQueue(Queue que){...}

    void findPos(){...}

    void changePos(Boy b){...}

    void reportName() {...}

    int getRank() {...}

    String getName(){...}

    void setPosition(int pos){...}

}
```

### Grandpa类
    - 老爷爷类
    - 主要包含一个sort方法用以指挥葫芦娃排序
    
```
public class Grandpa {
    
    public void sort(Queue que){...}

    public void changePos(Boy b1, Boy b2){...}

}
```

### Queue类
    - 抽象的队伍类
    - 提供进入队列、交换位置、打印等方法
    
```
public class Queue {
    int len;
    Boy[] array;
    int[] info;

    Queue(int len){...}

    public boolean addBoy(Boy b,int pos)
    {...}

    public boolean isEmpty(int pos)
    {...}

    public void swap(int pos1, int pos2){...}

    public void show(){...}

    public int prevRank(int pos){...}

    public int nextRank(int pos){...}

}
```
    
## 2.choreography sort 过程
    - 初始化葫芦娃
    - 让所有葫芦娃进入队列
    - 让所有葫芦娃自己找到在队伍中应该的位置
    - 由于每个葫芦娃知道自己的rank且主动进行排序过程，排序算法是不必要的
    
```
    Boy[]b=new Boy[7];
    Queue que=new Queue(7);
    initial(b,que);
    for(int i=0;i<7;i++)
    {
        b[i].findPos();
    }
```

## 3.orchestration sort 过程
    - 初始化葫芦娃
    - 让所有葫芦娃进入队列
    - 老爷爷对队列进行排序
    - 老爷爷判断某两个葫芦娃需要交换位置，通知这两个葫芦娃交换
    - 葫芦娃对象通过交换的方法进行交换

```
    Boy[]b=new Boy[7];
    Queue que=new Queue(7);
    initial(b,que);
    Grandpa grandpa=new Grandpa();
    grandpa.sort(que);
```

## 4.运行结果

```
The initial sequence is generated randomly.
---------------------------------------------------
| orchestration sort |
before sort, the queue is:
老四 老五 老七 老大 老六 老二 老三
老七 listens to the grandpa and wants to change position with 老大
老七 changes position with 老大, and the queue is:
老四 老五 老大 老七 老六 老二 老三
老七 listens to the grandpa and wants to change position with 老六
老七 changes position with 老六, and the queue is:
老四 老五 老大 老六 老七 老二 老三
老七 listens to the grandpa and wants to change position with 老二
老七 changes position with 老二, and the queue is:
老四 老五 老大 老六 老二 老七 老三
老七 listens to the grandpa and wants to change position with 老三
老七 changes position with 老三, and the queue is:
老四 老五 老大 老六 老二 老三 老七
老五 listens to the grandpa and wants to change position with 老大
老五 changes position with 老大, and the queue is:
老四 老大 老五 老六 老二 老三 老七
老六 listens to the grandpa and wants to change position with 老二
老六 changes position with 老二, and the queue is:
老四 老大 老五 老二 老六 老三 老七
老六 listens to the grandpa and wants to change position with 老三
老六 changes position with 老三, and the queue is:
老四 老大 老五 老二 老三 老六 老七
老四 listens to the grandpa and wants to change position with 老大
老四 changes position with 老大, and the queue is:
老大 老四 老五 老二 老三 老六 老七
老五 listens to the grandpa and wants to change position with 老二
老五 changes position with 老二, and the queue is:
老大 老四 老二 老五 老三 老六 老七
老五 listens to the grandpa and wants to change position with 老三
老五 changes position with 老三, and the queue is:
老大 老四 老二 老三 老五 老六 老七
老四 listens to the grandpa and wants to change position with 老二
老四 changes position with 老二, and the queue is:
老大 老二 老四 老三 老五 老六 老七
老四 listens to the grandpa and wants to change position with 老三
老四 changes position with 老三, and the queue is:
老大 老二 老三 老四 老五 老六 老七
after sort, the queue is:
老大 老二 老三 老四 老五 老六 老七
---------------------------------------------------
| choreography sort process |
before sort, the queue is:
老三 老大 老五 老四 老七 老二 老六
老大 wants to change position with 老三
老大 changes position with 老三, and the queue is:
老大 老三 老五 老四 老七 老二 老六
老二 wants to change position with 老三
老二 changes position with 老三, and the queue is:
老大 老二 老五 老四 老七 老三 老六
老三 wants to change position with 老五
老三 changes position with 老五, and the queue is:
老大 老二 老三 老四 老七 老五 老六
老五 wants to change position with 老七
老五 changes position with 老七, and the queue is:
老大 老二 老三 老四 老五 老七 老六
老六 wants to change position with 老七
老六 changes position with 老七, and the queue is:
老大 老二 老三 老四 老五 老六 老七
after sort, the queue is:
老大 老二 老三 老四 老五 老六 老七
---------------------------------------------------
```