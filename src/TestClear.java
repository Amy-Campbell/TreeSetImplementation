
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.TreeSet; // to be replaced by your own implementation of TreeSet

/**
 * test cases related to the clear() method
 * @author samle
 *
 */
class TestClear {

	TreeSet<Patient> ps, ps1to20;
	TreeSet<String> ss1to20;

	@BeforeEach
	void setUp() throws Exception {
		ps = new TreeSet<Patient>();
		ps1to20 = new TreeSet<Patient>();

		ss1to20 = new TreeSet<String>();
		
		for (int i=0; i<20; i++) {
			ps1to20.add(new Patient(9000111000l+i+1,"existing pt "+(i+1),0,0));
			ss1to20.add("existing string "+(i+1));
		}
		
	}

	/**
	 * clear set of string objects
	 */
	@Test
	void test_clear_str_set() {
		ss1to20.clear();
				
		if (ss1to20.size()!=0) {
			fail("clear set of objects of String class");
		}
	}
	
	/**
	 * clear set of custom class objects
	 */
	@Test
	void test_clear_pt_set() {
		ps1to20.clear();
		
		if (ps1to20.size()!=0) {
			fail("clear set of objects of custom class");
		}
	}
	
	/**
	 * clear an empty set
	 */
	void test_clear_empty_set() {
		ps.clear();
		
		if (ps.size()!=0) {
			fail("clear an empty set");
		}
	}
	
}
