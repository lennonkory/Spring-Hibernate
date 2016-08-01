package com.kcomp.service;

import java.util.logging.Logger;

import com.kcomp.dao.EnrollmentDeviceDAO;
import com.kcomp.dao.UserDao;
import com.kcomp.model.Device;
import com.kcomp.model.EnrollmentDevice;
import com.kcomp.model.User;

public class EnrollmentDeviceServiceImpl implements EnrollmentDeviceService{

	private EnrollmentDeviceDAO enrollmentDeviceDAO;
	private final static Logger log = Logger.getLogger(UserServiceImpl.class.getName());
	
	public boolean createEnrollmentDevice(EnrollmentDevice enrollmentDevice) {
		try {
			enrollmentDeviceDAO.save(enrollmentDevice);
			log.info("EnrollmentDevice saved");
		} catch(Exception e) {
			log.severe("Could not save enrollmentDevice " + e.getMessage());
			return false;
		}
		
		return true;
	}

	public EnrollmentDevice findByUser(User user) {
		return this.enrollmentDeviceDAO.findByUser(user);
	}

	public EnrollmentDevice findByDevice(Device device) {
		return this.enrollmentDeviceDAO.findByDevice(device);
	}

	public EnrollmentDeviceDAO getEnrollmentDeviceDao() {
		return this.enrollmentDeviceDAO;
	}

	public void setEnrollmentDeviceDao(EnrollmentDeviceDAO enrollmentDeviceDAO) {
		this.enrollmentDeviceDAO = enrollmentDeviceDAO;
	}

	public EnrollmentDevice findById(Long id) {
		return this.enrollmentDeviceDAO.findById(id);
	}

	public Device findDeviceByEnrollmentId(Long id) {
		return this.enrollmentDeviceDAO.findDeviceByEnrollmentId(id);
	}

	public User findUserByEnrollmentId(Long id) {
		return this.enrollmentDeviceDAO.findUserByEnrollmentId(id);
	}

}
