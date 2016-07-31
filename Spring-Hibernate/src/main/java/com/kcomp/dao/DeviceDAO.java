package com.kcomp.dao;

import com.kcomp.model.Device;

public interface DeviceDAO extends GenericDao<Device, Long>{
	public Device findByIdentifier(String identifier);
}
