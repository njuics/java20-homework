package CalabashBrother;

public class Sort {
        public static void bubbleSort(CalabashBrother[] calabashBrothers){
        for(int i = 0;i < (calabashBrothers.length);i++){
            for(int j = 0;j < calabashBrothers.length -1 - i;j++){
                if(calabashBrothers[j].getColor() > calabashBrothers[j + 1].getColor()){
                    CalabashBrother temp = calabashBrothers[j + 1];
                    calabashBrothers[j+1] = calabashBrothers[j];
                    calabashBrothers[j] = temp;
                }
            }
        }
    }
}
