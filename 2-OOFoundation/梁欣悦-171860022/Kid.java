import java.util.ArrayList;

/*娃娃类*/
public class Kid {
	String name;
	int age;
	int index;
	sortMethod method;
	public Kid(){
		this.name="";
		this.age=0;
		this.method=null;
		index=-1;
	}
	public Kid(String name,int age,sortMethod method){
		this.name=name;
		this.age=age;
		this.method=method;
		index=-1;
	}
	
	/*相互协作，在队伍中找到自己的位置，插队进去*/
	public void findMyPosition(ArrayList<Kid> kidArray){
		if(index!=-1) {
			kidArray.remove(index);
			index=-1;
		}
		
		for(Kid k:kidArray) {
			index++;
			if(method.cmp(this, k))	{
				break;
			}
		}
		kidArray.add(index,this);
		int count=0;
		//重新知道自己的位置
		for(Kid k:kidArray) {
			k.index=count++;
		}
	}
	
	/*直接外力指定自己的位置为n*/
	public void setMyPosition(ArrayList<Kid> kidArray,int n){
		if(index!=-1) {
			kidArray.remove(index);
			index=-1;
		}
		kidArray.remove(n);
		kidArray.add(n, this);
		index=n;
	}
	
	/*报数*/
	public void baoshu(){
		System.out.println(name);
	}
	
	
}
