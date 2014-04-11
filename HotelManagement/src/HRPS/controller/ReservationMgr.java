package HRPS.controller;

import HRPS.entity.Guest;
import HRPS.entity.Reservation;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReservationMgr implements Manager {

    //Attributes
    private ArrayList<Reservation> arrayReservation;

    public ReservationMgr() {

        arrayReservation = new ArrayList<Reservation>();
    }

    /**
     *
     * @param reservation
     */
    public boolean createReservation(Reservation reservation) {
        // TODO - implement ReservationMgr.createReservation
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param reservation
     */
    public boolean updateReservation(Reservation reservation) {
        // TODO - implement ReservationMgr.updateReservation
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param reservationId
     */
    public boolean removeReservation(int reservationId) {
        // TODO - implement ReservationMgr.removeReservation
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param reservationId
     */
    public Guest getReservation(int reservationId) {
        // TODO - implement ReservationMgr.getReservation
        throw new UnsupportedOperationException();
    }

    //Print all reservations
    public void printReservations() {
        for (Iterator it = arrayReservation.iterator(); it.hasNext();) {
            Reservation reservation = (Reservation) it.next();
            System.out.println(reservation.getResId());

        }

    }

    //Creates XML files from an array of Guest Objects
    //Do note the folder directory
    @Override
    public boolean createToFile(){

        // prepares the file strategy to directory 
        PersistenceStrategy strategy = new FilePersistenceStrategy(new File("/Users/Louis/HotelManagement/HotelManagement/Reservation"));
        // creates the list:
        List list = new XmlArrayList(strategy);

        //for each guest in arrayGuest, create one xml file
        for (Iterator it = arrayReservation.iterator(); it.hasNext();) {
            Reservation reservation = (Reservation) it.next();
            list.add(reservation);

        }

        System.out.println("Reservations to XML Complete");
        return false;
    }

    //Delete all xml files from specified folder,run this method before createToFile else u will get duplicates
    @Override
    public boolean deleteFromFile() {

        // prepares the file strategy to directory 
        PersistenceStrategy strategy = new FilePersistenceStrategy(new File("/Users/Louis/HotelManagement/HotelManagement/Reservation"));
        // creates the list:
        List list = new XmlArrayList(strategy);

        //for each guest in Guest folder, delete each
        for (Iterator it = list.iterator(); it.hasNext();) {
            Reservation reservation = (Reservation) it.next();
            it.remove();
        }


        return true;
    }

    //Reads from the reservation Folder and then creates adds reservation Objects into arrayReservation
    @Override
    public boolean retrieveFromFile() {

        // prepares the file strategy to directory 
        PersistenceStrategy strategy = new FilePersistenceStrategy(new File("/Users/Louis/HotelManagement/HotelManagement/Reservation"));
        // creates the list:
        List list = new XmlArrayList(strategy);


        //for each reservation in reservation folder, creates an reservation object in reservationarray
        for (Iterator it = list.iterator(); it.hasNext();) {
            Reservation reservation = (Reservation) it.next();
            arrayReservation.add(reservation);
        }

        return true;
    }
    
    @Override
    public void setup() {
        this.retrieveFromFile();
        this.deleteFromFile();
        this.printReservations();
        this.createToFile();
    }

}