package com.kcomp.Spring_Hibernate;

import java.util.logging.Logger;

import com.kcomp.model.DeviceState;
import com.kcomp.model.EnrollmentStatus;
import com.kcomp.model.Role;
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
			
			DeviceHistory deviceHistory = this.deviceHistoryService.findByDevice(device);
			if(deviceHistory == null){
				this.saveDeviceHistory(user, device, DeviceState.OPERATIONAL);
			}
			
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
	
	public User saveUser(String name, int age){
		User user = new User();
		user.setAge(age);
		user.setName(name);
		this.userService.createUser(user);
		return user;
	}
	
	public Device saveDevice(String identifier){
		Device device = new Device();
		device.setIdentifier(identifier);
		this.deviceService.createDevice(device);
		return device;
	}
	
	public Vehicle saveVehicle(String make){
		Vehicle vehicle = new Vehicle();
		vehicle.setMake(make);
		this.vehicleService.createVehicle(vehicle);
		return vehicle;
	}
	
	public DeviceHistory saveDeviceHistory(User user, Device device, DeviceState deviceState){
		
		DeviceHistory deviceHistory = new DeviceHistory();
		deviceHistory.setDevice(device);
		deviceHistory.setUser(user);
		deviceHistory.setDeviceState(deviceState);
		this.deviceHistoryService.createDeviceHistory(deviceHistory);
		return deviceHistory;
		
	}
	
	public EnrollmentAssociation saveEnrollmentAssociation(User user, Vehicle vehicle, EnrollmentStatus status, Role role){
		EnrollmentAssociation enrollmentAssociation = new EnrollmentAssociation();
		enrollmentAssociation.setUser(user);
		enrollmentAssociation.setVehicle(vehicle);
		enrollmentAssociation.setStatus(status);
		enrollmentAssociation.setRole(role);
		this.enrollmentAssociationService.createEnrollmentAssociation(enrollmentAssociation);
		return enrollmentAssociation;
	}
	
	public EnrollmentDevice saveEnrollmentDevice(User user, Device device, EnrollmentStatus status){
		EnrollmentDevice enrollmentDevice = new EnrollmentDevice();
		enrollmentDevice.setDevice(device);
		enrollmentDevice.setUser(user);
		enrollmentDevice.setStatus(status);
		this.enrollmentDeviceService.createEnrollmentDevice(enrollmentDevice);
		return enrollmentDevice;
	}
	
	public void associateUserAndGuest(User owner, User guest, Vehicle vehicle, Device device){
		EnrollmentAssociation enrollmentAssociation = this.enrollmentAssociationService.findByUserAndVehicle(guest, vehicle);
		
		if(enrollmentAssociation != null){
			throw new RuntimeException("Already associated!");
		}
		
		enrollmentAssociation = new EnrollmentAssociation();
		enrollmentAssociation.setStatus(EnrollmentStatus.ACTIVE);
		enrollmentAssociation.setUser(guest);
		enrollmentAssociation.setVehicle(vehicle);
		enrollmentAssociation.setRole(Role.GUEST);
		
		EnrollmentDevice ed = null;
		
		this.enrollmentAssociationService.createEnrollmentAssociation(enrollmentAssociation);
		
		if(this.deviceService.loadDeviceByIdentifier(device.getIdentifier()) == null){
			this.deviceService.createDevice(device);
			DeviceHistory deviceHistory = this.saveDeviceHistory(guest, device, DeviceState.OPERATIONAL);
			this.deviceHistoryService.createDeviceHistory(deviceHistory);
			ed = this.saveEnrollmentDevice(guest, device, EnrollmentStatus.ACTIVE);
		}
		else{
			ed = this.enrollmentDeviceService.findByDevice(device);
			if(ed == null){
				ed = this.saveEnrollmentDevice(guest, device, EnrollmentStatus.ACTIVE);
				DeviceHistory deviceHistory = this.saveDeviceHistory(guest, device, DeviceState.OPERATIONAL);
				this.deviceHistoryService.createDeviceHistory(deviceHistory);
			}
			DeviceHistory deviceHistory = this.deviceHistoryService.findByDevice(device);
			if(deviceHistory == null){
				deviceHistory = this.saveDeviceHistory(guest, device, DeviceState.OPERATIONAL);
			}
		}
		
		
	}
	
	public void removeAssociation(User user,User guest, Vehicle vehicle){
		
		EnrollmentAssociation enrollmentAssociation = null;
		enrollmentAssociation = this.enrollmentAssociationService.findByUserAndVehicle(guest, vehicle);
		
		if(enrollmentAssociation == null){
			throw new RuntimeException("No association found!");
		}
		
		enrollmentAssociation.setStatus(EnrollmentStatus.DEACTIVE);
		
		this.enrollmentAssociationService.update(enrollmentAssociation);
		
		Device device = this.deviceService.findDeviceByUser(guest);
		
		DeviceHistory dh = this.deviceHistoryService.findByDevice(device);
		dh.setDeviceState(DeviceState.NONOPERATION);
		

	}
	
}
