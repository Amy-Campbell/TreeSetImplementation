

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
// to be replaced by your own implementation of TreeSet

/**
 * test cases related to the addAll() method
 * @author samle
 *
 */
class TestAddAll {

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
	 * addAll elements (type: String) to an empty set
	 */
	@Test
	void test_addall_str_to_empty() {
		boolean result = ss.addAll(ss1to20);
				
		if (!result || ss.size()!=20) {
			fail("addAll objects of String class to empty set");
		}
	}
	
	/**
	 * addAll elements (type: Patient) to an empty set
	 */
	@Test
	void test_add_pt_to_empty() {
		boolean result = ps.addAll(ps1to20);
		
		if (!result || ps.size()!=20) {
			fail("addAll objects of custom class to empty set");
		}
	}
	
	/**
	 * addAll elements (type: String) to a non-empty set (mutually exclusive)
	 */
	@Test
	void test_add_str_to_nonempty_ex() {
		boolean result = ss1to10.addAll(ss11to25);
				
		if (!result || ss1to10.size()!=25) {
			fail("addAll objects of String class to non-empty set (mutually exclusive)");
		}
	}
	
	/**
	 * addAll elements (type: Patient) to a non-empty set (mutually exclusive)
	 */
	@Test
	void test_add_pt_to_nonempty_ex() {
		boolean result = ps1to10.addAll(ps11to25);
		
		if (!result || ps1to10.size()!=25) {
			fail("addAll objects of custom class to non-empty set (mutually exclusive)");
		}
	}
	
	/**
	 * addAll elements (type: String) to a non-empty set (some overlap)
	 */
	@Test
	void test_add_str_to_nonempty_some_overlap() {
		boolean result = ss1to20.addAll(ss11to25);
				
		if (!result || ss1to20.size()!=25) {
			fail("addAll objects of String class to non-empty set (some overlap)");
		}
	}
	
	/**
	 * addAll elements (type: Patient) to a non-empty set (some overlap)
	 */
	@Test
	void test_add_pt_to_nonempty_some_overlap() {
		boolean result = ps1to20.addAll(ps11to25);
		
		if (!result || ps1to20.size()!=25) {
			fail("addAll objects of custom class to non-empty set (some overlap)");
		}
	}
	
	/**
	 * add an existing element (type: String) to a set (complete overlap)
	 */
	@Test
	void test_addAll_existing_str() {
		boolean result = ss1to20.addAll(ss1to10);
				
		if (result || ss1to20.size()!=20) {
			fail("addAll existing list of String object");
		}
	}
	
	/**
	 * add an existing element (type: Patient) to a set (complete overlap)
	 */
	@Test
	void test_addAll_existing_pt() {
		boolean result = ps1to20.addAll(ps1to10);
		
		if (result || ps1to20.size()!=20) {
			fail("addAll existing list of custom class object");
		}
	}

}
