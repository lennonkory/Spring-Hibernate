package com.kcomp.service;

import java.util.logging.Logger;

import com.kcomp.dao.DeviceDAO;
import com.kcomp.model.Device;
import com.kcomp.model.User;

public class DeviceServiceImpl implements DeviceService{

	private DeviceDAO deviceDAO;
	private final static Logger log = Logger.getLogger(DeviceServiceImpl.class.getName());
	
	public boolean createDevice(Device device) {
		//TODO Check for existing devices here
		try {
			deviceDAO.save(device);
			log.info("Device saved");
		} catch(Exception e) {
			log.severe("Could not save device");
			return false;
		}
		
		return true;
	}

	public Device loadDeviceByIdentifier(String identifier) {
		return this.deviceDAO.findByIdentifier(identifier);
	}

	
	public DeviceDAO getDeviceDao() {
		return deviceDAO;
	}

	public void setDeviceDao(DeviceDAO deviceDao) {
		this.deviceDAO = deviceDao;
	}

	public Device findDeviceByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
