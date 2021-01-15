import java.util.Comparator;

public class CalabashComparator implements Comparator<Calabash>{
	@Override
	public int compare(Calabash x, Calabash y){
		return x.getName().compareTo(y.getName());
	}
}
