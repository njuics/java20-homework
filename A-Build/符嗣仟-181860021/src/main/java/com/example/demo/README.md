# Testing

### 1. 前言

本次作业在书写之前，对于上次作业的不足之处进行了优化，同时使用JUnit对于不同排序算法进行测试。

### 2. 优化

* 采用接口实现Creature，而非抽象类，从而提高灵活性。

* 使用泛型实现 **Comparator** ，替换掉了之前仅适用于Creature，需使用向上转型完成排序的方法。

  ```
  public class NegComparator <T extends Comparable<T>> implements Comparator<T>{
      @Override
      public int compare(T a,T b){
          return b.compareTo(a);
      }
  }
  /* 在CreatureList中使用:
     public void Possort(){
        Collections.sort(lst,new PosComparator<T>());
      }
  */
  ```

* 学习并使用了适配器模式，采用Iterable完成不同顺序的输出，例如：

```
public Iterable<T> reversed(){
        return new Iterable<T>(){
            public Iterator<T> iterator(){
                return new Iterator<T>(){
                    int cur = lst.size()-1;
                    @Override
                    public boolean hasNext(){
                        return cur>-1;
                    }
                    @Override
                    public T next(){
                        return lst.get(cur--);
                    }
                };
            }
        };
    }
```

### 3.Test

* @Before: 进行数据的初始化，见`setup()` 函数
* @After: 进行数据清理

* v1: 类似于OJ形式，给出输入&预期输出，进行测试。

```
    public void Possorttest1(){
        huluwas.Possort();
        Iterator<Calabash> iter = huluwas.iterator();
        assertEquals(iter.next().getname(), "a");
        assertEquals(iter.next().getname(), "b");
        assertEquals(iter.next().getname(), "c");
        assertEquals(iter.next().getname(), "d");
        assertEquals(iter.next().getname(), "e");
        assertEquals(iter.next().getname(), "f");
        assertEquals(iter.next().getname(), "g");
        assertFalse(iter.hasNext());
    }
```

* v2: 通过遍历，判断是否前1个的字典序始终小于（大于）后一个字典序，即可完成验证。

```
    public void Possorttest2(){
        huluwas.Possort();
        for(int i=0;i<6;i++){
           if(huluwas.get(i).getname().compareTo(huluwas.get(i+1).getname())>0)
                assertTrue(false);
        }
    }
```

