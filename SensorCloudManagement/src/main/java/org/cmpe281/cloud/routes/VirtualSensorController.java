package org.cmpe281.cloud.routes;

import javax.validation.Valid;

import org.cmpe281.cloud.dto.VirtualSensorDTO;
import org.cmpe281.cloud.services.VirtualSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yassaman
 *
 */

@RestController
@RequestMapping("/api/virtualsensor")
public class VirtualSensorController {

    private final VirtualSensorService service;
    
    @Autowired
    VirtualSensorController(VirtualSensorService service) {
        this.service = service;
    }
 
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    VirtualSensorDTO create(@RequestBody @Valid VirtualSensorDTO vsensorEntry) {
        return service.create(vsensorEntry);
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    VirtualSensorDTO delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
 
//    @RequestMapping(method = RequestMethod.GET)
//    List<VirtualSensorDTO> findAll() {
//        return service.findAll();
//    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    VirtualSensorDTO findById(@PathVariable("id") String id) {
        return service.findById(id);
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    VirtualSensorDTO update(@RequestBody @Valid VirtualSensorDTO vsensorEntry) {
        return service.update(vsensorEntry);
    }
 
//    @ExceptionHandler
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public void handleVirtualSensorNotFound(VirtualSensorNotFoundException ex) {
//    }
	
}
