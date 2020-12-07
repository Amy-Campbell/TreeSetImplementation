
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
 // to be replaced by your own implementation of TreeSet

/**
 * test cases related to the retainAll() method
 * @author samle
 *
 */
class TestRetainAll {

	TreeSet<Patient> ps, ps1to10, ps1to20, ps11to25;
	TreeSet<String> ss, ss1to10, ss1to20, ss11to25;

	@BeforeEach
	void setUp() throws Exception {
		ps = new TreeSet<Patient>();
		ps1to10 = new TreeSet<Patient>();
		ps1to20 = new TreeSet<Patient>();
		ps11to25 = new TreeSet<Patient>();

		ss = new TreeSet<String>();
		ss1to10 = new TreeSet<String>();
		ss1to20 = new TreeSet<String>();
		ss11to25 = new TreeSet<String>();
		
		for (int i=0; i<10; i++) {
			ps1to10.add(new Patient(9000111000l+i+1,"existing pt "+(i+1),0,0));
			ps1to20.add(new Patient(9000111000l+i+1,"existing pt "+(i+1),0,0));
			ss1to10.add("existing string "+(i+1));
			ss1to20.add("existing string "+(i+1));
		}
		
		for (int i=10; i<20; i++) {
			ps1to20.add(new Patient(9000111000l+i+1,"existing pt "+(i+1),0,0));
			ps11to25.add(new Patient(9000111000l+i+1,"existing pt "+(i+1),0,0));
			ss1to20.add("existing string "+(i+1));
			ss11to25.add("existing string "+(i+1));
		}
		
		for (int i=20; i<25; i++) {
			ps11to25.add(new Patient(9000111000l+i+1,"existing pt "+(i+1),0,0));
			ss11to25.add("existing string "+(i+1));
		}
		
	}

	/**
	 * retainAll (empty set) from set of String objects
	 */
	@Test
	void retainAll_empty_str_set() {
		boolean result = ss1to20.retainAll(ss);	
		if (!result || !ss1to20.isEmpty()) {
			fail("test retainAll (empty set) from set of String objects");
		}
	}
	
	/**
	 * retainAll (empty set) from set of custom class objects
	 */
	@Test
	void retain_empty_pt_set() {
		boolean result = ps1to20.retainAll(ps);	
		if (!result || !ps1to20.isEmpty()) {
			fail("test retainAll (empty set) from set of custom class objects");
		}
	}
	
	
	/**
	 * retainAll (mutually exclusive set) from set of String objects
	 */
	@Test
	void retainAll_mut_ex_str_set() {
		boolean result = ss1to10.retainAll(ss11to25);	
		if (!result || !ss1to10.isEmpty()) {
			fail("test retainAll (mutually exclusive set) from set of String objects");
		}
	}
	
	/**
	 * retainAll (mutually exclusive set) from set of custom class objects
	 */
	@Test
	void retain_mut_ex_pt_set() {
		boolean result = ps1to10.retainAll(ps11to25);	
		if (!result || !ps1to10.isEmpty()) {
			fail("test retainAll (mutually exclusive set) from set of custom class objects");
		}
	}

	/**
	 * retainAll (overlap set) from set of String objects
	 */
	@Test
	void retainAll_overlap_str_set() {
		boolean result = ss1to20.retainAll(ss11to25);	
		if (!result || ss1to20.size()!=10) {
			fail("test retainAll (overlap set) from set of String objects");
		}
	}
	
	/**
	 * retainAll (overlap set) from set of custom class objects
	 */
	@Test
	void retain_overlap_pt_set() {
		boolean result = ps1to20.retainAll(ps11to25);	
		if (!result || ps1to20.size()!=10) {
			fail("test retainAll (overlap set) from set of custom class objects");
		}
	}
	
	/**
	 * retainAll (subset) from set of String objects
	 */
	@Test
	void retainAll_subset_str_set() {
		boolean result = ss1to20.retainAll(ss1to10);	
		if (!result || ss1to20.size()!=10) {
			fail("test retainAll (subset) from set of String objects");
		}
	}
	
	/**
	 * retainAll (subset) from set of custom class objects
	 */
	@Test
	void retain_subset_pt_set() {
		boolean result = ps1to20.retainAll(ps1to10);	
		if (!result || ps1to20.size()!=10) {
			fail("test retainAll (subset) from set of custom class objects");
		}
	}
}
