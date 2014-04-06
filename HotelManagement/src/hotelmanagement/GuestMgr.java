package hotelmanagement;
import java.util.ArrayList;
import java.util.Iterator;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;
import hotelmanagement.XML.Author;
import java.io.File;
import java.util.List;


public class GuestMgr  {

    
    //Attributes
    private ArrayList<Guest> arrayGuest;
    
    public GuestMgr()
    {
        arrayGuest = new ArrayList<Guest>();
    }
	public boolean createGuest(String guestId,String FirstName,String lastName,
         String title,String address,String country,char gender,int contactNo,String email) 
         {
		// TODO - implement GuestMgr.createGuest
             Guest guest = new Guest(guestId,FirstName,lastName,title,address,country,gender,contactNo,email);
         
                arrayGuest.add(guest);
                
		return true;
	}

	public void printGuests(){
          
            for(Iterator it = arrayGuest.iterator();it.hasNext();){
                Guest guest = (Guest)it.next();
                System.out.println(guest.getFirstName());
                
            }
        }
         //Creates XML files from an array of Guest Objects
        //Do note the folder directory
        public boolean createToFile()
        {
            
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
        
        //Delete all xml files from specified folder,run this method before createToFile else u will get duplicates
        public boolean DeleteFromFile(){
            
            // prepares the file strategy to directory 
		PersistenceStrategy strategy = new FilePersistenceStrategy(new File("/Users/Louis/HotelManagement/HotelManagement/Guests"));
		// creates the list:
		List list = new XmlArrayList(strategy);
                
                //for each guest in Guest folder, delete each
		 for(Iterator it = list.iterator();it.hasNext();){
                Guest guest = (Guest)it.next();
                it.remove();
                }
            

            return true;
        }
         
          //Reads from the Guest Folder and then creates adds Guest Objects into arrayGuest
        public boolean retrieveFromFile(){
            
             // prepares the file strategy to directory 
		PersistenceStrategy strategy = new FilePersistenceStrategy(new File("/Users/Louis/HotelManagement/HotelManagement/Guests"));
		// creates the list:
		List list = new XmlArrayList(strategy);
            
                
                //for each guest in guestfolder, creates an guest object in arrayGuest
             for(Iterator it = list.iterator();it.hasNext();){
                Guest guest = (Guest)it.next();
                arrayGuest.add(guest);
                }
            
            return true;
        }
        
        
      
	public boolean updateGuest(Guest guest) {
		// TODO - implement GuestMgr.updateGuest
		//throw new UnsupportedOperationException();
	}

	
	public boolean removeGuest(String guestId) {
        arrayGuest.remove(arrayGuest.getGuest(guestId));
	}

	
	public Guest getGuest(String guestId) {
		while(i= 0;i<arrayGuest.size();i++){
            if(arrayGuest[i].getGuestId==guestId){
                return arrayGuest[i];
            }
        }
	}

        
 
	
      

}
