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
@Table(name = "device_history")
public class DeviceHistory {

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	@JoinColumn (name = "device_id")
	private Device device;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	@JoinColumn (name = "user_id")
	private User user;
	
	private DeviceState deviceState; 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Device getDevice() {
		return device;
	}
	public void setDevice(Device device) {
		this.device = device;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public DeviceState getDeviceState() {
		return deviceState;
	}
	public void setDeviceState(DeviceState deviceState) {
		this.deviceState = deviceState;
	}
	@Override
	public String toString() {
		return "DeviceHistory [id=" + id + ", device=" + device + ", user=" + user + ", deviceState=" + deviceState
				+ "]";
	}
	
}
