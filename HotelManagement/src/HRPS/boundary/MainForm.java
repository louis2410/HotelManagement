package HRPS.boundary;

import HRPS.controller.GuestMgr;
import HRPS.controller.HotelMgr;
import HRPS.controller.RoomMgr;
import HRPS.entity.RoomType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainForm {

    //Common parameter
    static Scanner sc = new Scanner(System.in);
    static HotelMgr hotelMgr = new HotelMgr();

    public static void main(String args[]) {
        //Main interface
        System.out.println("---------------------------------------------------------------------");
        System.out.println("\tWelcome to Hotel Reservation and Payment System");
        System.out.println("\t\t\tHPRS Version 1.0");
        System.out.println("---------------------------------------------------------------------");

        
        UIControl();
        
       
    }

    public static void UIControl(){
        
        int choice;
        
        do{
            choice = printMainMenu();
            switch(choice){
        
            case 1:printRoomMenu();
                    break;
             
            case 2:printGuestMenu();
                    break;
                
            case 3:printReservationMenu();
                    break;
            
            case 4:printReservationReceiptMenu();
                    break;
                
            case 5://CheckAvailableityofroom
                    printCheckRoomAvailablity();
                    break;
                
            case 6://Check-In 
                    break;
               
            case 7://Checkout and print invoice
                    break;
                
            case 8://Print RoomOccupancy Report
                    
                    printRoomOccupancyReport();
                    break;
               
            case 9://Exit XML functions   
                    hotelMgr.OutputToXML();
                    break;
        
        default:    System.out.println("Please enter a value from 1 to 9.");
                      
         }
            
            
            
        }while(choice != 9);
        
        
    }
    
    
    public static int printMainMenu() {
        int choice;     
        //Choice 
        System.out.println("Please select one of the following choices: \n"
                + "1. Create/Update/Remove rooms details \n"
                + "2. Create/Update/Remove guests detail\n"
                + "3. Create/Update/Remove reservation\n"
                + "4. Print reservation receipt\n"
                + "5. Check availability of a room\n"
                + "6. Check-in\n"
                + "7. Check-out and print bill invoice\n"
                + "8. Print Room Occupancyreport\n"
                + "9. Quit the system\n");
        System.out.print("Please select a choice : ");
        
            choice = sc.nextInt();
            return choice;
    }
    
    

    public static void printRoomMenu() {
        Scanner in = new Scanner(System.in);
        String roomId;
        System.out.println("Please select one of the following choices: \n"
                + "1. Create Room\n"
                + "2. Update Room\n"
                + "3. Remove Room\n"
                + "4. Back to menu\n");
        int CURRoomChoice = in.nextInt();
      
            switch (CURRoomChoice) {
                //Create Room
                case 1: hotelMgr.printNumOfAvailableRoomsForCreation();
                        System.out.println("Select Type of Room to be Created:");
                        System.out.println("1. Single Room");
                        System.out.println("2. Standard Room");
                        System.out.println("3. VIP Room");
                        System.out.println("4. Suite Room");
                        CURRoomChoice = in.nextInt();
                        in.nextLine();
                        hotelMgr.createRoomBasedonType(CURRoomChoice);
                        break;
                      
                //Update Room
                case 2: System.out.println("Enter Room ID");
                             roomId = in.next();
                             System.out.println("Select Type of Update");
                             System.out.println("1. Update Room Status");
                             System.out.println("2. Add RoomService");
                             int choice = in.nextInt();
                             switch(choice){                              
                                 case 1: System.out.println("Select Status");
                                         System.out.println("1. Occupied");
                                         System.out.println("2. Reserved");
                                         System.out.println("3. Under Maintance");
                                         System.out.println("4. Vacant");
                                         choice = in.nextInt();
                                         hotelMgr.updateRoomStatus(roomId, choice);
                                         break;
                                         
                                 case 2: System.out.println("Enter amount of Room Service");
                                         double amt = in.nextDouble();
                                         hotelMgr.addRoomService(roomId, amt);
                                         break;      
                             }

                        break;
                    
                //Remove Room
                case 3: System.out.println("Enter Room ID");
                               roomId = in.next();
                        hotelMgr.removeRoom(roomId);
                        break;
                    
                //Back to Menu
                case 4:    break;
             }
            
    }

    public static void printGuestMenu() {
        Scanner in = new Scanner(System.in);
        String guestId;
        System.out.println("Please select one of the following choices: \n"
                + "1. Create Guest\n"
                + "2. Update Guest\n"
                + "3. Remove Guest\n"
                + "4. Back to menu\n");
        int CURGuestchoice = in.nextInt();
        while (CURGuestchoice != 4) {
            switch (CURGuestchoice) {
                //Create Guest
                case 1:
                    System.out.print("Please input the guest ID: ");
                    guestId = in.next();
                    System.out.print("Please input the First Name: ");
                    String FirstName = in.next();
                    System.out.print("Please input the Last Name: ");
                    String lastName = in.next();
                    System.out.print("Please input the title: ");
                    String title = in.next();
                    System.out.print("Please input the address: ");
                    String address = in.next();
                    System.out.print("Please input the country: ");
                    String country = in.next();
                    System.out.print("Please input the gender: ");
                    char gender = in.next().charAt(0);
                    System.out.print("Please input the contact number: ");
                    int contactNo = in.nextInt();
                    System.out.print("Please input the email: ");
                    String email = in.next();
                    hotelMgr.createGuest(guestId, FirstName, lastName, title, address, country, gender, contactNo, email);
                    System.out.print("Is there any associate guest? Yes = y No = n ");
                    boolean assoguestchoice = in.next().charAt(0) == 'y';
                    while (assoguestchoice) {
                        System.out.println("Please input the associate guest Id");
                        String AssoguestId = in.next();
                       hotelMgr.getGuest(guestId).setAssoGuest(hotelMgr.getGuest(AssoguestId));
                        System.out.print("Is there any more associate guest? Yes = y No = n ");
                        assoguestchoice = in.next().charAt(0) == 'y';
                    }
                    break;
                //Update Guest
                case 2:
                    System.out.println("Please input the guest ID you want to Update");
                    guestId = in.next();
                    System.out.println("Please select one of the following choices: \n"
                            + "1. Update guest ID\n"
                            + "2. Update First Name\n"
                            + "3. Update Last Name\n"
                            + "4. Update title\n"
                            + "5. Update address\n"
                            + "6. Update country\n"
                            + "7. Update gender\n"
                            + "8. Update contact number\n"
                            + "9. Update email\n"
                            + "10. Back to last menu");
                    int UpdateGuestchoice = in.nextInt();
                    while (CURGuestchoice != 10) {
                        switch (UpdateGuestchoice) {
                            case 1:
                                System.out.print("Please input the guest ID: ");
                                guestId = in.next();
                                hotelMgr.getGuest(guestId).setGuestId(guestId);
                                break;
                            case 2:
                                System.out.print("Please input the First Name: ");
                                FirstName = in.next();
                                hotelMgr.getGuest(guestId).setFirstName(FirstName);
                                break;
                            case 3:
                                System.out.print("Please input the Last Name: ");
                                lastName = in.next();
                                hotelMgr.getGuest(guestId).setLastName(lastName);
                                break;
                            case 4:
                                System.out.print("Please input the title: ");
                                title = in.next();
                                hotelMgr.getGuest(guestId).setTitle(title);
                                break;
                            case 5:
                                System.out.print("Please input the address: ");
                                address = in.next();
                                hotelMgr.getGuest(guestId).setAddress(address);
                                break;
                            case 6:
                                System.out.print("Please input the country: ");
                                country = in.next();
                                hotelMgr.getGuest(guestId).setCountry(country);
                                break;
                            case 7:
                                System.out.print("Please input the gender: ");
                                gender = in.next().charAt(0);
                                hotelMgr.getGuest(guestId).setGender(gender);
                                break;
                            case 8:
                                System.out.print("Please input the contact number: ");
                                contactNo = in.nextInt();
                                hotelMgr.getGuest(guestId).setContactNo(contactNo);
                                break;
                            case 9:
                                System.out.print("Please input the email: ");
                                email = in.next();
                                hotelMgr.getGuest(guestId).setEmail(email);
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                //Remove Guest
                case 3:
                    System.out.println("Please input the guest ID you want to Remove");
                    guestId = in.next();
                    hotelMgr.removeGuest(guestId);
                    break;
                case 4:
                    System.out.println("Returning to Main Menu...");
                    printMainMenu();
                    break;

             
                default:
                    System.out.println("Please enter a value from 1 to 9.");
                    break;
            }
        }
        throw new UnsupportedOperationException();
    }
    
    public static void printRoomOccupancyReport(){
        hotelMgr.printRoomOccupancyReport();
    }

    //Arthur : Bryan
    public static void printReservationMenu() {
        // TODO - implement MainForm.printReservationMenu

        //Parameters
        int choice;

        //Print Reservation Menu
        System.out.println("Please select one of the following Reservation Service");
        System.out.println("1 : Create a new Reservation");
        System.out.println("2 : Update a Reservation");
        System.out.println("3 : Cancel a Reservation");
        System.out.println("4 : Return to Main Menu");

        do {
            System.out.print("Please select a choice : ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    printCreateReservationMenu();
                    break;
                case 2:
                    printUpdateReservationMenu();
                    break;
                case 3:
                    printRemoveReservationMenu();
                    break;
                case 4:
                    System.out.println("Returning to Main Menu...");
                    printMainMenu();
                    break;
                default:
                    System.out.println("Please enter a value from 1 to 4.");
                    break;
            }
        } while (choice != 4);
        throw new UnsupportedOperationException();
    }

    //Arthur : Bryan
    public static void printCreateReservationMenu() {
        //Parameters
        String guestId;
        Date checkIn, checkOut;
        int noOfRooms, noOfAdults, noOfChildren;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        //Check for exist guest record
        try {
            System.out.print("Enter the guest Id :");
            guestId = sc.next();

            if (!hotelMgr.checkExistingGuest(guestId)) {
                System.out.println("This is a new guest, please register the guest");
                System.out.println("Redirecting to New Guest Menu...");
                //Display Menu for creating a new guest;
                //printCreateGuest();
                System.out.println("Redirecting back to New Reservation Menu...");
            } else {
                System.out.println(hotelMgr.displayGuestDetails(guestId));
            }

            System.out.print("Enter the Check in date as dd/mm/yyyy : ");
            checkIn = df.parse(sc.next());
            System.out.print("Enter the Check out date as dd/mm/yyyy : ");
            checkOut = df.parse(sc.next());
            //Print Available Rooms
            System.out.println("The available rooms are : ");
            System.out.println(hotelMgr.getAllAvailableRooms(checkIn, checkOut));

            //Select From available rooms
            System.out.print("Enter the no of rooms : ");
            noOfRooms = sc.nextInt();

            //Enter room ID to book rooms.
            int rmId[] = new int[noOfRooms];
            System.out.println("Please from the avaliable list of rooms to reserve: ");
            for (int i = 0; i < noOfRooms; i++) {
                System.out.print("Room " + (i + 1) + " : ");
                rmId[i] = sc.nextInt();
            }

            System.out.println("Selected Rooms : " + rmId.toString());

            //Asking for additon details
            System.out.print("Please enter the no of adults : ");
            noOfAdults = sc.nextInt();
            System.out.print("Please enter the no of children : ");
            noOfChildren = sc.nextInt();

            System.out.println("Proceeding to create Reservation...");
            //Proceed to create Reservation.
            int resId = hotelMgr.createReservation(guestId, checkIn, checkOut, noOfRooms, rmId, noOfAdults, noOfChildren);
            if (resId != -1) {
                System.out.println("Creation of Reservation is succuessful.");
                System.out.println(hotelMgr.displayReservationDetails(resId));
                System.out.println("Returning to Reservation Management Menu....");
                return;
            } else {
                System.out.println("Creation of Reservation is failure. Please try again.");
                System.out.println("Returning to Reservation Management Menu....");
                return;
            }

            //Hang
        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Arthur : Bryan

    
    public static void printUpdateReservationMenu() {
        int resId = 0, choice = 0;

        try {
            do {
                System.out.print("Enter the reservation Id :");
                resId = sc.nextInt();

                if (resId == -1) {
                    return;
                } else if (hotelMgr.checkExisitingReservation(resId)) {
                    break;
                } else {
                    System.out.println("There is not such reservation. Please enter a valid id or -1 to return to Reservation Menu");
                }
            } while (resId != -1);

            //Check for reservation status
            if (!hotelMgr.checkAllowReservationStatus(resId)) {
                System.out.println("Sorry, the reservation is either has been checked into the hotel or has expired");
                System.out.println("Redirecting to Reservation Management Menu...");
                return;
            }

            //Print the detail of selected Reservations
            System.out.println(hotelMgr.displayReservationDetails(resId));

            //Print Options to update
            System.out.println("What would u like to change ?");
            System.out.println("1 : Check In date");
            System.out.println("2 : No of Days");
            System.out.println("3 : No of Rooms");
            System.out.println("4 : Guest in charge");
            System.out.println("5 : No of Adults");
            System.out.println("6 : No of Children");
            System.out.println("7 : Return to Reservation Management Menu");

            do {
                System.out.print("Please select a choice : ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Please enter a new Check In date : ");
                        break;
                    case 2:
                        System.out.print("Please enter the no of days : ");
                        break;
                    case 3:
                        System.out.print("Please enter the no of rooms  : ");
                        break;
                    case 4:
                        System.out.println("Please enter the guest Id : ");
                        printMainMenu();
                        break;
                    case 5:
                        System.out.println("Please enter the no of adults : ");
                        printMainMenu();
                        break;
                    case 6:
                        System.out.println("Please enter the no of children : ");
                        printMainMenu();
                        break;
                    case 7:
                        System.out.println("Returning to Reservation Management Menu...");
                        return;
                    default:
                        System.out.println("Please enter a value from 1 to 7.");
                        break;
                }
            } while (choice != 7);

        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Arthur : Bryan

    public static void printRemoveReservationMenu() {
        int resId = 0, choice = 0;

        try {
            do {
                System.out.print("Enter the reservation Id :");
                resId = sc.nextInt();

                if (resId == -1) {
                    return;
                } else if (hotelMgr.checkExisitingReservation(resId)) {
                    break;
                } else {
                    System.out.println("There is not such reservation. Please enter a valid id or -1 to return to Reservation Menu");
                }
            } while (resId != -1);

            //Check for reservation status
            if (!hotelMgr.checkAllowReservationStatus(resId)) {
                System.out.println("Sorry, the reservation is either has been checked into the hotel or has expired");
                System.out.println("Redirecting to Reservation Management Menu...");
                return;
            }

            //Print the detail of selected Reservations
            System.out.println(hotelMgr.displayReservationDetails(resId));

            //Print Options to update
            System.out.println("Do you want to cancel the above reservation?");
            System.out.println("1 : Yes");
            System.out.println("2 : No, Return to Reservation Management Menu");

            do {
                System.out.print("Please select a choice : ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        if (hotelMgr.removeReservation(resId)) {
                            System.out.println("The reservation has been removed.");
                        } else {
                            System.out.println("The reservation has failed to remove.");
                            System.out.println("Redirecting to Reservation Management Menu...");
                            return;
                        }
                        break;
                    case 2:
                        System.out.println("Returning to Reservation Management Menu...");
                        return;
                    default:
                        System.out.println("Please enter a value from 1 to 3.");
                        break;
                }
            } while (choice != 2);

        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Arthur : Bryan

    public static void printReservationReceiptMenu() {
        int resId = 0;
        try {
            do {
                System.out.print("Enter the reservation Id :");
                resId = sc.nextInt();

                if (resId == -1) {
                    return;
                } else if (hotelMgr.checkExisitingReservation(resId)) {
                    System.out.println("Printing Reservation Details");
                    System.out.println(hotelMgr.displayReservationDetails(resId));
                    break;
                } else {
                    System.out.println("There is not such reservation. Please enter a valid id or -1 to return to Reservation Menu");
                }
            } while (resId != -1);
            
            
        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void printCheckRoomAvailablity(){
           
           System.out.println("Enter Room Id");
           String rmId = sc.next();
           System.out.println("RoomId "+rmId +"is "+hotelMgr.checkRoomAvailability(rmId));
      
       }
    
    
    
    
    }

 