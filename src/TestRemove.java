

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// to be replaced by your own implementation of TreeSet

/**
 * test cases related to the remove() method
 * @author samle
 *
 */
class TestRemove {

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
	 * remove String objects from empty set
	 */
	@Test
	void remove_str_from_empty_set() {
		boolean result = ss.remove("test");	
		if (result || !ss.isEmpty()) {
			fail("remove String objects from empty set");
		}
	}
	
	/**
	 * remove custom class objects from empty set
	 */
	@Test
	void remove_pt_from_empty_set() {
		boolean result = ps.remove(new Patient(9000111000l,"test",0,0));	
		if (result || !ps.isEmpty()) {
			fail("remove custom class objects from empty set");
		}
	}

	/**
	 * remove existing objects from String set
	 */
	@Test
	void remove_existing_from_str_set() {
		boolean result = ss1to20.remove("existing string 7");	
		if (!result || ss1to20.size()!=19) {
			fail("remove existing objects from String set");
		}
	}
	
	/**
	 * remove existing objects from custom class set
	 */
	@Test
	void remove_existing_from_pt_set() {
		boolean result = ps1to20.remove(new Patient(9000111007l,"test",0,0));	
		if (!result || ps1to20.size()!=19) {
			fail("remove existing objects from custom class set");
		}
	}
	
	/**
	 * remove non-existing objects from String set
	 */
	@Test
	void remove_non_existing_from_str_set() {
		boolean result = ss1to20.remove("existing string 77");	
		if (result || ss1to20.size()!=20) {
			fail("remove existing objects from String set");
		}
	}
	
	/**
	 * remove non-existing objects from custom class set
	 */
	@Test
	void remove_non_existing_from_pt_set() {
		boolean result = ps1to20.remove(new Patient(9000111077l,"test",0,0));	
		if (result || ps1to20.size()!=20) {
			fail("remove existing objects from custom class set");
		}
	}
	
	
}
