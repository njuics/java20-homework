# **3-OOAdvanced**



## 程序类图



[类图url]: http://www.plantuml.com/plantuml/umla/XPBFRjGm4CRlVefHkMmfwGkmMXLL0Wu83ZrmgAhLn1coXiIERAUhQkcxCnElbNK2uh3Qp1__vflFlWiHVHpxJWseVs5BSENgdwJZ5Mot7ptsjDi1d9JI7OO0twRQIUttC8nrPpJiz-e67g8tjeMMubS-iRa6pXaR9V6XvPZ3PsSQ2FWoDoGM5mNcNUI06k6zoJpBlUyv51Is_AbUbSfIxh736iC1LcfoXT4NGM8oInIy4oR_M9qqrSvrX1QqwmVqbuAFE6I5vXaZoOGAJknQDFfreh1VzswqaTLbRPyyscR0fRASd_ZQ4_CAhS7v-7diHWw41MUBOFkxgkPzotncmdHalaLX1LfT8mic_mCrmKDgM6ZCYmlqYx6qoMCVdw2LP70sYDRKPkaedFzqUHh-sGHguQwgPkl_UYJT7QQ_MW3YLTw7JRczdKsHweKhH-UxPk49d9-srmSAqMCqpd8Me326uvkoPtCjoUpNQCylZAMYRsKnAK_IpW_su3mvNcCul31_ZIyw5hJKK4oPywjhcCrwV18XXOxlui7gQUOddTRfqQmcYPEbpOLW1QKzK5MxYtj8O-5jLHMdYae9u75tP9knx_u0	"类图URL"



![](https://i.loli.net/2020/09/28/sFurlajULVkXy2M.png)



## 编程思想

### 封装

姓名，年龄等信息和一些方法隐藏，只向外界提供一些必要的方法接口

### 继承

object包，包含这个世界的一些对象

1.基础类型 `Object` ，包含对象基本的姓名，年龄

2.`Calabash` 葫芦娃类继承自`Object`，可以自己和别的葫芦娃比较和交换

3.`Grandpa` 爷爷类继承自`Object` 可以创建葫芦娃和给葫芦娃排序

### 多态 & 接口

包`sortset` 中的类`Sortset` 提供接口，包括排序的一些方法，如随机排队，按序排队等，`Grandpa` 类和`Choreography `类中可以重载方法，进行不同的实现。

### 组合

`World` 世界由`Choreography ` 和` Orchestration`  两种方式组成

### 委托

`Choreography ` 世界委托 `Grandpa` 类对葫芦娃们进行排队

### 静态变量和静态块

用静态变量`objCount` 记录葫芦娃的数量，初始为0，每创建一个葫芦娃对象，计数加1

```java
static int objCount;
​    static{
​       objCount = 0;
​    }
```



## 运行方法和运行结果

在src目录下，`./run.sh`

运行结果示例

![image-20200928010818310](https://i.loli.net/2020/09/28/wkreUjHg3AE7bxW.png)



