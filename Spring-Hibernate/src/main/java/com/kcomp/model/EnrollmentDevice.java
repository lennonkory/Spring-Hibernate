package com.kcomp.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Enrollment_Device")

public class EnrollmentDevice extends Enrollment {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	@JoinColumn (name = "device_id")
	private Device device;

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	@Override
	public String toString() {
		return "EnrollmentDevice [device=" + device + ", user=" + this.getUser()+",status=" + this.getStatus()+ "]";
	}

}
