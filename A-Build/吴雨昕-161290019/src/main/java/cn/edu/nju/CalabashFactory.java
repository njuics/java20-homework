package cn.edu.nju;
public class CalabashFactory implements CreatureFactory<CalabashBoy>{
    @Override
    public CalabashBoy create() {
        return new CalabashBoy();
    }
}