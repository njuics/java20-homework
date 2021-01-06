package cn.edu.nju.zq.homework7;

import java.util.Comparator;
import java.util.Random;

enum Gender {
  MALE,
  FEMALE
}

class AscComparator implements Comparator<HuLuWa> {

  public int compare(HuLuWa h1, HuLuWa h2) {
    String name1 = h1.getName();
    String name2 = h2.getName();
    return name1.compareTo(name2);
  }
}
class DescComparator implements Comparator<HuLuWa> {

  public int compare(HuLuWa h1, HuLuWa h2) {
    String name1 = h1.getName();
    String name2 = h2.getName();
    return name2.compareTo(name1);
  }
}

class RandomComparator implements Comparator<HuLuWa> {

  public int compare(HuLuWa h1, HuLuWa h2) {
    Random random = new Random();
    return random.nextInt(3) - 1;
  }
}

public class HuLuWa {
  private String name;
  private Gender gender;

  HuLuWa(String name, Gender gender) {
    this.name = name;
    this.gender = gender;
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

  public String getName() {
    return name;
  }

  public Gender getGender() {
    return gender;
  }

  @Override
  public String toString() {
    return name + '(' + gender + ")  ";
  }
}