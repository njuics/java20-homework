class InsertSort extends Sort{
    void orchestration_sort(Huluwa array[],Grandpa gp){
        for(int k=1;k<array.length;k++)
            for(int i=k;i>0;i--)
                if(gp.compare_small(array[i],array[i-1])){
                    gp.swap(array[i],array[i-1]);
                }
    }
    void choreography_sort(Huluwa array[]){
        for(int k=1;k<array.length;k++)
            for(int i=k;i>0;i--)
                if(array[i].is_small(array[i-1])){
                    array[i].exchange(array[i-1]);
                }
    }
}