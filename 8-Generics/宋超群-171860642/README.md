## homework8

- 本次作业中稍作修改，将葫芦娃队列单独实现成一个类，并使用泛型限定了加入队列的对象只能是CalabashBoy类及其子类型的实例化对象，防止有妖怪混入其中。列队类实现如下。

  ```java
  //葫芦娃队列
  class BoysSequence <Boy extends CalabashBoy>{
      public ArrayList<CalabashBoy> boysList;
      BoysSequence(){
          boysList = new ArrayList<>();
      }
  
      void add(Boy newBoy){
          boysList.add(newBoy);
      }
  
      //按序输出葫芦娃名单
      void outputNameList(){
          for(CalabashBoy boy : boysList){
              System.out.println(boy.getName());
          }
      }
  
      //葫芦娃按序进行自我介绍
      void outputSequence(){
          for(CalabashBoy boy : boysList){
              System.out.println(boy.toString());
          }
      }
  }
  ```

- 排序功能放在‘老爷爷’类中，并且赋予老爷爷一个特殊技能（安抚受伤的葫芦娃，触发其休息回复HP的被动技能，使其快速恢复），使用泛型限定被安抚的对象只能是葫芦娃，即CalabashBoy类及其子类型对象。老爷爷 类具体实现如下

  ```JAVA
  class GrandFather<Boy extends CalabashBoy>{
  
      //爷爷发挥自己的特殊技能，帮助葫芦娃反复触发回复血量的被动技能
      void recover(Boy boy){
          while(boy.getHP() < 1000){
              boy.getWell();
          }
      }
      //排序
      void sort(BoysSequence sequence){
          Collections.sort(sequence.boysList);
      }
      //打乱次序
      void shuffle(BoysSequence sequence){
          Collections.shuffle(sequence.boysList);
      }
  
  }
  ```

  