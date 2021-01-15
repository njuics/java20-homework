public class Sort {
	public void bubbleSort(Characters[] bros) {
        for(int i = 0; i < bros.length - 1; ++i)
            for(int j = 0; j < bros.length - i - 1; ++j)
            	if(bros[j].id > bros[j+1].id) {
            		Characters temp = bros[j];
            		bros[j] = bros[j+1];
            		bros[j + 1] = temp;
            	}
	}

	public void selectSort(Characters[] bros) {
		for(int i = 0; i < bros.length - 1; ++i) {
			int max = 0;
			for(int j = i + 1; j < bros.length - i; ++j) {
				if(bros[j].id > bros[max].id)
					max = j;
			}
			Characters temp = bros[bros.length - i - 1];
			bros[bros.length - i - 1] = bros[max];
			bros[max] = temp;
		}
	}
}