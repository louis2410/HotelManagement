/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HRPS.controller;

/**
 *
 * @author Louis
 */
public class RoomsInit {
    
    //Single = 80rm floor 1,2,3,4
    //Standard = 60rm floor 5,6,7 
    //Suite = 40rm floor 8 9
    //VIP = 20rm floor 10
    
    
    public static void main(String[] args){
        RoomMgr roomMgr = new RoomMgr();
        String rmId = null;
        for(int f = 1;f<11;f++){
            
            for(int r = 1; r<21;r++){
                
                rmId = String.format("%02d",f) + String.format("%02d",r);
                System.out.println(rmId);
                
                if(f <= 4){
                    roomMgr.createSingleRoom(rmId, f);
                }
                if(f > 4 && f <= 7 ){
                    roomMgr.createStandardRoom(rmId, f);
                }
                    
                if(f> 7 && f <= 9){
                    roomMgr.createSuiteRoom(rmId, f);
                }
                if(f>9){
                    roomMgr.createVIPRoom(rmId, f);
                }
                
            }

        }
        roomMgr.createToFile();
    }
}
