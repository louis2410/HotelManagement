package HRPS.entity;

public class SingleRoom extends Room {

    public SingleRoom(int maxOcc, String rmId, int floor, RoomStatus roomstatus, RoomType roomtype, int curOcc, BedType bedtype) {
        super(maxOcc, rmId, floor, roomstatus, roomtype, curOcc, bedtype);
    }
   
    @Override
    public double getweekendRoomRate(){
        return 50.0;
    };

    @Override
    public double getweekdayRoomRate() {
        return 25.0;
    }
        

}

