package org.cmpe281.cloud.model;

/**
 * @author Yassaman
 *
 */

public class Location {
	
	private String latitude;
	private String longitude;
	
	public Location(String latitude, String longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "Location [latitude=" + latitude + ", longitude=" + longitude + "]";
	}	
}
