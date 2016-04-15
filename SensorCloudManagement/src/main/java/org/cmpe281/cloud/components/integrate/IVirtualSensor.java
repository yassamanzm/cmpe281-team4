package org.cmpe281.cloud.components.integrate;

import org.cmpe281.cloud.model.VirtualSensor;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Naks on 15-Apr-16.
 * Interface to connect with Virtual Sensor Service.
 */
public interface IVirtualSensor {
    public List<VirtualSensor> getSensorMetadata (String sensorId, String userId);
    public void storeInDB (JSONObject vsJsonObject);
}
