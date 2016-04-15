package org.cmpe281.cloud.dto;

/**
 * 
 * @author Vaishampayan Reddy
 *
 *	This is a POJO class for User
 */
public class UserDTO {
	private String _id;
	private String email;
	private String password;

	public UserDTO(String email, String password) {
		this.email = email;
		this.password = password;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}
