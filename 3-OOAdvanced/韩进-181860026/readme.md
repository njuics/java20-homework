<h1>作业3报告<h1>


<p>
<h2>
    1.数据结构
</h2>    
<p>
	<b>接口 Sorter</b> 
    <br>
	提供了orchestration与choreography两个函数
</p>
<p>
	<b>类 BubbleSorter</b>
    <br>
    继承了Sorter接口，提供了orchestration与choreography排序函数的具体实现；另外类中还提供了reportGourds与shuffleGourds函数用于葫芦娃依此报数与打乱排列顺序。
</p>
<p>
    <b>类 Human</b>
    <br>
    提供了name变量，以及reportName函数
</p>    
<p>
    <b>类 GourdBrother</b>
    <br>
    葫芦娃类，继承Human类，含有getIndex,cmpIndex,swapWithNextGourds函数
</p>
<p>
    <b>类 Grandfather</b>
    <br>
	爷爷类，继承Human类，含有cmpGourds，swapGourds函数，用以比较葫芦娃序号以及交换葫芦娃
</p>
<p>
	<b>类 World</b> 
    <br>
    含有类型为GourdBrother[]与Grandfather类型的变量，提供变量的初始化作用
</p>
<p>
	<b>类 Main</b>    
    <br>
    运行主函数
</p>
</p>
<h2>
    2.使用到的面向对象编程思想
</h2>

<p>
    <b>封装</b>
    <br>
	可以看到将数据与方法封装进了各个类中，只暴露了对外的接口
</p>
<p>
	<b>继承</b>
    <br>
    Grandfather类与GourdBrother类继承了Human类
</p>


	public class Grandfather extends Human
	public class GourdBrother extends Human

<p>
	<b>多态</b>    
    <br>
    Sorter类型的变量能指向BubbleSorter类，调用Sorter类的orchestration与choreography实际调用的是BubbleSorter类中的相应函数
</p>

```java
Sorter sorter = new BubbleSorter();
sorter.orchestration(gourdBrothers, grandfather);
sorter.choreography(gourdBrothers);
```

<p>
    <b>接口</b>
    <br>
    Sorter类便是Interface类型，提供两个接口函数，用于排序
</p>

<p>
    <b>构造器</b>
    <br>
    Human类有一个含参构造器，用于初始化name参数；那么相应的，继承自Human类的Grandfather类与GourdBrother类也含有含参构造器        
</p>

```
Human(String name)
{
	this.name = name;
}
Grandfather(String name)
{
	super(name);
}
GourdBrother(String name, int index)
{
    super(name);
    this.index = index;
}
```

<p>
    <b>静态变量与静态块</b>
    <br>
    葫芦娃数目作为静态变量，通过静态块初始化
</p>

```
static final int NUM_OF_GOURDS;
static
{
	NUM_OF_GOURDS = 7;
}
```

<p>
    <b>包</b>
	<br>
    所有类被组织在cn.edn.nju的包中
</p>

```
package cn.edu.nju;
```

<p>
    <b>修饰符</b>
	<br>
    使用了private来修饰私有数据，public公开函数接口
</p>

<h2>3.类图</h2>

![UML图](http://www.plantuml.com/plantuml/png/ZLFDojim4BphAHPoiI4-95T32Q4qxI49D8GSIWcoBTi2MJAItAQqUVVgnyGRCFdYY-NPdvdHhZV6Kcs7Jf1IK6FWwz1HIVuI4Wv9IZ8uMSrb0v9sZ2pWb-8LQDOhRGyEIL0q9NSojjbfAgkQsfPfrmnzFUUFxSgktwb1LoO9hwrMFXMA-5ujOGvUFyhDRpfN_-CdDEZJB85B2xqogyTfZIMZNASv2pbSLkoM4np33fPJKWhk8Oi0DCn-yrZY9HPA2KQbDnd1EJEn6lcvSDiUsCs6vFTiUI_ughFitwSuJbIEKEBgcAvfoU2aj0sk0I1gKBficR6QMgxa1_o84vhfdEPJkx9LcYaNxDi_Bxkb-JIHxL0KWZsqnRjfXxeMx8rnfmIjwblvZXXJ-fiQoKT15wL55NRZLQFSn-Ul92V6KijBgBca8WpkSDvVZr-kk-Fv--TJJW95Cgss_pkJk1tt60ILFVL7A5A5OMngTBAdtF_b2uXw8bddm76xdIUg6vC6Mf_i6ut-DqnMGoV-0m00)



