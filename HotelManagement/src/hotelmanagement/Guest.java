public class Guest {

	Room room;
	private string guestId;
	private string FirstName;
	private String lastName;
	private TitleType title;
	private string address;
	private string country;
	private char gender;
	private int contactNo;
	private string email;

	public string getGuestId() {
		return this.guestId;
	}

	/**
	 * 
	 * @param guestId
	 */
	public void setGuestId(string guestId) {
		this.guestId = guestId;
	}

	public string getFirstName() {
		// TODO - implement Guest.getFirstName
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 */
	public void setFirstName(int name) {
		// TODO - implement Guest.setFirstName
		throw new UnsupportedOperationException();
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

	public TitleType getTitle() {
		return this.title;
	}

	/**
	 * 
	 * @param title
	 */
	public void setTitle(TitleType title) {
		this.title = title;
	}

	public string getAddress() {
		return this.address;
	}

	/**
	 * 
	 * @param address
	 */
	public void setAddress(string address) {
		this.address = address;
	}

	public string getCountry() {
		return this.country;
	}

	/**
	 * 
	 * @param country
	 */
	public void setCountry(string country) {
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

	public string getEmail() {
		return this.email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(string email) {
		this.email = email;
	}

	/**
	 * 
	 * @param assoGuest
	 */
	public void setAssoGuest(ArrayList<Guest> assoGuest) {
		// TODO - implement Guest.setAssoGuest
		throw new UnsupportedOperationException();
	}

	public ArrayList<Guest> getAssoGuest() {
		// TODO - implement Guest.getAssoGuest
		throw new UnsupportedOperationException();
	}

}