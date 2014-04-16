package HRPS.controller;


import HRPS.entity.BedType;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;
import HRPS.entity.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class RoomMgr implements Manager {
        
  public static final int MaxNumSingleRoom = 80;
  public static final int MaxNumStandardRoom = 60;
  public static final int MaxNumVIPRoom = 40;
  public static final int MaxNumSuiteRoom =20;
     //Attributes
    private ArrayList<Room> arrayRoom;
    private PersistenceStrategy strategy;
    private List datalist;
    
    //Rooms which are reserved,undermaintaence etc, as long as not vacant
    private int NumOfSingleRoomNotVacant = 0;
    private int NumOfStandardRoomNotVacant = 0;
    private int NumOfSuiteRoomNotVacant= 0;
    private int NumOfVIPRoomNotVacant= 0;
    
    
    public RoomMgr() {
        arrayRoom = new ArrayList<Room>();
        // prepares the file strategy to Respecitve data directory 
        strategy = new FilePersistenceStrategy(new File(System.getProperty("user.dir") + "/src/HRPS/data/Room"));
        // creates the list and linkage to data directory
        datalist = new XmlArrayList(strategy);
        
        
        
        
        //Setup
        setup();
        
          System.out.println(NumOfSingleRoomNotVacant);
            System.out.println(NumOfStandardRoomNotVacant);
              System.out.println(NumOfSuiteRoomNotVacant);
                System.out.println(NumOfVIPRoomNotVacant);
                
    }
    
    
	
	public boolean createSingleRoom(String rmId,int floor) {
		// TODO - implement RoomMgr.createRoom
            SingleRoom single = new SingleRoom(1,rmId,floor,RoomStatus.Vacant,RoomType.Single,0,BedType.Single);
            //System.out.println("Room ID of created room :" + single.getRoomId());
            arrayRoom.add(single);
          
                    return true;         
	}
        
        public boolean createStandardRoom(String rmId,int floor) {
		// TODO - implement RoomMgr.createRoom
            StandardRoom standard = new StandardRoom(2,rmId,floor,RoomStatus.Vacant,RoomType.Standard,0,BedType.Double);
            //System.out.println("Room ID of created room :" + standard.getRoomId());
            arrayRoom.add(standard);
                    return true;         
	}
        
        public boolean createSuiteRoom(String rmId,int floor) {
		// TODO - implement RoomMgr.createRoom
           SuiteRoom suite = new SuiteRoom(3,rmId,floor,RoomStatus.Vacant,RoomType.Suite,0,BedType.Double);
           //System.out.println("Room ID of created room :" + suite.getRoomId()); 
           arrayRoom.add(suite);
          
                    return true;         
	}
        
        public boolean createVIPRoom(String rmId,int floor) {
		// TODO - implement RoomMgr.createRoom
            VipRoom vip = new VipRoom(4,rmId,floor,RoomStatus.Vacant,RoomType.VIP,0,BedType.Master);
            //System.out.println("Room ID of created room :" + vip.getRoomId());
            arrayRoom.add(vip);
          
                    return true;         
	}
        //UpdateRoomStatus
	public boolean updateRoomStatus(String RoomId,RoomStatus rmstats){
            
             for(int i = 0; i<arrayRoom.size();i++){
              
                if(arrayRoom.get(i).getRoomId().equals(RoomId)){
                    //if updating to vacant means NotVacant --
                    if(rmstats == RoomStatus.Vacant){
                        switch(arrayRoom.get(i).getRoomType()){
                            case Single:NumOfSingleRoomNotVacant--;break;
                            case Standard:NumOfStandardRoomNotVacant--;break;
                            case Suite:NumOfSuiteRoomNotVacant--;break;
                            case VIP:NumOfVIPRoomNotVacant--;break;
                        }   
                    }else{
                        //Updating to something else other than vacant, notvacant++ 
                        switch(arrayRoom.get(i).getRoomType()){
                            case Single:NumOfSingleRoomNotVacant++;break;
                            case Standard:NumOfStandardRoomNotVacant++;break;
                            case Suite:NumOfSuiteRoomNotVacant++;break;
                            case VIP:NumOfVIPRoomNotVacant++;break;       
                             }
                    //setroom status
                    arrayRoom.get(i).setRoomStatus(rmstats);
                       return true; 
                    }
                 }
             }
            return false;
        }
        //Update/Add Rm Service
        public boolean updateRoomService(String RoomId,double RmService){
            
             for(int i = 0; i<arrayRoom.size();i++){
                //if match then delete
                if(arrayRoom.get(i).getRoomId().equals(RoomId)){
                    arrayRoom.get(i).AddRmService(RmService);
                       return true; 
                }
             }
            
            return false;
        }
           //NOT IN USE, u CANNOT DELETE A ROOM ANYMORE
	public boolean removeRoom(String RoomId) {

            //go through arrayRoom in memory, find and delete room
            for(int i = 0; i<arrayRoom.size();i++){
                //if match then delete
                if(arrayRoom.get(i).getRoomId().equals(RoomId)){
                    arrayRoom.remove(i); 
                    //Split up roomId
                    String id = RoomId.substring(RoomId.length() - 2, RoomId.length());
                    String rmType = RoomId.substring(0, RoomId.length()-2);
                    RoomType roomType = RoomType.valueOf(rmType);
                     //go to boolean arrays to change to false;
                    switch(roomType){
                                        case Single: singleArray[Integer.valueOf(id)] = false;
                                            break;
                                        case Standard: standardArray[Integer.valueOf(id)] = false;
                                            break;
                                        case Suite: suiteArray[Integer.valueOf(id)] = false;
                                            break;
                                        case VIP: VIPArray[Integer.valueOf(id)] = false;
                                            break;
                                    }
                    return true;
                }
            }
        
            return false ;
	}

	public Room getRoom(String RoomId) {
		      
            for(int i = 0; i<arrayRoom.size();i++){
                //if match then delete
                if(arrayRoom.get(i).getRoomId().equals(RoomId))
                   return arrayRoom.get(i);
                    }
            System.out.println("Room not found");
            return null;
        }

	public void printRoomOccupancyReport() {
		
            //Single Rooms
            System.out.println("=== Single Rooms ===");
            System.out.println("Total Number of Single Rooms: "+MaxNumSingleRoom);
            System.out.println("Current Number of Single Rooms in use: " 
                    + (MaxNumSingleRoom - this.AvailableNumOfRoomsBasedOnType(RoomType.Single)));
            System.out.println("Number of Single Rooms available: "+
                    (this.AvailableNumOfRoomsBasedOnType(RoomType.Single)));
            
             //Standard Rooms
            System.out.println("=== Standard Rooms ===");
            System.out.println("Total Number of Standard Rooms: "+MaxNumStandardRoom);
            System.out.println("Current Number of Standard Rooms in use: " 
                    + (MaxNumStandardRoom -this.AvailableNumOfRoomsBasedOnType(RoomType.Standard)));
               System.out.println("Number of Standard Rooms available: "+
                    ( this.AvailableNumOfRoomsBasedOnType(RoomType.Standard)));
             //SUITE Rooms
            System.out.println("=== Suite Rooms ===");
            System.out.println("Total Number of Suite Rooms: "+MaxNumSuiteRoom);
            System.out.println("Current Number of Suite Rooms in use: " 
                    + (MaxNumSuiteRoom -this.AvailableNumOfRoomsBasedOnType(RoomType.Suite)));
               System.out.println("Number of Suite Rooms available: "+
                    ( this.AvailableNumOfRoomsBasedOnType(RoomType.Suite)));
             //VIP Rooms
            System.out.println("=== VIP Rooms ===");
            System.out.println("Total Number of VIP Rooms: "+MaxNumVIPRoom);
            System.out.println("Current Number of VIP Rooms in use: " 
                    + (MaxNumVIPRoom - this.AvailableNumOfRoomsBasedOnType(RoomType.VIP)));
               System.out.println("Number of VIP Rooms available: "+
                    ( this.AvailableNumOfRoomsBasedOnType(RoomType.VIP)));
            
            
            
            
	}

        
        
        //Get CurrentNumberOfRoomsBasedOnType      
        public int AvailableNumOfRoomsBasedOnType(RoomType roomtype){
   
            switch(roomtype){
                
                   case Single: return MaxNumSingleRoom - NumOfSingleRoomNotVacant;
                    
                   case Standard: return MaxNumStandardRoom - NumOfStandardRoomNotVacant;
                       
                   case VIP: return MaxNumVIPRoom - NumOfSuiteRoomNotVacant;    
                       
                   case Suite: return MaxNumSuiteRoom - NumOfVIPRoomNotVacant;    
            }
             
            return 0;        
            
            
        }
        
        //RoomID Generation not in use anymore
        public String generateRoomId(RoomType roomtype){
            String id = "Rooms have reached limit";   
            switch(roomtype){
                
                case Single: for(int i = 0;i<singleArray.length;i++){
                                //first element which is empty
                                if(singleArray[i] == false){
                                    id = "Single" + Integer.toString(i);
                                    singleArray[i]=true;
                                    break;
                                }
                              }
                              return id;
                              
                 case Standard: for(int i = 0;i<standardArray.length;i++){
                                //first element which is empty
                                if(standardArray[i] == false){
                                    id = "Standard" + Integer.toString(i);
                                    standardArray[i] = true;
                                    break;
                                }
                              }
                              return id;        
                              
               case VIP: for(int i = 0;i<VIPArray.length;i++){
                                //first element which is empty
                                if(VIPArray[i] == false){
                                    id = "VIP" + Integer.toString(i);
                                    VIPArray[i] = true;
                                    break;
                                }
                              }
                              return id;    
                              
                 case Suite: for(int i = 0;i<suiteArray.length;i++){
                                //first element which is empty
                                if(suiteArray[i] == false){
                                    id = "Suite" + Integer.toString(i);
                                    suiteArray[i] = true;
                                    break;
                                }
                              }
                              return id;                   
            
        
                }
            return id;
        }
        

        
        
    //Create XML from room objects    
     @Override
    public boolean createToFile() {
        try {
            //for each reservation  in arrayRoom create one xml file
            for (Iterator it = arrayRoom.iterator(); it.hasNext();) {
                Room room = (Room) it.next();
                datalist.add(room);
            }
        } catch (Exception ex) {
            System.out.println("Failed to write to data directory");
            return false;
        }

        System.out.println("Rooms to XML Complete");
        return true;
    }

   //Delete all xml files from specified folder,run this method before createToFile else u will get duplicates
    @Override
    public boolean deleteFromFile() {
        try {
            //for each guest in Room folder, delete each
            for (Iterator it = datalist.iterator(); it.hasNext();) {
                Room room = (Room) it.next();
                it.remove();
            }
        } catch (Exception ex) {
            System.out.println("Failed to delete all from data directory");
            return false;
        }

        System.out.println("Room XML Delete Complete ");
        return true;
    }

    //Reads from the Room folder and then creates adds Room Objects into arrayRoom
    @Override
    public boolean retrieveFromFile() {
        try {
            
        for (Iterator it = datalist.iterator(); it.hasNext();) {
            Room room = (Room) it.next();
            arrayRoom.add(room);
            //if roomt not vacant 
           if((room.getRoomStatus().compareTo(RoomStatus.Vacant)!= 0)){
            switch(room.getRoomType()){           
                case Single: NumOfSingleRoomNotVacant++;break;
                case Standard: NumOfStandardRoomNotVacant++;break;
                case VIP: NumOfSuiteRoomNotVacant++;break;
                case Suite: NumOfVIPRoomNotVacant++;break;           
                }
            }
        }
        } catch (Exception ex) {
            System.out.println("Failed to retrive XML from data directory");
            return false;
        }
        System.out.println("Room XML to roomArray Complete");
        return true;
    }
      @Override
     public void setup() {
        this.retrieveFromFile();

    }
}
