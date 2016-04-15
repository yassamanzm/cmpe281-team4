/**
 * 
 */
package org.cmpe281.cloud.virtualsensorcontroller.services;

import java.util.List;

import org.cmpe281.cloud.components.integrate.IVirtualSensor;
import org.cmpe281.cloud.model.VirtualSensor;
import org.cmpe281.cloud.virtualsensorcontroller.dbhandler.VirtualSensorDBOperations;
import org.json.JSONObject;

/**
 * @author Yassaman
 *
 */
public class VirtualSensorImp implements IVirtualSensor {
	
	private VirtualSensorDBOperations vsDBOperations;
	
	public VirtualSensorImp() {
		vsDBOperations= new VirtualSensorDBOperations();
	}

	@Override
	public List<VirtualSensor> getSensorMetadata(String sensorId, String userId) {
		return vsDBOperations.getVirtualSensorListByUserId(sensorId, userId);
	}

	@Override
	public void storeInDB(JSONObject vsJsonObject) {
		vsDBOperations.storeInDB(vsJsonObject);
		
	}

}
