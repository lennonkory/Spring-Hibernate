package com.kcomp.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.kcomp.model.Device;

public class DeviceJpaDAO extends GenericJpaDao<Device, Long> implements DeviceDAO{

	public DeviceJpaDAO() {
		super(Device.class);
	}

	private Query createQuery(String hql){
		return this.getEntityManager().createQuery(hql);
	}
	
	private String getClassName(){
		return this.getPersistentClass().getSimpleName();
	}
	
	public Device findByIdentifier(String identifier) {
		
		Device device = null;
		
		String hql = "select d from " + this.getClassName() + " d where d.identifier = :identifier";
		
		Query q = this.createQuery(hql);
		
		q.setParameter("identifier", identifier);
		
		try{
			device = (Device)q.getSingleResult();
			System.out.println("Found?");
		}
		catch(NoResultException nre){
			System.out.println(nre.getMessage());
		}
		
		return device;
	}

}
