# 5-Class作业说明  

## MyClassLoader实现  
### 通过findClass()完成对类的加载；  
首先利用loadClass()来加载Base64编码的字节码，然后利用defineclass()对类进行创建；   

## Main实现  
利用MyClassLoader对Monster类的进行加载； 
再利用下列函数进行验证；   
output_name(hw5);//输出类的名字  
get_instantiation(hw5);//利用构造器创建Monster类的mon对象，并初始化name="wht",health=10,damage=1;  
output_attribution(hw5);//输出对象的所有属性  
output_function(hw5);//输出对象的所有方法  
