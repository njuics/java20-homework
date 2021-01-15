package homework_7;
import java.util.Comparator;

class Asc_Comparator implements Comparator<Calabash_Brothers>{

	@Override
	public int compare(Calabash_Brothers o1, Calabash_Brothers o2) {
		// TODO Auto-generated method stub
		return o1.get_name().compareTo(o2.get_name());
	}
	
}

class Des_Comparator implements Comparator<Calabash_Brothers>{

	@Override
	public int compare(Calabash_Brothers o1, Calabash_Brothers o2) {
		// TODO Auto-generated method stub
		return o2.get_name().compareTo(o1.get_name());
	}
	
}
