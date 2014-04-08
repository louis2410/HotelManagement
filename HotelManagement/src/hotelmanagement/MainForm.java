import java.util.ArrayList;
import java.util.Scanner;
public class MainForm {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		GuestMgr guestmgr = new GuestMgr();
		//Main interface
		System.out.println("Please select one of the following choices: \n"+
		"1. Create/Update/Remove rooms details \n"+
		"2. Create/Update/Removeguestsdetail\n"+
		"3. Create/Update/Removereservation\n"+
		"4. Print reservation receipt\n"+
		"5. Check availability of a room\n"+
		"6. Check-in\n"+
		"7. Check-out and print billinvoice\n"+
		"8. Print Room Occupancyreport\n"+
		"9. Quit the system\n");
		int mainchoice = in.nextInt();
		while(mainchoice!=9){
			mainchoice = in.nextInt();
			switch(mainchoice){
				//case 1:
				case 2: 
					printGuestMenu(guestmgr);
			}
		}
		throw new UnsupportedOperationException();
	}

	public void printMainMenu() {
		// TODO - implement MainForm.printMainMenu
		throw new UnsupportedOperationException();
	}

	public void printRoomMenu() {
		// TODO - implement MainForm.printRoomMenu
		throw new UnsupportedOperationException();
	}

	public static void printGuestMenu(GuestMgr guestmgr) {
		Scanner in = new Scanner(System.in);
		String guestId;
		System.out.println("Please select one of the following choices: \n"+
			"1. Create Guest\n"+
			"2. Update Guest\n"+
			"3. Remove Guest\n"+
			"4. Back to menu\n");
		int CURGuestchoice = in.nextInt();
		while(CURGuestchoice!=4){
			switch(CURGuestchoice){
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
			        guestmgr.createGuest(guestId,FirstName,lastName,title,address,country,gender,contactNo,email);
			        	System.out.print("Is there any associate guest? Yes = y No = n ");
			        	boolean assoguestchoice = in.next().charAt(0)=='y';
				        while(assoguestchoice){
				        	System.out.println("Please input the associate guest Id");
			        		String AssoguestId = in.next();
			        		guestmgr.getGuest(guestId).setAssoGuest(guestmgr.getGuest(AssoguestId));
			        		System.out.print("Is there any associate guest? Yes = y No = n ");
				        	assoguestchoice = in.next().charAt(0)=='y';
			        }
				    break;
				//Update Guest
				case 2:
					System.out.println("Please input the guest ID you want to Update");
					guestId = in.next();
					System.out.println("Please select one of the following choices: \n"+
							"1. Update guest ID\n"+
							"2. Update First Name\n"+
							"3. Update Last Name\n"+
							"4. Update title\n"+
							"5. Update address\n"+
							"6. Update country\n"+
							"7. Update gender\n"+
							"8. Update contact number\n"+
							"9. Update email\n"+
							"10. Back to last menu");
					int UpdateGuestchoice = in.nextInt();
					while(CURGuestchoice!=10){
						switch(UpdateGuestchoice){
							case 1:
								System.out.print("Please input the guest ID: ");
								guestId = in.next();
								guestmgr.getGuest(guestId).setGuestId(guestId);
								break;
							case 2:
								System.out.print("Please input the First Name: ");
								FirstName = in.next();
								guestmgr.getGuest(guestId).setFirstName(FirstName);
								break;
							case 3:
								System.out.print("Please input the Last Name: ");
								lastName = in.next();
								guestmgr.getGuest(guestId).setLastName(lastName);
								break;
							case 4:
								System.out.print("Please input the title: ");
					        	title = in.next();
					        	guestmgr.getGuest(guestId).setTitle(title);
					        	break;
							case 5:
								System.out.print("Please input the address: ");
					        	address = in.next();
					        	guestmgr.getGuest(guestId).setAddress(address);
					        	break;
							case 6:
								System.out.print("Please input the country: ");
					        	country = in.next();
					        	guestmgr.getGuest(guestId).setCountry(country);
					        	break;
							case 7:
								System.out.print("Please input the gender: ");
					        	gender = in.next().charAt(0);
					        	guestmgr.getGuest(guestId).setGender(gender);
					        	break;
							case 8:
								System.out.print("Please input the contact number: ");
					        	contactNo = in.nextInt();
					        	guestmgr.getGuest(guestId).setContactNo(contactNo);
					        	break;
							case 9:
								System.out.print("Please input the email: ");
					        	email = in.next();
					        	guestmgr.getGuest(guestId).setEmail(email);
					        	break;
					        default:
					        	break;
						}
					}
					break;
				//Remove Guest
				case 3:
					System.out.println("Please input the guest ID you want to Update");
					guestId = in.next();
					guestmgr.removeGuest(guestId);
					break;
			}
		}
		throw new UnsupportedOperationException();
	}

	public void printReservationMenu() {
		// TODO - implement MainForm.printReservationMenu
		throw new UnsupportedOperationException();
	}

}