package BaseTest;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import Main.Universe;
import UnitCollection.ORDER;
import Units.HuLuBaby;
import Units.OldMan;

public class HuLuTest {

	private Universe u;
	private OldMan o;
	private final int babyNum = 2000;
	
	@Before
	public void init() {
		u = new Universe();
		u.oldMan = new OldMan("Old Man", 100, 100, u.mainGr);
		o = u.oldMan;
		
		for (int i = 0; i < babyNum; ++i) {
			o.giveBirth();
		}
	}
	
	@Test
	public void test_OldMan_GiveBirth() {
		//Universe u = new Universe();
		//u.oldMan = new OldMan("Old Man", 100, 100, u.mainGr);
		//OldMan o = u.oldMan;
		assertTrue(o.getChildList().size() == babyNum);
		for (HuLuBaby h: o.getChildList().getIterable()) {
			assertTrue(h.getName().length() == 7 || h.getName().length() == 11);
		}
	}
	
	@Test(timeout = 1000)
	public void test_SortTime(){
		o.sortChildList(ORDER.RANDOM);
		o.sortChildList(ORDER.DESC, true);
		o.sortChildList(ORDER.ASC,false);
		o.sortChildListByComparator(ORDER.ASC, true);
		o.sortChildListByComparator(ORDER.DESC, false);
	}
	
	@Test
	public void test_SortResult() {
		o.sortChildList(ORDER.ASC,false);
		for (int i = 0; i < o.getChildList().size() - 1; ++i) {
			assertTrue(o.getChildList().get(i).getName().compareTo(o.getChildList().get(i + 1).getName()) <= 0);
		}
		
		o.sortChildList(ORDER.DESC,false);
		for (int i = 0; i < o.getChildList().size() - 1; ++i) {
			assertTrue(o.getChildList().get(i).getName().compareTo(o.getChildList().get(i + 1).getName()) >= 0);
		}
		
		o.sortChildListByComparator(ORDER.ASC,false);
		for (int i = 0; i < o.getChildList().size() - 1; ++i) {
			assertTrue(o.getChildList().get(i).getName().compareTo(o.getChildList().get(i + 1).getName()) <= 0);
		}
		
		o.sortChildListByComparator(ORDER.DESC,false);
		for (int i = 0; i < o.getChildList().size() - 1; ++i) {
			assertTrue(o.getChildList().get(i).getName().compareTo(o.getChildList().get(i + 1).getName()) >= 0);
		}
		
		int count = 0;
		o.sortChildList(ORDER.ASC,true);
		for (int i = 0; i < o.getChildList().size() - 1; ++i) {
			if (o.getChildList().get(i).getSex() != o.getChildList().get(i+1).getSex())
				count++;
		}
		assertTrue(count == 0 || count == 1);
		
		count = 0;
		o.sortChildListByComparator(ORDER.DESC,true);
		for (int i = 0; i < o.getChildList().size() - 1; ++i) {
			if (o.getChildList().get(i).getSex() != o.getChildList().get(i+1).getSex())
				count++;
		}
		assertTrue(count == 0 || count == 1);
	}

}
