package org.cmpe281.cloud.sensordatacollector;

import java.net.UnknownHostException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;
/**
 * @author Savani
 * service for fetching sensor data based on different parameters
 * 
 */
@Path ("fetch")
public class SensorDataFetch {
	@GET
	@Produces(MediaType.APPLICATION_JSON)

	public Response fetchData(){
		ObjectMapper objMap = new ObjectMapper();
		objMap.setVisibility(PropertyAccessor.ALL, Visibility.ANY);
		MongoClient db_cl = null;
		try {
			db_cl = new MongoClient("mongodb://admin:admin@ds023530.mlab.com:23530/cmpe281project");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB db = db_cl.getDB("database_name");
		DBCollection tab = db.getCollection("Sensor_Data");
		BasicDBObject nQuery = new BasicDBObject();
		//add in db
		JSON json = new JSON();
		String json_op = json.serialize("kl");
		return Response.ok(json_op, MediaType.APPLICATION_JSON).build(); 
	}


}
