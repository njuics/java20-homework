## 第二次作业
### 数据结构设计
本次实验中主要实现了五个类，分别为
- OopFoundation 作为程序入口
- CalabashBoy 为葫芦娃类
- BoyQueue 为队伍类
- Grandpa 为爷爷类
- LineUp 排序功能类
 
#### CalabashBoy
- 存放葫芦娃基本信息：如名字，序号等
- 提供了葫芦娃之间进行比较、交换的基础功能，用于各种排序算法
  
#### BoyQueue
- 作为葫芦娃队列的管理类
- 提供队伍初始化、打乱、输出队列等基本功能

#### Grandpa
- 作为第三方调度者功能，实现orchestration模式

#### LineUp
- 提供不同模式的排序功能，可选择orchestration或choreography
  
#### 耦合性
由于葫芦娃类提供了基本的比较及交换函数，在使用基于比较的排序算法时，可直接进行排序算法的替换，无需对代码其他部分进行修改