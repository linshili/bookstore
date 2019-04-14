package com.nsc.backend.entity;

import java.math.BigDecimal;
import java.util.Date;

public class OrderSup {
    private Integer orderId;

    private String orderNumber;

    private Date orderTime;

    private Date orderPayTime;

    private Date orderEndTime;

    private BigDecimal orderTotalAcount;

    private Integer userId;
    
    private User user;

    private Integer tradeTableMethod;

    private String tradeTableNumber;

    private Integer addId;
    
    private Address address;

    private Integer orderIspay;

    private Integer orderIsequal;

    private Integer orderIsvalid;
    
    private String orderNote;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public Date getOrdeTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getOrderPayTime() {
        return orderPayTime;
    }

    public void setOrderPayTime(Date orderPayTime) {
        this.orderPayTime = orderPayTime;
    }

    public Date getOrderEndTime() {
        return orderEndTime;
    }

    public void setOrderEndTime(Date orderEndTime) {
        this.orderEndTime = orderEndTime;
    }

    public BigDecimal getOrderTotalAcount() {
        return orderTotalAcount;
    }

    public void setOrderTotalAcount(BigDecimal orderTotalAcount) {
        this.orderTotalAcount = orderTotalAcount;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getTradeTableMethod() {
        return tradeTableMethod;
    }

    public void setTradeTableMethod(Integer tradeTableMethod) {
        this.tradeTableMethod = tradeTableMethod;
    }

    public String getTradeTableNumber() {
        return tradeTableNumber;
    }

    public void setTradeTableNumber(String tradeTableNumber) {
        this.tradeTableNumber = tradeTableNumber == null ? null : tradeTableNumber.trim();
    }

    public Integer getAddId() {
        return addId;
    }

    public void setAddId(Integer addId) {
        this.addId = addId;
    }

    
    public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getOrderIspay() {
        return orderIspay;
    }

    public void setOrderIspay(Integer orderIspay) {
        this.orderIspay = orderIspay;
    }

    public Integer getOrderIsequal() {
        return orderIsequal;
    }

    public void setOrderIsequal(Integer orderIsequal) {
        this.orderIsequal = orderIsequal;
    }

    public Integer getOrderIsvalid() {
        return orderIsvalid;
    }

    public void setOrderIsvalid(Integer orderIsvalid) {
        this.orderIsvalid = orderIsvalid;
    }

	public String getOrderNote() {
		return orderNote;
	}

	public void setOrderNote(String orderNote) {
		this.orderNote = orderNote;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	@Override
	public String toString() {
		return "OrderSup [orderId=" + orderId + ", orderNumber=" + orderNumber + ", orderTime=" + orderTime
				+ ", orderPayTime=" + orderPayTime + ", orderEndTime=" + orderEndTime + ", orderTotalAcount="
				+ orderTotalAcount + ", userId=" + userId + ", user=" + user + ", tradeTableMethod=" + tradeTableMethod
				+ ", tradeTableNumber=" + tradeTableNumber + ", addId=" + addId + ", address=" + address
				+ ", orderIspay=" + orderIspay + ", orderIsequal=" + orderIsequal + ", orderIsvalid=" + orderIsvalid
				+ ", orderNote=" + orderNote + "]";
	}
	
	
    
    
}