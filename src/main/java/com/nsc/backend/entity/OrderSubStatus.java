package com.nsc.backend.entity;

public enum OrderSubStatus {


	    Pending(0),Paid(1),Cancel(2),ReturnGoods(3),Invalid(4);
	
	    private int code;
	    
	    OrderSubStatus(int code){
	        this.code=code;
	    }
	    public Integer getCode(){
	        return code;
	    }
	
}
