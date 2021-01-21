package cn.edu.nju.zq.homework3;

public class HuLuWa {
  private String name;
  private int rank;

  HuLuWa(String name, int rank) {
    this.name = name;
    this.rank = rank;
  }

  public boolean youngerThan(HuLuWa h) {
    return this.rank > h.rank;
  }

  public void exchangeWith(HuLuWa h) {
    String tempname = h.name;
    h.name = this.name;
    this.name = tempname;
    int temprank = h.rank;
    h.rank = this.rank;
    this.rank = temprank;
  }

  public int getRank() {
    return rank;
  }

  public void tellName() {
    System.out.print(name + " ");
  }
}
