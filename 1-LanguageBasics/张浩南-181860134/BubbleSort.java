public class BubbleSort{
    public static void main(String[] args)
    {

        int n=10,tmp;
        int a[]={0,4,3,7,1,2,9,5,0,8,6};
        
        for (int i=1;i<n;++i)
            for (int j=n-1;j>=i;--j)
                if (a[j]>a[j+1])
                {
                    tmp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=tmp;
                }
        for (int i=1;i<=n;++i) System.out.print(a[i]+(i==n?"\n":" "));
    }
}