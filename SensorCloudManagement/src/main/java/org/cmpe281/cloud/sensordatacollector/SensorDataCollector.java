package org.cmpe281.cloud.sensordatacollector;

import java.io.IOException;
import java.util.Iterator;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.cmpe281.cloud.dbhandler.SensorDBOperations;
import org.json.JSONArray;
import org.json.JSONObject;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

/**
 * @author Savani
 * service for updating sensor data in mongodb
 * 
 */
@Path("update")
public class SensorDataCollector {
	@PUT

	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response setData(String input) throws JsonParseException, JsonMappingException, IOException
	{
		SensorDBOperations sdo = new SensorDBOperations();
		System.out.println("Inside server");
		ObjectMapper objMap = new ObjectMapper();
		objMap.setVisibility(PropertyAccessor.ALL, Visibility.ANY);
	//	String timeStamp = "{ Time: "+String.valueOf(System.currentTimeMillis())+"}";
		//String db_input  = JSON.stringify(JSON.parse(input)+JSON.parse(timeStamp));
		JSONObject newObject = new JSONObject(input) ;
		//check this code based on the call of the client code..  ?????
		JSONArray barometerReadings = (JSONArray)newObject.getJSONObject("table").
				getJSONArray("rows");
		sdo.updateDB(barometerReadings);
		return Response.ok().build();

	}
	@GET 
	@Produces("text/plain")
	public String getData(){
		return "Hello World";
	}
}