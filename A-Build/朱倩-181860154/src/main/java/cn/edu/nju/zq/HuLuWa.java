package cn.edu.nju.zq;

import java.util.Comparator;
import java.util.Random;
import org.apache.commons.lang.RandomStringUtils;


public class HuLuWa extends Creature implements Comparable<HuLuWa>{
  HuLuWa(String name, Gender gender) {
    super(name,gender);
  }

  public static HuLuWa getNewHuluwa() { //random name and gender
    //get random name
    Random random = new Random();
    int length = random.nextInt(5) + 1; //name length:1~5
    String name=RandomStringUtils.randomAlphabetic(length);
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
