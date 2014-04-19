package HRPS.entity;

import java.util.ArrayList;
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
    private ArrayList<Room> arrayRoom;
    private double finalprice;
    
    public Transaction(){
    }
    
    public Transaction(String transId){
        this.transactionId = transId;
    }

    
    public void setFinalPrice(double finalprice)
    {
        this.finalprice = finalprice;
    }
    
    public double getFinalPrice(){
        return this.finalprice;
    }
    
    
     public ArrayList<Room> getRooms(ArrayList<String> roomIds) {
        ArrayList<Room> rooms = new ArrayList();
        for (int i = 0; i < arrayRoom.size(); i++) {
            for (int j = 0; j < roomIds.size(); j++) {
                if (arrayRoom.get(i).getRoomId().equals(roomIds.get(j))) {
                    rooms.add(arrayRoom.get(i));
                }
            }
        }
        return rooms;
    }
     
      public void SetRooms(ArrayList<Room> roomIds) {
            this.arrayRoom = roomIds;
       
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