package OOFoundation;


public class Grandpa {

    /**
     * 冒泡算法，升序排序
     * @param array
     */
    public void sortHuluwa(HuluWa[] array){

        for(int i = array.length-1 ;i>0;i--){
            for(int j = 0 ; j< i ;j++){
                if(array[j].compareTo(array[j+1]) >0){
                    HuluWa temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

    }


}
