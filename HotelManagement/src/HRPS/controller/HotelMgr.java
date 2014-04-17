package HRPS.controller;

import HRPS.entity.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HotelMgr {
    //Managers for each sector
    GuestMgr guestMgr = new GuestMgr();
    ReservationMgr resMgr = new ReservationMgr();
    RoomMgr roomMgr = new RoomMgr(); 
    
    //I dunoe whats this is for
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

    //Room Manager Access Methods added by Louis
    //Print NumOfAvailableRoomsForCreation
    public void printNumOfAvailableRoomsForCreation()
    {  
        int single = roomMgr.MaxNumOfRoomsBasedOnType(RoomType.Single);
       int standard= roomMgr.MaxNumOfRoomsBasedOnType(RoomType.Standard);
       int vip = roomMgr.MaxNumOfRoomsBasedOnType(RoomType.VIP);
       int suite = roomMgr.MaxNumOfRoomsBasedOnType(RoomType.Suite);
       System.out.println("Available Rooms for Creation");
       System.out.println("Single Rooms: "+single);
       System.out.println("Standard Rooms: "+standard);
       System.out.println("VIP Rooms: "+vip);
       System.out.println("Suite Rooms: "+suite);
    
    }  

    public boolean updateRoomStatus(String rmId, int status){
        switch(status){
            //update to occupied
            case 1: return roomMgr.updateRoomStatus(rmId, RoomStatus.Occupied);
            //update to Reservered
            case 2: return roomMgr.updateRoomStatus(rmId, RoomStatus.Reserved);
            //update to Under Maintaince
            case 3: return roomMgr.updateRoomStatus(rmId, RoomStatus.UnderMaintenance);
            //update to Vacant
            case 4: return  roomMgr.updateRoomStatus(rmId, RoomStatus.Vacant);
        }
        System.out.println("Room not updated");
        return false;
    }
    public boolean addRoomService(String rmId, double amt){
        return roomMgr.updateRoomService(rmId, amt);
    }
    public boolean removeRoom(String rmId){
        
        return roomMgr.removeRoom(rmId);
    }
    
    public String firstAvailRoom(RoomType RoomType){
        
        return roomMgr.getFirstAvailableRoom(RoomType);
        
    }
    
    public void printRoomOccupancyReport(){
        roomMgr.printRoomOccupancyReport();
    }
    //Guest Manager Access Methods Added by Louis
    
    public String createGuest(String guestId, String FirstName, String lastName,
            String title, String address, String country, char gender, int contactNo, String email){
 
        return guestMgr.createGuest(guestId, FirstName, lastName, title, address, country, gender, contactNo, email);
    }
    
    public Guest getGuest(String guestId){
        return guestMgr.getGuest(guestId);
    }
    
    public boolean removeGuest(String guestId){
                
        return guestMgr.removeGuest(guestId);
    }
    
    
    
    
    //Impportant , execute before closing program
    public void OutputToXML(){
        
        guestMgr.DeleteFromFile();
        guestMgr.createToFile();
        roomMgr.deleteFromFile();
        roomMgr.createToFile();
        resMgr.deleteFromFile();
        resMgr.createToFile();
    }
    
    
    
    //ReservationScheduleCheck
    public int ReservationScheduleCheck(Date checkin, Date checkout,RoomType rmType){

        int NumOfClashes = resMgr.CheckReservationClash(checkin, checkout,rmType);
        int NumAvailableRooms = roomMgr.MaxNumOfRoomsBasedOnType(rmType);
        System.out.println(NumOfClashes);
        System.out.println(NumAvailableRooms);
        
        if(NumAvailableRooms - NumOfClashes > 0){
            return NumAvailableRooms - NumOfClashes;
        }
        return 0;
    }
    
    //Reservation ID generate
    public String generateResId(){
        
        return "R"+(resMgr.NumOfReservations()+1);
    }
    
   
    public String checkRoomAvailability(String roomId) {
        // TODO - implement HotelMgr.checkRoomAvailability

        return roomMgr.getRoom(roomId).getRoomStatus().toString();
    }


    
    
    
    
    
    
    
    
    
    
    
    
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

   
    public void createReservation(String associatedGuest, String resId, Date resBookDate, Date resCheckInDate, Date resCheckOutDate, ReservationStatus resStatus, int noOfAdults, int noOfChildren, boolean paymentStatus, RoomType rmtype){
        resMgr.createReservation(associatedGuest, resId, resBookDate, resCheckInDate, resCheckOutDate, resStatus, noOfAdults, noOfChildren, paymentStatus, rmtype);
        
       
    }
    
    public Reservation getReservation(String resId){
     return   resMgr.getReservation(resId);
    }
    
    
    public boolean removeReservation(int resId){
        return resMgr.removeReservation(resId);
    }

    //Arthur : Bryan
    public boolean checkExistingGuest(String guestId) {
        if (guestMgr.getGuest(guestId) != null) {
            return true;
        } else {
            return false;
        }
    }
    //Arthur : Bryan
    public String displayGuestDetails(String guestId) {
        return guestMgr.getGuest(guestId).toString();
    }

    
    
    
    
    
    
    
    
    
    
    //Arthur : Bryan
    public String getAllAvailableRooms(Date checkIn, Date checkOut) {
        String singleDisplay = "--- \t Single Rooms \t\t ---\n",
                standardDisplay = "\n--- \t Standand Rooms \t ---\n",
                suitDisplay = "\n--- \t Suit Rooms \t\t ---\n",
                vipDisplay = "\n--- \t VIP Rooms \t\t ---\n";

        //A RoomMgr methods to get all the rooms in hotel
        List<Room> allRoomList = null;
        //A List of all Reserved Rooms
        List<Room> resRoomList = resMgr.getReservedRooms(checkIn, checkOut);

        //get the rest of ava rooms for display
        for (int i = 0; i < allRoomList.size(); i++) {
            if (resRoomList.contains(allRoomList.get(i)) || allRoomList.get(i).getRoomStatus() == RoomStatus.UnderMaintance) {
                allRoomList.remove(i);
            } else {
                if (allRoomList.get(i).getRoomType() == RoomType.Single) {
                    singleDisplay += " " + allRoomList.get(i).getRoomId() + ",";
                } else if (allRoomList.get(i).getRoomType() == RoomType.Standard) {
                    standardDisplay += " " + allRoomList.get(i).getRoomId() + ",";
                } else if (allRoomList.get(i).getRoomType() == RoomType.Suite) {
                    suitDisplay += " " + allRoomList.get(i).getRoomId() + ",";
                } else if (allRoomList.get(i).getRoomType() == RoomType.VIP) {
                    vipDisplay += " " + allRoomList.get(i).getRoomId() + ",";
                }
            }

        }

        return singleDisplay + standardDisplay + suitDisplay + vipDisplay;
    }

    //Arthur : Bryan
    //EXTRA
    public String getAvailableNoOfRooms(Date checkIn, Date checkOut) {
        String singleDisplay = "--- \t Single Rooms \t\t : ",
                standardDisplay = "\n--- \t Standand Rooms \t : ",
                suitDisplay = "\n--- \t Suit Rooms \t\t : ",
                vipDisplay = "\n--- \t VIP Rooms \t\t : ";

        int singleCount = 0, standardCount = 0, suitCount = 0, vipCount = 0;

        //A RoomMgr methods to get all the rooms in hotel
        List<Room> allRoomList = null;
        //A List of all Reserved Rooms
        List<Room> resRoomList = resMgr.getReservedRooms(checkIn, checkOut);

        //get the rest of ava rooms for display
        for (int i = 0; i < allRoomList.size(); i++) {
            if (resRoomList.contains(allRoomList.get(i)) || allRoomList.get(i).getRoomStatus() == RoomStatus.UnderMaintance) {
                allRoomList.remove(i);
            } else {
                if (allRoomList.get(i).getRoomType() == RoomType.Single) {
                    singleCount++;
                } else if (allRoomList.get(i).getRoomType() == RoomType.Standard) {
                    standardCount++;
                } else if (allRoomList.get(i).getRoomType() == RoomType.Suite) {
                    suitCount++;
                } else if (allRoomList.get(i).getRoomType() == RoomType.VIP) {
                    vipCount++;
                }
            }

        }

        return singleDisplay + singleCount + standardDisplay + standardCount + suitDisplay + vipDisplay;
    }
    //Arthur : Bryan

    public boolean checkExisitingReservation(String resId) {
        if (resMgr.getReservation(resId) != null) {
            return true;
        } else {
            return false;
        }

    }

    //Arthur : Bryan
    public String displayReservationDetails(String resId) {
        return resMgr.getReservation(resId).toString();
    }

    //Arthur : Bryan
    public boolean checkAllowReservationStatus(int resId) {
        if (resMgr.getReservation(resId).getResStatus() == RReservationTypeCheck_In
                || resMgr.getReservation(resId).getResStatus() == ReReservationTypexpired) {
            return false;
        } else {
            return true;
        }

    }
}



