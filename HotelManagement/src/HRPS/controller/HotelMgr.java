package HRPS.controller;

import HRPS.entity.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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
            resMgr.createReservation(roomList, guest, resId, currDate, checkIn, checkOut, noOfRooms, ReseravationType.Confirmed, noOfAdults, noOfChildren, false);
            
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
                } else if (allRoomList.get(i).getRoomType() == RoomType.Suit) {
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
                } else if (allRoomList.get(i).getRoomType() == RoomType.Suit) {
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
        if (resMgr.getReservation(resId).getResStatus() == ReseravationType.Check_In
                || resMgr.getReservation(resId).getResStatus() == ReseravationType.Expired) {
            return false;
        } else {
            return true;
        }

    }
}