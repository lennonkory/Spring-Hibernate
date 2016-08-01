package com.kcomp.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.kcomp.model.Device;
import com.kcomp.model.DeviceHistory;
import com.kcomp.model.User;

public class DeviceHistoryJpaDAO extends GenericJpaDao<DeviceHistory, Long> implements DeviceHistoryDAO {

	public DeviceHistoryJpaDAO() {
		super(DeviceHistory.class);
	}

	private Query createQuery(String hql){
		return this.getEntityManager().createQuery(hql);
	}
	
	private String getClassName(){
		return this.getPersistentClass().getSimpleName();
	}
	
	public DeviceHistory findByUser(User user) {

		DeviceHistory deviceHistory = null;
		
		String hql = "select dh from " + this.getClassName() + " dh where dh.user = :user";
		
		Query q = this.createQuery(hql);
		
		q.setParameter("user", user);
		
		try{
			deviceHistory = (DeviceHistory)q.getSingleResult();
		}
		catch(NoResultException nre){
			//Do something here
		}
		
		return deviceHistory;
		
	}

	public DeviceHistory findByDevice(Device device) {

		DeviceHistory deviceHistory = null;
		
		String hql = "select dh from " + this.getClassName() + " dh where dh.device = :device";
		
		Query q = this.createQuery(hql);
		
		q.setParameter("device", device);
		
		try{
			deviceHistory = (DeviceHistory)q.getSingleResult();
		}
		catch(NoResultException nre){
			//Do something here
		}
		
		return deviceHistory;
		
	}
	

}
