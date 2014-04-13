package HRPS.entity;

import java.util.*;

public class Reservation {

    List<Room> associatedRooms;
    Guest associatedGuest;
    private int resId;
    private java.util.Date resBookDate;
    private java.util.Date resCheckInDate;
    private java.util.Date resCheckOutDate;
    private int noOfDays;
    private ReservationStatus resStatus;
    private int noOfAdults;
    private int noOfChildren;
    private boolean paymentStatus;
    
    //default constructor
    public Reservation() {
        associatedRooms = new ArrayList<Room>();
        associatedGuest = new Guest();
    }
    
    //all mighty constructor
    public Reservation(List<Room> associatedRooms, Guest associatedGuest, int resId, Date resBookDate, Date resCheckInDate, Date resCheckOutDate, int noOfDays, ReservationStatus resStatus, int noOfAdults, int noOfChildren, boolean paymentStatus) {
        this.associatedRooms = associatedRooms;
        this.associatedGuest = associatedGuest;
        this.resId = resId;
        this.resBookDate = resBookDate;
        this.resCheckInDate = resCheckInDate;
        this.resCheckOutDate = resCheckOutDate;
        this.noOfDays = noOfDays;
        this.resStatus = resStatus;
        this.noOfAdults = noOfAdults;
        this.noOfChildren = noOfChildren;
        this.paymentStatus = paymentStatus;
    }

    public int getResId() {
        return this.resId;
    }

    /**
     *
     * @param resId
     */
    public void setResId(int resId) {
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
    
    public List<Room> getAllRooms(){
        return associatedRooms;
    }

    /**
     *
     * @param noOfRooms
     */
    public void addNoOfRooms(int noOfRooms, RoomType roomType) {
        // TODO - implement Reservation.setNoOfRooms
        for(int i=0; i<noOfRooms;i++){
            if(roomType == RoomType.Single){
                this.associatedRooms.add(new SingleRoom());
            }else if(roomType == RoomType.Standard){
                this.associatedRooms.add(new StandardRoom());
            }else if(roomType == RoomType.Suit){
                this.associatedRooms.add(new SuiteRoom());
            } else if(roomType == RoomType.VIP){
                this.associatedRooms.add(new VipRoom());
            }
        }
    }

    /**
     *
     * @param roomId
     */
    public Room getSpecifyRoom(String roomId) {
        // TODO - implement Reservation.getSpecifyRoom
        Room tempRoom = null;
        for(Iterator it = this.associatedRooms.iterator(); it.hasNext();){
            tempRoom = (Room) it.next();
            if(tempRoom.getRoomId() == roomId){
                break;
            }
        }
        return tempRoom;
    }

    public boolean setSpecifyRoom(Room room) {
        // TODO - implement Reservation.setSpecifyRoom
         try {
          for(int i=0;i<this.associatedRooms.size();i++){
            if(associatedRooms.get(i).getRoomId() == room.getRoomId()){
                associatedRooms.set(i, room);
                break;
            }
        }
        } catch (Exception ex) {
            System.out.println("Failed to set" + room.getRoomId() + " all from data directory");
            return false;
        }
        return true;
    }

    public List<Room> getAssociatedRooms() {
        return associatedRooms;
    }

    public void setAssociatedRooms(List<Room> associatedRooms) {
        this.associatedRooms = associatedRooms;
    }

    public Guest getAssociatedGuest() {
        return associatedGuest;
    }

    public void setAssociatedGuest(Guest associatedGuest) {
        this.associatedGuest = associatedGuest;
    }
    
    public String toString(){
        String display = "";
        display +="Reservation Details of " + resId + "\n";
        display +="-------------------------------------------------\n";
        display +="Guest \t : " + this.associatedGuest.getTitle() + " " + this.associatedGuest.getFirstName();
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