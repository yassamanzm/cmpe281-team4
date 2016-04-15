package org.cmpe281.cloud.datastore;

/**
 * @author Yassaman
 *
 */

import java.util.List;

import org.cmpe281.cloud.model.VirtualSensor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IVirtualSensorRepository extends MongoRepository<VirtualSensor,String>{
    
	public List<VirtualSensor> findByUserId(String userId);
    public VirtualSensor findByName(String name);
    public void deleteByName(String name);
    public void deleteByUserId(String userId);
    public void add(VirtualSensor vsensor);
    
   // To-do: findByLocation

}
