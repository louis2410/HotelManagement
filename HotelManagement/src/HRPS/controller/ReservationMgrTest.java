package HRPS.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import HRPS.entity.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;

/**
 * 
 *
 * @author Louis
 */
public class ReservationMgrTest {
    
    
      
    public static void main(String[] args) throws ParseException {
    //Managers for each sector
    GuestMgr guestMgr = new GuestMgr();
    ReservationMgr resMgr = new ReservationMgr();
    RoomMgr roomMgr = new RoomMgr(); 
    Calendar cal = Calendar.getInstance();
    int num = 123;
    String rmid;
    String guestId;
    
    String checkin = "4/12/2014";
    String checkout = "4/14/2014";
    int days = 2;
    int adult = 1;
    int children = 0;
    //Create Test Guest
    guestId = guestMgr.createGuest( "A1","John","Connor","Mr","WeeRoad","West",'m',num,"john@mail.com");
    //Create Test Room
    rmid = roomMgr.createSingleRoom();
    
   
 
     DateFormat dF = DateFormat.getDateInstance(DateFormat.SHORT);
   
    Date checkinDate = dF.parse(checkin);
    Date checkoutDate = dF.parse(checkout);
     
    //Reservation res = new Reservation( associatedGuest, resId, resBookDate, resCheckInDate ,
    //resCheckOutDate, noOfDays, resStatus, noOfAdults, noOfChildren, paymentStatus);
    resMgr.createReservation(guestId,"res1",cal.getTime(),checkinDate,checkoutDate,days, ReservationStatus.Confirmed,adult,children, true);
    
    resMgr.createToFile();
    
    
    }
    
    
    
}
