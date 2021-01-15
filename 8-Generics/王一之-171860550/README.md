# 8-Generics
本次作业是对7-Collections作业程序的改进。 
   
程序整体文件以及类框架未发生变化

## 修改
interface Say重命名为Tostring，含tostring函数，返回一个该类的字符串描述其身份信息。  
tile的位置属性由一维pos改为二维 row 以及 col。但目前阶段暂时不维护位置属性。  
由于现在都实现了compareTo接口，因此删去了原本unit下的compare函数。

## 泛型使用
创建地面二维arrayList时检查成员为一维arrayList，创建一维arrayList时检查成员为tile，
打印遍历arraylist时，同样检查类型。  
葫芦娃的compareTo函数参数为其父类Unit，此时无法使用泛型检查是否为葫芦娃，因此使用运行时检查instanceof
