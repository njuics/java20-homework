import java.util.Arrays;
public class Sort {
    static int []numList = {1212121,10,23,43,21,32,123,5,2432,777,666,233333,122093,903,423,11111,2312};
    static int []copyList = new int[numList.length];
    public static void mergesort(int[] numList,int l,int r){
        int mid = (int)(l+r)/2;
        if(l<r-1){
            mergesort(numList,l,mid);
            mergesort(numList,mid,r);
        }
        for(int i=l;i<mid;i++){
            copyList[i] = numList[i];
        }
        for(int i = mid,j=r-1;i<r;i++,j--){
            copyList[i] = numList[j];
        }
        int a=l,b=r-1,index = l;
        while(a<=b){
            if(copyList[a]<=copyList[b]){
                numList[index++] = copyList[a++];
            }
            else{
                numList[index++] = copyList[b--];
            }
        }
    }
    public static void main(String args[]){
        mergesort(numList,0,numList.length);
        System.out.println(Arrays.toString(numList));
    }

}