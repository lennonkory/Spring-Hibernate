package com.kcomp.Spring_Hibernate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.kcomp.dao.DeviceHistoryJpaDAO;
import com.kcomp.dao.DeviceJpaDAO;
import com.kcomp.dao.EnrollmentAssociationJpaDAO;
import com.kcomp.dao.EnrollmentDeviceJpaDAO;
import com.kcomp.dao.UserJpaDao;
import com.kcomp.dao.VehicleJpaDao;

import com.kcomp.service.DeviceHistoryService;
import com.kcomp.service.DeviceHistoryServiceImpl;
import com.kcomp.service.DeviceService;
import com.kcomp.service.DeviceServiceImpl;
import com.kcomp.service.EnrollmentAssociationService;
import com.kcomp.service.EnrollmentAssociationServiceImpl;
import com.kcomp.service.EnrollmentDeviceService;
import com.kcomp.service.EnrollmentDeviceServiceImpl;
import com.kcomp.service.UserService;
import com.kcomp.service.UserServiceImpl;
import com.kcomp.service.VehicleService;
import com.kcomp.service.VehicleServiceImpl;

@Configuration
public class Config {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	
	public Config(){
		this.entityManagerFactory = Persistence.createEntityManagerFactory("test-jpa");
		this.entityManager = entityManagerFactory.createEntityManager();
	}
	
	@Bean
	DeviceService deviceService(){
		
		DeviceJpaDAO deviceJpaDAO = new DeviceJpaDAO();
	    deviceJpaDAO.setEntityManager(this.entityManager);
	    
	   	DeviceService deviceService = new DeviceServiceImpl();
	    
	   	deviceService.setDeviceDao(deviceJpaDAO);
	   	
	   	return deviceService;
	   	
	}
	
	@Bean
	DeviceHistoryService deviceHistoryService(){
		
		DeviceHistoryJpaDAO deviceHistoryJpaDAO = new DeviceHistoryJpaDAO();
		deviceHistoryJpaDAO.setEntityManager(this.entityManager);
	    
	   	DeviceHistoryService deviceHistoryService = new DeviceHistoryServiceImpl();
	    
	   	deviceHistoryService.setDeviceHistoryDao(deviceHistoryJpaDAO);
	   	
	   	return deviceHistoryService;
	   	
	}
	
	@Bean
	UserService userService(){
		
		UserJpaDao userJpaDAO = new UserJpaDao();
		userJpaDAO.setEntityManager(this.entityManager);
	    
		UserService userService = new UserServiceImpl();
	    
		userService.setUserDao(userJpaDAO);
	   	
	   	return userService;
	   	
	}
	
	@Bean
	VehicleService vehicleService(){
		
		VehicleJpaDao vehicleJpaDAO = new VehicleJpaDao();
		vehicleJpaDAO.setEntityManager(this.entityManager);
	    
		VehicleService vehicleService = new VehicleServiceImpl();
	    
		vehicleService.setVehicleDao(vehicleJpaDAO);
	   	
	   	return vehicleService;
	   	
	}
	
	@Bean
	EnrollmentAssociationService enrollmentAssociationService(){
		
		EnrollmentAssociationJpaDAO enrollmentAssociationDAO = new EnrollmentAssociationJpaDAO();
		enrollmentAssociationDAO.setEntityManager(this.entityManager);
	    
		EnrollmentAssociationService enrollmentAssociationService = new EnrollmentAssociationServiceImpl();
	    
		enrollmentAssociationService.setEnrollmentAssociationDAO(enrollmentAssociationDAO);
	   	
	   	return enrollmentAssociationService;
	   	
	}
	
	@Bean
	EnrollmentDeviceService enrollmentDeviceService(){
		
		EnrollmentDeviceJpaDAO enrollmentDeviceDAO = new EnrollmentDeviceJpaDAO();
		enrollmentDeviceDAO.setEntityManager(this.entityManager);
	    
		EnrollmentDeviceService enrollmentDeviceService = new EnrollmentDeviceServiceImpl();
	    
		enrollmentDeviceService.setEnrollmentDeviceDao(enrollmentDeviceDAO);
	   	
	   	return enrollmentDeviceService;
	   	
	}
	
	@Bean
	Utils utils(){
		Utils utils = new Utils();
		
		utils.setDeviceHistoryService(deviceHistoryService());
		utils.setDeviceService(deviceService());
		utils.setEnrollmentAssociationService(enrollmentAssociationService());
		utils.setEnrollmentDeviceService(enrollmentDeviceService());
		utils.setUserService(userService());
		utils.setVehicleService(vehicleService());
		
		return utils;
	}
	
}
