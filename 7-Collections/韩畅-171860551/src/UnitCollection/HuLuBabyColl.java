package UnitCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import Units.HuLuBaby;

public class HuLuBabyColl {
	private List<HuLuBaby> HLBList;
	public HuLuBabyColl() {
		// TODO Auto-generated constructor stub
		HLBList = new ArrayList<>();
	}
	
	public void add(HuLuBaby h){
		HLBList.add(h);
	}
	
	public int size(){
		return HLBList.size();
	}
	
	public HuLuBaby get(int i) {
		return HLBList.get(i);
	}
	
	public void shuffle() {
		Collections.shuffle(HLBList);
	}
	
	public void sortLs(ORDER od, boolean sortSx) {
		HLBList.forEach(x->x.setOd(od, sortSx));
		Collections.sort(HLBList);
	}
	
	public void sortLs(ORDER od){
		sortLs(od, false);
	}
	
	public void sortByComparator(Comparator<HuLuBaby> com) {
		Collections.sort(HLBList, com);
	}
	
	public Iterator<HuLuBaby> getIterator(){
		return new Iterator<HuLuBaby>() {
			private int ind = -1;
			
			@Override
			public HuLuBaby next() {
				// TODO Auto-generated method stub
				ind++;
				if (ind >= HLBList.size()) {
					throw new NoSuchElementException();
				}
				return HLBList.get(ind);
			}
			
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return ind < HLBList.size() - 1;
			}
		};
		
	
	}
	
	public Iterable<HuLuBaby> getIterable(){
		return this::getIterator;
	}
	
	public Iterator<HuLuBaby> getReverseIterator(){
		return new Iterator<HuLuBaby>() {
			private int ind = HLBList.size();
			
			@Override
			public HuLuBaby next() {
				// TODO Auto-generated method stub
				ind--;
				if (ind < 0) {
					throw new NoSuchElementException();
				}
				return HLBList.get(ind);
			}
			
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return ind >= 0;
			}
		};
	}
	
	public Iterable<HuLuBaby> getReverseIterable(){
		return this::getReverseIterator;
	}
}
