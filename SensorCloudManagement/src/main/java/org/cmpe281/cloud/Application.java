package org.cmpe281.cloud;

import org.cmpe281.cloud.virtualsensorcontroller.dbhandler.VirtualSensorDBOperations;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Naks
 * Class to configure application context
 * SpringBootApplication annotation search and add all the subclasses.
 */
@SpringBootApplication
public class Application {
    /**
     * Main method for the project.
     * @param args Nothing needs to be passed
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        
        VirtualSensorDBOperations vbOps= new VirtualSensorDBOperations();
        
//		document.put("sensorid", virtualsensorData.get("sensorid"));
//		document.put("userid", virtualsensorData.get("sensorid"));
//		document.put("latitude", virtualsensorData.get("latitude"));
//		document.put("longitude", virtualsensorData.get("longitude"));
//		document.put("timecreated",timeCreated.toString() );
//		document.put("timeupdated",timeCreated.toString() );
//		document.put("state",SensorState.RUNNING.toString() );
        
        JSONObject jObject= new JSONObject();
        jObject.append("userid", "1");
        jObject.append("sensorid", "1");
        jObject.append("latitude", "-12345");
        jObject.append("longitude", "2222");
        
        vbOps.storeInDB(jObject);
        
    }
}
