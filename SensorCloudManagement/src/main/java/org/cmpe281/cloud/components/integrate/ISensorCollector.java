package org.cmpe281.cloud.components.integrate;

import org.cmpe281.cloud.model.BarometerSensor;

import java.util.List;

public interface ISensorCollector {
	public List<BarometerSensor> getSensorData(String coordinate); //fetching data
	public boolean delete(String coordinate); //stop observing
}
