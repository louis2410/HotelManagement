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
    
 
       int i = roomMgr.MaxNumOfRoomsBasedOnType(RoomType.Single);
       System.out.println(i);
       roomMgr.updateRoomStatus("0101", RoomStatus.Occupied);
       i = roomMgr.MaxNumOfRoomsBasedOnType(RoomType.Single);
       System.out.println(i);
      
       roomMgr.printRoomOccupancyReport();
       
    }
    
    
    
    
}
