package HRPS.entity;

public class RoomFeature {

	private int rmFeatureId;
	private String name;
	private String description;

	public int getRmFeatureId() {
		return this.rmFeatureId;
	}

	/**
	 * 
	 * @param rmFeatureId
	 */
	public void setRmFeatureId(int rmFeatureId) {
		this.rmFeatureId = rmFeatureId;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}