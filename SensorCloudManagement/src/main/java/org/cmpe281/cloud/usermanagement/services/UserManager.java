package org.cmpe281.cloud.usermanagement.services;

import java.net.UnknownHostException;

import org.cmpe281.cloud.dbhandler.DBHandler;
import org.cmpe281.cloud.dbhandler.IDBHandler;
import org.cmpe281.cloud.dto.UserDTO;
import org.cmpe281.cloud.dto.UserProfileDTO;
import org.cmpe281.cloud.manage.exceptions.DuplicateUserException;
import org.cmpe281.cloud.pojo.User;
import org.cmpe281.cloud.usermanagement.serviceinterface.IUserManager;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * @author Vaishampayan Reddy
 *
 */
public class UserManager implements IUserManager {
	private IDBHandler dbHandler;
	private static final String mongoDbUrl = "mongodb://admin:admin@ds023530.mlab.com:23530/cmpe281project";
	private static final String database = "SensorData";

	private Gson gsonHelper = new Gson();

	public UserManager() {
		try {
			dbHandler = new DBHandler(mongoDbUrl, database);
		}
		catch(UnknownHostException e) {
			//
		}
	}

	public UserDTO createUser(User user) throws DuplicateUserException {
		BasicDBObject userObject = new BasicDBObject();
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.append("email", user.getEmail());
		if(dbHandler.doesExistInDb("Users", searchQuery)) {
			//Insert into User Collection
			userObject.append("email", user.getEmail());
			userObject.append("password", user.getPassword());
			dbHandler.addToCollection("Users", userObject);
			DBObject userData = dbHandler.getDocumentFromCollection("Users", searchQuery);

			//Insert into UserProfile Collection
			BasicDBObject userProfileObject = new BasicDBObject();
			userProfileObject.append("first_name", user.getFirst_name());
			userProfileObject.append("last_name", user.getLast_name());
			userProfileObject.append("userid", userData.get("_id"));
			dbHandler.addToCollection("Users", userObject);
			UserDTO userDTO = gsonHelper.fromJson(userData.toString(), UserDTO.class);
			return userDTO;
		}
		else {
			throw new DuplicateUserException(user.getEmail());
		}
	}

	public void deleteUser(User user) {
	}

	public void updateUser(User user) {
	}

	public UserProfileDTO getUserProfile(User user) {
		return null;
	}
}
