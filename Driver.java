/**
 * 
 */
package ca.bcit.comp1451.assignment1;

/**
 * @author seikoigi
 *
 */
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Date object birthday
		Date d1 = new Date(25, 2, 1995);
		Date d2 = new Date(31, 10, 2000);
		Date d3 = new Date(5, 12, 2017);
		Date d4 = new Date(24, 4, 1981);
		
		//Date object account created
		Date d5 = new Date(2, 2, 2000);
		Date d6 = new Date(8, 9, 2016);
		Date d7 = new Date(7, 15, 1970);
		Date d8 = new Date(4, 10, 1980);
		
		// customer object
		Customer c1 = new Customer("Jhon", "Smith", "1234 Homer Street Vancouver", d1);
		Customer c2 = new Customer("seiko", "igi", "555 Seymour St, Vancouver, BC", d2);
		Customer c3 = new Customer("LauRa", "WilLiams", "1011 Mainland St, Vancouver, BC V6B 5P9", d3);
		Customer c4 = new Customer("TayloR", "Brown", "3700 Willingdon Ave, Burnaby, BC V5G 3H2", d4);
		
		//account object
		Account a1 = new Account(c1, d5, 800);
		Account a2 = new Account(c2, d6, 10090.10);
		Account a3 = new Account(c3, d7, 200.80);
		Account a4 = new Account(c4, d8, 100000.20);
		
		// bank object
		Bank b1 = new Bank("ABC Bank");
		b1.addAccount(a1);
		b1.addAccount(a2);
		b1.addAccount(a3);
		b1.addAccount(a4);
		
		//transaction
		b1.makeTransaction();

		// c1.displayCustomerInfo();
		// c2.displayCustomerInfo();
		// c3.displayCustomerInfo();
		// c4.displayCustomerInfo();
		// System.out.println();
		//
		// a1.displayDetail();
		// a2.displayDetail();
		// a3.displayDetail();
		// a4.displayDetail();

	}

}
