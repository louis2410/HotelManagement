package HRPS.entity;

public  class Room {

	private int maxOccupancy;
	private String roomId;
	private int floor;
	private RoomStatus roomStatus;
	private RoomType roomType;
        private int currentOccupancy;
	private BedType bedType;

        //Removed, see getweekday&getweekend rates method
	//private double roomWeekDayRate;
	//private double roomWeekEndRate;
        //Roomsize redundant
	//private int roomSize;

	public Room(int maxOcc,String rmId,int floor,RoomStatus roomstatus, RoomType roomtype,int curOcc,BedType bedtype) {
          
            this.maxOccupancy=maxOcc;
            this.roomId = rmId;
            this.currentOccupancy =curOcc;
            this.floor = floor;
            this.roomStatus = roomstatus;
            this.roomType = roomtype;
            this.bedType = bedtype;
           
		
	}



	public String getRoomId() {
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
		return this.floor;
	}

	/**
	 * 
	 * @param floorId
	 */
	public void setFloorId(int floorId) {
		this.floor = floorId;
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

	
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
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