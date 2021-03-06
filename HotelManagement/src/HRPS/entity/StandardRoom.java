package HRPS.entity;

public class StandardRoom extends Room {
    
    public StandardRoom(int maxOcc, String rmId, int floor, RoomStatus roomstatus, RoomType roomtype, int curOcc, BedType bedtype) {
        super(maxOcc, rmId, floor, roomstatus, roomtype, curOcc, bedtype);
    }
   
    @Override
    public double getweekendRoomRate(){
        return 70.0;
    };

    @Override
    public double getweekdayRoomRate() {
        return 35.0;
    }
        

}