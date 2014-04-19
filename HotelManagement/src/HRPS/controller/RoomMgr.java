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
    public static final int MaxNumSuiteRoom = 20;
    //Attributes
    private ArrayList<Room> arrayRoom;
    private PersistenceStrategy strategy;
    private List datalist;
    //Rooms which are reserved,undermaintaence etc, as long as not vacant
    private int NumOfSingleRoomNotVacant = 0;
    private int NumOfStandardRoomNotVacant = 0;
    private int NumOfSuiteRoomNotVacant = 0;
    private int NumOfVIPRoomNotVacant = 0;

    public RoomMgr() {
        arrayRoom = new ArrayList<Room>();
        // prepares the file strategy to Respecitve data directory 
        strategy = new FilePersistenceStrategy(new File(System.getProperty("user.dir") + "/src/HRPS/data/Room"));
        // creates the list and linkage to data directory
        datalist = new XmlArrayList(strategy);
        //Setup
        setup();

        //  System.out.println(NumOfSingleRoomNotVacant);
        //  System.out.println(NumOfStandardRoomNotVacant);
        //  System.out.println(NumOfSuiteRoomNotVacant);
        //  System.out.println(NumOfVIPRoomNotVacant);

    }

    public boolean createSingleRoom(String rmId, int floor) {
        // TODO - implement RoomMgr.createRoom
        SingleRoom single = new SingleRoom(1, rmId, floor, RoomStatus.Vacant, RoomType.Single, 0, BedType.Single);
        //System.out.println("Room ID of created room :" + single.getRoomId());
        arrayRoom.add(single);
        return true;
    }

    public boolean createStandardRoom(String rmId, int floor) {
        // TODO - implement RoomMgr.createRoom
        StandardRoom standard = new StandardRoom(2, rmId, floor, RoomStatus.Vacant, RoomType.Standard, 0, BedType.Double);
        //System.out.println("Room ID of created room :" + standard.getRoomId());
        arrayRoom.add(standard);
        return true;
    }

    public boolean createSuiteRoom(String rmId, int floor) {
        // TODO - implement RoomMgr.createRoom
        SuiteRoom suite = new SuiteRoom(3, rmId, floor, RoomStatus.Vacant, RoomType.Suite, 0, BedType.Double);
        //System.out.println("Room ID of created room :" + suite.getRoomId()); 
        arrayRoom.add(suite);

        return true;
    }

    public boolean createVIPRoom(String rmId, int floor) {
        // TODO - implement RoomMgr.createRoom
        VipRoom vip = new VipRoom(4, rmId, floor, RoomStatus.Vacant, RoomType.VIP, 0, BedType.Master);
        //System.out.println("Room ID of created room :" + vip.getRoomId());
        arrayRoom.add(vip);

        return true;
    }

    //UpdateRoomStatus
    public boolean updateRoomStatus(String RoomId, RoomStatus rmstats) {

        for (int i = 0; i < arrayRoom.size(); i++) {

            if (arrayRoom.get(i).getRoomId().equals(RoomId)) {
                //if updating to vacant means NotVacant --
                if (rmstats == RoomStatus.Vacant) {
                    switch (arrayRoom.get(i).getRoomType()) {
                        case Single:
                            NumOfSingleRoomNotVacant--;
                            break;
                        case Standard:
                            NumOfStandardRoomNotVacant--;
                            break;
                        case Suite:
                            NumOfSuiteRoomNotVacant--;
                            break;
                        case VIP:
                            NumOfVIPRoomNotVacant--;
                            break;
                    }
                } else {
                    //Updating to something else other than vacant, notvacant++ 
                    switch (arrayRoom.get(i).getRoomType()) {
                        case Single:
                            NumOfSingleRoomNotVacant++;
                            break;
                        case Standard:
                            NumOfStandardRoomNotVacant++;
                            break;
                        case Suite:
                            NumOfSuiteRoomNotVacant++;
                            break;
                        case VIP:
                            NumOfVIPRoomNotVacant++;
                            break;
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

    public boolean updateRoomService(String RoomId, double RmService) {

        for (int i = 0; i < arrayRoom.size(); i++) {
            //if match then delete
            if (arrayRoom.get(i).getRoomId().equals(RoomId)) {
                arrayRoom.get(i).addRmService(RmService);
                return true;
            }
        }

        return false;
    }
   
  
    public boolean removeRoom(String RoomId) {
        for (int i = 0; i < arrayRoom.size(); i++) {
            //if match then delete
            if (arrayRoom.get(i).getRoomId().equals(RoomId)) {
                arrayRoom.remove(i);
                return true;
            }
        }
        return false;
    }

    public Room getRoom(String RoomId) {
        for (int i = 0; i < arrayRoom.size(); i++) {
            //if match then delete
            if (arrayRoom.get(i).getRoomId().equals(RoomId)) {
                return arrayRoom.get(i);
            }
        }
        return null;
    }

    public ArrayList<Room> getRooms(ArrayList<String> roomIds) {
        ArrayList<Room> rooms = new ArrayList();
        for (int i = 0; i < arrayRoom.size(); i++) {
            for (int j = 0; j < roomIds.size(); j++) {
                if (arrayRoom.get(i).getRoomId().equals(roomIds.get(j))) {
                    rooms.add(arrayRoom.get(i));
                }
            }
        }
        return rooms;
    }

    public void printRoomOccupancyReport() {

        //Rooms Counter
        int SingleCountMaintenance =0;
        int SingleCountReserved = 0;
        int SingleCountOccupied = 0;
        int SingleCountVacant=0;
        
         int StandardCountMaintenance =0;
        int StandardCountReserved = 0;
        int StandardCountOccupied = 0;
        int StandardCountVacant=0;
        
         int SuiteCountMaintenance =0;
        int SuiteCountReserved = 0;
        int SuiteCountOccupied = 0;
        int SuiteCountVacant=0;
        
         int VIPCountMaintenance =0;
        int VIPCountReserved = 0;
        int VIPCountOccupied = 0;
        int VIPCountVacant=0;
        
        for(int i=0; i<arrayRoom.size();i++){
            
            switch(arrayRoom.get(i).getRoomType()){
                
                case Single: switch(arrayRoom.get(i).getRoomStatus())
                                {   case Vacant: SingleCountVacant++;break;
                                    case Occupied: SingleCountOccupied++;break; 
                                    case Reserved: SingleCountReserved++;break;
                                    case UnderMaintenance: SingleCountMaintenance++;break;
                    
                                }break;
                                    
                 case Standard: switch(arrayRoom.get(i).getRoomStatus())
                                {   case Vacant: StandardCountVacant++;break;
                                    case Occupied: StandardCountOccupied++;break; 
                                    case Reserved: StandardCountReserved++;break;
                                    case UnderMaintenance: StandardCountMaintenance++;break;
                    
                                }break;
                     
                  case Suite: switch(arrayRoom.get(i).getRoomStatus())
                                {   case Vacant: SuiteCountVacant++;break;
                                    case Occupied: SuiteCountOccupied++;break; 
                                    case Reserved: SuiteCountReserved++;break;
                                    case UnderMaintenance: SuiteCountMaintenance++;break;
                    
                                }break;
                      
                  case VIP: switch(arrayRoom.get(i).getRoomStatus())
                                {   case Vacant: VIPCountVacant++;break;
                                    case Occupied: VIPCountOccupied++;break; 
                                    case Reserved: VIPCountReserved++;break;
                                    case UnderMaintenance: VIPCountMaintenance++;break;
                    
                                }break;
        
            }
   
        }
        
        
        System.out.println("=== ROOM OCCUPANCY REPORT FOR TODAY");
        System.out.println();
        
        //Single Rooms
        System.out.println("=== Single Rooms ===");
        System.out.println("Total Number of Single Rooms: " + MaxNumSingleRoom);
        System.out.println("Number of Single Rooms under maintenance: "+SingleCountMaintenance);
        System.out.println("Number of Single Rooms Reserved: "+ SingleCountReserved);
        System.out.println("Number of Single Rooms Occupied: "+ SingleCountOccupied);
        System.out.println("Number of Single Rooms Vacant: "+ SingleCountVacant);
        System.out.println();

        //Standard Rooms
        System.out.println("=== Standard Rooms ===");
        System.out.println("Total Number of Standard Rooms: " + MaxNumStandardRoom);
        System.out.println("Number of Standard Rooms under maintenance: "+StandardCountMaintenance);
        System.out.println("Number of Standard Rooms Reserved: "+ StandardCountReserved);
        System.out.println("Number of Standard Rooms Occupied: "+ StandardCountOccupied);
        System.out.println("Number of Standard Rooms Vacant: "+ StandardCountVacant);
        System.out.println();
        
        //SUITE Rooms
        System.out.println("=== Suite Rooms ===");
        System.out.println("Total Number of Suite Rooms: " + MaxNumSuiteRoom);
        System.out.println("Number of Suite Rooms under maintenance: "+SuiteCountMaintenance);
        System.out.println("Number of Suite Rooms Reserved: "+ SuiteCountReserved);
        System.out.println("Number of Suite Rooms Occupied: "+ SuiteCountOccupied);
        System.out.println("Number of Suite Rooms Vacant: "+ SuiteCountVacant);
        System.out.println();
        //VIP Rooms
        System.out.println("=== VIP Rooms ===");
        System.out.println("Total Number of VIP Rooms: " + MaxNumVIPRoom);
        System.out.println("Number of VIP Rooms under maintenance: "+VIPCountMaintenance);
        System.out.println("Number of VIP Rooms Reserved: "+ VIPCountReserved);
        System.out.println("Number of VIP Rooms Occupied: "+ VIPCountOccupied);
        System.out.println("Number of VIP Rooms Vacant: "+ VIPCountVacant);
        System.out.println();
        
    }

    //Get CurrentNumberOfRoomsBasedOnType      
    public int MaxNumOfRoomsBasedOnType(RoomType roomtype) {

        switch (roomtype) {

            case Single:
                return MaxNumSingleRoom;

            case Standard:
                return MaxNumStandardRoom;

            case VIP:
                return MaxNumVIPRoom;

            case Suite:
                return MaxNumSuiteRoom;
        }

        return 0;


    }

    public String getFirstAvailableRoom(RoomType roomType) {

        for (int i = 0; i < arrayRoom.size(); i++) {
            if (arrayRoom.get(i).getRoomType().equals(roomType) && (arrayRoom.get(i).getRoomStatus().equals(RoomStatus.Vacant))) {
                return arrayRoom.get(i).getRoomId();
            }

        }
        System.out.println("No available room");
        return null;

    }

    //RoomID Generation not in use anymore
//    public String generateRoomId(RoomType roomtype) {
//        String id = "Rooms have reached limit";
//        switch (roomtype) {
//
//            case Single:
//                for (int i = 0; i < singleArray.length; i++) {
//                    //first element which is empty
//                    if (singleArray[i] == false) {
//                        id = "Single" + Integer.toString(i);
//                        singleArray[i] = true;
//                        break;
//                    }
//                }
//                return id;
//
//            case Standard:
//                for (int i = 0; i < standardArray.length; i++) {
//                    //first element which is empty
//                    if (standardArray[i] == false) {
//                        id = "Standard" + Integer.toString(i);
//                        standardArray[i] = true;
//                        break;
//                    }
//                }
//                return id;
//
//            case VIP:
//                for (int i = 0; i < VIPArray.length; i++) {
//                    //first element which is empty
//                    if (VIPArray[i] == false) {
//                        id = "VIP" + Integer.toString(i);
//                        VIPArray[i] = true;
//                        break;
//                    }
//                }
//                return id;
//
//            case Suite:
//                for (int i = 0; i < suiteArray.length; i++) {
//                    //first element which is empty
//                    if (suiteArray[i] == false) {
//                        id = "Suite" + Integer.toString(i);
//                        suiteArray[i] = true;
//                        break;
//                    }
//                }
//                return id;
//
//
//        }
//        return id;
//    }
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
            System.out.println("Failed to delete all Room from data directory");
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
                if ((room.getRoomStatus().compareTo(RoomStatus.Vacant) != 0)) {
                    switch (room.getRoomType()) {
                        case Single:
                            NumOfSingleRoomNotVacant++;
                            break;
                        case Standard:
                            NumOfStandardRoomNotVacant++;
                            break;
                        case VIP:
                            NumOfSuiteRoomNotVacant++;
                            break;
                        case Suite:
                            NumOfVIPRoomNotVacant++;
                            break;
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
