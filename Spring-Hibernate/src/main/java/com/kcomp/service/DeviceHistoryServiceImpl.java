package com.kcomp.service;

import java.util.logging.Logger;

import com.kcomp.dao.DeviceHistoryDAO;
import com.kcomp.model.DeviceHistory;
import com.kcomp.model.User;
import com.kcomp.model.Device;

public class DeviceHistoryServiceImpl implements DeviceHistoryService{
	
	private DeviceHistoryDAO deviceHistoryDAO;
	private final static Logger log = Logger.getLogger(DeviceHistoryServiceImpl.class.getName());

	public boolean createDeviceHistory(DeviceHistory deviceHistory) {
		try {
			deviceHistoryDAO.save(deviceHistory);
			log.info("Device saved");
		} catch(Exception e) {
			log.severe("Could not save device");
			return false;
		}
		return true;
	}

	public DeviceHistory findById(Long id) {
		return deviceHistoryDAO.findById(id);
	}

	public DeviceHistory findByUser(User user) {
		
		return deviceHistoryDAO.findByUser(user);
	}

	public DeviceHistory findByDevice(Device device) {
		return deviceHistoryDAO.findByDevice(device);
	}

	public DeviceHistoryDAO getDeviceHistoryDao() {
		return this.deviceHistoryDAO;
	}

	public void setDeviceHistoryDao(DeviceHistoryDAO deviceHistoryDao) {
		this.deviceHistoryDAO = deviceHistoryDao;
		
	}

}
