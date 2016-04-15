package org.cmpe281.cloud.components.integrate;

import org.cmpe281.cloud.model.VirtualSensor;

import java.util.HashMap;

/**
 * Created by Naks on 15-Apr-16.
 * Interface to connect with Virtual Sensor Service.
 */
public interface IVirtualSensor {
    public HashMap<String,VirtualSensor> getSensorMetadata (String userId);
}
