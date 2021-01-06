# OOFoundation


## 设计思想

###  Orchestration（葫芦爷爷指挥排队）
1.  葫芦爷爷知道每个葫芦娃对应的排序后的位置。
2.  葫芦爷爷从前往后看，对于每个他看到的葫芦娃，如果该葫芦娃（假设为a）没有站到
正确的位置的话，而b站在a应该站的位置上，那么他就让a和b交换位置，并重复此过程。
3.  直到每个人都站在正确的位置上，葫芦爷爷的指挥结束。

###  Choreography（葫芦兄弟协作排队）
1.  葫芦兄弟能发现当前队列前后兄弟与自身的大小比较。
2.  从后往前开始，每个葫芦娃与他前面的兄弟比较，若比较大，则两者交换位置。这样的话每一轮都能确定一个葫芦娃的位置。

## 设计方法
因为 *Orchestration* 和 *Choreography* 两者都是排队算法，故二者都可以通过继承最基本的排队算法实现。
两者都继承`queue`并覆写`queue`中的`sort`方法。  

    class queue{
    public void sort(CalabashBoy[] brothers){}
    public void swap(CalabashBoy a,CalabashBoy b){
        int tmp=a.id;
        a.id=b.id;
        b.id=tmp;
    }
}

如此一来，利用多态的性质，选择任意一个排队算法：

    queue gf=new Choreography();
    queue gf=new Orchestration();

这样替换排序算法时代码的改动小。
    

