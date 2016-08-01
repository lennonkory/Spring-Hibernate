package com.kcomp.dao;

import com.kcomp.model.DeviceHistory;
import com.kcomp.model.User;
import com.kcomp.model.Device;

public interface DeviceHistoryDAO extends GenericDao<DeviceHistory, Long> {

	public DeviceHistory findByUser(User user);
	public DeviceHistory findByDevice(Device device);
	
}
