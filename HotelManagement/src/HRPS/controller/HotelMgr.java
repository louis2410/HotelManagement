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
        int single = roomMgr.NumOfRoomsAvailableForCreation(RoomType.Single);
       int standard= roomMgr.NumOfRoomsAvailableForCreation(RoomType.Standard);
       int vip = roomMgr.NumOfRoomsAvailableForCreation(RoomType.VIP);
       int suite = roomMgr.NumOfRoomsAvailableForCreation(RoomType.Suite);
       System.out.println("Available Rooms for Creation");
       System.out.println("Single Rooms: "+single);
       System.out.println("Standard Rooms: "+standard);
       System.out.println("VIP Rooms: "+vip);
       System.out.println("Suite Rooms: "+suite);
    
    }  
    public boolean createRoomBasedonType(int choice){
        
        switch(choice){
            
            //Single room
            case 1: //Check if max room of that type is reached
                    if(roomMgr.NumOfRoomsAvailableForCreation(RoomType.Single)>0){
                        //int maxOcc,int rmId,int floor,RoomStatus roomstatus, RoomType roomtype,int curOcc,BedType bedtype
                       roomMgr.createSingleRoom();
                       return true;
                    }
                 
                
             //Standard room
            case 2: //Check if max room of that type is reached
                    if(roomMgr.NumOfRoomsAvailableForCreation(RoomType.Standard)>0){
                        //int maxOcc,int rmId,int floor,RoomStatus roomstatus, RoomType roomtype,int curOcc,BedType bedtype
                       roomMgr.createStandardRoom();
                       return true;
                    }
                  
                
             //Suite room
            case 3: //Check if max room of that type is reached
                    if(roomMgr.NumOfRoomsAvailableForCreation(RoomType.Suite)>0){
                        //int maxOcc,int rmId,int floor,RoomStatus roomstatus, RoomType roomtype,int curOcc,BedType bedtype
                       roomMgr.createSuiteRoom();
                       return true;
                    }
                  
                
              //VIP room
            case 4: //Check if max room of that type is reached
                    if(roomMgr.NumOfRoomsAvailableForCreation(RoomType.VIP)>0){
                        //int maxOcc,int rmId,int floor,RoomStatus roomstatus, RoomType roomtype,int curOcc,BedType bedtype
                       roomMgr.createVIPRoom();
                       return true;
                    }
                     
                
            default: System.out.println("Please choose a valid room type");
                     return false;   
            
        }
        
    }
    public boolean updateRoomStatus(String rmId, int status){
        switch(status){
            //update to occupied
            case 1: return roomMgr.updateRoom(rmId, RoomStatus.Occupied);
            //update to Reservered
            case 2: return roomMgr.updateRoom(rmId, RoomStatus.Reserved);
            //update to Under Maintaince
            case 3: return roomMgr.updateRoom(rmId, RoomStatus.UnderMaintenance);
            //update to Vacant
            case 4: return  roomMgr.updateRoom(rmId, RoomStatus.Vacant);
        }
        System.out.println("Room not updated");
        return false;
    }
    public boolean addRoomService(String rmId, double amt){
        return roomMgr.updateRoom(rmId, amt);
    }
    public boolean removeRoom(String rmId){
        
        return roomMgr.removeRoom(rmId);
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
        
    }
    
    
    
    //ReservationScheduleCheck
    public int ReservationScheduleCheck(Date checkin, Date checkout,String rmType){
        
        
        ArrayList reservations = resMgr.getArrayReservation();
        
        
       
        
        
        return 0;
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

    //Arthur : Bryan
    public int createReservation(String guestId, Date checkIn, Date checkOut, int noOfRooms, int[] rmId, int noOfAdults, int noOfChildren) {
        // TODO - implement HotelMgr.createReservation
        int resId = -1;
        try {
            Guest guest = guestMgr.getGuest(guestId);
            ArrayList<Room> roomList = new ArrayList<Room>();
            for (int i = 0; i < noOfRooms; i++) {
                roomList.add(roomMgr.getRoom(rmId[i]));
            }
            DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmm");
            Date currDate = new Date();
            resId = Integer.parseInt(dateFormat.format(currDate)) ;
            resMgr.createReservation(roomList, guest, resId, currDate, checkIn, checkOut, noOfRooms, ReservationStatus.Confirmed, noOfAdults, noOfChildren, false);
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return resId;
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

    public boolean checkExisitingReservation(int resId) {
        if (resMgr.getReservation(resId) != null) {
            return true;
        } else {
            return false;
        }

    }

    //Arthur : Bryan
    public String displayReservationDetails(int resId) {
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



