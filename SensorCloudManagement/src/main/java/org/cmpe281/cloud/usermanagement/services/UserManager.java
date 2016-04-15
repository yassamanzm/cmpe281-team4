package org.cmpe281.cloud.usermanagement.services;

import org.cmpe281.cloud.dto.UserDTO;
import org.cmpe281.cloud.dto.UserProfileDTO;
import org.cmpe281.cloud.usermanagement.serviceinterface.IUserManager;
import org.json.JSONObject;

/**
 * @author Vaishampayan Reddy
 *
 */
public class UserManager implements IUserManager {

	public UserDTO createUser(String user) {
		JSONObject userObject = new JSONObject(user);
		
		return null;
	}

	public void deleteUser(String userid) {
	}

	public void updateUser(String user) {
	}

	public UserProfileDTO getUserProfile(String userid) {
		return null;
	}
}
