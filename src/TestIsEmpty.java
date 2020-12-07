

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.TreeSet; // to be replaced by your own implementation of TreeSet

/**
 * test cases related to the equals() method
 * @author samle
 *
 */
class TestIsEmpty {

	TreeSet<Patient> ps, ps1to20;
	TreeSet<String> ss, ss1to20;

	@BeforeEach
	void setUp() throws Exception {
		ps = new TreeSet<Patient>();
		ss = new TreeSet<String>();
		
		ps1to20 = new TreeSet<Patient>();
		ss1to20 = new TreeSet<String>();
		
		for (int i=0; i<20; i++) {
			ps1to20.add(new Patient(9000111000l+i+1,"existing pt "+(i+1),0,0));
			ss1to20.add("existing string "+(i+1));
		}
		
	}

	/**
	 * set of non-empty string objects
	 */
	@Test
	void test_non_empty_str_set() {
		if (ss1to20.isEmpty()) {
			fail("test isEmpty on set of non-empty string objects");
		}
	}
	
	/**
	 * set of non-empty custom class objects
	 */
	@Test
	void test_non_empty_pt_set() {
		if (ps1to20.isEmpty()) {
			fail("test isEmpty on set of non-empty objects of custom class");
		}
	}
	
	/**
	 * set of empty string objects
	 */
	@Test
	void test_empty_str_set() {
		if (!ss.isEmpty()) {
			fail("test isEmpty on set of empty string objects");
		}
	}
	
	/**
	 * set of empty custom class objects
	 */
	@Test
	void test_empty_pt_set() {
		if (!ps.isEmpty()) {
			fail("test isEmpty on set of empty objects of custom class");
		}
	}
}
