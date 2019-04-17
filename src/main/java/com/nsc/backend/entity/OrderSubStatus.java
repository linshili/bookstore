package com.nsc.backend.entity;

public enum OrderSubStatus {


	    Pending(0),Delivering(1),Transporting(2),Received(3),AfterServicing(4),Invalid(5);
	
	    private int code;
	    
	    OrderSubStatus(int code){
	        this.code=code;
	    }
	    public Integer getCode(){
	        return code;
	    }
	
}
