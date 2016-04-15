package org.cmpe281.cloud.usermanagement.serviceinterface;

import org.cmpe281.cloud.dto.UserDTO;
import org.cmpe281.cloud.dto.UserProfileDTO;

/** 
 * @author Vaishampayan Reddy
 *
 */
public interface IUserManager {
	public UserDTO createUser(String user);
	public void deleteUser(String userid);
	public void updateUser(String user);
	public UserProfileDTO getUserProfile(String userid);
}
