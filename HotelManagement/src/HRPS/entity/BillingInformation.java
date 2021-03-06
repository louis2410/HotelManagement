package HRPS.entity;


import java.util.Date;

public class BillingInformation {

	private String billAddress;
	private long creditCardNo;
	private CreditCardType creditCardType;
	private Date creditCardExpiryDate;

        
        public BillingInformation(){
            
        }
        
	public String getBillAddress() {
		return this.billAddress;
	}

	/**
	 * 
	 * @param billAddress
	 */
	public void setBillAddress(String billAddress) {
		this.billAddress = billAddress;
	}

	public long getCreditCardNo() {
		return this.creditCardNo;
	}

	/**
	 * 
	 * @param creditCardNo
	 */
	public void setCreditCardNo(long creditCardNo) {
		this.creditCardNo = creditCardNo;
	}

	public CreditCardType getCreditCardType() {
		return this.creditCardType;
	}

	/**
	 * 
	 * @param creditCardType
	 */
	public void setCreditCardType(CreditCardType creditCardType) {
		this.creditCardType = creditCardType;
	}

	public Date getCreditCardExpiryDate() {
		return this.creditCardExpiryDate;
	}

	/**
	 * 
	 * @param creditCardExpiryDate
	 */
	public void setCreditCardExpiryDate(Date creditCardExpiryDate) {
		this.creditCardExpiryDate = creditCardExpiryDate;
	}

}