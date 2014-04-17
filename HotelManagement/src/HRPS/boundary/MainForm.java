package HRPS.boundary;

import HRPS.controller.HotelMgr;
import HRPS.entity.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
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
    // Handles Printing of Menu

    public static void UIControl() {
        int choice;
        do {
            choice = printMainMenu();
            switch (choice) {
                case 1:
                    printRoomMenu();
                    break;
                case 2:
                    printGuestMenu();
                    break;
                case 3:
                    printReservationMenu();
                    break;
                case 4:
                    printReservationReceiptMenu();
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
                default:
                    System.out.println("Please enter a value from 1 to 9.");
                    break;
            }
        } while (choice != 9);
    }

    public static int printMainMenu() {
        int choice;
        System.out.println("Please select one of the following services: \n"
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
        int choice = 0;
        do {
            System.out.println("\t--This is the Room Management Menu--");
            System.out.println("Please select one of the following services: \n"
                    + "1. Create Room\n"
                    + "2. Update Room\n"
                    + "3. Remove Room\n"
                    + "4. Back to menu\n");
            System.out.print("Please select a choice : ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    printCreateRoomMenu();
                    break;
                case 2:
                    printUpdateRoomMenu();
                    break;
                case 3:
                    printRemoveRoomMenu();
                    break;
                case 4:
                    System.out.println("\t--This is the end of Room Management Menu--");
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Please enter a value from 1 to 4.");
                    break;
            }
        } while (choice != 4);
    }

    public static void printCreateRoomMenu() {
        int choice = 0;
        String roomId;
        do {
            System.out.println("\t--This is the Create Room Form--");
            System.out.print("Please input a new room ID: ");
            roomId = sc.next();

            System.out.println("Checking if the room exist in the system");
            if (hotelMgr.checkExistingRoom(roomId)) {
                System.out.println("There is already such room exist in the system.");
                System.out.println(hotelMgr.getRoom(roomId).toString());
                System.out.println("Returning to Room Management Menu...");
                return;
            } else {
                System.out.println("There is no such room  exist in the system. Please continue with creation");
            }

            System.out.println("Select Type of Room to create:");
            System.out.println("1. Single Room");
            System.out.println("2. Standard Room");
            System.out.println("3. Suite Room");
            System.out.println("4. VIP Room");
            System.out.print("Please select a choice : ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    hotelMgr.createSingleRoom(roomId, Integer.parseInt(roomId.substring(0, 2)));
                    System.out.println(hotelMgr.getRoom(roomId).toString());
                    System.out.println("\t--This is the end of Create Room Form--");
                    return;
                case 2:
                    hotelMgr.createStandardRoom(roomId, Integer.parseInt(roomId.substring(0, 2)));
                    System.out.println(hotelMgr.getRoom(roomId).toString());
                    System.out.println("\t--This is the end of Create Room Form--");
                    return;
                case 3:
                    hotelMgr.createSuiteRoom(roomId, Integer.parseInt(roomId.substring(0, 2)));
                    System.out.println(hotelMgr.getRoom(roomId).toString());
                    System.out.println("\t--This is the end of Create Room Form--");
                    return;
                case 4:
                    hotelMgr.createVIPRoom(roomId, Integer.parseInt(roomId.substring(0, 2)));
                    System.out.println(hotelMgr.getRoom(roomId).toString());
                    System.out.println("\t--This is the end of Create Room Form--");
                    return;
                default:
                    System.out.println("Please enter a value from 1 to 4.");
                    break;
            }
        } while (choice != 4);
    }

    public static void printUpdateRoomMenu() {
        int choice = 0;
        String roomId;
        do {
            System.out.println("\t--This is the Update Room Form--");
            System.out.print("Please input a new room ID: ");
            roomId = sc.next();

            System.out.println("Checking if the room exist in the system");
            if (hotelMgr.checkExistingRoom(roomId)) {
                System.out.println("There is such room exist in the system.");
                System.out.println(hotelMgr.getRoom(roomId).toString());
            } else {
                System.out.println("There is no such room  exist in the system.");
                System.out.println("Returning to Room Management Menu...");
                return;
            }

            System.out.println("Select Type of Update");
            System.out.println("1. Update Room Status");
            System.out.println("2. Add RoomService");
            System.out.print("Please select a choice : ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    do {
                        System.out.println("Select Status");
                        System.out.println("1. Occupied");
                        System.out.println("2. Reserved");
                        System.out.println("3. Under Maintance");
                        System.out.println("4. Vacant");
                        System.out.print("Please select a choice : ");
                        choice = sc.nextInt();
                        switch (choice) {
                            case 1:
                                hotelMgr.updateRoomStatus(roomId, RoomStatus.Occupied);
                                System.out.println(hotelMgr.getRoom(roomId).toString());
                                System.out.println("\t--This is the end of Update  Room Form--");
                                return;
                            case 2:
                                hotelMgr.updateRoomStatus(roomId, RoomStatus.Reserved);
                                System.out.println(hotelMgr.getRoom(roomId).toString());
                                System.out.println("\t--This is the end of Update Room Form--");
                                return;
                            case 3:
                                hotelMgr.updateRoomStatus(roomId, RoomStatus.UnderMaintenance);
                                System.out.println(hotelMgr.getRoom(roomId).toString());
                                System.out.println("\t--This is the end of Update Room Form--");
                                return;
                            case 4:
                                hotelMgr.updateRoomStatus(roomId, RoomStatus.Vacant);
                                System.out.println(hotelMgr.getRoom(roomId).toString());
                                System.out.println("\t--This is the end of Update Room Form--");
                                return;
                            default:
                                System.out.println("Please enter a value from 1 to 4.");
                                break;
                        }
                    } while (choice != 4);
                    return;
                case 2:
                    System.out.println("Please enter the cost of the room service");
                    double amt = sc.nextDouble();
                    hotelMgr.addRoomService(roomId, amt);
                    return;
                default:
                    System.out.println("Please enter a value from 1 to 4.");
                    break;
            }
        } while (choice != 4);
    }

    public static void printRemoveRoomMenu() {
        int choice = 0;
        String roomId;
        System.out.println("\t--This is the Remove Room Form--");
        System.out.print("Please input the room ID: ");
        roomId = sc.next();

        System.out.println("Checking if the room exist in the system");
        if (hotelMgr.checkExistingRoom(roomId)) {
            System.out.println("There is such room exist in the system.");
            System.out.println(hotelMgr.getRoom(roomId).toString());
        } else {
            System.out.println("There is no such room  exist in the system.");
            System.out.println("Returning to Room Management Menu...");
            return;
        }

        if (!hotelMgr.removeRoom(roomId)) {
            System.out.println("Failed to remove Room " + roomId);
            System.out.println("Please try again.");
            System.out.print("Returning to Room Management Menu...");
        } else {
            System.out.println("Success in removing Room " + roomId);
            System.out.println("|t--This is the end of Room Removeal Form--");
            System.out.print("Returning to Room Management Menu...");
        }

    }

    public static void printGuestMenu() {
        int CURGuestchoice;
        do {
            System.out.println("\t--This is the Guest Management Menu--");
            System.out.println("Please select one of the following choices: \n"
                    + "1. Create Guest\n"
                    + "2. Update Guest\n"
                    + "3. Remove Guest\n"
                    + "4. Back to menu\n");
            CURGuestchoice = sc.nextInt();

            switch (CURGuestchoice) {
                //Create Guest
                case 1:
                    printCreateGuestMenu();
                    break;
                //Update Guest
                case 2:
                    printUpdateGuestMenu();
                    break;
                //Remove Guest
                case 3:
                    printRemoveGuestMenu();
                    break;
                case 4:
                    System.out.println("\t--This is the end of Guest Management Menu--");
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Please enter a value from 1 to 4.");
                    break;
            }
        } while (CURGuestchoice != 4);
    }

    public static void printCreateGuestMenu() {
        System.out.println("\t--This is the Guest Creation Form--");

        String guestId;
        System.out.print("Please input the guest ID: ");
        guestId = sc.next();

        System.out.println("Checking if the guest exist in the system");
        if (hotelMgr.checkExistingGuest(guestId)) {
            System.out.println("There is already such guest exist in the system.");
            System.out.println(hotelMgr.getGuest(guestId).toString());
            System.out.println("Returning to Guest Management Menu...");
            return;
        } else {
            System.out.println("There is no such guest exist in the system. Please continue with registration");
        }

        System.out.print("Please input the First Name: ");
        String FirstName = sc.next();
        System.out.print("Please input the Last Name: ");
        String lastName = sc.next();
        System.out.print("Please input the title: ");
        String title = sc.next();
        System.out.print("Please input the address: ");
        String address = sc.next();
        System.out.print("Please input the country: ");
        String country = sc.next();
        System.out.print("Please input the gender: ");
        char gender = sc.next().charAt(0);
        System.out.print("Please input the contact number: ");
        int contactNo = sc.nextInt();
        System.out.print("Please input the email: ");
        String email = sc.next();
        hotelMgr.createGuest(guestId, FirstName, lastName, title, address, country, gender, contactNo, email);
        System.out.print("Is there any associate guest? Yes = y No = n ");
        boolean assoguestchoice = false;
        String output = sc.next();
        if (output.equalsIgnoreCase("y")) {
            assoguestchoice = true;
        }
        while (assoguestchoice) {
            System.out.println("Please input the associate guest Id");
            String AssoguestId = sc.next();
            hotelMgr.getGuest(guestId).setAssoGuest(hotelMgr.getGuest(AssoguestId));
            System.out.print("Is there any more associate guest? Yes = y No = n ");
            assoguestchoice = false;
            if (sc.next().equals("y")) {
                assoguestchoice = true;
            }
        }

        System.out.println("\t--This is the end of Guest Creation Form--");
        System.out.println("Returning to Guest Management Menu...");
    }

    public static void printUpdateGuestMenu() {
        System.out.println("\t--This is the Guest Update Form--");

        String guestId;
        System.out.print("Please input the guest ID: ");
        guestId = sc.next();

        System.out.println("Checking if the guest exist in the system");
        if (hotelMgr.checkExistingGuest(guestId)) {
            System.out.println("There is already such guest exist in the system.");
            System.out.println(hotelMgr.getGuest(guestId).toString());
            System.out.println("Returning to Guest Management Menu...");
            return;
        } else {
            System.out.println("There is no such guest exist in the system. Please continue with update");
        }

        int UpdateGuestchoice;
        do {
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
            UpdateGuestchoice = sc.nextInt();

            switch (UpdateGuestchoice) {
                case 1:
                    System.out.print("Please input the guest ID: ");
                    guestId = sc.next();
                    hotelMgr.getGuest(guestId).setGuestId(guestId);
                    break;
                case 2:
                    System.out.print("Please input the First Name: ");
                    hotelMgr.getGuest(guestId).setFirstName(sc.next());
                    break;
                case 3:
                    System.out.print("Please input the Last Name: ");

                    hotelMgr.getGuest(guestId).setLastName(sc.next());
                    break;
                case 4:
                    System.out.print("Please input the title: ");
                    hotelMgr.getGuest(guestId).setTitle(sc.next());
                    break;
                case 5:
                    System.out.print("Please input the address: ");
                    hotelMgr.getGuest(guestId).setAddress(sc.next());
                    break;
                case 6:
                    System.out.print("Please input the country: ");
                    hotelMgr.getGuest(guestId).setCountry(sc.next());
                    break;
                case 7:
                    System.out.print("Please input the gender: ");
                    hotelMgr.getGuest(guestId).setGender(sc.next().charAt(0));
                    break;
                case 8:
                    System.out.print("Please input the contact number: ");
                    hotelMgr.getGuest(guestId).setContactNo(sc.nextInt());
                    break;
                case 9:
                    System.out.print("Please input the email: ");
                    hotelMgr.getGuest(guestId).setEmail(sc.next());
                    break;
                case 10:
                    System.out.println("This is the end of Guest Update Form");
                    System.out.print("Returning to Guest Management Menu...");
                    return;
                default:
                    break;
            }

        } while (UpdateGuestchoice != 10);
    }

    public static void printRemoveGuestMenu() {
        System.out.println("\t--This is the Guest Removal Form--");

        String guestId;
        System.out.print("Please input the guest ID: ");
        guestId = sc.next();

        System.out.println("Checking if the guest exist in the system");
        if (hotelMgr.checkExistingGuest(guestId)) {
            System.out.println("There is already such guest exist in the system.");
            System.out.println(hotelMgr.getGuest(guestId).toString());
            System.out.println("Returning to Guest Management Menu...");
            return;
        } else {
            System.out.println("There is no such guest exist in the system. Please continue with removal.");
        }

        if (!hotelMgr.removeGuest(guestId)) {
            System.out.println("Failed to remove Guest " + guestId);
            System.out.println("Please try again.");
            System.out.print("Returning to Guest Management Menu...");
        } else {
            System.out.println("Success in removing Guest " + guestId);
            System.out.println("This is the end of Guest Removeal Form");
            System.out.print("Returning to Guest Management Menu...");
        }
    }

    public static void printRoomOccupancyReport() {
        hotelMgr.printRoomOccupancyReport();
    }

    //Arthur : Bryan
    public static void printReservationMenu() {
        // TODO - implement MainForm.printReservationMenu

        //Parameters
        int choice;



        do { //Print Reservation Menu
            System.out.println("Please select one of the following Reservation Service");
            System.out.println("1 : Create a new Reservation");
            System.out.println("2 : Update a Reservation");
            System.out.println("3 : Cancel a Reservation");
            System.out.println("4 : Return to Main Menu");
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

    }

    public static void printCreateReservationMenu() {
        //Date Format
        DateFormat dF = DateFormat.getDateInstance(DateFormat.SHORT);
        Calendar cal = Calendar.getInstance();
        //Get Checkin and Checkout dates
        System.out.println("Enter Check In date in the form of MM/DD/YYYY");
        Date checkInDate = null;
        try {
            checkInDate = dF.parse(sc.next());
        } catch (ParseException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Enter Check Out date in the form of MM/DD/YYYY");
        Date checkOutDate = null;
        try {
            checkOutDate = dF.parse(sc.next());
        } catch (ParseException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Display All available room types for time period
        int NumSingleRoom = hotelMgr.ReservationScheduleCheck(checkInDate, checkOutDate, RoomType.Single);
        int NumStandardRoom = hotelMgr.ReservationScheduleCheck(checkInDate, checkOutDate, RoomType.Standard);
        int NumSuiteRoom = hotelMgr.ReservationScheduleCheck(checkInDate, checkOutDate, RoomType.Suite);
        int NumVIPRoom = hotelMgr.ReservationScheduleCheck(checkInDate, checkOutDate, RoomType.VIP);

        System.out.println("Rooms Available for Time Period: " + checkInDate.toString() + " to " + checkOutDate.toString());
        System.out.println("Single Rooms : " + NumSingleRoom);
        System.out.println("Standard Rooms: " + NumStandardRoom);
        System.out.println("Suite Rooms: " + NumSuiteRoom);
        System.out.println("VIP Rooms: " + NumVIPRoom);
        System.out.println();
        //Get Room Type
        System.out.println("Please Select the type of room");
        System.out.println("1. Single");
        System.out.println("2. Standard");
        System.out.println("3. Suite");
        System.out.println("4. VIP");
        int select = sc.nextInt();
        RoomType RmType = null;

        //Get Number of Rooms
        System.out.println("Enter Number of Rooms");
        int NumRooms = sc.nextInt();


        //Check NumRooms requested with available rooms for booking
        boolean assignRooms = false;
        ReservationStatus resStatus = ReservationStatus.Inquiry;
        switch (select) {
            case 1:
                RmType = RoomType.Single;
                //Number of rooms required more than rooms available
                if (NumRooms >= NumSingleRoom) {
                    System.out.println("Putting Reservation Status on Waitlist");
                    resStatus = ReservationStatus.In_Waitlist;
                } else {
                    resStatus = ReservationStatus.Confirmed;
                    assignRooms = true;
                }
                break;

            case 2:
                RmType = RoomType.Standard;
                //Number of rooms required more than rooms available
                if (NumRooms >= NumStandardRoom) {
                    System.out.println("Putting Reservation Status on Waitlist");
                    resStatus = ReservationStatus.In_Waitlist;
                } else {
                    resStatus = ReservationStatus.Confirmed;
                    assignRooms = true;
                }
                break;
            case 3:
                RmType = RoomType.Suite;
                //Number of rooms required more than rooms available
                if (NumRooms >= NumSuiteRoom) {
                    System.out.println("Putting Reservation Status on Waitlist");
                    resStatus = ReservationStatus.In_Waitlist;
                } else {
                    resStatus = ReservationStatus.Confirmed;
                    assignRooms = true;
                }
                break;

            case 4:
                RmType = RoomType.VIP;
                //Number of rooms required more than rooms available
                if (NumRooms >= NumVIPRoom) {
                    System.out.println("Putting Reservation Status on Waitlist");
                    resStatus = ReservationStatus.In_Waitlist;
                } else {
                    resStatus = ReservationStatus.Confirmed;
                    assignRooms = true;
                }
                break;
        }

        //Enter Guest
        //Need to make sure guest exists first
        System.out.println("Enter GuestId of guest making reservation");
        String guestId = sc.next();
        System.out.println("Enter Number of Adults");
        int adults = sc.nextInt();
        System.out.println("Enter Number of Children");
        int children = sc.nextInt();
        //auto generation reservation method
        String resId = hotelMgr.generateResId();
        //Create Reservation 
        //  associatedGuest, resId, resBookDate, resCheckInDate ,
        //resCheckOutDate, resStatus, noOfAdults, noOfChildren, paymentStatus,roomType);
        hotelMgr.createReservation(guestId, resId, cal.getTime(), checkInDate, checkOutDate, resStatus, adults, children, false, RmType);

        if (assignRooms == true) {
            //Add each rooms to reservation
            for (int i = 0; i < NumRooms; i++) {
                //add associated rooms
                String rmId = hotelMgr.firstAvailRoom(RmType);
                hotelMgr.getReservation(resId).AddAssociatedRoom(rmId);
                //Set room status to reserved, 2 = reserved
                hotelMgr.updateRoomStatus(rmId, RoomStatus.Reserved);
            }
        }

    }

    public static void printUpdateReservationMenu() {
        String resId = "0";
        int choice = 0;

        try {
            do {
                System.out.print("Enter the reservation Id :");
                resId = sc.next();

                if (hotelMgr.checkExisitingReservation(resId)) {
                    break;
                } else {
                    System.out.println("There is not such reservation. Please enter a valid id or -1 to return to Reservation Menu");
                }
            } while (!resId.isEmpty());

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
        String resId = " ";
        int choice = 0;

        try {
            do {
                System.out.print("Enter the reservation Id :");
                resId = sc.next();
                if (hotelMgr.checkExisitingReservation(resId)) {
                    break;
                } else {
                    System.out.println("There is not such reservation. Please enter a valid id or -1 to return to Reservation Menu");
                }
            } while (!resId.isEmpty());

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
        String resId = "0";
        try {
            do {
                System.out.print("Enter the reservation Id :");
                resId = sc.next();

                if (hotelMgr.checkExisitingReservation(resId)) {
                    System.out.println("Printing Reservation Details");
                    System.out.println(hotelMgr.displayReservationDetails(resId));
                    break;
                } else {
                    System.out.println("There is not such reservation. Please enter a valid id or -1 to return to Reservation Menu");
                }
            } while (!resId.isEmpty());


        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void printCheckRoomAvailablity() {

        System.out.println("Enter Room Id");
        String rmId = sc.next();
        System.out.println("RoomId " + rmId + "is " + hotelMgr.checkRoomAvailability(rmId));

    }
}
