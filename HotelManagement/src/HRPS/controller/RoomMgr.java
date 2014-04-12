package HRPS.controller;


import HRPS.entity.BedType;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;
import HRPS.entity.Guest;
import HRPS.entity.Room;
import HRPS.entity.RoomStatus;
import HRPS.entity.RoomType;
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
    
    
	/**
	 * Creation of a new Room in the hotel
     * @param maxOcc
     * @param rmId
     * @param floor
     * @param room
 
	 */
	public boolean createRoom(int maxOcc,String rmId,int floor,RoomStatus roomstatus, RoomType roomtype,int curOcc,BedType bedtype) {
		// TODO - implement RoomMgr.createRoom
            Room room = new Room(maxOcc,rmId,floor,roomstatus,roomtype,curOcc,bedtype);
            arrayRoom.add(room);
          
                    return true;
            
	}

	/**
	 * Update Room Features and Specs
	 * @param room
	 */
	public boolean updateRoom(Room room) {
		// TODO - implement RoomMgr.updateRoom
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param roomId
	 */
	public boolean removeRoom(int roomId) {
		// TODO - implement RoomMgr.removeRoom
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param roomId
	 */
	public Room getRoom(String roomId) {
		// TODO - implement RoomMgr.getRoom
		throw new UnsupportedOperationException();
	}

	public void printRoomOccupancyReport() {
		// TODO - implement RoomMgr.printRoomOccupancyReport
		throw new UnsupportedOperationException();
	}

        
        
        //Get CurrentNumberOfRoomsBasedOnType      
        public int AvailableNumOfRoomsBasedOnType(RoomType roomtype){
            
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
                                    id = "single" + Integer.toString(i);
                                    singleArray[i]=true;
                                }
                              }
                              return id;
                              
                 case Standard: for(int i = 0;i<standardArray.length;i++){
                                //first element which is empty
                                if(standardArray[i] == false){
                                    id = "single" + Integer.toString(i);
                                    standardArray[i] = true;
                                }
                              }
                              return id;        
                              
               case VIP: for(int i = 0;i<VIPArray.length;i++){
                                //first element which is empty
                                if(VIPArray[i] == false){
                                    id = "single" + Integer.toString(i);
                                    VIPArray[i] = true;
                                }
                              }
                              return id;    
                              
                 case Suite: for(int i = 0;i<suiteArray.length;i++){
                                //first element which is empty
                                if(suiteArray[i] == false){
                                    id = "single" + Integer.toString(i);
                                    suiteArray[i] = true;
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
            System.out.println("Failed to retrive all from data directory");
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
