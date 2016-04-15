package org.cmpe281.cloud.routes;

import com.google.gson.Gson;
import org.cmpe281.cloud.components.integrate.ISensorCollector;
import org.cmpe281.cloud.components.integrate.IVirtualSensor;
import org.cmpe281.cloud.model.BarometerSensor;
import org.cmpe281.cloud.model.VirtualSensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Naks on 15-Apr-16.
 * Class connects to Virtual Sensor to fetch the metadata of available sensors
 */

@RestController
@RequestMapping(value = "api/data_manager")
public class VSDataManagerController {

    @Autowired
    IVirtualSensor virtualSensor;

    @Autowired
    ISensorCollector sensorCollector;

    private HttpSession session;

    @RequestMapping(value="/get_vs",method = RequestMethod.GET)
    public String getVirtualSensorData(
            @RequestParam(value = "user", required=true) String userId,
            @RequestParam(value = "sensor_id", required=true) String sensorId,HttpServletRequest request) {
        try {
            HashMap<String,List<BarometerSensor>> sensorList = new HashMap<String, List<BarometerSensor>>();
            Gson gson = new Gson();
            List<VirtualSensor> virtualSensorList=this.virtualSensor.getSensorMetadata(sensorId,userId);
            for(VirtualSensor vs : virtualSensorList) {
                String coordinate = vs.getLatitude().toString() + "," + vs.getLongitude().toString();
                sensorList.put(coordinate, sensorCollector.getSensorData(coordinate)); // Connecting the service
            }
            return gson.toJson(sensorList);
        } catch (Exception e){
            return e.getMessage();
        }
    }
}
