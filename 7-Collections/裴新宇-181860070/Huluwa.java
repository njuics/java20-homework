import java.util.*;

public class Huluwa implements Comparable<Huluwa> {
    private String name;
    private boolean gender;// 1: male 0: female
    public Huluwa(String name,boolean gender){
        this.name = name;
        this.gender = gender;
    }
    public String get_name(){
        return this.name;
    }
    public boolean get_gender(){
        return this.gender;
    }
    public void set_name(String name){
        this.name = name;
    }
    public void set_gender(boolean gender){
        this.gender = gender;
    }
    public void count_off(){
        System.out.print(this.name);
    }

    @Override
	public int compareTo(Huluwa h) {
		return name.compareTo(h.name);
	}
}