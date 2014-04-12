/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HRPS.controller;
import HRPS.controller.GuestMgr;
import HRPS.entity.BedType;
import java.util.ArrayList;
import HRPS.entity.RoomStatus;
import HRPS.entity.RoomType;

/**
 *
 * @author Louis
 */
public class RoomMgrTest {
    
     public static void main(String[] args) {
        
        
       RoomMgr roomMgr = new RoomMgr();
        int num = 12334;
        boolean sucess;
        //int maxOcc,int rmId,int floor,RoomStatus roomstatus, RoomType roomtype,int curOcc,BedType bedtype
        sucess = roomMgr.createRoom(2,1,1,RoomStatus.Vacant,RoomType.Single,0,BedType.Single);
       
        
        sucess = roomMgr.createToFile();
   
        System.out.println("complete");
    }
    
    
    
    
}
