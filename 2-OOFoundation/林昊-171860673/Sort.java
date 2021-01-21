public class Sort {
    public static void algorithmSort(SingleHuLuWa huLuWaArray[]){
        for (int i = 1; i < huLuWaArray.length; i++) {
            SingleHuLuWa currHuLuWa = huLuWaArray[i];
            int j = i - 1;
            while (j >= 0 && huLuWaArray[j].getPriority() > currHuLuWa.getPriority()) {
                huLuWaArray[j + 1] = huLuWaArray[j];
                j--;
            }
            huLuWaArray[j + 1] = currHuLuWa;
        }
    }
    public static void grandpaSort(SingleHuLuWa huLuWaArray[]) {
        SingleHuLuWa[] sortedArray = new SingleHuLuWa[7];
        for (int i = 0; i < huLuWaArray.length; i++) {
            int priori = huLuWaArray[i].getPriority();
            sortedArray[priori - 1] = huLuWaArray[i];
        }
        for (int i = 0; i < huLuWaArray.length; i++) {
            huLuWaArray[i] = sortedArray[i];
        }
    }
    public static void cooperationSort(SingleHuLuWa huLuWaArray[]){
        for (int i = 1; i < huLuWaArray.length; i++) {
            SingleHuLuWa currHuLuWa = huLuWaArray[i];
            int j = i - 1;
            while (j >= 0 && huLuWaArray[j].compareTo(currHuLuWa)) {
                huLuWaArray[j + 1] = huLuWaArray[j];
                j--;
            }
            huLuWaArray[j + 1] = currHuLuWa;
        }
    }
}
