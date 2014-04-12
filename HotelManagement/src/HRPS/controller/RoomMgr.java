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
        
  public static final int MaxNumSingleRoom = 20;
  public static final int MaxNumStandardRoom = 20;
  public static final int MaxNumVIPRoom = 20;
  public static final int MAxSuiteRoom =20;
     //Attributes
    private ArrayList<Room> arrayRoom;
    private PersistenceStrategy strategy;
    private List datalist;
    
    
    public RoomMgr() {
        arrayRoom = new ArrayList<Room>();
     
        // prepares the file strategy to Respecitve data directory 
        strategy = new FilePersistenceStrategy(new File(System.getProperty("user.dir") + "/src/HRPS/data/Room"));
        // creates the list and linkage to data directory
        datalist = new XmlArrayList(strategy);
        //Setup
        setup();
    }
    
    
	/**
	 * Creation of a new Room in the hotel
	 * @param room
	 */
	public boolean createRoom(int maxOcc,int rmId,int floor,RoomStatus roomstatus, RoomType roomtype,int curOcc,BedType bedtype) {
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
	public Room getRoom(int roomId) {
		// TODO - implement RoomMgr.getRoom
		throw new UnsupportedOperationException();
	}

	public void printRoomOccupancyReport() {
		// TODO - implement RoomMgr.printRoomOccupancyReport
		throw new UnsupportedOperationException();
	}

        
        
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
            //for each reservation in reservation folder, creates an reservation object in reservationarray
        for (Iterator it = datalist.iterator(); it.hasNext();) {
            Room room = (Room) it.next();
            arrayRoom.add(room);
        }
        } catch (Exception ex) {
            System.out.println("Failed to retrive all from data directory");
            return false;
        }
        System.out.println("Room XML to roomArray Complete");
        return true;
    }

     public void setup() {
        this.retrieveFromFile();
        //this.deleteFromFile();
        //this.createToFile();
    }
}