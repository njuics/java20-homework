package UnitCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import Units.Character;

// --- 第八次作业 ---
// 很显然，人物管理者对于被管理者的名册并不仅仅局限于葫芦娃乃至正面派系
// 蛇精对于自己的喽啰等下属也需要进行名册索引
// 但二者容器有共通之处，此处使用泛型可以较好地解决上述问题

public class CharacterColl<T extends Character> {
	private List<T> CList;
	public CharacterColl() {
		// TODO Auto-generated constructor stub
		CList = new ArrayList<>();
	}
	
	public void add(T h){
		CList.add(h);
	}
	
	public int size(){
		return CList.size();
	}
	
	public T get(int i) {
		return CList.get(i);
	}
	
	public void shuffle() {
		Collections.shuffle(CList);
	}
	
	public void sortLs(ORDER od, boolean sortSx) {
		CList.forEach(x->x.setOd(od, sortSx));
		Collections.sort(CList);
	}
	
	public void sortLs(ORDER od){
		sortLs(od, false);
	}
	
	public void sortByComparator(Comparator<T> com) {
		Collections.sort(CList, com);
	}
	
	public Iterator<T> getIterator(){
		return new Iterator<T>() {
			private int ind = -1;
			
			@Override
			public T next() {
				// TODO Auto-generated method stub
				ind++;
				if (ind >= CList.size()) {
					throw new NoSuchElementException();
				}
				return CList.get(ind);
			}
			
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return ind < CList.size() - 1;
			}
		};
		
	
	}
	
	public Iterable<T> getIterable(){
		return this::getIterator;
	}
	
	public Iterator<T> getReverseIterator(){
		return new Iterator<T>() {
			private int ind = CList.size();
			
			@Override
			public T next() {
				// TODO Auto-generated method stub
				ind--;
				if (ind < 0) {
					throw new NoSuchElementException();
				}
				return CList.get(ind);
			}
			
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return ind >= 0;
			}
		};
	}
	
	public Iterable<T> getReverseIterable(){
		return this::getReverseIterator;
	}
}
