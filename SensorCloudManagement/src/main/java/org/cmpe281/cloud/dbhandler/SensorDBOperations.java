package org.cmpe281.cloud.dbhandler;

import java.net.UnknownHostException;

import org.json.JSONArray;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

/**
 * @author Savani
 * class for handling database operations..
 * 
 */
public class SensorDBOperations {
	MongoClient dbClient;
	DB database;
	DBCollection table;
	public SensorDBOperations() {
		super();
		try {
			this.dbClient = new MongoClient
					("mongodb://admin:admin@ds023530.mlab.com:23530/cmpe281project");
			//this.database = dbClient.getDB("BarometerData");
			this.table = database.getCollection("SensorData");
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	//insert array in JSON format in the database
	public void updateDB(JSONArray barometerReadings){
		for(int i = 0; i<barometerReadings.length(); i++){
			//System.out.println(barometerReadings.get(i).toString() + "Array");
			table.insert( (DBObject) JSON.parse((String) barometerReadings.get(i).toString()));
		}	
	}
	
	
	public void search(String latitude, String longitude){
		BasicDBObject bdo = new BasicDBObject();
		bdo.put("latitude", latitude);
		bdo.put("longitude", longitude);
	//	bdo.put
	}
	
	
	public void closeConnection(){
		dbClient.close();
	}
	
	
	

}
