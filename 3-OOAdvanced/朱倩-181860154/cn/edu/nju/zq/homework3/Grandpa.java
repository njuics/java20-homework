package cn.edu.nju.zq.homework3;

import java.util.List;

public class Grandpa {

  public boolean needExchange(HuLuWa h1, HuLuWa h2) {
    return h1.getRank() > h2.getRank();
  }

  public void exchange(List<HuLuWa> queue, int pos1, int pos2) {
    HuLuWa temp = queue.get(pos1);
    queue.set(pos1, queue.get(pos2));
    queue.set(pos2, temp);
  }
}
