package org.cmpe281.cloud.sensordatacollector;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.cmpe281.cloud.model.BarometerSensor;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * @author Savani
 * service for updating sensor data in mongodb reading from
 * 
 */
@Path("update")
public class SensorDataCollector {
	Gson gson = new Gson();
	@PUT

	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)

	public Response setData(String input) throws JsonParseException, JsonMappingException, IOException 
	{
		//SensorDBOperations sdo = new SensorDBOperations();
		//http://erddap.axiomdatascience.com/erddap/tabledap/cencoos_sensor_service.json?time,latitude,longitude,depth,station,parameter,unit,value&time>=2016-04-08T00:00:00Z&latitude=34.0997222222222&longitude=-118.703333333333	&parameter=%22Barometric%20Pressure%22

		JSONObject erdapJSON = null;
		try {
			String temp = null;
			URL erdapURL = new URL("http://erddap.axiomdatascience.com/erddap/tabledap/"
					+ "cencoos_sensor_service.json?time,latitude,longitude,depth,station,unit,value,parameter&time>=2016-04-15T00:00:00Z&parameter=%22Barometric%20Pressure%22");
			URLConnection erdapURLConnection = erdapURL.openConnection();

			//  myURLConnection.connect();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					erdapURLConnection.getInputStream()));
			// String input;
			StringBuilder responseStrBuilder = new StringBuilder();
			while ((temp = br.readLine()) != null)
				responseStrBuilder.append(temp);
			erdapJSON = new JSONObject(responseStrBuilder.toString()) ;
			//System.out.println("string json +  "+erdapJSON);
			
			

		}
		catch (Exception e) { 
			// new URL() failed
			// ...
		} 


		System.out.println("Inside server");
		ObjectMapper objMap = new ObjectMapper();
		objMap.setVisibility(PropertyAccessor.ALL, Visibility.ANY);
		//	String timeStamp = "{ Time: "+String.valueOf(System.currentTimeMillis())+"}";
		//String db_input  = JSON.stringify(JSON.parse(input)+JSON.parse(timeStamp));
	//	JSONObject newObject = new JSONObject(input) ;
		//check this code based on the call of the client code..  ?????
		JSONArray barometerReadings = (JSONArray)erdapJSON.getJSONObject("table").
				getJSONArray("rows");
		createJSONObject(barometerReadings);

		//sdo.updateDB(barometerReadings);
		return Response.ok().build();

	}
	@GET 
	@Produces("text/plain")
	public String getData(){
		return "Hello World";
	}

	public String createJSONObject(JSONArray barometerReadings){
		String temp = null;
		//String ret = "";
		String[] columns;
		ArrayList<BarometerSensor> readings = new ArrayList<BarometerSensor>();
		temp = barometerReadings.get(0).toString();
		System.out.println("...... "+temp );
		//return temp;
		for(int i = 0; i<barometerReadings.length(); i++){
			temp = barometerReadings.get(i).toString();
			System.out.println("...... "+temp );
			temp.replace("[", " ");
			temp.replace("]", " ");
			
			columns = temp.split(",");
			BarometerSensor bs = new BarometerSensor(columns[0],columns[1], 
					columns[2], columns[3],columns[4], columns[7], columns[5], columns[6]);
			readings.add(bs);
			
			//System.out.println(temp);
		}
		String json = gson.toJson(readings);
		System.out.println("Json "+json);
		
		return json;

	}

}