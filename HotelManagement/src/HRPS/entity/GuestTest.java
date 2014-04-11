/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HRPS.entity;

import HRPS.controller.GuestMgr;
import java.util.ArrayList;

/**
 *
 * @author Louis
 */

//Test Class for writing and storing in XML

public class GuestTest {
    
   
    public static void main(String[] args) {
        
        
        GuestMgr guestMgr = new GuestMgr();
        int num = 12334;
        boolean sucess;
        sucess = guestMgr.createGuest( "A1","John","Connor","Mr","WeeRoad","West",'m',num,"john@mail.com");
        sucess = guestMgr.createGuest( "A2","James","Bond","Mr","PeeRoad","West",'m',num,"john@mail.com");
        sucess = guestMgr.createGuest( "A3","Jack","Ripper","Mr","peeRoad","West",'m',num,"john@mail.com");
       
        
        //guestMgr.retrieveFromFile();
        //guestMgr.DeleteFromFile();
        //guestMgr.createToFile();
        //guestMgr.printGuests();
        
        guestMgr.setup();
        System.out.println("complete");
    }
    
    
    
}
