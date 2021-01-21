package app;

import java.util.Random;



class CalabashIncComparator <T extends Comparable<? super T>> extends Sortset<T> { // 正序比较器
	public int compare(T cal1, T cal2) { 
		return cal1.compareTo(cal2);
	}
}

class CalabashDecComparator <T extends Comparable<? super T>> extends Sortset<T> { // 逆序比较器
	public int compare(T cal1, T cal2) { 
		return cal2.compareTo(cal1);
	}
}

class CalabashRandomComparator <T extends Comparable<? super T>> extends Sortset<T>{ // 乱序比较器
	public int compare(T cal1, T cal2) { 
        Random rand = new Random();
        return rand.nextInt(3) - 1;
	}
}