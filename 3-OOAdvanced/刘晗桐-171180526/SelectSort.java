package OOPAdvanced;

public class SelectSort extends SortMethod implements SortModes {
	SelectSort() {
		this.sortMethodName = "Selection Sort";
	}
	public void orchestration(CalBro[] bros, Grandpa grandPa) {
		for(int i = 0; i < bros.length - 1; ++i) {
			int max = 0;
			for(int j = i + 1; j < bros.length - i; ++j) {
				if(grandPa.compare(bros[j], bros[max]) > 0)
					max = j;
			}
			grandPa.swap(bros[bros.length-i-1], bros[max]);
		}
	}
	public void choreography(CalBro[] bros) {
		for(int i = 0; i < bros.length - 1; ++i) {
			int max = 0;
			for(int j = i + 1; j < bros.length - i; ++j) {
				if(bros[j].compare(bros[max]) > 0)
					max = j;
			}
			bros[bros.length-i-1].swap(bros[max]);
		}
	}
}
