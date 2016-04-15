package org.compe281.cloud.serviceinterface;

import org.compe281.cloud.dto.VirtualSensorDTO;

/**
 * @author Yassaman
 *
 */
public interface IVirtualSensorService {
	

    public VirtualSensorDTO create(VirtualSensorDTO vsensor);
 
    public VirtualSensorDTO delete(String id);	
 
//    public List<VirtualSensorDTO> findAll();
 
    public VirtualSensorDTO findById(String id);
 
    public VirtualSensorDTO update(VirtualSensorDTO vsensor);

}
