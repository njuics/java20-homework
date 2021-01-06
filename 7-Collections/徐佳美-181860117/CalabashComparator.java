import java.util.Comparator;
import java.util.Random;

class CalabashIncComparator implements Comparator<Calabash> { // 正序比较器
	public int compare(Calabash cal1, Calabash cal2) { 
		return cal1.compareTo(cal2);
	}
}

class CalabashDecComparator implements Comparator<Calabash> { // 逆序比较器
	public int compare(Calabash cal1, Calabash cal2) { 
		return cal2.compareTo(cal1);
	}
}

class CalabashRandomComparator implements Comparator<Calabash> { // 乱序比较器
	public int compare(Calabash cal1, Calabash cal2) { 
        Random rand = new Random();
        return rand.nextInt(3) - 1;
	}
}