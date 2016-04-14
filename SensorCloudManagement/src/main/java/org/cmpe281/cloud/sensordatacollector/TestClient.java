package org.cmpe281.cloud.sensordatacollector;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONString;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


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
			 
			// JSONString jstr = JSON.stringify(str);
			 
			// http://localhost:8080/SensorDataCollector/
				 
				 Client cl1 = ClientBuilder.newClient();
				WebTarget tar1 = cl1.target("http://localhost:8080/SensorCloudManagement/sensordata/fetch");
				System.out.println("In client 1 75");
				//String abc = JSON.serialize(obj_json);
				ObjectMapper objMap = new ObjectMapper();
				objMap.setVisibility(PropertyAccessor.ALL, Visibility.ANY);
				Response response = tar1.request().get();
			//	String a= tar1.request().get().toString();
				System.out.println(response + "Response");
				
		}
		public static String readFile(String path, Charset encoding) 
				  throws IOException 
				{
				  byte[] encoded = Files.readAllBytes(Paths.get(path));
				  return new String(encoded, encoding);
				}

			
	

}
