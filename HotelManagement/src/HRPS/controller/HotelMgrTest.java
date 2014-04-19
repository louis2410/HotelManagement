/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HRPS.controller;

import HRPS.entity.*;
import java.util.*;
import java.util.List;


/**
 *
 * @author Louis
 */
public class HotelMgrTest {
    
    public static void main(String[] args) {
   int choice = 0;
        PaymentType paymentType = null;
        Scanner sc = new Scanner(System.in);System.out.println("How you like to pay ? Please slect one of following payment methods.");
            System.out.println("1 : Cash");
            System.out.println("2 : Credit Cardt");
            System.out.print("Please select a choice : ");
        do { //Print Reservation Menu
            System.out.println("How you like to pay ? Please slect one of following payment methods.");
            System.out.println("1 : Cash");
            System.out.println("2 : Credit Card");
            System.out.print("Please select a choice : ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    paymentType = PaymentType.Cash;
                    break;
                case 2:
                    paymentType = PaymentType.Credit;
                    break;
                default:
                    System.out.println("Please enter a value from 1 to 2.");
                    break;
            }
        } while ((choice != 2) && (choice !=1));
    
    
}
}