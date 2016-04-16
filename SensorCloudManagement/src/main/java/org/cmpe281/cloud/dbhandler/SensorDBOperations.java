package org.cmpe281.cloud.dbhandler;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONString;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
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


	public JSONArray search(String latitude, String longitude){
		BasicDBObject bdo = new BasicDBObject();
		ArrayList<JSONString> json_op = new ArrayList<>();
		JSONArray sensorReadings  = new JSONArray();
		bdo.put("latitude", latitude);
		bdo.put("longitude", longitude);
		//	bdo.put
		BasicDBObject searchQuery = new BasicDBObject();
		//searchQuery.put("name", "mkyong");

		BasicDBObject nQuery = new BasicDBObject();
		List<BasicDBObject> ls_srch = new ArrayList<BasicDBObject>();
		ls_srch.add(new BasicDBObject("latitude", latitude));
		ls_srch.add(new BasicDBObject("longitude", longitude));
		nQuery.put("$and", ls_srch);
		//	BasicDBObject fld = new BasicDBObject();
		//  fld.put("DataInput", 1);
		DBCursor cursor1 = table.find(nQuery);
		JSONArray json = new JSONArray();
	
		while(cursor1.hasNext()){
		
			sensorReadings.put(cursor1.next());
		}
		return sensorReadings;
	}

	

	public void closeConnection(){
		dbClient.close();
	}




}
