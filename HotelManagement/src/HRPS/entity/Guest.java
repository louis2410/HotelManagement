package HRPS.entity;

import java.util.ArrayList;

public class Guest {

    //Room room;
    private String guestId;
    private String FirstName;
    private String lastName;
    private String title;
    private String address;
    private String country;
    private char gender;
    private int contactNo;
    private String email;
    private ArrayList<Guest> AssoGuest;
    private BillingInformation billInfo;

    public Guest() {
    }

    public Guest(String guestId, String FirstName, String lastName,
            String title, String address, String country, char gender, int contactNo, String email) {
        this.FirstName = FirstName;
        this.address = address;
        this.contactNo = contactNo;
        this.country = country;
        this.email = email;
        this.gender = gender;
        this.guestId = guestId;
        this.lastName = lastName;
        this.title = title;
        this.AssoGuest = new ArrayList();
        this.billInfo = new BillingInformation();
    }

    public String getGuestId() {
        return this.guestId;
    }

    /**
     *
     * @param guestId
     */
    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public String getFirstName() {
        // TODO - implement Guest.getFirstName
        return this.FirstName;
    }

    /**
     *
     * @param name
     */
    public void setFirstName(String name) {
        // TODO - implement Guest.setFirstName
        this.FirstName = name;
    }

    public String getLastName() {
        return this.lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return this.title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return this.address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return this.country;
    }

    /**
     *
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    public char getGender() {
        return this.gender;
    }

    /**
     *
     * @param gender
     */
    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getContactNo() {
        return this.contactNo;
    }

    /**
     *
     * @param contactNo
     */
    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return this.email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @param assoGuest
     */
    public void setAssoGuest(Guest AssoGuest) {
        this.AssoGuest.add(AssoGuest);
    }

    public ArrayList<Guest> getAssoGuest() {
        return AssoGuest;

    }
    
    public String toString(){
        String display ="";
        display +="Guest Details of " + this.guestId + "\n";
        display +="-------------------------------------------------\n";
        display +="Name \t : " + this.title + " " + this.lastName + " " + this.FirstName + " \n";
        display +="Gender \t : " + this.gender + "\n";
        display +="Address \t : " + this.address + "\n";
        display +="Country \t : " + this.country + "\n" ;
        display +="Email \t : " + this.email + "\n" ;
        display +="Contact No \t : " + this.contactNo + "\n";
        
        return display;
    }

    public BillingInformation getBillInfo() {
        return this.billInfo;
    }

    public void setBillInfo(BillingInformation billInfo) {
        this.billInfo = billInfo;
    }
}
