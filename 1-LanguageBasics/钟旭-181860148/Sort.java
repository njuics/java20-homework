public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] Arr=new int[] {2020,5,76,123,2,998,34,996};
		for(int i=Arr.length-1;i>=0;i--) {
			for(int j=0;j<i;j++) {
				if(Arr[j+1]<Arr[j]) {
					int tmp=Arr[j+1];
					Arr[j+1]=Arr[j];
					Arr[j]=tmp;
				}
			}
		}
		for(int i:Arr) {
			System.out.println(i);
		}
	}

}
