/**
 * 
 */
package org.cmpe281.cloud.virtualsensorcontroller.dbhandler;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.cmpe281.cloud.enums.SensorState;
import org.cmpe281.cloud.model.VirtualSensor;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/**
 * @author Yassaman
 *
 */
@Component
public class VirtualSensorDBOperations {

	MongoClient dbClient;
	DB database;
	DBCollection table;
	public VirtualSensorDBOperations() {
		super();
		try {
			this.dbClient = new MongoClient
					("mongodb://admin:admin@ds023530.mlab.com:23530");
			this.database = dbClient.getDB("cmpe281project");
			this.table = database.getCollection("VirtualSensor");
			
			System.out.println("*** VirtualSensorDBOperations ***");	

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	//insert JSON object format in the database
	public void storeInDB(JSONObject virtualsensorData){

		System.out.println("*** VirtualSensorDBOperations ***");
		
		BasicDBObject document = new BasicDBObject();
		Date timeCreated= new Date(); // timecreated and timeupdated are the same at this point

		// a unique id is generated
		document.put("sensorid", virtualsensorData.get("sensorid"));
		document.put("userid", virtualsensorData.get("sensorid"));
		document.put("latitude", virtualsensorData.get("latitude"));
		document.put("longitude", virtualsensorData.get("longitude"));
		document.put("timecreated",timeCreated.toString() );
		document.put("timeupdated",timeCreated.toString() );
		document.put("state",SensorState.RUNNING.toString() );

		table.insert( document);

	}


	public List<VirtualSensor> getVirtualSensorListByUserId(String sensorId, String userId) {

		try{
			Gson gson = new Gson();
			List<VirtualSensor> virtualSensorList= new ArrayList<VirtualSensor>();

			BasicDBObject query = new BasicDBObject();
			query.put("userid", userId);
			query.put("sensorid", sensorId);

			DBCursor dbCursor= table.find(query);

			while (dbCursor.hasNext()) { 
				DBObject obj = dbCursor.next(); 
				VirtualSensor vs = gson.fromJson(obj.toString(), VirtualSensor.class);  
				virtualSensorList.add(vs); 
			}

			return virtualSensorList;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());	
			return null;
		}

		finally{
			dbClient.close();	
		}
	}

}
