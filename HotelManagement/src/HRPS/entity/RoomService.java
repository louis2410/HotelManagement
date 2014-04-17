package HRPS.entity;


import java.util.Date;

public class RoomService {

	private java.util.Date rmdateTime;
	private double rmServicePrice;

        public RoomService(Date inputdate, double rmServicePrice){
            
            this.rmdateTime = inputdate;
            this.rmServicePrice = rmServicePrice;
            
        }    
       
	public java.util.Date getRmDateTime() {
		// TODO - implement RoomService.getRmDateTime
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param dateTime
	 */
	public void setRmDateTime(java.util.Date dateTime) {
		// TODO - implement RoomService.setRmDateTime
		throw new UnsupportedOperationException();
	}

	public double getRmServicePrice() {
		return this.rmServicePrice;
	}

	/**
	 * 
	 * @param rmServicePrice
	 */
	public void setRmServicePrice(double rmServicePrice) {
		this.rmServicePrice = rmServicePrice;
	}

}