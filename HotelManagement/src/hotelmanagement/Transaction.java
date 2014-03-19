public class Transaction {

	private int transactionId;
	private Date transactionDate;

	public int getTransactionId() {
		return this.transactionId;
	}

	/**
	 * 
	 * @param transactionId
	 */
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Date getTransactionDate() {
		return this.transactionDate;
	}

	/**
	 * 
	 * @param transactionDate
	 */
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

}