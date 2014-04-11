package HRPS.controller;

import HRPS.entity.Room;
import HRPS.entity.RoomType;
import java.util.Date;
import java.util.List;

public class HotelMgr {

        //Managers for each sector
        GuestMgr guestMgr = new GuestMgr();
        ReservationMgr resMgr = new ReservationMgr();
        RoomMgr roomMgr = new RoomMgr();
    
	private int maxNoOfFloor = 10;
	private int maxNoOfRooms = 200;
	private int singleBedAmt = 80;
	private final int standandBedAmt = 60;
	private final int vipBedAmt = 40;
	private final int suitBedAmt = 20;
	/**
	 * in 24Hrs format
	 */
	private int checkInTime = 1300;

	/**
	 * 
	 * @param roomId
	 */
	public Room checkRoomAvailability(int roomId) {
		// TODO - implement HotelMgr.checkRoomAvailability
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param guestId
	 */
	public Room checkRoomDetails(int guestId) {
		// TODO - implement HotelMgr.checkRoomDetails
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param guestName
	 */
	public Room checkRoomDetails(String guestName) {
		// TODO - implement HotelMgr.checkRoomDetails
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param resId
	 */
	public boolean checkInByReservation(int resId) {
		// TODO - implement HotelMgr.checkInByReservation
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param guest
	 */
	public boolean checkInByGuest(String guest) {
		// TODO - implement HotelMgr.checkInByGuest
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param resId
	 */
	public boolean checkOutByReservation(int resId) {
		// TODO - implement HotelMgr.checkOutByReservation
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param roomId
	 */
	public boolean checkOutByRoom(int roomId) {
		// TODO - implement HotelMgr.checkOutByRoom
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param resId
	 */
	public void getReservationReceipt(int resId) {
		// TODO - implement HotelMgr.getReservationReceipt
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param guestId
	 */
	public void getReservationReceipt(String guestId) {
		// TODO - implement HotelMgr.getReservationReceipt
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param guest
	 */
	public boolean checkOutByGuest(String guest) {
		// TODO - implement HotelMgr.checkOutByGuest
		throw new UnsupportedOperationException();
	}

	public void createReservation() {
		// TODO - implement HotelMgr.createReservation
		throw new UnsupportedOperationException();
	}
        
        //Arthur : Bryan
        public boolean checkExistingGuest(String guestId){
            if(guestMgr.getGuest(guestId) != null)
                return true;
            else 
                return false;
        }
        //Arthur : Bryan
        public String displayGuestDetails(String guestId){
            return guestMgr.getGuest(guestId).toString();
        }
        
        //Arthur : Bryan
        public String getAllAvailableRooms(Date checkIn, Date checkOut){
            String singleDisplay = "--- \t Single Rooms \t\t ---\n",
                   standardDisplay  = "\n--- \t Standand Rooms \t ---\n",
                   suitDisplay  = "\n--- \t Suit Rooms \t\t ---\n",
                   vipDisplay  = "\n--- \t VIP Rooms \t\t ---\n";
            
            //A RoomMgr methods to get all the rooms in hotel
            List<Room> avaRoomList = null;
            //A List of all Reserved Rooms
            List<Room> resRoomList = resMgr.getReservedRooms(checkIn, checkOut);
            
            //get the rest of ava rooms for display
            for(int i=0;i<avaRoomList.size();i++){
                if(resRoomList.contains(avaRoomList.get(i))){
                    avaRoomList.remove(i);
                }else{
                    if(avaRoomList.get(i).getRoomType() == RoomType.Single)
                        singleDisplay += " " + avaRoomList.get(i).getRoomId() + ",";
                    else if(avaRoomList.get(i).getRoomType() == RoomType.Standard)
                        standardDisplay += " " + avaRoomList.get(i).getRoomId() + ",";
                    else if(avaRoomList.get(i).getRoomType() == RoomType.Suit)
                        suitDisplay += " " + avaRoomList.get(i).getRoomId() + ",";
                    else if(avaRoomList.get(i).getRoomType() == RoomType.VIP)
                        vipDisplay += " " + avaRoomList.get(i).getRoomId() + ",";
                }
                
            }
              
            return singleDisplay + standardDisplay + suitDisplay + vipDisplay;
        }
        
        //Arthur : Bryan
        public String getAvailableNoOfRooms(Date checkIn, Date checkOut){
            String singleDisplay = "--- \t Single Rooms \t\t : ",
                   standardDisplay  = "\n--- \t Standand Rooms \t : ",
                   suitDisplay  = "\n--- \t Suit Rooms \t\t : ",
                   vipDisplay  = "\n--- \t VIP Rooms \t\t : ";
            
            int singleCount=0, standardCount=0, suitCount=0, vipCount=0;
            
            //A RoomMgr methods to get all the rooms in hotel
            List<Room> avaRoomList = null;
            //A List of all Reserved Rooms
            List<Room> resRoomList = resMgr.getReservedRooms(checkIn, checkOut);
            
            //get the rest of ava rooms for display
            for(int i=0;i<avaRoomList.size();i++){
                if(resRoomList.contains(avaRoomList.get(i))){
                    avaRoomList.remove(i);
                }else{
                    if(avaRoomList.get(i).getRoomType() == RoomType.Single)
                        singleCount++;
                    else if(avaRoomList.get(i).getRoomType() == RoomType.Standard)
                        standardCount++;
                    else if(avaRoomList.get(i).getRoomType() == RoomType.Suit)
                        suitCount++;
                    else if(avaRoomList.get(i).getRoomType() == RoomType.VIP)
                        vipCount++;
                }
                
            }
              
            return singleDisplay + singleCount + standardDisplay + standardCount+ suitDisplay + vipDisplay;
        }
        
        public boolean checkExisitingReservation(int resId){
            if(resMgr.getReservation(resId) != null)
                return true;
            else
                return false;
            
        }

}