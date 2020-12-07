

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

 // to be replaced by your own implementation of TreeSet

/**
 * test cases related to the equals() method
 * @author samle
 *
 */
class TestEquals {

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
	 * compare sets of string objects (mutually exclusive)
	 */
	@Test
	void test_equals_in_str_set_mut_ex() {
		if (ss1to10.equals(ss11to25)) {
			fail("compare mutually excludive sets of objects of String class");
		}
	}
	
	/**
	 * compare sets of custom class objects (mutually exclusive)
	 */
	@Test
	void test_equals_in_pt_set_mut_ex() {
		if (ps1to10.equals(ps11to25)) {
			fail("compare mutually excludive sets of objects of custom class");
		}
	}
	
	/**
	 * compare set of string objects (some overlap)
	 */
	@Test
	void test_equals_in_str_set_some_overlap() {
		if (ss1to20.equals(ss11to25)) {
			fail("compare partial overlap sets of objects of String class");
		}
	}
	
	/**
	 * compare set of custom class objects (some overlap)
	 */
	@Test
	void test_equals_in_pt_set_mut_some_overlap() {
		if (ps1to20.equals(ps11to25)) {
			fail("compare partial overlap sets of objects of custom class");
		}
	}
	
	/**
	 * compare set of string objects (complete overlap)
	 */
	@Test
	void test_equals_in_str_set_complete_overlap() {
		TreeSet<String> ss2 = new TreeSet<String>();
		for (int i=0; i<20; i++) {
			ss2.add("existing string "+(i+1));
		}
		
		if (!ss1to20.equals(ss2)) {
			fail("compare complete overlap sets of objects of String class");
		}
	}
	
	/**
	 * compare set of custom class objects (complete overlap)
	 */
	@Test
	void test_equals_in_pt_set_mut_complete_overlap() {
		TreeSet<Patient> ps2 = new TreeSet<Patient>();
		for (int i=0; i<20; i++) {
			ps2.add(new Patient(9000111000l+i+1,"test pt "+(i+1),10,10));
		}
		
		if (!ps1to20.equals(ps2)) {
			fail("compare complete overlap sets of objects of custom class");
		}
	}
	
	/**
	 * compare set of string objects (complete overlap - mix order)
	 */
	@Test
	void test_equals_in_str_set_complete_overlap_mx() {
		TreeSet<String> ss2 = new TreeSet<String>();
		for (int i=19; i>=0; i--) {
			ss2.add("existing string "+(i+1));
		}
		
		if (!ss1to20.equals(ss2)) {
			fail("compare complete overlap sets of objects of String class; different order");
		}
	}
	
	/**
	 * compare set of custom class objects (complete overlap - mix order)
	 */
	@Test
	void test_equals_in_pt_set_mut_complete_overlap_mx() {
		TreeSet<Patient> ps2 = new TreeSet<Patient>();
		for (int i=19; i>=0; i--) {
			ps2.add(new Patient(9000111000l+i+1,"test pt "+(i+1),10,10));
		}
		
		if (!ps1to20.equals(ps2)) {
			fail("compare complete overlap sets of objects of custom class; different order");
		}
	}
	
	
}
