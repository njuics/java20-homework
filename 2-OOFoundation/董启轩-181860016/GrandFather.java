public class GrandFather {
    public void simplesort(CalabashBrother bro[]){
        for(int i=0;i<bro.length-1;i++)
        {
            int j=0;
            for(j=0;j<bro.length;j++)
                if(bro[j].position==1) break;
            while(bro[j].position<bro.length-i)
            {
                int k=0;
                for(k=0;k<bro.length;k++)
                    if(bro[k].position==bro[j].position+1) break;
                if(bro[j].cmp(bro[k])) {bro[j].swapPosition(bro[k]);}
                j=k;
            }
        }
    }
}
