package com.kcomp.Spring_Hibernate;

import java.util.logging.Logger;

import com.kcomp.model.EnrollmentStatus;
import com.kcomp.model.User;
import com.kcomp.model.Vehicle;
import com.kcomp.model.Device;
import com.kcomp.model.DeviceHistory;
import com.kcomp.model.EnrollmentAssociation;
import com.kcomp.model.EnrollmentDevice;
import com.kcomp.service.DeviceHistoryService;
import com.kcomp.service.DeviceService;
import com.kcomp.service.EnrollmentAssociationService;
import com.kcomp.service.EnrollmentDeviceService;
import com.kcomp.service.UserService;
import com.kcomp.service.VehicleService;

public class Utils {

	private UserService userService;
	private DeviceService deviceService;
	private VehicleService vehicleService;
	private EnrollmentAssociationService enrollmentAssociationService;
	private EnrollmentDeviceService enrollmentDeviceService;
	private DeviceHistoryService deviceHistoryService;
	
	private final static Logger log = Logger.getLogger(Utils.class.getName());
	
	//Getters and Setters
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public DeviceService getDeviceService() {
		return deviceService;
	}
	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}
	public VehicleService getVehicleService() {
		return vehicleService;
	}
	public void setVehicleService(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}
	public EnrollmentAssociationService getEnrollmentAssociationService() {
		return enrollmentAssociationService;
	}
	public void setEnrollmentAssociationService(
			EnrollmentAssociationService enrollmentAssociationService) {
		this.enrollmentAssociationService = enrollmentAssociationService;
	}
	public EnrollmentDeviceService getEnrollmentDeviceService() {
		return enrollmentDeviceService;
	}
	public void setEnrollmentDeviceService(
			EnrollmentDeviceService enrollmentDeviceService) {
		this.enrollmentDeviceService = enrollmentDeviceService;
	}
	public DeviceHistoryService getDeviceHistoryService() {
		return deviceHistoryService;
	}
	public void setDeviceHistoryService(DeviceHistoryService deviceHistoryService) {
		this.deviceHistoryService = deviceHistoryService;
	}

	public void logOn(String name, String identifier){
		
		User user = this.userService.loadUserByUsername(name);
		Device device = null;
		
		if(user == null){
			log.info("Creating user");
			user = new User();
			user.setName(name);
			user.setAge(23);
			this.userService.createUser(user);
		}
		
		EnrollmentDevice enrollmentDevice = this.enrollmentDeviceService.findByUser(user);
		
		if(enrollmentDevice == null){//No association
			enrollmentDevice = new EnrollmentDevice();
			enrollmentDevice.setStatus(EnrollmentStatus.ACTIVE);
			
			enrollmentDevice.setUser(user);
			
			device = this.deviceService.loadDeviceByIdentifier(identifier);
			
			if(device == null){//Create new Device
				device = new Device();
				device.setIdentifier(identifier);
				this.deviceService.createDevice(device);
			}
			enrollmentDevice.setDevice(device);
			
			this.enrollmentDeviceService.createEnrollmentDevice(enrollmentDevice);
		}
		else{
			
			device = this.enrollmentDeviceService.findDeviceByEnrollmentId(enrollmentDevice.getDevice().getId());
			
			if(device == null){
				throw new RuntimeException("No Device associationed with user!");
			}
			
		}
		
		System.out.println(user.toString());
		System.out.println(device.toString());
		System.out.println(enrollmentDevice.toString());
		
	}
	
}
