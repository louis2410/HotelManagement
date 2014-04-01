
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;
import hotelmanagement.Guest;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class RoomMgr implements Manager {
        
  
	/**
	 * Creation of a new Room in the hotel
	 * @param room
	 */
	public boolean createRoom(Room room) {
		// TODO - implement RoomMgr.createRoom
		throw new UnsupportedOperationException();
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

        
        
         public boolean createToFile(int n)
        {
            switch(n)
                case 1 = arrayStnard.
            
            
            // prepares the file strategy to directory 
		PersistenceStrategy strategy = new FilePersistenceStrategy(new File("/Users/Louis/HotelManagement/HotelManagement/Guests"));
		// creates the list:
		List list = new XmlArrayList(strategy);
                
                //for each guest in arrayGuest, create one xml file
		 for(Iterator it = arrayGuest.iterator();it.hasNext();){
                Guest guest = (Guest)it.next();
                list.add(guest);
                //System.out.println(guest.getFirstName());      
                }

           return true;
        }
}