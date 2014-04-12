/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HRPS.controller;

import HRPS.entity.RoomType;

/**
 *
 * @author Louis
 */
public class HotelMgrTest {
    
    public static void main(String[] args) {
    
        HotelMgr hotelMgr = new HotelMgr();
        hotelMgr.createRoomBasedonType(RoomType.Single);
        
    
    }
    
    
}
