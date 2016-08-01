package com.kcomp.service;

import com.kcomp.dao.EnrollmentDeviceDAO;
import com.kcomp.model.Device;
import com.kcomp.model.EnrollmentDevice;
import com.kcomp.model.User;

public interface EnrollmentDeviceService {

	boolean createEnrollmentDevice(EnrollmentDevice enrollmentDevice);
	EnrollmentDevice findById(Long id);
	EnrollmentDevice findByUser(User user);
	EnrollmentDevice findByDevice(Device device);
	Device findDeviceByEnrollmentId(Long id);
	User findUserByEnrollmentId(Long id);
	public EnrollmentDeviceDAO getEnrollmentDeviceDao();
	public void setEnrollmentDeviceDao(EnrollmentDeviceDAO enrollmentDeviceDAO);
	
}
