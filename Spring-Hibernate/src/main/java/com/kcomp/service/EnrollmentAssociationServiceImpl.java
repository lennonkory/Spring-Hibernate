package com.kcomp.service;

import java.util.logging.Logger;

import com.kcomp.dao.EnrollmentAssociationDAO;
import com.kcomp.model.EnrollmentAssociation;
import com.kcomp.model.Vehicle;

public class EnrollmentAssociationServiceImpl implements EnrollmentAssociationService{

	private EnrollmentAssociationDAO enrollmentAssociationDAO;
	private final static Logger log = Logger.getLogger(EnrollmentAssociationServiceImpl.class.getName());
	
	public boolean createEnrollmentAssociation(EnrollmentAssociation enrollmentAssociation){
		try {
			enrollmentAssociationDAO.save(enrollmentAssociation);
			log.info("EnrollmentAssociation saved");
		} catch(Exception e) {
			log.severe("Could not save enrollmentAssociation " + e.getMessage());
			return false;
		}
			
		return true;
	}

	public EnrollmentAssociation loadEnrollmentAssociationByVehicle(
			Vehicle vehicle) {
		return enrollmentAssociationDAO.findByVehicle(vehicle);
	}

	public EnrollmentAssociationDAO getEnrollmentAssociationDao() {
		return enrollmentAssociationDAO;
	}

	public void setEnrollmentAssociationDAO(
			EnrollmentAssociationDAO enrollmentAssociationDAO) {
		this.enrollmentAssociationDAO = enrollmentAssociationDAO;
		
	}

}
