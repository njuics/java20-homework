import java.util.ArrayList;

public class Grandpa {
	sortMethod method;
	public Grandpa(sortMethod method){
		this.method=method;
	}
	
	/*“Ø“Ø÷∏ª”≈≈–Ú*/
	 public void orchestrationSort(ArrayList<Kid> kidArray) {
	        for(int i =0;i<kidArray.size()-1;i++) { 
	            for(int j=0;j<kidArray.size()-1-i;j++) {  
	                if(!method.cmp(kidArray.get(j),kidArray.get(j+1))) {
	                   Kid temp=kidArray.get(j);
	                   kidArray.remove(j);
	                   kidArray.add(j+1,temp);
	                   kidArray.get(j).index=j;
	                   kidArray.get(j+1).index=j+1;
	            }
	            }    
	        }
	    }
}
