package HRPS.entity;

import java.util.Date;

public class Transaction {

	private int transactionId;
	private Date transactionDate;
	private int promoRate;
	private int getRate;

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

	public int getGetRate() {
		return this.getRate;
	}

	/**
	 * 
	 * @param getRate
	 */
	public void setGetRate(int getRate) {
		this.getRate = getRate;
	}

}