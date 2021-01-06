import java.util.ArrayList;

/*������*/
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
	
	/*�໥Э�����ڶ������ҵ��Լ���λ�ã���ӽ�ȥ*/
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
		//����֪���Լ���λ��
		for(Kid k:kidArray) {
			k.index=count++;
		}
	}
	
	/*ֱ������ָ���Լ���λ��Ϊn*/
	public void setMyPosition(ArrayList<Kid> kidArray,int n){
		if(index!=-1) {
			kidArray.remove(index);
			index=-1;
		}
		kidArray.remove(n);
		kidArray.add(n, this);
		index=n;
	}
	
	/*����*/
	public void baoshu(){
		System.out.println(name);
	}
	
	
}
