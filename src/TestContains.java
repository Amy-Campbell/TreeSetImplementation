
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
 // to be replaced by your own implementation of TreeSet

/**
 * test cases related to the contains() method
 * @author samle
 *
 */
class TestContains {

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
	 * try to find an existing string in a set of string objects
	 */
	@Test
	void test_find_in_str_set() {
		if (!ss1to20.contains("existing string 5")) {
			fail("find existing item in set of objects of String class");
		}
	}
	
	/**
	 * try to find an existing object in a set of custom class objects
	 */
	@Test
	void test_find_in_pt_set() {
		if (!ps1to20.contains(new Patient(9000111005l,"existing pt 5",10,10))) {
			fail("find existing item set of objects of custom class");
		}
	}
	
	/**
	 * try to find a non-existing object in a set of String objects
	 */
	@Test
	void test_find_non_ex_in_str_set() {
		if (ss1to20.contains("existing string 21")) {
			fail("find non-existing item in set of objects of String class");
		}
	}
	
	/**
	 * try to find a non-existing object in a set of custom class objects
	 */
	@Test
	void test_find_non_ex_in_pt_set() {
		if (ps1to20.contains(new Patient(9000111021l,"existing pt 21",10,10))) {
			fail("find non-existing item set of objects of custom class");
		}
	}
	
	/**
	 * try to find a non-existing object (different class) in a set
	 */
	@SuppressWarnings("unlikely-arg-type")
	void test_find_diff_type_in_str_set() {
		if (ss1to20.contains(new Patient(9000111021l,"existing pt 21",10,10))) {
			fail("find item of custom class in set of objects of String class");
		}
	}
	
	/**
	 * try to find a non-existing object (different class) in a set
	 */
	@SuppressWarnings("unlikely-arg-type")
	void test_find_diff_type_in_pt_set() {
		if (ps1to20.contains("existing pt 5")) {
			fail("find item of String class in set of objects of custom class");
		}
	}
}
