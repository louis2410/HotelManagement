package hotelmanagement;
import java.util.*;

public class Reservation {

	Collection<Room> associatedRooms;
	Guest associatedGuest;
	private int resId;
	private java.util.Date resBookDate;
	private java.util.Date resCheckInDate;
	private java.util.Date resCheckOutDate;
	private int noOfDays;
	private ReseravationType resStatus;
	private int noOfAdults;
	private int noOfChildren;
	private boolean paymentStatus;

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

	public ReseravationType getResStatus() {
		return this.resStatus;
	}

	/**
	 * 
	 * @param resStatus
	 */
	public void setResStatus(ReseravationType resStatus) {
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

	public int getPaymentStatus() {
		// TODO - implement Reservation.getPaymentStatus
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param paymentStatus
	 */
	public void setPaymentStatus(int paymentStatus) {
		// TODO - implement Reservation.setPaymentStatus
		throw new UnsupportedOperationException();
	}

	public int getNoOfRooms() {
		// TODO - implement Reservation.getNoOfRooms
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param noOfRooms
	 */
	public void setNoOfRooms(int noOfRooms) {
		// TODO - implement Reservation.setNoOfRooms
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param roomId
	 */
	public room getSpecifyRoom(int roomId) {
		// TODO - implement Reservation.getSpecifyRoom
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param room
	 */
	public boolean setSpecifyRoom(Room room) {
		// TODO - implement Reservation.setSpecifyRoom
		throw new UnsupportedOperationException();
	}

}