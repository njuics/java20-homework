public class SelectSort{
    public static void selectionSort(int[] list){
        for(int i = 0;i < list.length - 1;i++){
            int currentMin = list[i];
            int currentIndex = i;
            for(int j = i + 1;j < list.length; j++){
                if(currentMin > list[j]){
                    currentMin = list[j];
                    currentIndex = j;
                }
            }
            if(currentIndex !=i){
                list[currentIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }
    public static void main(String[] args){
        int[] arrry={3, 5,19,34,25,44,22,9,56,100,6};
        System.out.println("The raw data:");
        for(int e:arrry){
            System.out.print(e + " ");
        }
        selectionSort(arrry);
        System.out.println();
        System.out.println("The sorted data:");
        for(int e:arrry){
            System.out.print(e + " ");
        }
    }
}