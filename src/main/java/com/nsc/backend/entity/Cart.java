package com.nsc.backend.entity;

import java.util.Date;

/**
 * 
 * @Desc 购物车实体类
 * @author sjg
 * @Date 2019年4月12日
 */
public class Cart {
    private Integer cartId;

    private Integer userId;
    
    private User user;

    private String userUnionId;

    private String userOpenId;

    private Integer bookId;
    
    private Book book;

	private Date cartJoinCartTime;

	private Double cartSum;

    private Double cartUnitPrice;

    private Integer cartCount;

    private Byte cartIsDeleted;

    private Byte cartIsCheck;

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
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

	public String getUserUnionId() {
		return userUnionId;
	}

	public void setUserUnionId(String userUnionId) {
		this.userUnionId = userUnionId;
	}

	public String getUserOpenId() {
		return userOpenId;
	}

	public void setUserOpenId(String userOpenId) {
		this.userOpenId = userOpenId;
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


	public Double getCartSum() {
		return cartSum;
	}

	public void setCartSum(Double cartSum) {
		this.cartSum = cartSum;
	}

	public Double getCartUnitPrice() {
		return cartUnitPrice;
	}
	

	public void setCartUnitPrice(Double cartUnitPrice) {
		this.cartUnitPrice = cartUnitPrice;
	}
	
	

	public Date getCartJoinCartTime() {
		return cartJoinCartTime;
	}

	public void setCartJoinCartTime(Date cartJoinCartTime) {
		this.cartJoinCartTime = cartJoinCartTime;
	}

	public Integer getCartCount() {
		return cartCount;
	}

	public void setCartCount(Integer cartCount) {
		this.cartCount = cartCount;
	}

	public Byte getCartIsDeleted() {
		return cartIsDeleted;
	}

	public void setCartIsDeleted(Byte cartIsDeleted) {
		this.cartIsDeleted = cartIsDeleted;
	}

	public Byte getCartIsCheck() {
		return cartIsCheck;
	}

	public void setCartIsCheck(Byte cartIsCheck) {
		this.cartIsCheck = cartIsCheck;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", userId=" + userId + ", userUnionId=" + userUnionId + ", userOpenId="
				+ userOpenId + ", bookId=" + bookId + ", cartjoinCartTime=" + cartJoinCartTime
				+ ", cartSum=" + cartSum + ", cartUnitPrice=" + cartUnitPrice + ", cartCount="
				+ cartCount + ", cartIsDeleted=" + cartIsDeleted + ", cartIsCheck=" + cartIsCheck + "]";
	}

    
}
