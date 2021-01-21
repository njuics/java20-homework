package cn.edu.nju.zq.homework3;

import java.util.List;

interface Sort {
  void orchestration(Grandpa grandpa, List<HuLuWa> queue);
  void choreography(List<HuLuWa> queue);
}

public class BubbleSort implements Sort {

  public void orchestration(Grandpa grandpa, List<HuLuWa> queue) {
    for (int i = 1; i < queue.size(); i++) {
      for (int j = queue.size() - 1; j >= i; j--) {
        if (grandpa.needExchange(queue.get(j - 1), queue.get(j))) {
          grandpa.exchange(queue, j - 1, j);
        }
      }
    }
  }

  public void choreography(List<HuLuWa> queue) {
    for (int i = 1; i < queue.size(); i++) {
      for (int j = queue.size() - 1; j >= i; j--) {
        if (queue.get(j - 1).youngerThan(queue.get(j))) {
          queue.get(j - 1).exchangeWith(queue.get(j));
        }
      }
    }
  }
}
