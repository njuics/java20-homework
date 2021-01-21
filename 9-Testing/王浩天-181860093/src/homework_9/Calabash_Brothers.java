package homework_9;


public class Calabash_Brothers extends Human {
	private int value;
		
	Calabash_Brothers(int i){
		this.value=i;
		switch(i) {
		case 1:this.name="Red";break;
		case 2:this.name="Orange";break;
		case 3:this.name="Yellow";break;
		case 4:this.name="Green";break;
		case 5:this.name="Cyan";break;
		case 6:this.name="Blue";break;
		case 7:this.name="Purple";break;
		default:System.out.print("Wrong input");
		}
	}
	
	int getval() {
		return value;
	}
	String getname() {
		return name;
	}
	void change(int i,String n) {
		value=i;name=n;
	}
	void show() {
		System.out.print(value+"-"+name+" ");
	}
	boolean compare_val(Calabash_Brothers a) {
		if(a.getval()>this.value)return true;
		else return false;
	}
	void swap(Calabash_Brothers a) {
		int tem_val=a.getval();
		String tem_nam=a.getname();
		a.change(value, name);
		this.change(tem_val, tem_nam);
	}
}
