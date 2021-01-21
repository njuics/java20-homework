class Grandpa{
    boolean compare_small(Huluwa x,Huluwa y){
        if(x.index<y.index){
            return true;
        }
        else{
            return false;
        }
    }
    void swap(Huluwa x,Huluwa y){
        Huluwa temp=new Huluwa();
        temp.name=x.name;
        temp.index=x.index;
        x.name=y.name;
        x.index=y.index;
        y.name=temp.name;
        y.index=temp.index;
    }
}