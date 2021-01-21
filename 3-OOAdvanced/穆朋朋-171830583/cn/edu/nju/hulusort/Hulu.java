package cn.edu.nju.hulusort;
public class Hulu {
    private int color;  // 颜色；0-6分别代表葫芦娃的大娃到七娃；
    
    Hulu() {
        color=0;
    }

    Hulu(int color) {
        this.color=color;
    }
    int getColor() {
        return color;
    }
}
