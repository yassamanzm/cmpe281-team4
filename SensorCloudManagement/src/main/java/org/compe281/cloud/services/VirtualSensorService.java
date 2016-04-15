package org.compe281.cloud.services;

import org.cmpe281.cloud.datastore.IVirtualSensorRepository;
import org.cmpe281.cloud.enums.SensorState;
import org.cmpe281.cloud.model.VirtualSensor;
import org.compe281.cloud.dto.VirtualSensorDTO;
import org.compe281.cloud.serviceinterface.IVirtualSensorService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Yassaman
 *
 */
public class VirtualSensorService implements IVirtualSensorService {


	private final IVirtualSensorRepository repository;

	@Autowired
	VirtualSensorService(IVirtualSensorRepository repository) {
		this.repository = repository;
	}

	public VirtualSensorDTO create(VirtualSensorDTO vsensor) {
		VirtualSensor persisted = new VirtualSensor(vsensor.getId(), vsensor.getName(), vsensor.getUserId(), 
				vsensor.getLatitude(), vsensor.getLongitude(), vsensor.getTimeCreated(), vsensor.getTimeUpdated(),
				vsensor.getState());
		persisted = repository.save(persisted);
		return convertToDTO(persisted);
	}

	public VirtualSensorDTO delete(String id) {
		// soft delete, change the status to stopped
		VirtualSensor deleted = findSensorById(id);
		deleted.setState(SensorState.STOPPED);
		repository.save(deleted);
		return convertToDTO(deleted);
	}

//	public List<VirtualSensorDTO> findAll() {
//		List<VirtualSensor> todoEntries = repository.findAll();
//		return convertToDTOs(todoEntries);
//	}

	public VirtualSensorDTO findById(String id) {
		VirtualSensor found = findSensorById(id);
		return convertToDTO(found);
	}

	public VirtualSensorDTO update(VirtualSensorDTO vsensor) {
		VirtualSensor updated = findSensorById(vsensor.getId());
		updated.setTimeUpdated(vsensor.getTimeUpdated());
		updated = repository.save(updated);
		return convertToDTO(updated);
	}

//	private List<VirtualSensorDTO> convertToDTOs(List<VirtualSensor> models) {
//		return models.stream()
//				.map(this::convertToDTO)
//				.collect(toList());
//	}

	private VirtualSensor findSensorById(String id) {
		VirtualSensor result = repository.findOne(id);
		// what if result is null? Throw an exception?
		return result;

	}

	private VirtualSensorDTO convertToDTO(VirtualSensor vsensorModel) {
		VirtualSensorDTO dto = new VirtualSensorDTO();

		dto.setId(vsensorModel.getId());
		dto.setUserId(vsensorModel.getUserId());
		dto.setName(vsensorModel.getName());
		dto.setLatitude(vsensorModel.getLatitude());
		dto.setLongitude(vsensorModel.getLongitude());
		dto.setTimeCreated(vsensorModel.getTimeCreated());
		dto.setTimeUpdated(vsensorModel.getTimeUpdated());
		dto.setState(vsensorModel.getState());

		return dto;
	}
}
