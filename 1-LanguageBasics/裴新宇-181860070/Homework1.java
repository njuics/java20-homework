public class Homework1{
    public static void main(String []args){
        int p[] = {1,9,2,8,3,7,4,6,5,0};
        for(int i=0;i<p.length-1;i++){
            for(int j=0;j<p.length-i-1;j++){
                if(p[j]>p[j+1]){
                    int t = p[j];
                    p[j] = p[j+1];
                    p[j+1] = t;
                }
            }
        }
        for(int x:p){
            System.out.print(x);
            System.out.print(' ');
        }
        return;
    }
}