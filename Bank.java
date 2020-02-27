/**
 * 
 */
package ca.bcit.comp1451.assignment1;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author seikoigi
 *
 */
public class Bank {
	private String bankName;
	private HashMap<String, Account> accountList;
	private Scanner scan;
	
	/**
	 * constructor
	 * @param bankName bank name
	 */
	public Bank(String bankName) {
		setBankName(bankName);
		accountList = new HashMap<String, Account>();
		scan = new Scanner(System.in);
	}

	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName
	 *            the bankName to set
	 */
	public void setBankName(String bankName) {
		if (bankName == null || bankName.equals("")) {
			System.out.println("Invalid Bank name");
		} else {
			this.bankName = bankName;
		}

	}
	
	/**
	 * take account object and adds it to the hashMap
	 * @param toAdd
	 */
	public void addAccount(Account toAdd) {
		if (toAdd != null) {
			accountList.put(toAdd.getAccountNumber(), toAdd);
		}
	}
	
	/**
	 * return an account from the collection
	 * @param accountNumber
	 * @return account
	 */
	public Account getAccount(String accountNumber) {
		if (accountNumber != null && accountList.containsKey(accountNumber)) {
			return accountList.get(accountNumber);
		} else {
			return null;
		}
	}
	
	/**
	 * display all the transaction associated with that account number
	 * @param accountNumber
	 */
	public void printAccountTransactions(String accountNumber) {
		if (accountNumber != null && accountList.containsKey(accountNumber)) {
			Account a = accountList.get(accountNumber);
			a.displayTransactionDetails();
		} else {
			System.out.println("Account number is invalid");
		}
	}
	
	/**
	 * scan user's input and process transaction
	 */
	public void makeTransaction() {
		boolean done = false;
		while (done == false) {

			System.out.println("Please enter your account number");
			// get account number from user
			String accountNumber = scan.next();

			// search the account number exist in a HashMap list
			if (accountNumber != null && accountList.containsKey(accountNumber)) {

				// list of possible transaction
				System.out.println("Options");
				System.out.println("1. Deposit");
				System.out.println("2. Withdraw");
				System.out.println("3. Show Transactions");
				System.out.println("Please enter option number");

				// get option from the user
				int option = scan.nextInt();

				int depositOption = 1;
				int withdrawOption = 2;
				int showTransactions = 3;

				Account account = accountList.get(accountNumber);

				if (option == depositOption) {
					Date date = Date.createUserInputDate(scan);
					double amount = transactionProcessAmount();
					boolean isValidTransaction = account.deposit(amount);
					if (isValidTransaction == true) {
						TransactionRecord deposit = new TransactionRecord(amount, date);
						deposit.setAccountNumber(account.getAccountNumber());
						deposit.setTransactionType("deposit");
						account.addTransaction(deposit);
					}

				} else if (option == withdrawOption) {
					Date date = Date.createUserInputDate(scan);
					double amount = transactionProcessAmount();
					boolean isValidTransaction = account.withdraw(amount);
					if (isValidTransaction == true) {
						TransactionRecord withdraw = new TransactionRecord(amount, date);
						withdraw.setAccountNumber(account.getAccountNumber());
						withdraw.setTransactionType("withdraw");
						account.addTransaction(withdraw);
					}

				} else if (option == showTransactions) {

					account.displayTransactionDetails();
				}

			} else {
				System.out.println("Account number is invalid");
			}
			done = !anotherTransaction();

		} // end while loop
	}
	
	/**
	 * ask user to input the amount
	 * @return amount
	 */
	public double transactionProcessAmount() {
		boolean done = false;
		double amount = 0.0;

		while (!done) {
			System.out.println("Please enter amount");
			// ask the user to input the amount
			amount = scan.nextDouble();
			
			if (amount > 0) {
				done = true;
			} else {
				System.out.println("Invlid number");
			}
		}
		return amount;
	}
	
	/**
	 * ask user whether do another transaction or not
	 * @return false
	 */
	public boolean anotherTransaction() {
		System.out.println("Do another transaction?");
		System.out.println("If yes, enter 1");
		System.out.println("If no, enter 2");

		int yes = 1;
		int no = 2;

		int answer = scan.nextInt();

		if (answer == yes) {
			return true;
		} else if (answer == no) {
			return false;
		} else {
			System.out.println("Invalid input");
		}

		return false;

	}

}
