package org.cmpe281.cloud.routes;

import org.cmpe281.cloud.dto.UserDTO;
import org.cmpe281.cloud.manage.exceptions.DuplicateUserException;
import org.cmpe281.cloud.pojo.User;
import org.cmpe281.cloud.usermanagement.serviceinterface.IUserManager;
import org.cmpe281.cloud.usermanagement.services.UserManager;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vaishampayan Reddy
 *
 */

@RestController
@RequestMapping("/api/users")
public class UserManagementHandler {

	IUserManager userManager = new UserManager();

	@RequestMapping(value="/api/register",method = RequestMethod.POST)
	public String createNewUser(@RequestBody User user) {
		try {
			UserDTO userDTO = userManager.createUser(user);
			JSONObject responseObject = new JSONObject();
			responseObject.put("status", 200);
			responseObject.put("id", userDTO.get_id());
			return responseObject.toString();
		} catch (DuplicateUserException e) {
			JSONObject responseObject = new JSONObject();
			responseObject.put("status", 403);
			responseObject.put("message", e.getMessage());
			return responseObject.toString();
		}
	}
}
