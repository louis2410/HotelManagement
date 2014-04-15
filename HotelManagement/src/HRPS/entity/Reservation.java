package HRPS.entity;

import java.util.*;
import java.text.SimpleDateFormat;
public class Reservation {

    private ArrayList <String> associatedRooms;
    private String associatedGuest;
    private String resId;
    private RoomType roomType;
    private java.util.Date resBookDate;
    private java.util.Date resCheckInDate;
    private java.util.Date resCheckOutDate;
    //private int noOfDays;
    private ReservationStatus resStatus;
    private int noOfAdults;
    private int noOfChildren;
    private boolean paymentStatus;
    
    //default constructor
    public Reservation() {
        associatedRooms = new ArrayList<String>();
    }
    
    //all mighty constructor
    public Reservation (String associatedGuest, String resId, Date resBookDate, Date resCheckInDate, Date resCheckOutDate, ReservationStatus resStatus, int noOfAdults, int noOfChildren, boolean paymentStatus,RoomType rmtype) {
        //this.associatedRooms = associatedRooms;
        this.associatedGuest = associatedGuest;
        this.resId = resId;
        this.resBookDate = resBookDate;
        this.resCheckInDate = resCheckInDate;
        this.resCheckOutDate = resCheckOutDate;
        this.resStatus = resStatus;
        this.noOfAdults = noOfAdults;
        this.noOfChildren = noOfChildren;
        this.paymentStatus = paymentStatus;
        this.roomType = rmtype;
        this.associatedRooms = new ArrayList();
    }

    public RoomType getRoomType(){
        
        return this.roomType;
    }
    
    public String getResId() {
        return this.resId;
    }

    /**
     *
     * @param resId
     */
    public void setResId(String resId) {
        this.resId = resId;
    }

    public java.util.Date getResBookDate() {
        return this.resBookDate;
    }

    /**
     *
     * @param resBookDate
     */
    public void setResBookDate(java.util.Date resBookDate) {
        this.resBookDate = resBookDate;
    }

    public java.util.Date getResCheckInDate() {
        return this.resCheckInDate;
    }

    /**
     *
     * @param resCheckInDate
     */
    public void setResCheckInDate(java.util.Date resCheckInDate) {
        this.resCheckInDate = resCheckInDate;
    }

    public java.util.Date getResCheckOutDate() {
        return this.resCheckOutDate;
    }

    /**
     *
     * @param resCheckOutDate
     */
    public void setResCheckOutDate(java.util.Date resCheckOutDate) {
        this.resCheckOutDate = resCheckOutDate;
    }

    public int getNoOfDays() {
        return this.noOfDays;
    }

    /**
     *
     * @param noOfDays
     */
    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }

    public ReservationStatus getResStatus() {
        return this.resStatus;
    }

    /**
     *
     * @param resStatus
     */
    public void setResStatus(ReservationStatus resStatus) {
        this.resStatus = resStatus;
    }

    public int getNoOfAdults() {
        return this.noOfAdults;
    }

    /**
     *
     * @param noOfAdults
     */
    public void setNoOfAdults(int noOfAdults) {
        this.noOfAdults = noOfAdults;
    }

    public int getNoOfChildren() {
        return this.noOfChildren;
    }

    /**
     *
     * @param noOfChildren
     */
    public void setNoOfChildren(int noOfChildren) {
        this.noOfChildren = noOfChildren;
    }

    public boolean getPaymentStatus() {
        // TODO - implement Reservation.getPaymentStatus
        return this.paymentStatus;
    }

    /**
     *
     * @param paymentStatus
     */
    public void setPaymentStatus(boolean paymentStatus) {
        // TODO - implement Reservation.setPaymentStatus
        this.paymentStatus = paymentStatus;
    }

    public int getNoOfRooms() {
        // TODO - implement Reservation.getNoOfRooms
        return associatedRooms.size();
    }
    




    public ArrayList<String> getAssociatedRooms() {
        return associatedRooms;
    }

    public void AddAssociatedRoom(String associatedRoom) {
        
        
        associatedRooms.add(associatedRoom);
        
    }

    public String getAssociatedGuest() {
        return associatedGuest;
    }

    public void setAssociatedGuest(String associatedGuest) {
        this.associatedGuest = associatedGuest;
    }
    
    public String toString(){
        String display = "";
        display +="Reservation Details of " + resId + "\n";
        display +="-------------------------------------------------\n";
        //display +="Guest \t : " + this.associatedGuest.getTitle() + " " + this.associatedGuest;
        display +="Book date \t : " + this.resBookDate + "\n";
        display +="Check In \t : " + this.resCheckInDate + "\n" ;
        display +="Check out \t : " + this.resCheckOutDate + "\n" ;
        display +="No of days \t : " + this.noOfDays + "\n";
        display +="No of adults \t : " + this.noOfAdults + "\n";
        display +="No of children \t : " + this.noOfChildren + "\n";
        display +="No of Rooms \t : " + getNoOfRooms() + "\n";
        display +="Status \t : " + this.resStatus + "\n";
        display +="Payment Status : " + (this.paymentStatus?"Paid":"UnPaid") + "\n";
        
        return display;
    }
    
}