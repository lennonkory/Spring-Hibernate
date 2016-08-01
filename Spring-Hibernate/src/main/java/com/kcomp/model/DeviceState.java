package com.kcomp.model;

public enum DeviceState {

	AVAILABLE(0, "AVAILABLE"),
	OPERATIONAL(1, "OPERATIONAL"),
	NONOPERATION(2, "NONOPERATIONAL");

	private int key;
	private String value;
	
	DeviceState(int key, String value){
		this.key = key;
		this.value = value;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	
}
