package org.cmpe281.cloud.sensordatacollector;

import java.util.ArrayList;
import java.util.List;

import org.cmpe281.cloud.components.integrate.ISensorCollector;
import org.cmpe281.cloud.dbhandler.SensorDBOperations;
import org.cmpe281.cloud.model.BarometerSensor;
import org.json.JSONArray;
import org.json.JSONString;

import com.google.gson.Gson;

public class SensorCollectorImp implements ISensorCollector {

	@Override
	public ArrayList<BarometerSensor> getSensorData(String latlang) {
		ArrayList<BarometerSensor> readingsList = new ArrayList<>();
		SensorDBOperations sdo = new SensorDBOperations();
		String[] input = latlang.split(",");
		JSONArray sensorReadings = new JSONArray();
		sensorReadings = sdo.search(input[0], input[1]);
		Gson gson = new Gson();
		for(int i= 0; i < sensorReadings.length(); i++){
		readingsList = gson.fromJson(sensorReadings.getString(i), BarometerSensor.class);
		
		}

		
		// TODO Auto-generated method stub
		return readingsList;
	}

}
