package HRPS.entity;

import java.util.ArrayList;
import java.util.Calendar;

public abstract class Room {

    private int maxOccupancy;
    private String roomId;
    private int floor;
    private RoomStatus roomStatus;
    private RoomType roomType;
    private int currentOccupancy;
    private BedType bedType;
    private ArrayList<RoomService> ArrayRoomService;
    //Removed, see getweekday&getweekend rates method
    //private double roomWeekDayRate;
    //private double roomWeekEndRate;
    //Roomsize redundant
    //private int roomSize;

    public Room(int maxOcc, String rmId, int floor, RoomStatus roomstatus, RoomType roomtype, int curOcc, BedType bedtype) {

        this.maxOccupancy = maxOcc;
        this.roomId = rmId;
        this.currentOccupancy = curOcc;
        this.floor = floor;
        this.roomStatus = roomstatus;
        this.roomType = roomtype;
        this.bedType = bedtype;
        this.ArrayRoomService = new ArrayList();

    }

    public abstract double getweekdayRoomRate();

    public abstract double getweekendRoomRate();

    public String getRoomId() {
        return this.roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public int getFloorId() {
        return this.floor;
    }

    public void setFloorId(int floorId) {
        this.floor = floorId;
    }

    public RoomStatus getRoomStatus() {
        return this.roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public RoomType getRoomType() {
        return this.roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public BedType getBedType() {
        return this.bedType;
    }

    public void setBedType(BedType bedType) {
        this.bedType = bedType;
    }

    public int getCurrentOccupancy() {
        return this.currentOccupancy;
    }

    public void setCurrentOccupancy(int currentOccupancy) {
        this.currentOccupancy = currentOccupancy;
    }
    
    public ArrayList<RoomService> getRmService() {
        return this.ArrayRoomService;
    }

    public boolean addRmService(double amt) {
        RoomService rmService = new RoomService(Calendar.getInstance().getTime(), amt);
        this.ArrayRoomService.add(rmService);
        return true;
    }

    public void clearRmService() {
        this.ArrayRoomService.clear();
    }

    //Author : Bryan
    public boolean equals(Room room) {
        return this.roomId == room.roomId;
    }
    //Author : Bryan
    public String toString() {
        String display = "";
        display += "Room Details of " + this.roomId + "\n";
        display += "-------------------------------------------------\n";
        display += "Floor \t : " + this.floor + " \n";
        display += "Room Type \t : " + this.roomType + "\n";
        display += "Bed Type \t : " + this.bedType + "\n";
        display += "Room Status \t : " + this.roomStatus + "\n";

        return display;
    }
}