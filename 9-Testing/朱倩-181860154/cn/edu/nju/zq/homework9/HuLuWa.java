package cn.edu.nju.zq.homework9;

import java.util.Comparator;
import java.util.Random;


public class HuLuWa extends Creature implements Comparable<HuLuWa>{
  HuLuWa(String name, Gender gender) {
    super(name,gender);
  }

  public static HuLuWa getNewHuluwa() { //random name and gender
    //get random name
    String str = "abcdefghijklmnopqrstuvwxyz";
    Random random = new Random();
    StringBuffer sb = new StringBuffer();
    int length = random.nextInt(5) + 1; //name length:1~5
    for (int i = 0; i < length; i++) {
      int number = random.nextInt(26);
      sb.append(str.charAt(number));
    }
    String name = sb.toString();
    //get random gender
    Gender gender = (random.nextInt(2) == 0) ? Gender.MALE : Gender.FEMALE;
    return new HuLuWa(name, gender);
  }

  @Override
  public String toString() {
    return name + '(' + gender + ")  ";
  }

  @Override
  public int compareTo(HuLuWa h){
    return this.name.compareTo(h.getName());
  }
}
