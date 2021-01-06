# 9-Testing
本次作业是对8-Generics作业程序的单元测试。 
   

## 修改
修改了部分变量的名称 如一个String buffer由sb改为sBuffer.  
增加了一个继承自Unit的新类Monster，用于对葫芦娃的测试以及今后使用。  
添加了葫芦娃的随机颜色初始化

## 单元测试内容
正确性测试：  
* HuLuWa的方法：  
compareTo：检查是否对非葫芦娃类正确返回0,两个葫芦娃交换次序比较结果是否相反。  
getRandomString：检查返回的字符串长度是否正确  
* Tile的方法：  
swap：检查两个都有成员、都为空、仅有一个为空的tile的swap。
leave：检查是否返回了leave的unit，以及leave后是否为空。  
enter：检查已有单位后是否返回失败，以及无单位是否成功。  
* Ground方法：
divideByGender:检查是否分成了男女两组

性能测试：  
* 测试三种sort的用时。
