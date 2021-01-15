import java.util.*;

public class CalabashList extends ArrayList<Calabash>{
	public CalabashList(){
		super();
	}
	public CalabashList(int initialCapacity){
		super(initialCapacity);
	}
	public CalabashList(Collection<Calabash> c){
		super(c);
	}
	
	public Iterable<Calabash> reversed(){
		return new Iterable<Calabash>(){
			public Iterator<Calabash> iterator(){
				return new Iterator<Calabash>(){
					private int current = size() - 1;
					public boolean hasNext(){
						return current > -1;
					}
					public Calabash next(){
						return get(current--);
					}
				};
			}
		};
	}
	
	public Iterable<Calabash> randomized(){
		return new Iterable<Calabash>(){
			public Iterator<Calabash> iterator(){
				ArrayList<Calabash> shuffled = new ArrayList<Calabash>(CalabashList.this);
				Collections.shuffle(shuffled, new Random());
				return shuffled.iterator();
			}
		};
	}
	
	public CalabashList maleList(){
		CalabashList ret = new CalabashList(this.size());
		for(Calabash c : this){
			if(c.getGender() == "Male"){
				ret.add(c);
			}
		}
		ret.trimToSize();
		return ret;
	}
	
	public CalabashList femaleList(){
		CalabashList ret = new CalabashList(this.size());
		for(Calabash c : this){
			if(c.getGender() == "Female"){
				ret.add(c);
			}
		}
		ret.trimToSize();
		return ret;
	}
}
					