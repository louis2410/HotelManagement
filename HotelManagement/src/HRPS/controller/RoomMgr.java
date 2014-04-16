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
        
  public static final int MaxNumSingleRoom = 40;
  public static final int MaxNumStandardRoom = 30;
  public static final int MaxNumVIPRoom = 20;
  public static final int MaxNumSuiteRoom =10;
     //Attributes
    private ArrayList<Room> arrayRoom;
    private PersistenceStrategy strategy;
    private List datalist;
    private final boolean singleArray[] = new boolean[MaxNumSingleRoom];
    private final boolean standardArray[] = new boolean[MaxNumStandardRoom];
    private final boolean VIPArray[] = new boolean[MaxNumVIPRoom];
    private final boolean suiteArray[] = new boolean[MaxNumSuiteRoom];
    
    public RoomMgr() {
        arrayRoom = new ArrayList<Room>();
        // prepares the file strategy to Respecitve data directory 
        strategy = new FilePersistenceStrategy(new File(System.getProperty("user.dir") + "/src/HRPS/data/Room"));
        // creates the list and linkage to data directory
        datalist = new XmlArrayList(strategy);
        
        //Set boolean Array Values to false
        for(int i = 0; i< singleArray.length;i++){
            singleArray[i] = false;
        }
          for(int i = 0; i< standardArray.length;i++){
            standardArray[i] = false;
        }
            for(int i = 0; i< VIPArray.length;i++){
            VIPArray[i] = false;
        }
              for(int i = 0; i< suiteArray.length;i++){
            suiteArray[i] = false;
        }
        
        
        //Setup
        setup();
    }
    
        public ArrayList getRoomArray(){
            return arrayRoom;
        }
	
	public String createSingleRoom() {
		// TODO - implement RoomMgr.createRoom
            SingleRoom single = new SingleRoom(1,this.generateRoomId(RoomType.Single),1,RoomStatus.Vacant,RoomType.Single,0,BedType.Single);
            System.out.println("Room ID of created room :" + single.getRoomId());
            arrayRoom.add(single);
          
                    return single.getRoomId();         
	}
        
        public String createStandardRoom() {
		// TODO - implement RoomMgr.createRoom
            StandardRoom standard = new StandardRoom(1,this.generateRoomId(RoomType.Standard),1,RoomStatus.Vacant,RoomType.Standard,0,BedType.Double);
            System.out.println("Room ID of created room :" + standard.getRoomId());
            arrayRoom.add(standard);
                    return standard.getRoomId();         
	}
        
        public String createSuiteRoom() {
		// TODO - implement RoomMgr.createRoom
           SuiteRoom suite = new SuiteRoom(1,this.generateRoomId(RoomType.Suite),1,RoomStatus.Vacant,RoomType.Suite,0,BedType.Double);
           System.out.println("Room ID of created room :" + suite.getRoomId()); 
           arrayRoom.add(suite);
          
                    return suite.getRoomId();         
	}
        
        public String createVIPRoom() {
		// TODO - implement RoomMgr.createRoom
            VipRoom vip = new VipRoom(1,this.generateRoomId(RoomType.VIP),1,RoomStatus.Vacant,RoomType.VIP,0,BedType.Master);
            System.out.println("Room ID of created room :" + vip.getRoomId());
            arrayRoom.add(vip);
          
                    return vip.getRoomId();         
	}
        //UpdateRoomStatus
	public boolean updateRoom(String RoomId,RoomStatus rmstats){
            
             for(int i = 0; i<arrayRoom.size();i++){
                //if match then delete
                if(arrayRoom.get(i).getRoomId().equals(RoomId)){
                    arrayRoom.get(i).setRoomStatus(rmstats);
                       return true; 
                }
             }
            
            return false;
        }
        //Update/Add Rm Service
        public boolean updateRoom(String RoomId,double RmService){
            
             for(int i = 0; i<arrayRoom.size();i++){
                //if match then delete
                if(arrayRoom.get(i).getRoomId().equals(RoomId)){
                    arrayRoom.get(i).AddRmService(RmService);
                       return true; 
                }
             }
            
            return false;
        }
           
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
		        //go through arrayRoom in memory, find and delete room
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
                    + (MaxNumSingleRoom - this.NumOfRoomsAvailableForCreation(RoomType.Single)));
            System.out.println("Number of Single Rooms available: "+
                    this.NumOfRoomsAvailableForCreation(RoomType.Single));
            
             //Standard Rooms
            System.out.println("=== Standard Rooms ===");
            System.out.println("Total Number of Standard Rooms: "+MaxNumStandardRoom);
            System.out.println("Current Number of Standard Rooms in use: " 
                    + (MaxNumStandardRoom - this.NumOfRoomsAvailableForCreation(RoomType.Standard)));
               System.out.println("Number of Standard Rooms available: "+
                    this.NumOfRoomsAvailableForCreation(RoomType.Standard));
             //SUITE Rooms
            System.out.println("=== Suite Rooms ===");
            System.out.println("Total Number of Suite Rooms: "+MaxNumSuiteRoom);
            System.out.println("Current Number of Suite Rooms in use: " 
                    + (MaxNumSuiteRoom - this.NumOfRoomsAvailableForCreation(RoomType.Suite)));
               System.out.println("Number of Suite Rooms available: "+
                    this.NumOfRoomsAvailableForCreation(RoomType.Suite));
             //VIP Rooms
            System.out.println("=== VIP Rooms ===");
            System.out.println("Total Number of VIP Rooms: "+MaxNumVIPRoom);
            System.out.println("Current Number of VIP Rooms in use: " 
                    + (MaxNumVIPRoom - this.NumOfRoomsAvailableForCreation(RoomType.VIP)));
               System.out.println("Number of VIP Rooms available: "+
                    this.NumOfRoomsAvailableForCreation(RoomType.VIP));
            
            
            
            
	}

        
        //
        
        
        //Get CurrentNumberOfRoomsBasedOnType      
        public int NumOfRoomsAvailableForCreation(RoomType roomtype){
            
            int count = 0;
            //Loop through array to get number of rooms
          for (Iterator it = arrayRoom.iterator(); it.hasNext();) {
                Room room = (Room) it.next();
                if(room.getRoomType() == roomtype){
                    count++;
                }
            }
            
          
            switch(roomtype){
                
                   case Single: return MaxNumSingleRoom - count;
                    
                   case Standard: return MaxNumStandardRoom - count;
                       
                   case VIP: return MaxNumVIPRoom - count;    
                       
                   case Suite: return MaxNumSuiteRoom - count;    
            }
             
            return 0;        
            
            
        }
        
        //RoomID Generation
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
            String id = room.getRoomId().substring(room.getRoomId().length() - 2, room.getRoomId().length());
           
            switch(room.getRoomType()){
                
                case Single: singleArray[Integer.valueOf(id)] = true;break;
                case Standard: standardArray[Integer.valueOf(id)] = true;break;
                case VIP: VIPArray[Integer.valueOf(id)] = true;break;          
                case Suite: suiteArray[Integer.valueOf(id)] = true;break;
                      
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
