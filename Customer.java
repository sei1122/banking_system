/**
 * 
 */
package ca.bcit.comp1451.assignment1;

/**
 * @author seikoigi
 *
 */
public class Customer {
	private String firstName;
	private String lastName;
	private String address;
	private Date dateOfBirth;
	
	/**
	 * constructor
	 * @param firstName first name 
	 * @param lastName last name
	 * @param address address
	 * @param dateOfBirth birth date
	 */
	public Customer(String firstName, String lastName, String address, Date dateOfBirth) {
		setFirstName(firstName);
		setLastName(lastName);
		setAddress(address);
		setDateOfBirth(dateOfBirth);

	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		if (firstName != null && !firstName.isEmpty()) {
			this.firstName = firstName;
		} else {
			this.firstName = "unknown";
		}

	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		if (lastName != null && !lastName.isEmpty()) {
			this.lastName = lastName;
		} else {
			this.lastName = "unknown";
		}
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		if (address != null && !address.isEmpty()) {
			this.address = address;
		} else {
			this.address = "unknown";
		}
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param name
	 * @return formatted name
	 */
	public String formatName(String name) {
		return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	/**
	 * display full name
	 */
	public void displayFullName() {
		String f = formatName(firstName);
		String l = formatName(lastName);
		System.out.println(f + " " + l);
	}
	
	/**
	 * display customer information
	 */
	public void displayCustomerInfo() {
		System.out.print("Name: ");
		displayFullName();
		System.out.println("Address: " + getAddress());
		System.out.println("Birthdate: " + getDateOfBirth().formattedDate());

	}

}
