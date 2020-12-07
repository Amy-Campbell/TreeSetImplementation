
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
 // to be replaced by your own implementation of TreeSet

/**
 * test cases related to the iterator() method
 * @author samle
 *
 */
class TestIterator {

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
	 * iterator of set of String objects
	 */
	@Test
	void itr_str_set() {
		TreeSet<String> test = new TreeSet<String>();
		for (String s:ss1to20) {
			test.add(s);
		}
		if (!ss1to20.equals(test)) {
			fail("test iterator of string objects");
		}
	}
	
	/**
	 * iterator of set of custom class objects
	 */
	@Test
	void itr_pt_set() {
		TreeSet<Patient> test = new TreeSet<Patient>();
		for (Patient p:ps1to20) {
			test.add(p);
		}
		if (!ps1to20.equals(test)) {
			fail("test iterator of custom class objects");
		}
	}

	/**
	 * test remove method from iterator
	 */
	@Test
	void itr_remove_str_set() {
		Iterator<String> itr = ss1to20.iterator();
		itr.next(); // remove one element
		itr.remove();
		if (ss1to20.size()!=19) {
			fail("test remove one element on iterator of string objects");
		}
		while(itr.hasNext()) {
			itr.next();
			itr.remove();
		}
		if (!ss1to20.isEmpty()) {
			fail("test remove all elements on iterator of string objects");
		}
	}
	
	/**
	 * test remove method from iterator
	 */
	@Test
	void itr_remove_pt_set() {
		Iterator<Patient> itr = ps1to20.iterator();
		itr.next(); // remove one element
		itr.remove();
		if (ps1to20.size()!=19) {
			fail("test remove one element on iterator of custom class objects");
		}
		while(itr.hasNext()) {
			itr.next();
			itr.remove();
		}
		if (!ps1to20.isEmpty()) {
			fail("test remove all elements on iterator of custom class objects");
		}
	}
}