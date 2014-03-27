public class TransactionMgr implements Manager {

	private int promoRate;
	private int gstRate;

	/**
	 * 
	 * @param transaction
	 */
	public void createTransaction(Transaction transaction) {
		// TODO - implement TransactionMgr.createTransaction
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param transactionId
	 */
	public void getTransaction(int transactionId) {
		// TODO - implement TransactionMgr.getTransaction
		throw new UnsupportedOperationException();
	}

	public int getPromoRate() {
		return this.promoRate;
	}

	/**
	 * 
	 * @param promoRate
	 */
	public void setPromoRate(int promoRate) {
		this.promoRate = promoRate;
	}

	public int getGstRate() {
		return this.gstRate;
	}

	/**
	 * 
	 * @param gstRate
	 */
	public void setGstRate(int gstRate) {
		this.gstRate = gstRate;
	}

}