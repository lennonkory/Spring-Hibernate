package com.kcomp.service;

import com.kcomp.dao.DeviceDAO;
import com.kcomp.model.Device;

public interface DeviceService {

	boolean createDevice(Device device);
	Device loadDeviceByIdentifier(String identifier);
	public DeviceDAO getDeviceDao();

	public void setDeviceDao(DeviceDAO deviceDao);
	
}
