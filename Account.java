/**
 * 
 */
package ca.bcit.comp1451.assignment1;

import java.util.ArrayList;


/**
 * @author seikoigi
 *
 */
public class Account {
	private Customer customer;
	private String accountNumber;
	private Date accountCreatedDate;
	private double balance;
	private ArrayList<TransactionRecord> transactionRecords;
	private static int uniqueNumber;

	/**
	 * constructor
	 * @param customer
	 * @param accountCreatedDate
	 * @param balance
	 */
	public Account(Customer customer, Date accountCreatedDate, double balance) {
		setCustomer(customer);
		setAccountCreatedDate(accountCreatedDate);
		setBalance(balance);
		transactionRecords = new ArrayList<TransactionRecord>();
		createAccountNumber();
	}
	
	/**
	 * create account number
	 */
	private void createAccountNumber() {
		uniqueNumber++;
		accountNumber = "ab" + uniqueNumber;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber
	 *            the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the accountCreatedDate
	 */
	public Date getAccountCreatedDate() {
		return accountCreatedDate;
	}

	/**
	 * @param accountCreatedDate
	 *            the accountCreatedDate to set
	 */
	public void setAccountCreatedDate(Date accountCreatedDate) {
		this.accountCreatedDate = accountCreatedDate;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance
	 *            the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	/**
	 * add amount to the balance if the amount is positive
	 * @param amount
	 * @return true or false
	 */
	public boolean deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			return true;
		} else {
			System.out.println("the amount was invalid");
			return false;
		}

	}
	
	/**
	 * withdraw money from the balance
	 * @param amount
	 * @return true or false
	 */
	public boolean withdraw(double amount) {
		if (amount < 0) {
			System.out.println("Your withdraw amount is negative");
			return false;
		} else if ((balance - amount) < 0) {
			System.out.println("Your balance is negative");
			return false;
		} else {
			balance -= amount;
			return true;
		}

	}
	
	/**
	 * Add a transaction object to the arrayList
	 * @param t transaction record object
	 */
	public void addTransaction(TransactionRecord t) {
		transactionRecords.add(t);
	}
	
	/**
	 * loop through the collection and display each transaction detail
	 */
	public void displayTransactionDetails() {
		for (TransactionRecord tr : transactionRecords) {
			System.out.println(tr.getIssued().formattedDate());
			System.out.println(tr.getTransactionType());
			System.out.println(tr.getAmount());
		}
	}
	
	/**
	 * display account detail
	 */
	public void displayDetail() {
		customer.displayFullName();
		System.out.println(accountCreatedDate.formattedDate());
		System.out.println(getBalance());

	}

}
