/**
 * 
 */
package ca.bcit.comp1451.assignment1;

/**
 * @author seikoigi
 *
 */
public class TransactionRecord {
	private double amount;
	private Date issued;
	private String accountNumber;
	private String transactionType;
	
	/**
	 * constructor
	 * @param amount amount
	 * @param issued issue
	 */
	public TransactionRecord(double amount, Date issued) {
		setAmount(amount);
		setIssued(issued);

	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the issued
	 */
	public Date getIssued() {
		return issued;
	}

	/**
	 * @param issued
	 *            the issued to set
	 */
	public void setIssued(Date issued) {
		this.issued = issued;
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
	 * @return the transactionType
	 */
	public String getTransactionType() {
		return transactionType;
	}

	/**
	 * @param transactionType
	 *            the transactionType to set
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

}
