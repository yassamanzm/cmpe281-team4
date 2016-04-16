package org.cmpe281.cloud.usermanagement.serviceinterface;

import org.cmpe281.cloud.dto.UserDTO;
import org.cmpe281.cloud.dto.UserProfileDTO;
import org.cmpe281.cloud.manage.exceptions.DuplicateUserException;
import org.cmpe281.cloud.pojo.User;

/** 
 * @author Vaishampayan Reddy
 *
 */
public interface IUserManager {
	public UserDTO createUser(User user) throws DuplicateUserException;
	public void deleteUser(User user);
	public void updateUser(User user);
	public UserProfileDTO getUserProfile(User user);
}
