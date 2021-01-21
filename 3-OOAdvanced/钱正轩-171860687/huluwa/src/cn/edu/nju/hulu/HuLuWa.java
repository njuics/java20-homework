package cn.edu.nju.hulu;

enum Order {
    FIRST, SECOND, THIRD, FOURTH, FIFTH, SIXTH, SEVENTH, NULL
}

public class HuLuWa implements Comparable<HuLuWa> {
    private final Order order;
    private final String name;
    private HuLuWa left = null;
    private HuLuWa right = null;

    /**
     * 葫芦娃构造器
     *
     * @param order 年功序列
     * @param name  名字
     */
    HuLuWa(Order order, String name) {
        this.order = order;
        this.name = name;
    }

    /**
     * 和另一个葫芦娃交换位置
     *
     * @param h 待交换的葫芦娃
     */
    public void swap(HuLuWa h) {
        if (this.equals(h)) {
            return;
        }
        HuLuWa al = this.left;
        HuLuWa ar = this.right;
        HuLuWa bl = h.left;
        HuLuWa br = h.right;
        if (ar.equals(h)) {
            al.right = h;
            h.left = al;
            h.right = this;
            this.left = h;
            this.right = br;
            br.left = this;
        } else if (br.equals(this)) {
            bl.right = this;
            this.left = bl;
            this.right = h;
            h.left = this;
            h.right = ar;
            ar.left = h;
        } else {
            this.left = bl;
            this.right = br;
            bl.right = this;
            br.left = this;
            h.left = al;
            h.right = ar;
            al.right = h;
            ar.left = h;
        }
    }

    /**
     * @return the left
     */
    public HuLuWa getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(HuLuWa left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public HuLuWa getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(HuLuWa right) {
        this.right = right;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(HuLuWa o) {
        return this.order.compareTo(o.order);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((order == null) ? 0 : order.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HuLuWa)) {
            return false;
        }
        HuLuWa other = (HuLuWa) obj;
        return this.order.equals(other.order);
    }
}
