package HRPS.entity;

public class SuiteRoom extends Room {
    
    
    
    public SuiteRoom(int maxOcc, String rmId, int floor, RoomStatus roomstatus, RoomType roomtype, int curOcc, BedType bedtype) {
        super(maxOcc, rmId, floor, roomstatus, roomtype, curOcc, bedtype);
    }
   
    @Override
    public double getweekendRoomRate(){
        return 80.0;
    };

    @Override
    public double getweekdayRoomRate() {
        return 45.0;
    }
        

}