# README
## 类图
![](http://www.plantuml.com/plantuml/png/hL51JiCm4Bpx5PQu1D7s0usgmW6e10YK5vZ4IImIEzXhgYhaxwoxYUH092xjgJkUsPdPx1q82xvjMDu8v_YZR_nHz8pZhyStKFcWD71LRC_O5GzJPzmqPc2LhhWMhII8DYJNiobYZGytvqMLX1TpV3LkaV5bLC4xn26PiCal296A-9QnOGp_O8KkxWNKqbA3Pz6b95WTDCXAsXslCT6TDO549M9PSk5q4tvhhJWzAGSf7MJ7dR6G_8K_VJ0OsDW8WxvvIMKMoMH0j6GUhJrbjI_BvXUEAfL_PC4-T7oNbTAhy4_gWgnnaBOKkUI1TPYcdlrxcAMxB9y5RQW5Jx_Nw_WJC2h33S94YP6OE4k7UpQRKR3q4WltMDMtpGy0)

### Huluwa
葫芦娃类，用一个静态id自增来标记葫芦娃的位置，同时拥有成员变量name标记葫芦娃的名字

### GrandFather
爷爷类，继承于葫芦娃类。这里默认爷爷也在队伍中，不过是第一个，那么其成员变量与葫芦娃一致，所以继承于葫芦娃类并新增一个成员变量huluBrothers来记录所有葫芦娃的正确位置

成员函数sort来对葫芦娃进行排队

### BroQue
兄弟队伍类，这个类由8个葫芦娃类实例构成，队首为爷爷

myshuffle成员函数用来打乱兄弟的排队

这里的quicksort来对葫芦娃进行排队

### SortInterface
接口，这里主要是三个函数

- getNowPos 获取葫芦娃位置
- print 打印葫芦娃名称
- getName 获取葫芦娃名字

## 设计思路
重写函数getNowPos来进行不一样的位置返回，爷爷类输入返回目标娃的应在位置，葫芦娃类则返回其自身应在位置。

### 编排排序
爷爷从第一位开始，去看他应该在哪，便把他和他应该在的位置的娃交换

交换过来的娃如果正确就往第二位看，否则再交换，以此反复，直到最后的位置

### 协同排序
每次挑一个葫芦娃出来，葫芦娃知道自己应该在哪里，如果在这个葫芦娃前面，那就站到他前面去，否则站到他后面去，这样结束后这个葫芦娃的位置就确定的，把该葫芦娃前后分两堆独自进行刚刚的站队，直到每堆只剩一人。


