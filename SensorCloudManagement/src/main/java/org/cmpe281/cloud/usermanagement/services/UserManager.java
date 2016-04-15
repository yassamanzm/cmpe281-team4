package org.cmpe281.cloud.usermanagement.services;

import java.net.UnknownHostException;

import org.cmpe281.cloud.dbhandler.DBHandler;
import org.cmpe281.cloud.dbhandler.IDBHandler;
import org.cmpe281.cloud.dto.UserDTO;
import org.cmpe281.cloud.dto.UserProfileDTO;
import org.cmpe281.cloud.manage.exceptions.DuplicateUserException;
import org.cmpe281.cloud.usermanagement.serviceinterface.IUserManager;
import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * @author Vaishampayan Reddy
 *
 */
public class UserManager implements IUserManager {
	private IDBHandler dbHandler;
	private static final String mongoDbUrl = "mongodb://admin:admin@ds023530.mlab.com:23530/cmpe281project";
	private static final String database = "SensorData";

	public UserManager() throws UnknownHostException {
		dbHandler = new DBHandler(mongoDbUrl, database);
	}

	public UserDTO createUser(String user) throws JSONException, DuplicateUserException {
		JSONObject userJson = new JSONObject(user);
		BasicDBObject userObject = new BasicDBObject();
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.append("email", userJson.get("email"));
		if(dbHandler.doesExistInDb("Users", searchQuery)) {
			//Insert into User Collection
			userObject.append("email", userJson.get("email"));
			userObject.append("password", userJson.get("password"));
			dbHandler.addToCollection("Users", userObject);
			DBObject userData = dbHandler.getDocumentFromCollection("Users", searchQuery);

			//Insert into UserProfile Collection
			BasicDBObject userProfileObject = new BasicDBObject();
			userProfileObject.append("first_name", userJson.get("first_name"));
			userProfileObject.append("last_name", userJson.get("last_name"));
			userProfileObject.append("userid", userData.get("_id"));
			dbHandler.addToCollection("Users", userObject);
			//return userData.toString();
			return null;
		}
		else {
			throw new DuplicateUserException(userJson.getString("email"));
		}
	}

	public void deleteUser(String userid) {
	}

	public void updateUser(String user) {
	}

	public UserProfileDTO getUserProfile(String userid) {
		return null;
	}
}
