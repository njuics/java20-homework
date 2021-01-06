import java.util.*;

public class GenderedList<T extends Gendered> extends ArrayList<T>{
	public GenderedList(){
		super();
	}
	public GenderedList(int initialCapacity){
		super(initialCapacity);
	}
	public GenderedList(Collection<T> c){
		super(c);
	}
	
	public Iterable<T> reversed(){
		return new Iterable<T>(){
			public Iterator<T> iterator(){
				return new Iterator<T>(){
					private int current = size() - 1;
					public boolean hasNext(){
						return current > -1;
					}
					public T next(){
						return get(current--);
					}
				};
			}
		};
	}
	
	public Iterable<T> randomized(){
		return new Iterable<T>(){
			public Iterator<T> iterator(){
				ArrayList<T> shuffled = new ArrayList<>(GenderedList.this);
				Collections.shuffle(shuffled, new Random());
				return shuffled.iterator();
			}
		};
	}
	
	public GenderedList<T> maleList(){
		GenderedList<T> ret = new GenderedList<>(this.size());
		for(T c : this){
			if(c.getGender() == Gendered.MALE){
				ret.add(c);
			}
		}
		ret.trimToSize();
		return ret;
	}
	
	public GenderedList<T> femaleList(){
		GenderedList<T> ret = new GenderedList<>(this.size());
		for(T c : this){
			if(c.getGender() == Gendered.FEMALE){
				ret.add(c);
			}
		}
		ret.trimToSize();
		return ret;
	}
}
					