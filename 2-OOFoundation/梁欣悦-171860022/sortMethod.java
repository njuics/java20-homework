
public class sortMethod {
	public int methodNumber=0;
	/*�ı�methodNumber�ı��������ʽ*/
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
