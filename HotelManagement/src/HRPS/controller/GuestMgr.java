package HRPS.controller;

import HRPS.entity.Guest;
import java.util.ArrayList;
import java.util.Iterator;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;

import HRPS.XML.Author;

import java.io.File;
import java.util.List;

public class GuestMgr {

    //Attributes
    private ArrayList<Guest> arrayGuest;
    private PersistenceStrategy strategy;
    private List datalist;
    
    public GuestMgr() {
        arrayGuest = new ArrayList<Guest>();
           // prepares the file strategy to Respecitve data directory 
        strategy = new FilePersistenceStrategy(new File(System.getProperty("user.dir") + "/src/HRPS/data/Guest"));
        // creates the list and linkage to data directory
        datalist = new XmlArrayList(strategy);
       
        //Setup
        setup();
    }

    public String createGuest(String guestId, String FirstName, String lastName,
            String title, String address, String country, char gender, int contactNo, String email) {
        // TODO - implement GuestMgr.createGuest
        Guest guest = new Guest(guestId, FirstName, lastName, title, address, country, gender, contactNo, email);

        arrayGuest.add(guest);

        return guestId;
    }

    public void printAllGuests() {

        for (Iterator it = arrayGuest.iterator(); it.hasNext();) {
            Guest guest = (Guest) it.next();
            System.out.println(guest.getFirstName());

        }
    }
    
     public void printGuest(String guestId) {

        for (Iterator it = arrayGuest.iterator(); it.hasNext();) {
            Guest guest = (Guest) it.next();
            if(guest.getGuestId() == guestId){
                System.out.println(guest.getFirstName());
                break;
            }      
        }
    }
    //Creates XML files from an array of Guest Objects
    //Do note the folder directory

    public boolean createToFile() {

   
    try {
            //for each reservation  in arrayRoom create one xml file
            for (Iterator it = arrayGuest.iterator(); it.hasNext();) {
             Guest guest = (Guest) it.next();
                datalist.add(guest);
            }
        } catch (Exception ex) {
            System.out.println("Failed to write to data directory");
            return false;
        }

        System.out.println("Guests to XML Complete");
        return true;
    }

    //Delete all xml files from specified folder,run this method before createToFile else u will get duplicates
    public boolean DeleteFromFile() {
       //for each guest in guestfolder, delete xml
               try {
        for (Iterator it = datalist.iterator(); it.hasNext();) {
            Guest guest = (Guest) it.next();
            it.remove();
        }
        } catch (Exception ex) {
            System.out.println("Failed to delete all from data directory");
            return false;
        }
        System.out.println("Guest XML Delete Complete");
        return true;
    }

    //Reads from the Guest Folder and then creates adds Guest Objects into arrayGuest
    public boolean retrieveFromFile() {
        //for each guest in guestfolder, creates an guest object in arrayGuest
               try {
        for (Iterator it = datalist.iterator(); it.hasNext();) {
            Guest guest = (Guest) it.next();
            arrayGuest.add(guest);
        }
        } catch (Exception ex) {
            System.out.println("Failed to retrive all from data directory");
            return false;
        }
        System.out.println("Guest XML to arrayGuest Complete");
        return true;
    }


    public boolean updateGuest(Guest guest) {
        for (int i = 0; i < arrayGuest.size(); i++) {
            if (arrayGuest.get(i).getGuestId() == guest.getGuestId()) {
                arrayGuest.set(i, guest);
            }
        }
        return false;

    }

    public boolean removeGuest(String guestId) {
        boolean success = true;
        try{
            for (int i = 0; i < arrayGuest.size(); i++) {
            if (arrayGuest.get(i).getGuestId() == guestId) {
                arrayGuest.remove(i);
            }
        }
        }catch (Exception ex){
            success = false;
        }
        return success;
    }

    public Guest getGuest(String guestId) {
        for (int i = 0; i < arrayGuest.size(); i++) {
            System.out.println(arrayGuest.get(i).getGuestId());
            if (arrayGuest.get(i).getGuestId().equals(guestId)) {
                return arrayGuest.get(i);
            }
        }
        return null;
    }

    public void setup() {
        this.retrieveFromFile();
        //this.DeleteFromFile();
        //this.printAllGuests();
        //this.createToFile();


    }
}
