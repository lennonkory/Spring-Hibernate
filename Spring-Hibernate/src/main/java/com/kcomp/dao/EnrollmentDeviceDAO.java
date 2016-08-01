package com.kcomp.dao;

import com.kcomp.model.Device;
import com.kcomp.model.EnrollmentDevice;
import com.kcomp.model.User;

public interface EnrollmentDeviceDAO extends GenericDao<EnrollmentDevice, Long>{

	public EnrollmentDevice findByDevice(Device device);
	public EnrollmentDevice findByUser(User user);
	public Device findDeviceByEnrollmentId(Long id);
	public User findUserByEnrollmentId(Long id);
	
}
