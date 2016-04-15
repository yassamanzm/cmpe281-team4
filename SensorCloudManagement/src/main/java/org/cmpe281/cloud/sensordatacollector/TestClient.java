package org.cmpe281.cloud.sensordatacollector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.jpa.criteria.expression.function.CurrentTimeFunction;
import org.json.JSONObject;
import org.json.JSONString;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.core.net.SyslogOutputStream;


public class TestClient {

	public static void main(String[] args) {
		 String str =  "{\"rows\":  [\"2016-04-07T20:49:00Z\", "
			 		+ "35.6655555555556, -121.284722222222, 0.0,"
			 		+ " \"urn:ioos:station:gov.noaa.nws:K87Q\", \"Barometric Pressure\","
			 		+ " \"hectopascal\", 1016.9], [\"2016-04-07T18:49:00Z\", "
			 		+ "35.6655555555556, -121.284722222222,"
			 		+ " 0.0, \"urn:ioos:station:gov.noaa.nws:K87Q\","
			 		+ " \"Barometric Pressure\", \"hectopascal\", 1017.3],"
			 		+ " [\"2016-04-07T17:49:00Z\", 35.6655555555556, "
			 		+ "-121.284722222222, 0.0, \"urn:ioos:station:gov.noaa.nws:K87Q\", "
			 		+ "\"Barometric Pressure\", \"hectopascal\", 1017.3], "
			 		+ "[\"2016-04-07T16:49:00Z\","
			 		+ " 35.6655555555556, -121.284722222222, 0.0, "
			 		+ "\"urn:ioos:station:gov.noaa.nws:K87Q\", "
			 		+ "\"Barometric Pressure\", \"hectopascal\", 1017.3]}";
		//	 BufferedInputStream bis = new BufferedInputStream("");
			String json1 = null;
			 try {
				 json1 = readFile("/Users/savani/Downloads/123.json",
						 StandardCharsets.UTF_8);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			 try {
//				    //System.out.println("conn + "+System.get);
//				 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//				 Date date = new Date();
//				 System.out.println("conn + "+date);
//				 	URL myURL = new URL("http://erddap.axiomdatascience.com/erddap/tabledap/"
//				    		+ "cencoos_sensor_service.json?time,latitude,longitude,station,unit,value,parameter&time>=2016-04-15T00:00:00Z&parameter=%22Barometric%20Pressure%22");
//				    URLConnection myURLConnection = myURL.openConnection();
//				    
//				  //  myURLConnection.connect();
//				    BufferedReader in = new BufferedReader(new InputStreamReader(
//				    		myURLConnection.getInputStream()));
//				    String input;
//				    StringBuilder responseStrBuilder = new StringBuilder();
//				   
//				    while ((input = in.readLine()) != null)
//				        responseStrBuilder.append(input);
//				   JSONObject str1 = new JSONObject(responseStrBuilder.toString()) ;
//				    
//				    System.out.println("string json +  "+str1);
//			 }
//				catch (Exception e) { 
//				    // new URL() failed
//				    // ...
//				} 
			// JSONString jstr = JSON.stringify(str);
			 
			// http://localhost:8080/SensorDataCollector/
				 
				 Client cl1 = ClientBuilder.newClient();
			WebTarget tar1 = cl1.target("http://localhost:8080/SensorCloudManagement/sensordata/update");
				// WebTarget tar1 = cl1.target("http://erddap.axiomdatascience.com/erddap/tabledap/cencoos_sensor_service."
				// 		+ "json?time,latitude");//,value=time>=&2016-04-13T00:00:00Z
				 System.out.println("In client 1 75");
				//String abc = JSON.serialize(obj_json);
				ObjectMapper objMap = new ObjectMapper();
				objMap.setVisibility(PropertyAccessor.ALL, Visibility.ANY);
				Response response = tar1.request().put(Entity.json(json1));
			//	String a= tar1.request().get().toString();
				System.out.println(response.toString() + "Response");
				
		}
		public static String readFile(String path, Charset encoding) 
				  throws IOException 
				{
				  byte[] encoded = Files.readAllBytes(Paths.get(path));
				  return new String(encoded, encoding);
				}

			
	

}
