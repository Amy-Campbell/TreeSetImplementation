import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

 // to be replaced by your own implementation of TreeSet

/**
 * test cases related to the removeAll() method
 * @author samle
 *
 */
class TestRemoveAll {

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
	 * removeAll (empty set) from set of String objects
	 */
	@Test
	void removeAll_empty_str_set() {
		boolean result = ss1to20.removeAll(ss);	
		if (result || ss1to20.size()!=20) {
			fail("test removeAll (empty set) from set of String objects");
		}
	}
	
	/**
	 * removeAll (empty set) from set of custom class objects
	 */
	@Test
	void removeAll_empty_pt_set() {
		boolean result = ps1to20.removeAll(ps);	
		if (result || ps1to20.size()!=20) {
			fail("test removeAll (empty set) from set of custom class objects");
		}
	}

	/**
	 * removeAll (mutually exclusive set) from set of String objects
	 */
	@Test
	void removeAll_mut_ex_str_set() {
		boolean result = ss1to10.removeAll(ss11to25);	
		if (result || ss1to10.size()!=10) {
			fail("test removeAll (mutually exclusive set) from set of String objects");
		}
	}
	
	/**
	 * removeAll (mutually exclusive set) from set of custom class objects
	 */
	@Test
	void removeAll_mut_ex_pt_set() {
		boolean result = ps1to10.removeAll(ps11to25);	
		if (result || ps1to10.size()!=10) {
			fail("test removeAll (mutually exclusive set) from set of custom class objects");
		}
	}
	
	/**
	 * removeAll (partially overlap set) from set of String objects
	 */
	@Test
	void removeAll_overlap_str_set() {
		boolean result = ss11to25.removeAll(ss1to20);	
		if (!result || ss11to25.size()!=5) {
			fail("test removeAll (partially overlap set) from set of String objects");
		}
	}
	
	/**
	 * removeAll (partially overlap set) from set of custom class objects
	 */
	@Test
	void removeAll_overlap_pt_set() {
		boolean result = ps11to25.removeAll(ps1to20);	
		if (!result || ps11to25.size()!=5) {
			fail("test removeAll (partially overlap set) from set of custom class objects");
		}
	}
	
	/**
	 * removeAll (subset) from set of String objects
	 */
	@Test
	void removeAll_subset_str_set() {
		boolean result = ss1to20.removeAll(ss1to10);	
		if (!result || ss1to20.size()!=10) {
			fail("test removeAll (partially overlap set) from set of String objects");
		}
	}
	
	/**
	 * removeAll (subset) from set of custom class objects
	 */
	@Test
	void removeAll_subset_pt_set() {
		boolean result = ps1to20.removeAll(ps1to10);	
		if (!result || ps1to20.size()!=10) {
			fail("test removeAll (partially overlap set) from set of custom class objects");
		}
	}
}