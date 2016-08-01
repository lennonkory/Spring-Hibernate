package com.kcomp.service;

import com.kcomp.dao.DeviceDAO;
import com.kcomp.model.Device;
import com.kcomp.model.User;

public interface DeviceService {

	boolean createDevice(Device device);
	Device loadDeviceByIdentifier(String identifier);
	Device findDeviceByUser(User user);
	public DeviceDAO getDeviceDao();
	public void setDeviceDao(DeviceDAO deviceDao);
	
}
