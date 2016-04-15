package org.cmpe281.cloud.manage.exceptions;

public class DuplicateUserException extends Exception{

	private static final long serialVersionUID = -17353453731783942L;
	private String userEmail;
	public DuplicateUserException(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String getMessage() {
		return "Exception: Email already registered with: " + userEmail;
	}
}
