public class Sort {
    public static void main(String[] args) {
        int number[]=new int[]{1,4,2,0,0,3,8,3,7,7,19,5};
        for(int i=0;i<number.length-1;i++)
            for(int j=0;j<number.length-1;j++){
                if(number[j]>number[j+1]){
                    int temp=number[j];
                    number[j]=number[j+1];
                    number[j+1]=temp;
                }
            }
        for(int i:number)
            System.out.println(i);
 
    }
}