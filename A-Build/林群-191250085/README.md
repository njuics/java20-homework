# Homework10

## 添加依赖包
> org.apache.commons.RandUtils  
> org.apache.commons.Collections

## 第三方库的使用
`Rand`接口：使用了`RandUtils`中的子类，来随机生成葫芦娃的姓名以及性别，避免了使用默认的`Rand`包时重新编写生成算法和指定随机种子。   

`IterableQueue`类：使用了`Collections`类增强，使得队列封装类可以求两个集合是否相同，求两个集合的交集、并集和差集。