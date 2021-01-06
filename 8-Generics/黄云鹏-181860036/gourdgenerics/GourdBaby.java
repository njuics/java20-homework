package gourdrgenerics;

import java.util.Collections;

class GourdBaby extends Race<GourdBaby>{ // 葫芦娃，继承自由葫芦娃实例化的种族类，
	GourdBaby(String n){
		super(n);
	}
	GourdBaby(String n,String s,int a){
		super(n,s,a);
	}
	public void selfIntroduce() {
		super.selfIntroduce("GourdBaby");
	}
	public void introduceSiblingsInAgeOrder() {
		Collections.sort(this.siblings);
		for (GourdBaby gb:this.siblings) {
			gb.selfIntroduce();
		}
	}
}
