
public class sortMethod {
	public int methodNumber=0;
	/*改变methodNumber改变多种排序方式*/
	public boolean cmp(Kid kid1,Kid kid2){
		switch (methodNumber){
		case 0:
			if(kid1.age>kid2.age) {
				return true;
			}
			break;
		case 1:
			if(kid1.age<=kid2.age) {
				return true;
			}
			break;
		}
		return false;
	}
}
