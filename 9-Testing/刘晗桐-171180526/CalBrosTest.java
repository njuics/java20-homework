package Testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalBrosTest {
	static final int maxNum = 50;
	static final int minNum = 1;
	CalBros testBros;
	@BeforeEach
	void setUp() throws Exception {
		testBros = new CalBros(maxNum);
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	// CalBros(int n) create a list of CalBro
	// every bro is assigned with a name between "1" ~ "n"
	// every bro has only one of two possible genders: male and female
	
	@Test
	// test whether the member is a list
	void testList() {
		List<CalBro> testClass = new LinkedList<CalBro>();
		assertEquals(testClass.getClass(), testBros.bros.getClass());
	}
	
	@Test 
	// test whether the name is in the range of "1" ~ "n"
	void testName() {
		List<CalBro> broCopy = testBros.getBroList();
		for(CalBro bro : broCopy) {
			int nameInt = Integer.parseInt(bro.getName());
			assertTrue(nameInt >= minNum && nameInt <= maxNum);
		}
	}
	
	@Test
	// test whether the gender is whether "male" or "female"
	void testGender() {
		List<CalBro> broCopy = testBros.getBroList();
		for(CalBro bro : broCopy) {
			assertTrue(bro.getGender() == "male" || bro.getGender() == "female");
		}
	}
	
	@Test
	// test whether passing a negative number will cause exception
	void testException() throws Exception {
		assertThrows(IllegalArgumentException.class, () -> new CalBros(-1));
	}	
}
