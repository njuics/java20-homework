## 一、程序结构及类描述  
* 本程序的主类为LineUp类，类中包含数据成员model，huLuWa，sortModel。其中，model为程序思想的选择，为1表示使用orchestration思想，为2表示使用choreography思想；huLuWa数组存储7个葫芦兄弟对象的引用；sortModel用于选择使用的排序算法，本次作业我实现了冒泡排序与快速排序两种排序方式，sortModel为1时使用冒泡排序，为2时使用快速排序。因此，对于不同实现思想以及不同排序算法之间的切换，只需要修改LineUp类中成员model、sortModel的值即可，可见改动很小；类中包含方法shuffle()用于实现葫芦兄弟的打乱，sort()方法用于实现葫芦兄弟之间协同排序，outPut()方法实现按照队伍中顺序报数。
* HuLuWa类描述每一个葫芦娃的特征，数据成员rank表示葫芦娃在兄弟中的排行，1表示老大...以此类推；position表示葫芦娃在当前队伍中的位置，因此提供了setPosition()与getPosition()方法来设置和获取position的值；swap()方法用于实现葫芦娃之间的交换位置。
* GrandFather类描述爷爷的特征，类中包含数据成员huLuWa数组，看作是七个葫芦娃属于爷爷；类中实现的方法均可以看作是爷爷向葫芦娃发出的指令，setHuLuWaPosition()方法可看作是爷爷要求指定葫芦娃移动到指定位置，getHuLuWaPosition()为爷爷要求指定葫芦娃报数；shuffle()为爷爷要求葫芦娃随意打乱顺序，bubbleSort()与quickSort()为爷爷要求葫芦娃按照某种排序方法排序。
* 程序的执行从LineUp类中的main()方法开始，在main()函数中首先创建了七个葫芦娃对象，如果使用orchestration思想，则创建一个GrandFather对象，并在创建时将葫芦娃对象设置属于GrandFather对象，之后由GrandFather对象向葫芦娃发出打乱、排序指令；如果使用choreography思想，则调用sort()方法实现葫芦兄弟之间协同排序。
  
## 二、解决思路
* 本次作业我认为用到的面向对象的核心思想是组合思想。
* 在orchestration思想的实现中，可以将葫芦娃看作是“属于”一个GrandFather对象，GrandFather对象通过setPosition()等接口向指定葫芦娃对象发出指令，要求其移动或者报数，并在此基础上实现冒泡排序与快速排序方法。
* 在choreography思想的实现中，从老大开始，每个葫芦娃检查自己在队列中的位置与自己的排行是否一致(若老大排在队列中的第一位，则老大认为自己的位置与排行一致，以此类推)，若不一致，则葫芦娃通过自身的swap()方法与自己正确位置上的葫芦娃交换位置，显然这是各个葫芦娃协作进行排序且排序结果正确。