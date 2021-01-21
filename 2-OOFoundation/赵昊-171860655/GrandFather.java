public class GrandFather {
    private static final int sortMode = 1;
    public void SortBrothers(CalabashBrother[] brothersArray){
        System.out.println("爷爷指挥排序，排序前点名：");
        for (CalabashBrother calabashBrother : brothersArray)
            System.out.print(calabashBrother.getName()+" ");
        System.out.println();
        switch (sortMode){
            case 1:selectSort(brothersArray);System.out.println("使用选择排序");break;
            case 2:bubbleSort(brothersArray);System.out.println("使用冒泡排序");break;
            case 3:quickSort(brothersArray,0,brothersArray.length-1);System.out.println("使用快速排序");break;
            default:System.out.println("不存在的排序模式");
        }
        System.out.println("排好序后点名：");
        for (CalabashBrother calabashBrother : brothersArray)
            System.out.print(calabashBrother.getName()+" ");
        System.out.println();
    }
    private void quickSort(CalabashBrother[] brothersArray,int left,int right) {
        if(left>=right)
            return;
        int i = left;
        int j = right;
        CalabashBrother key = brothersArray[left];
        while(i<j) {
            while(i<j && brothersArray[j].getRank()>=key.getRank())
                j--;
            if(i<j) {
                brothersArray[i] = brothersArray[j];
                i++;
            }
            while(i<j && brothersArray[i].getRank()<key.getRank())
                i++;
            if(i<j) {
                brothersArray[j] = brothersArray[i];
                j--;
            }
        }
        brothersArray[i] = key;
        quickSort(brothersArray, left, i-1);
        quickSort(brothersArray, i+1, right);
    }

    public void selectSort(CalabashBrother[] brothersArray){
        for(int i=0;i<brothersArray.length;i++)
        {
            int minRank = brothersArray[i].getRank();
            int mark = i;
            for(int j=i+1;j<brothersArray.length;j++)
            {
                if(brothersArray[j].getRank()<minRank){
                    minRank = brothersArray[j].getRank();
                    mark = j;
                }
            }
            if(i!=mark){
                CalabashBrother temp = brothersArray[i];
                brothersArray[i] = brothersArray[mark];
                brothersArray[mark] = temp;
            }
        }
    }
    public void bubbleSort(CalabashBrother[] brothersArray){
        for(int i = 0;i<brothersArray.length-1;i++){
            for(int j = 0;j<brothersArray.length-1-i;j++){
                if(brothersArray[j].getRank()>brothersArray[j+1].getRank()) {
                    CalabashBrother temp = brothersArray[j+1];
                    brothersArray[j+1] = brothersArray[j];
                    brothersArray[j] = temp;
                }
            }
        }
    }

}
