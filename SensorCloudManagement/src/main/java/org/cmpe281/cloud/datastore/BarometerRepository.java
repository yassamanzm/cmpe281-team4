package org.cmpe281.cloud.datastore;

import org.cmpe281.cloud.model.BarometerSensor;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Naks on 13-Apr-16.
 * Repository interface for CRUD operations
 */
public interface BarometerRepository  extends MongoRepository<BarometerSensor,String>{
    public BarometerSensor findById(String id);
}
