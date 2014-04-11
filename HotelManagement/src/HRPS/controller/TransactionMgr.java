package HRPS.controller;

import HRPS.entity.Transaction;

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

    @Override
    public boolean createToFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retrieveFromFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteFromFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setup() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}