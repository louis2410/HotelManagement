package HRPS.controller;

import HRPS.entity.Guest;
import HRPS.entity.ReservationStatus;
import HRPS.entity.Reservation;
import HRPS.entity.Room;
import HRPS.entity.RoomType;
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
    
    public int NumOfReservations(){
        return arrayReservation.size();
    }

    //Returns numberofclashes
    public int CheckReservationClash(Date newcheckin,Date newcheckout,RoomType rmType){
        int count = 0;
        
        //Loop through each reservation
        for(int i = 0;i<arrayReservation.size();i++){
            boolean hit = false;
           //if roomType matches and reservationStatus is confirmed or checked in then clash
            if(arrayReservation.get(i).getRoomType().equals(rmType) && (arrayReservation.get(i).getResStatus().equals(ReservationStatus.Check_In)||arrayReservation.get(i).getResStatus().equals(ReservationStatus.Confirmed)))
            {
                   //Check dates 
                //if newcheckin falls on checkindate and before checkoutdate
             if((newcheckin.equals(arrayReservation.get(i).getResCheckInDate()))
                   && newcheckin.before(arrayReservation.get(i).getResCheckOutDate())){ 
                     hit = true;
               }
            //if newcheckin falls after checkindate and beforecheckoutdate
              if((newcheckin.after(arrayReservation.get(i).getResCheckInDate()))
                    && newcheckin.before(arrayReservation.get(i).getResCheckOutDate())){ 
                    hit = true;
                }
        
            //if newcheckin before checkindate and beforecheckoutdate
              if((newcheckin.before(arrayReservation.get(i).getResCheckInDate()))
                    && newcheckin.before(arrayReservation.get(i).getResCheckOutDate())){ 
                    hit = true;
                }
        
                //if newcheckin falls on checkOutdate
            if((newcheckin.equals(arrayReservation.get(i).getResCheckOutDate()))){
                hit = true;
            }
                
                 //if newcheckout before on checkindate
            if((newcheckout.before(arrayReservation.get(i).getResCheckInDate()))){
                hit = false;
            }
              
                //if newcheckout falls on checkindate
            if((newcheckout.equals(arrayReservation.get(i).getResCheckOutDate()))){
                hit = true;
            }
          //clashcount increase    
            if(hit == true){
              count++;
            }   
         }
        }
        
        
        return count;
    }
    
    
    
    public ArrayList getArrayReservation(){
        return arrayReservation;
    }
    /**
     *
     * @param reservation
     */
    public boolean createReservation(String associatedGuest, String resId, Date resBookDate, Date resCheckInDate, Date resCheckOutDate, ReservationStatus resStatus, int noOfAdults, int noOfChildren, boolean paymentStatus, RoomType rmtype) {
        // TODO - implement ReservationMgr.createReservation
        //add 1 new reservation record into data directory
         try {
            Reservation res = new Reservation( associatedGuest, resId, resBookDate, resCheckInDate , resCheckOutDate, resStatus, noOfAdults, noOfChildren, paymentStatus, rmtype);
            //Store in memory
            arrayReservation.add(res);
        } catch (Exception ex) {
            System.out.println("Failed to create " + resId + " to data directory");
            return false;
        }
        return true;
    }

    public boolean addRoomToReservation(String resId,String roomId){
        getReservation(resId).AddAssociatedRoom(roomId);   
        return true;
    }
    
    
    public Reservation getReservation(String resId){
        
        for(int i =0;i<arrayReservation.size();i++){
            
            if(arrayReservation.get(i).getResId().equals(resId)){
                
                return arrayReservation.get(i);
            }
        }
        System.out.println("Reservation not found");
        return null;
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
        System.out.println("XML To Reservation Complete");
        return true;
    }

    @Override
    public void setup() {
        this.retrieveFromFile();
        //this.deleteFromFile();
        //this.createToFile();
    }
    
    
}