class BubbleSort extends Sort{
    void orchestration_sort(Huluwa array[],Grandpa gp){
        for(int k=0;k<array.length;k++)
            for(int i=0;i<array.length-1;i++)
                if(!gp.compare_small(array[i],array[i+1])){
                    gp.swap(array[i],array[i+1]);
                }
    }
    void choreography_sort(Huluwa array[]){
        for(int k=0;k<array.length;k++)
            for(int i=0;i<array.length-1;i++)
                if(!array[i].is_small(array[i+1])){
                    array[i].exchange(array[i+1]);
                }
    }
}