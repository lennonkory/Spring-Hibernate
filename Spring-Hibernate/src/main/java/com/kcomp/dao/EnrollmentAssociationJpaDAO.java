package com.kcomp.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.kcomp.model.EnrollmentAssociation;
import com.kcomp.model.Vehicle;

public class EnrollmentAssociationJpaDAO extends GenericJpaDao<EnrollmentAssociation, Long> implements EnrollmentAssociationDAO{

	public EnrollmentAssociationJpaDAO() {
		super(EnrollmentAssociation.class);
	}

	private Query createQuery(String hql){
		return this.getEntityManager().createQuery(hql);
	}
	
	private String getClassName(){
		return this.getPersistentClass().getSimpleName();
	}
	
	public EnrollmentAssociation findByVehicle(Vehicle vehicle){
		
		EnrollmentAssociation enrollmentAssociation = null;
		
		String hql = "select ea from " + this.getClassName() + " ea where ea.vehicle = :vehicle";
		
		Query q = this.createQuery(hql);
		
		q.setParameter("vehicle", vehicle);
		
		try{
			enrollmentAssociation = (EnrollmentAssociation)q.getSingleResult();
			System.out.println("Found?");
		}
		catch(NoResultException nre){
			System.out.println(nre.getMessage());
		}
		
		return enrollmentAssociation;
		
	}

}
