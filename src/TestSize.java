

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

 // to be replaced by your own implementation of TreeSet

/**
 * test cases related to the size() method
 * @author samle
 *
 */
class TestSize {

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
	 * size of set of String objects
	 */
	@Test
	void size_str_set() {	
		if (ss1to20.size()!=20) {
			fail("test size of set of String objects");
		}
	}
	
	/**
	 * size of set of custom class objects
	 */
	@Test
	void size_pt_set() {
		if (ps1to20.size()!=20) {
			fail("test size of set of custom class objects");
		}
	}
	
	/**
	 * size of empty set of String objects
	 */
	@Test
	void size_empty_str_set() {	
		if (ss.size()!=0) {
			fail("test size of empty set of String objects");
		}
	}
	
	/**
	 * size of empty set of custom class objects
	 */
	@Test
	void size_empty_pt_set() {
		if (ps.size()!=0) {
			fail("test size of empty set of custom class objects");
		}
	}
}
