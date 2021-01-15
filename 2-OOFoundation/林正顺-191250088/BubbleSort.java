public class BubbleSort extends Sort{
    public void concreteSort(CalabashBrothers[] brothers, int l, int r){
        CalabashBrothers temp;

        for(int i = l; i < r; i++){
            for(int j = l; j < r - i; j++){
                if(brothers[j].getNumber() > brothers[j + 1].getNumber()){
                    temp = brothers[j];
                    brothers[j] = brothers[j + 1];
                    brothers[j + 1] = temp;
                }
            }
        }
    }
}
