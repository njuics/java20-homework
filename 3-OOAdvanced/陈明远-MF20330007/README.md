# 第三次作业

>> ##  本次作业采用choreography方法完成

1.一共有4个类，分别为GrandFather,GourdBaby,GourdBrother,World。和一个接口Method组成。  
2.其中GroudBaby为一个抽象类，代码如下：  

```java
    public  abstract class GourdBaby implements Method{
    private int ranking;
    private String name;
    public GourdBaby() {
    }
    public GourdBaby(int ranking, String name) {
        this.ranking = ranking;
        this.name = name;
    }
    public int getRanking() {
        return this.ranking;
    }
    public String getName() {
        return this.name;
    }
    public void reportName() {
    }
}
```

这个抽象类实现了Method这个接口，接口定义如下：  

```java
public interface Method {
    public int getRanking();
    public String getName();
    public void reportName();
}
```

3.然后构造了一个GourdBrother这个类继承了GourdBaby这个类，并实现了所有方法。在这个类里面初始化了七个葫芦娃并定义了排序这个方法，排序方法使用了匿名类和Arrarys里面的sort函数，具体使用如下：

```java
    public void sort() {
        Arrays.sort(gourdBrothers, new Comparator<GourdBrother>() {
            @Override
            public int compare(GourdBrother o1, GourdBrother o2) {
               return o1.getRanking() - o2.getRanking();
            }
        });
    }
```

4.然后定义了GrandFather和World，并在World类里面初始化了其他类，构造了一个有葫芦娃和爷爷的世界。其中排序方式由葫芦娃自己定义。  

最后是作业的类图：  

## ![](http://www.plantuml.com/plantuml/png/XP6zJiGm3CVtF8L76EwUWE7401CCTmEpcxXDH9eWnqL2XNSdBKO9GeXk_ld_eSQd8iYopD649CGZMe874fyTh0RgLp5C96TCpo5DLzSxl0ZNOUEFE9F2rnmSCBra_gOV1eSYZ5RWFY_iRd5usrFRgDxVBGh_hx0HIz50pkA9kuextC1VxaQ7mE9xKAgedyUGGl5z8MFIU5YRpcAC5_NsxBpNTlwdpD5z6MSCIVLGzyQqvu6RzyFXnyyPFK_T78zDQ4wKN3tZ9m00)
