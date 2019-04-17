package com.nsc.backend.entity;

import java.math.BigDecimal;

public class OrderSub {
	
    private Integer orderGoodsId;

    private Integer orderId;
    
    private OrderSup orderSup;

    private String ordergoodsNumber;

    private Byte orderState;

    private Integer orderGoodsCount;

    private Byte invoice;

    private Integer orderGoodsIsReturnGoods;

    private BigDecimal orderGoodsTotalPrice;

    private Integer bookId;
    
    private Book book;

    private Integer storeId;

    private Integer orderReturnStatus;

    private String orderReturnReason;

    public Integer getOrderGoodsId() {
        return orderGoodsId;
    }

    public void setOrderGoodsId(Integer orderGoodsId) {
        this.orderGoodsId = orderGoodsId;
    }
    
    public OrderSup getOrderSup() {
		return orderSup;
	}

	public void setOrderSup(OrderSup orderSup) {
		this.orderSup = orderSup;
	}

	public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrdergoodsNumber() {
        return ordergoodsNumber;
    }

    public void setOrdergoodsNumber(String ordergoodsNumber) {
        this.ordergoodsNumber = ordergoodsNumber == null ? null : ordergoodsNumber.trim();
    }

    public Byte getOrderState() {
        return orderState;
    }

    public void setOrderState(Byte orderState) {
        this.orderState = orderState;
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

    public Integer getOrderGoodsIsReturnGoods() {
        return orderGoodsIsReturnGoods;
    }

    public void setOrderGoodsIsReturnGoods(Integer orderGoodsIsReturnGoods) {
        this.orderGoodsIsReturnGoods = orderGoodsIsReturnGoods;
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

	public void setOrderReturnStatus(Integer orderReturnStatus) {
		this.orderReturnStatus = orderReturnStatus;
	}

	public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getOrderReturnStatus() {
        return orderReturnStatus;
    }

    public void setOrderReturn_status(Integer orderReturnStatus) {
        this.orderReturnStatus = orderReturnStatus;
    }

    public String getOrderReturnReason() {
        return orderReturnReason;
    }

    public void setOrderReturnReason(String orderReturnReason) {
        this.orderReturnReason = orderReturnReason == null ? null : orderReturnReason.trim();
    }
}