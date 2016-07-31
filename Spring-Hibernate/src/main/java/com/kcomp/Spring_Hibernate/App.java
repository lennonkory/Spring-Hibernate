package com.kcomp.Spring_Hibernate;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.kcomp.dao.DeviceJpaDAO;
import com.kcomp.dao.EnrollmentAssociationJpaDAO;
import com.kcomp.model.Device;
import com.kcomp.model.EnrollmentAssociation;
import com.kcomp.model.User;
import com.kcomp.model.Vehicle;
import com.kcomp.service.DeviceService;
import com.kcomp.service.DeviceServiceImpl;
import com.kcomp.service.EnrollmentAssociationService;
import com.kcomp.service.EnrollmentAssociationServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
	private final static Logger log = Logger.getLogger(App.class.getName());
	
	public static void testDevice(){
		
		String identifier = "124";
		
		EntityManagerFactory entityManagerFactory = 
	            Persistence.createEntityManagerFactory("test-jpa");
    	
	    DeviceJpaDAO deviceJpaDAO = new DeviceJpaDAO();
	    EntityManager em = entityManagerFactory.createEntityManager();
	    deviceJpaDAO.setEntityManager(em);
	    
	   	DeviceService deviceService = new DeviceServiceImpl();
	    
	   	deviceService.setDeviceDao(deviceJpaDAO);
	    
	   	Device device = new Device();
	   	device.setIdentifier(identifier);

	    deviceService.createDevice(device);
	    
	    Device found = deviceService.loadDeviceByIdentifier(identifier);
	    
	    log.info("Loading Device");
	    
	    try{
	    	System.out.println(found.toString());
	    	log.info("Device found");
	    }
	    catch(NullPointerException npe){
	    	log.severe("Device not found: " + npe.getMessage());
	    }
	  
	}
	
	public static void testEA(){
		
		EntityManagerFactory entityManagerFactory = 
	            Persistence.createEntityManagerFactory("test-jpa");
    	
	    EnrollmentAssociationJpaDAO enrollmentAssociationJpaDAP = new EnrollmentAssociationJpaDAO();
	    EntityManager em = entityManagerFactory.createEntityManager();
	    enrollmentAssociationJpaDAP.setEntityManager(em);
	    
	    EnrollmentAssociationService enrollmentAssociationService = new EnrollmentAssociationServiceImpl();
	    
	    enrollmentAssociationService.setEnrollmentAssociationDAO(enrollmentAssociationJpaDAP);
	    
	   	EnrollmentAssociation enrollmentAssociation = new EnrollmentAssociation();
	   	
	   	Vehicle vehicle = new Vehicle();
	   	User user = new User();
	   	
	   	user.setAge(24);
	   	user.setName("Bob");
	   	
	   	vehicle.setMake("Car");
	   	
	   	enrollmentAssociation.setVehicle(vehicle);
	   	enrollmentAssociation.setUser(user);
	   	
	   	
	   	enrollmentAssociationService.createEnrollmentAssociation(enrollmentAssociation);
	    
	   	EnrollmentAssociation found = enrollmentAssociationService.loadEnrollmentAssociationByVehicle(vehicle);
	    
	    log.info("Loading EnrollmentAssociation");
	    
	    try{
	    	System.out.println(found.toString());
	    	log.info("EnrollmentAssociation found");
	    }
	    catch(NullPointerException npe){
	    	log.severe("EnrollmentAssociation not found: " + npe.getMessage());
	    }
	}
	
    public static void main( String[] args ){
      
    	testEA();
    	
    }
}