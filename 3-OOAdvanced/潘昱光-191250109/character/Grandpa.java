package character;
public class Grandpa implements Sort{
    Huluwa[] children;
    public Grandpa(){
        children=new Huluwa[7];
    }
    public Grandpa(Huluwa[] huluwas){
        children=huluwas;
    }
    public void setChildren(Huluwa[] huluwas){
        children=huluwas;
    }
    public void sort(int b,int e){
        int i=b,j=e;
        if(b>=e)
            return;
        while(i<j){
            while(!children[i].largerThan(children[j])&&j>b){
                j--;
            }
            if(i<j){
                Huluwa temp=children[i];
                children[i]=children[j];
                children[j]=temp;
            }
            while(children[j].largerThan(children[i])&&i<e){
                i++;
            }
            if(i<j){
                Huluwa temp=children[i];
                children[i]=children[j];
                children[j]=temp;
            }
        }
        sort(b,j);
        sort(j+1,e);
    }
    public void callChildren(){
        for(int i=0;i<children.length;++i){
            children[i].call();
        }
    }
}
