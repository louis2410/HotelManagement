package HRPS.controller;

import HRPS.entity.Guest;
import HRPS.entity.ReservationStatus;
import HRPS.entity.Reservation;
import HRPS.entity.Room;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.text.SimpleDateFormat;

public class ReservationMgr implements Manager {

    //Attributes
    private ArrayList<Reservation> arrayReservation;
    private PersistenceStrategy strategy;
    private List datalist;
    
    public ReservationMgr() {
        arrayReservation = new ArrayList<Reservation>();
        // prepares the file strategy to Respecitve data directory 
        strategy = new FilePersistenceStrategy(new File(System.getProperty("user.dir") + "/src/HRPS/data/Reservation"));
        // creates the list and linkage to data directory
        datalist = new XmlArrayList(strategy);
        //Setup
        setup();
    }

    /**
     *
     * @param reservation
     */
    public boolean createReservation(String associatedGuest, String resId, Date resBookDate, Date resCheckInDate, Date resCheckOutDate, int noOfDays, ReservationStatus resStatus, int noOfAdults, int noOfChildren, boolean paymentStatus) {
        // TODO - implement ReservationMgr.createReservation
        //add 1 new reservation record into data directory
         try {
            Reservation res = new Reservation( associatedGuest, resId, resBookDate, resCheckInDate , resCheckOutDate, noOfDays, resStatus, noOfAdults, noOfChildren, paymentStatus);
            //Store in memory
            arrayReservation.add(res);
        } catch (Exception ex) {
            System.out.println("Failed to create " + resId + " to data directory");
            return false;
        }
        return true;
    }

    /**
     *
     * @param reservation
     */
    public boolean updateReservation(List<Room> associatedRooms, Guest associatedGuest, int resId, Date resBookDate, Date resCheckInDate, Date resCheckOutDate, int noOfDays, ReservationStatus resStatus, int noOfAdults, int noOfChildren, boolean paymentStatus) {
        // TODO - implement ReservationMgr.updateReservation
         try {
            Reservation newRes = new Reservation(associatedRooms, associatedGuest, resId, resBookDate, resCheckInDate , resCheckOutDate, noOfDays, resStatus, noOfAdults, noOfChildren, paymentStatus);
            for (Iterator it = datalist.iterator(); it.hasNext();) {
                Reservation res = (Reservation) it.next();
                if(res.getResId() == newRes.getResId()){
                    //Update in data directory
                    it.remove();
                    datalist.add(newRes);
                    //handle memory version
                    for(int i=0; i<arrayReservation.size();i++){
                        if(arrayReservation.get(i).getResId() == resId){
                            arrayReservation.set(i, newRes);
                        }
                    }
                    break;
                }
                    
            }
        } catch (Exception ex) {
            System.out.println("Failed to update" + resId+ " all from data directory");
            return false;
        }
        return true;
    }

    /**
     *
     * @param reservationId
     */
    public boolean removeReservation(int reservationId) {
        // TODO - implement ReservationMgr.removeReservation
         try {
            //for each guest in Guest folder, delete each
            for (Iterator it = datalist.iterator(); it.hasNext();) {
                Reservation res = (Reservation) it.next();
                if(res.getResId() == reservationId){
                    //Remove from file
                    it.remove();
                    //Handle memory if found
                    for(int i=0; i<arrayReservation.size();i++){
                        if(arrayReservation.get(i).getResId() == reservationId){
                            arrayReservation.remove(i);
                        }
                    }
                    break;
                }
            }
            
        } catch (Exception ex) {
            System.out.println("Failed to delete" + reservationId + " all from data directory");
            return false;
        }
        return true;
    }

    /**
     *
     * @param reservationId
     */
    public Reservation getReservation(int reservationId) {
        // TODO - implement ReservationMgr.getReservation
        Reservation res = null;
        try {
            for (Iterator it = datalist.iterator(); it.hasNext();) {
                res = (Reservation) it.next();
                if(res.getResId() == reservationId){
                    break;
                }
                    
            }
        } catch (Exception e) {
            System.out.println("Failed to get Reservation " + reservationId + " all from data directory");
            return null;
        }
        return res;
    }

    //Print all reservations
    public String printReservations() {
        String display = "";
        for (Iterator it = arrayReservation.iterator(); it.hasNext();) {
            Reservation reservation = (Reservation) it.next();
            display += reservation.toString();
        }
        return display;
    }

    @Override
    public boolean createToFile() {
        try {
            //for each reservation  in arrayReservation, create one xml file
            for (Iterator it = arrayReservation.iterator(); it.hasNext();) {
                Reservation reservation = (Reservation) it.next();
                datalist.add(reservation);
            }
        } catch (Exception ex) {
            System.out.println("Failed to write to data directory");
            return false;
        }

        System.out.println("Reservations to XML Complete");
        return true;
    }

    //Delete all xml files from specified folder,run this method before createToFile else u will get duplicates
    @Override
    public boolean deleteFromFile() {
        try {
            //for each guest in Guest folder, delete each
            for (Iterator it = datalist.iterator(); it.hasNext();) {
                Reservation reservation = (Reservation)it.next();
                it.remove();
            }
        } catch (Exception ex) {
            System.out.println("Failed to delete all from data directory");
            return false;
        }

        System.out.println("Reservations to XML Complete");
        return true;
    }

    //Reads from the reservation Folder and then creates adds reservation Objects into arrayReservation
    @Override
    public boolean retrieveFromFile() {
        try {
            //for each reservation in reservation folder, creates an reservation object in reservationarray
        for (Iterator it = datalist.iterator(); it.hasNext();) {
            Reservation reservation = (Reservation) it.next();
            arrayReservation.add(reservation);
        }
        } catch (Exception ex) {
            System.out.println("Failed to retrive all from data directory");
            return false;
        }
        System.out.println("Reservations to XML Complete");
        return true;
    }

    @Override
    public void setup() {
        this.retrieveFromFile();
        this.deleteFromFile();
        //this.createToFile();
    }
    
    public List<Room> getReservedRooms(Date start, Date end){
        ArrayList<Room> resRoomsList = new ArrayList<Room>();
        Reservation res = null;
        try {
            for (Iterator it = datalist.iterator(); it.hasNext();) {
                res = (Reservation) it.next();
                if((res.getResCheckInDate().before(end)) && (res.getResCheckOutDate().after(start))){
                    for(Iterator it2 =res.getAllRooms().iterator(); it2.hasNext();){
                        Room tempRoom = (Room) it2.next();
                        if(!resRoomsList.contains(tempRoom)){
                            resRoomsList.add(tempRoom);
                        }
                    }
                }
                    
            }
        } catch (Exception e) {
            System.out.println("Failed to get all reservered Rooms from data directory");
            return null;
        }
        return resRoomsList;
    }
    
}