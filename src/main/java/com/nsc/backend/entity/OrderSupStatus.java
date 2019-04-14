package com.nsc.backend.entity;

public enum OrderSupStatus {
	
	InAva(0),Ava(1);
	
	private int code;
	OrderSupStatus(int code){
		this.code = code;
	}
	public Integer getCode() {
		return this.code;
	}

}
