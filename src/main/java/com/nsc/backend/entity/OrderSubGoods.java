package com.nsc.backend.entity;

import java.math.BigDecimal;
import java.util.Date;

public class OrderSubGoods {
	
	private String unionId;
	
    private Integer orderGoodsId;
    
    private Integer orderId;
    
    private Integer bookId;
    
    private Integer storeId;
    
    private Byte invoice;
    
    private Date orderTime;
    
    private Date orderPayTime;
    
    private Date orderEndTime;
    
    private Byte orderGoodsIsReturnGoods;
    
    private Byte orderReturnStatus;
    
    private String orderReturnReason;
    
    private String orderGoodsNumber;
    
    private Integer orderGoodsCount;

    private BigDecimal orderGoodsTotalPrice;

    private String tradeTableNumber;
    
    private Byte tradeTableMethod;

    private Book book;
    
    private Address address;


    public Integer getOrderGoodsId() {
        return orderGoodsId;
    }

    public void setOrderGoodsId(Integer orderGoodsId) {
        this.orderGoodsId = orderGoodsId;
    }
    
    /**
     * 获取子订单对应的主订单Id
     * @return
     */
	public Integer getOrderId() {
        return orderId;
    }

	/**
	 * 设置子订单对应的主订单Id
	 * @param orderId
	 */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrdergoodsNumber() {
        return orderGoodsNumber;
    }

    public void setOrdergoodsNumber(String orderGoodsNumber) {
        this.orderGoodsNumber = orderGoodsNumber == null ? null : orderGoodsNumber.trim();
    }

    public Integer getOrderGoodsCount() {
        return orderGoodsCount;
    }

    public void setOrderGoodsCount(Integer orderGoodsCount) {
        this.orderGoodsCount = orderGoodsCount;
    }

    public Byte getInvoice() {
        return invoice;
    }

    public void setInvoice(Byte invoice) {
        this.invoice = invoice;
    }

    public BigDecimal getOrderGoodsTotalPrice() {
        return orderGoodsTotalPrice;
    }

    public void setOrderGoodsTotalPrice(BigDecimal orderGoodsTotalPrice) {
        this.orderGoodsTotalPrice = orderGoodsTotalPrice;
    }

    public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    /**
     * 获取订单生成时间
     * @return
     */
	public Date getOrderTime() {
		return orderTime;
	}

	/**
	 * 设置订单生成时间
	 * @param orderTime
	 */
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	/**
	 * 获取订单支付时间
	 * @return
	 */
	public Date getOrderPayTime() {
		return orderPayTime;
	}

	/**
	 * 设置订单支付时间
	 * @param orderPayTime
	 */
	public void setOrderPayTime(Date orderPayTime) {
		this.orderPayTime = orderPayTime;
	}

	public String getTradeTableNumber() {
		return tradeTableNumber;
	}

	public void setTradeTableNumber(String tradeTableNumber) {
		this.tradeTableNumber = tradeTableNumber == null ? null : tradeTableNumber.trim();
	}

	public Byte getTradeTableMethod() {
		return tradeTableMethod;
	}

	public void setTradeTableMethod(Byte tradeTableMethod) {
		this.tradeTableMethod = tradeTableMethod;
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public Date getOrderEndTime() {
		return orderEndTime;
	}

	public void setOrderEndTime(Date orderEndTime) {
		this.orderEndTime = orderEndTime;
	}

	public Byte getOrderGoodsIsReturnGoods() {
		return orderGoodsIsReturnGoods;
	}

	public void setOrderGoodsIsReturnGoods(Byte orderGoodsIsReturnGoods) {
		this.orderGoodsIsReturnGoods = orderGoodsIsReturnGoods;
	}

	public Byte getOrderReturnStatus() {
		return orderReturnStatus;
	}

	public void setOrderReturnStatus(Byte orderReturnStatus) {
		this.orderReturnStatus = orderReturnStatus;
	}

	public String getOrderReturnReason() {
		return orderReturnReason;
	}

	public void setOrderReturnReason(String orderReturnReason) {
		this.orderReturnReason = orderReturnReason;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "OrderSubGoods [unionId=" + unionId + ", orderGoodsId=" + orderGoodsId + ", orderId=" + orderId
				+ ", bookId=" + bookId + ", storeId=" + storeId + ", invoice=" + invoice + ", orderTime=" + orderTime
				+ ", orderPayTime=" + orderPayTime + ", orderEndTime=" + orderEndTime + ", orderGoodsIsReturnGoods="
				+ orderGoodsIsReturnGoods + ", orderReturnStatus=" + orderReturnStatus + ", orderReturnReason="
				+ orderReturnReason + ", orderGoodsNumber=" + orderGoodsNumber + ", orderGoodsCount=" + orderGoodsCount
				+ ", orderGoodsTotalPrice=" + orderGoodsTotalPrice + ", tradeTableNumber=" + tradeTableNumber
				+ ", tradeTableMethod=" + tradeTableMethod + ", book=" + book + ", address=" + address + "]";
	}
	
	
}
