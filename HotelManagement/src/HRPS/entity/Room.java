package HRPS.entity;

public  class Room {

	private static final int maxOccupancy;
	private int roomId;
	private int floor;
	//private int roomSize;
	private RoomStatus roomStatus;
	private RoomType roomType;
	private double roomWeekDayRate;
	private double roomWeekEndRate;
	private int currentOccupancy;
	private BedType bedType;

	public Room() {
		// TODO - implement Room.Room
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param roomId
	 * @param floorId
	 */
	public Room(int roomId, int floorId) {
		// TODO - implement Room.Room
		throw new UnsupportedOperationException();
	}

	public int getRoomId() {
		return this.roomId;
	}

	/**
	 * 
	 * @param roomId
	 */
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getFloorId() {
		return this.floorId;
	}

	/**
	 * 
	 * @param floorId
	 */
	public void setFloorId(int floorId) {
		this.floorId = floorId;
	}

	public RoomType getRoomSize() {
		// TODO - implement Room.getRoomSize
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param roomSize
	 */
	public void setRoomSize(int roomSize) {
		this.roomSize = roomSize;
	}

	public RoomStatus getRoomStatus() {
		return this.roomStatus;
	}

	/**
	 * 
	 * @param roomStatus
	 */
	public void setRoomStatus(RoomStatus roomStatus) {
		this.roomStatus = roomStatus;
	}

	public RoomType getRoomType() {
		return this.roomType;
	}

	/**
	 * 
	 * @param roomType
	 */
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public double getRoomWeekDayRate() {
		return this.roomWeekDayRate;
	}

	/**
	 * 
	 * @param roomWeekDayRate
	 */
	public void setRoomWeekDayRate(double roomWeekDayRate) {
		this.roomWeekDayRate = roomWeekDayRate;
	}

	public double getRoomWeekEndRate() {
		return this.roomWeekEndRate;
	}

	/**
	 * 
	 * @param roomWeekEndRate
	 */
	public void setRoomWeekEndRate(double roomWeekEndRate) {
		this.roomWeekEndRate = roomWeekEndRate;
	}

	public BedType getBedType() {
		return this.bedType;
	}

	/**
	 * 
	 * @param bedType
	 */
	public void setBedType(BedType bedType) {
		this.bedType = bedType;
	}

	public int getCurrentOccupancy() {
		return this.currentOccupancy;
	}

	/**
	 * 
	 * @param currentOccupancy
	 */
	public void setCurrentOccupancy(int currentOccupancy) {
		this.currentOccupancy = currentOccupancy;
	}
        
        //Author : Bryan
        public boolean equals(Room room){
            return this.roomId == room.roomId;
        }

        //Louis 
        
        public double getweekdayRoomRate(Room room){
            
            switch(room.getRoomType()){
                
                case Single: return 25.0;
                    
                case Standard: return 50.0;    
                
                case VIP: return 75.0;
                    
                case Suite: return 100.0;    
                
            }
            //If room type dont match
            return 0;
            
        }
        
         public double getweekendRoomRate(Room room){
            
            switch(room.getRoomType()){
                
                case Single: return 35.0;
                    
                case Standard: return 70.0;    
                
                case VIP: return 105.0;
                    
                case Suite: return 140.0;    
                
            }
            //If room type dont match
            return 0;
            
        }
        
        
        
}