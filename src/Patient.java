
/**
 * Class for testing the funcitonalities of Set
 * 
 * @author samle
 *
 */
public class Patient implements Comparable<Patient> {
	
	long phn;
	String name;
	int age;
	double bmi;
	
	/**
	 * constructor
	 * @param phn
	 * @param name
	 * @param age
	 * @param bmi
	 */
	public Patient(long phn, String name, int age, double bmi) {
		this.phn = phn;
		this.name = name;
		this.age = age;
		this.bmi = bmi;
	}

	/**
	 * define equivalence
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		
		// phn alone determines whether two Patient object
		// refers to the same Patient
		if (phn != other.phn)
			return false;
		return true;
	}

	
	/**
	 * compare to method
	 */
	@Override
	public int compareTo(Patient o) {
		return (int)(this.phn-o.getPhn());
	}

	/**
	 * getter for phn field
	 * @return phn
	 */
	public long getPhn() {
		return phn;
	}

	/**
	 * setter for phn field
	 * @param phn
	 */
	public void setPhn(int phn) {
		this.phn = phn;
	}

	/**
	 * getter for name field
	 * @return patient name
	 */
	public String getName() {
		return name;
	}

	/**
	 * setter for name field
	 * @param patient name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter for age field
	 * @return age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * setter for age field
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * getter for bmi field
	 * @return bmi
	 */
	public double getBmi() {
		return bmi;
	}

	/**
	 * getter for bmi field
	 * @param bmi
	 */
	public void setBmi(double bmi) {
		this.bmi = bmi;
	}
	
	
}
