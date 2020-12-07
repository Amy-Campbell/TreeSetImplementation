

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

 // to be replaced by your own implementation of TreeSet

/**
 * test cases related to the add() method
 * @author samle
 *
 */
class TestAdd {

	TreeSet<Patient> ps, ps1;
	TreeSet<String> ss, ss1;
	
	/**
	 * create an empty set
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		ps = new TreeSet<Patient>();
		ss = new TreeSet<String>();
		
		// the following, we add something so that they are 
		// non-empty set
		ps1 = new TreeSet<Patient>();
		ss1 = new TreeSet<String>();
		
		ps1.add(new Patient(9000111000l,"existing pt",0,0));
		ss1.add("existing string");
	}

	/**
	 * add an element (type: String) to an empty set
	 */
	@Test
	void test_add_str_to_empty() {
		boolean result = ss.add("test");
				
		if (!result || ss.size()!=1) {
			fail("add object of String class to empty set");
		}
	}
	
	/**
	 * add an element (type: Patient) to an empty set
	 */
	@Test
	void test_add_pt_to_empty() {
		Patient p = new Patient(9000111001l,"a",50,23.1);
		boolean result = ps.add(p);
		
		if (!result || ps.size()!=1) {
			fail("add object of custom class to empty set");
		}
	}
	
	/**
	 * add an element (type: String) to a non-empty set 
	 */
	@Test
	void test_add_str_to_nonempty() {
		boolean result = ss1.add("test");
				
		if (!result || ss1.size()!=2) {
			fail("add object of String class to non-empty set");
		}
	}
	
	/**
	 * add an element (type: Patient) to a non-empty set 
	 */
	@Test
	void test_add_pt_to_nonempty() {
		Patient p = new Patient(9000111001l,"a",50,23.1);
		boolean result = ps1.add(p);
		
		if (!result || ps1.size()!=2) {
			fail("add object of custom class to non-empty set");
		}
	}
	
	/**
	 * add an existing element (type: String) to a set
	 */
	@Test
	void test_add_existing_str() {
		boolean result = ss1.add("existing string");
				
		if (result || ss1.size()!=1) {
			fail("add existing String object");
		}
	}
	
	/**
	 * add an existing element (type: Patient) to a set
	 */
	@Test
	void test_add_existing_pt() {
		Patient p = new Patient(9000111000l,"a",10,13.1);
		boolean result = ps1.add(p);
		
		if (result || ps1.size()!=1) {
			fail("add existing custom class object");
		}
	}
}
