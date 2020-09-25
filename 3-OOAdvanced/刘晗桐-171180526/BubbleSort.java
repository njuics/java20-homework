package OOPAdvanced;

public class BubbleSort extends SortMethod implements SortModes {
	BubbleSort() {
		this.sortMethodName = "Bubble Sort";
	}
	public void orchestration(CalBro[] bros, Grandpa grandPa) {
        for(int i = 0; i < bros.length - 1; ++i)
            for(int j = 0; j < bros.length - i - 1; ++j)
            	if(grandPa.compare(bros[j], bros[j+1]) > 0) {
            		grandPa.swap(bros[j], bros[j+1]);
            	}
	}
	public void choreography(CalBro[] bros) {
        for(int i = 0; i < bros.length - 1; ++i)
            for(int j = 0; j < bros.length - i - 1; ++j)
            	if(bros[j].compare(bros[j+1]) > 0) {
            		bros[j].swap(bros[j+1]);
            	}
	}
}
