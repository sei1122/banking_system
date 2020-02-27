/**
 * 
 */
package ca.bcit.comp1451.assignment1;

import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
//import java.util.HashMap;
//import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author seikoigi
 *
 */
public class Testing {

	/**
	 * @throws java.lang.Exception
	 */
	private Bank bank;
	// private HashMap<String, Account> accountList;
	// private Scanner scan;

	@Before
	public void setUp() throws Exception {
		bank = new Bank("ABC Bnak");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {

	}

	/**
	 * Test method for bank constructor positive
	 */
	@Test
	public void testBankPositive() {
		assertEquals("ABC Bnak", bank.getBankName());
	}

	/**
	 * Test method for bank constructor negative
	 */
	@Test
	public void testBankNegative() {
		Bank bank = new Bank(null);
		assertEquals(null, bank.getBankName());
	}

	/**
	 * Test method getBankName Positive
	 */
	@Test
	public void testGetBankNamePositive() {
		Bank bank = new Bank("test bank");
		assertEquals("test bank", bank.getBankName());
	}

	/**
	 * Test method get BankName Negative
	 */
	@Test
	public void testGetBankNameNegatibe() {
		Bank bank = new Bank(null);
		assertEquals(null, bank.getBankName());
	}

	/**
	 * Test method set bank name positive
	 */
	@Test
	public void testSetBankNamePositive() {
		Bank bank = new Bank("test bank");
		assertEquals("test bank", bank.getBankName());
	}

	/**
	 * Test method set bank name negative
	 */
	@Test
	public void testSetBankNameNegative() {
		Bank bank = new Bank("");
		assertEquals(null, bank.getBankName());
	}

	/**
	 * Test method for add account to the HashMap accountList positive
	 */
	@Test
	public void testAddAccountPositive() {
		Date d1 = new Date(25, 2, 1995);
		Date d5 = new Date(2, 2, 2000);
		Customer c1 = new Customer("Jhon", "Smith", "1234 Homer Street Vancouver", d1);
		Account a1 = new Account(c1, d5, 800);
		bank.addAccount(a1);
		Account testAccount = bank.getAccount(a1.getAccountNumber());
		assertEquals(a1, testAccount);
	}

	/**
	 * Test method for add account to the HashMap accountList negative
	 */
	@Test
	public void testAddAccountNegative() {
		Date d1 = new Date(25, 2, 1995);
		Date d5 = new Date(2, 2, 2000);
		Customer c1 = new Customer("Jhon", "Smith", "1234 Homer Street Vancouver", d1);
		Account a1 = new Account(c1, d5, 800);
		bank.addAccount(a1);
		// some other bank account number
		Account testAccount = bank.getAccount("ccc10000");
		assertEquals(null, testAccount);
	}

	/**
	 * Test method for get account positive
	 */
	@Test
	public void testGetAccountPositive() {
		Date d1 = new Date(25, 2, 1995);
		Date d5 = new Date(2, 2, 2000);
		Customer c1 = new Customer("Jhon", "Smith", "1234 Homer Street Vancouver", d1);
		Account a1 = new Account(c1, d5, 800);
		bank.addAccount(a1);
		Account testAccount = bank.getAccount(a1.getAccountNumber());
		assertEquals(a1, testAccount);
	}

	/**
	 * Test method for get account negative
	 */
	@Test
	public void testGetAccountNegative() {
		Date d1 = new Date(25, 2, 1995);
		Date d5 = new Date(2, 2, 2000);
		Customer c1 = new Customer("Jhon", "Smith", "1234 Homer Street Vancouver", d1);
		Account a1 = new Account(c1, d5, -1);
		bank.addAccount(a1);
		Account testAccount = bank.getAccount("ccc10");
		assertEquals(null, testAccount);
	}

	/**
	 * Test method for transaction positive
	 */
	@Test
	public void testMakeTransactionPositive() {

		ByteArrayInputStream in = new ByteArrayInputStream(
				String.format("ab999%n1%n11%n11%n2013%n800.2%n1%nab999%n2%n11%n11%n2013%n800.2%n1%nab999%n3%n2%n")
						.getBytes());
		System.setIn(in);

		Date d2 = new Date(31, 10, 2000);
		Date d6 = new Date(8, 9, 2016);
		Customer c2 = new Customer("seiko", "igi", "555 Seymour St, Vancouver, BC", d2);
		Account a2 = new Account(c2, d6, 10090.10);
		a2.setAccountNumber("ab999");
		Bank b1 = new Bank("ABC Bank");
		b1.addAccount(a2);
		b1.makeTransaction();

		Account testAccount = b1.getAccount("ab999");

		assertEquals(10090.10, testAccount.getBalance(), .01);

		// reset System.in to its original
		// System.setIn(System.in)x`
	}

	/**
	 * Test method for transaction negative
	 */
	@Test
	public void testMakeTransactionNegative() {

		// try to deposit -800.2 then then use the correct 1.0
		ByteArrayInputStream in = new ByteArrayInputStream(
				String.format("ab999%n1%n11%n11%n2013%n-800.2%n1.0%n1%nab999%n3%n2%n").getBytes());
		System.setIn(in);

		Date d2 = new Date(31, 10, 2000);
		Date d6 = new Date(8, 9, 2016);
		Customer c2 = new Customer("seiko", "igi", "555 Seymour St, Vancouver, BC", d2);
		Account a2 = new Account(c2, d6, 10090.10);
		a2.setAccountNumber("ab999");
		Bank b1 = new Bank("ABC Bank");
		b1.addAccount(a2);
		b1.makeTransaction();

		Account testAccount = b1.getAccount("ab999");

		assertEquals(10091.10, testAccount.getBalance(), .01);

		// reset System.in to its original
		// System.setIn(System.in)x`
	}

	/**
	 * Test method for account transactions positive display all the transaction
	 * associated with that account number
	 */
	@Test
	public void testPrintAccountTransactionsPositive() {

		// Keep current System.out with us
		PrintStream oldOut = System.out;
		ByteArrayOutputStream printOutputStream = new ByteArrayOutputStream();

		Date d1 = new Date(25, 2, 1995);
		Date d5 = new Date(2, 2, 2000);
		Customer c1 = new Customer("Jhon", "Smith", "1234 Homer Street Vancouver", d1);
		Account a1 = new Account(c1, d5, 500.30);

		double amount = 800.2;
		boolean depositValid = a1.deposit(amount);
		if (depositValid) {
			TransactionRecord deposit = new TransactionRecord(amount, d5);
			deposit.setAccountNumber(a1.getAccountNumber());
			deposit.setTransactionType("deposit");
			a1.addTransaction(deposit);
		}

		// override all system print outs into printOutputStream
		System.setOut(new PrintStream(printOutputStream));

		a1.displayTransactionDetails();

		// Copy the stream output into a string.
		String printOutputString = new String(printOutputStream.toByteArray());

		// Reset the System.out
		System.setOut(oldOut);

		String expectedOutput = "02/February/2000";
		assertTrue(printOutputString.contains(expectedOutput));

	}

	/**
	 * Test method for account transactions, negative display all the
	 * transaction associated with that account number
	 */
	@Test
	public void testPrintAccountTransactionsNegative() {

		// Keep current System.out with us
		PrintStream oldOut = System.out;
		ByteArrayOutputStream printOutputStream = new ByteArrayOutputStream();

		Date d1 = new Date(25, 2, 1995);
		Date d5 = new Date(2, 2, 2000);
		Customer c1 = new Customer("Jhon", "Smith", "1234 Homer Street Vancouver", d1);
		Account a1 = new Account(c1, d5, 500.30);

		double amount = -800.2;
		boolean depositValid = a1.deposit(amount);
		if (depositValid) {
			TransactionRecord deposit = new TransactionRecord(amount, d5);
			deposit.setAccountNumber(a1.getAccountNumber());
			deposit.setTransactionType("deposit");
			a1.addTransaction(deposit);
		}

		// override all system print outs into printOutputStream
		System.setOut(new PrintStream(printOutputStream));

		a1.displayTransactionDetails();

		// Copy the stream output into a string.
		String printOutputString = new String(printOutputStream.toByteArray());

		// Reset the System.out
		System.setOut(oldOut);

		assertTrue(printOutputString.length() == 0);
	}

	/**
	 * Test method for amount input
	 */
	@Test
	public void testTransactionProcessAmountPositive() {
		ByteArrayInputStream in = new ByteArrayInputStream(String.format("1.0%n").getBytes());
		System.setIn(in);
		Bank b1 = new Bank("ABC Bank");

		assertEquals(1.0, b1.transactionProcessAmount(), .01);
	}

	@Test
	public void testTransactionProcessAmountNegative() {
		ByteArrayInputStream in = new ByteArrayInputStream(String.format("-2.0%n2.0%n").getBytes());
		System.setIn(in);
		Bank b1 = new Bank("ABC Bank");
		assertEquals(2.0, b1.transactionProcessAmount(), .01);
	}

	/**
	 * Test method for another transaction positive
	 */
	@Test
	public void testAnotherTransactionPositive() {
		ByteArrayInputStream in = new ByteArrayInputStream(String.format("1").getBytes());
		System.setIn(in);
		Bank b1 = new Bank("ABC Bank");

		assertTrue(b1.anotherTransaction() == true);
	}

	/**
	 * Test method for another transaction negative
	 */
	@Test
	public void testAnotherTransactionNegative() {
		ByteArrayInputStream in = new ByteArrayInputStream(String.format("3").getBytes());
		System.setIn(in);
		Bank b1 = new Bank("ABC Bank");

		assertTrue(b1.anotherTransaction() == false);
	}

}
