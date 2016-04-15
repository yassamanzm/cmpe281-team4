package org.cmpe281.cloud.components.integrate;

import java.util.HashMap;

import org.cmpe281.cloud.model.BarometerSensor;

public interface ISensorCollector {
	public HashMap<String, BarometerSensor>  getSensorData(String latlong); //fetching data
	public boolean delete(String latlong); //stop observing

}
