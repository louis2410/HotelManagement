package HRPS.entity;

public class VipRoom extends Room {
    
    
    public VipRoom(int maxOcc, String rmId, int floor, RoomStatus roomstatus, RoomType roomtype, int curOcc, BedType bedtype) {
        super(maxOcc, rmId, floor, roomstatus, roomtype, curOcc, bedtype);
    }
   
    @Override
    public double getweekendRoomRate(){
        return 90.0;
    };

    @Override
    public double getweekdayRoomRate() {
        return 55.0;
    }
        

    
}