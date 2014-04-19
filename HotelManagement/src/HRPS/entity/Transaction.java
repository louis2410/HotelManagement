package HRPS.entity;

import java.util.Date;

public class Transaction {

    private String transactionId;
    private Date transactionDate;
    private int promoRate;
    private int gstRate;
    private CreditCardType creditcard;
    private Guest guest;
    private String resId;
    private PaymentType payType;
    
    public Transaction(){
    }
    
    public Transaction(String transId){
        this.transactionId = transId;
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getTransactionDate() {
        return this.transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public CreditCardType getCreditcard() {
        return creditcard;
    }

    public void setCreditcard(CreditCardType creditcard) {
        this.creditcard = creditcard;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public int getPromoRate() {
        return this.promoRate;
    }

    public void setPromoRate(int promoRate) {
        this.promoRate = promoRate;
    }

    public int getGstRate() {
        return this.gstRate;
    }

    public void setGstRate(int gstRate) {
        this.gstRate = gstRate;
    }

    public PaymentType getPayType() {
        return payType;
    }

    public void setPayType(PaymentType payType) {
        this.payType = payType;
    }
}