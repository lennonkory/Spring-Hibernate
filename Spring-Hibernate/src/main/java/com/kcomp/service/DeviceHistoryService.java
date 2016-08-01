package com.kcomp.service;

import com.kcomp.dao.DeviceHistoryDAO;
import com.kcomp.model.DeviceHistory;
import com.kcomp.model.User;
import com.kcomp.model.Device;

public interface DeviceHistoryService {

	boolean createDeviceHistory(DeviceHistory deviceHistory);
	DeviceHistory findById(Long id);
	DeviceHistory findByUser(User user);
	DeviceHistory findByDevice(Device device);
	public DeviceHistoryDAO getDeviceHistoryDao();
	public void setDeviceHistoryDao(DeviceHistoryDAO deviceHistoryDao);
	
}
