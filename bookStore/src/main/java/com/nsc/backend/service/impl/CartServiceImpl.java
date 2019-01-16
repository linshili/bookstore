package com.nsc.backend.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nsc.backend.entity.Cart;
import com.nsc.backend.mapper.CartMapper;
import com.nsc.backend.service.ICartService;
import com.nsc.web.util.backstate.BackState;

/**
 * 购物信息业务层
 * @author Lenovo
 */
@Service
@Transactional
public class CartServiceImpl implements ICartService{
	
	private static final int Integer = 0;
	@Autowired
	private CartMapper cartMapper;
	//判断购物车是否有此商品
	public Cart getCartByBookId(Integer bookId,String openId) {
		 Cart cart = cartMapper.getCartByBookId(bookId,openId);
		 return cart;
	}
	//将更新的购物车信息，在数据库进行更新
	public void updateCart(Cart cart) {
		 cartMapper.updateCart(cart);
	}
	//保存订单信息到数据库
	public void saveCart(Cart cart) {
		cartMapper.saveCart(cart);
	}
	//根据用户id将此用户的购物信息，查找出来
	public List<Cart> showCart(String openId) {
		List<Cart> carts = cartMapper.showCart(openId);
		return carts;
	}
	//将list传向持久层，删除购物车信息
	public void deleteCart(List<Integer> list) {
		cartMapper.deleteCart(list);
	}
	//根据cartId的list集合，将List<Cart>查询出来 
	public List<Cart> findCartByList(List<Integer> list) {
		List<Cart> clist = cartMapper.findCartByList(list);
		return clist;
	}
	//修改数据中cart的count
	public void updateBookCount(Cart cart) {
		cartMapper.updateBookCount(cart);
	}
	//根据cartid查找cart
	public Cart findCartByCartId(Integer cartId) {
		Cart cart = cartMapper.findCartByCartId(cartId);
		return cart;
	}
	
	//选中购物车中的商品
	public void isCheck(List<Integer> cartlist) {
			
				cartMapper.isCheck(cartlist);
		}
	
	//查找对应商家需要付款的cart
	public List<Cart> findPayCartByStoreId(Integer storeId) {
		return cartMapper.findPayCartByStoreId(storeId);
		
	}
	//是否删除
	public void updateIsDelete(List<Integer> cartlist) {
			cartMapper.updateIsDelete(cartlist);
			
	}
	
	
	//选中商品是否删除
	public void changeStatus(String openId ,Integer bookId) {
		
		System.out.println("openId==="+openId);
		System.out.println("bookId==="+bookId);
		cartMapper.changeStatus(openId, bookId);
		System.out.println("======end");
		
	}

	//更改购物车数量
	public BackState updCount(Map<String,Integer> map) {
		BackState bs=new BackState();
		
		try {
			cartMapper.updCount(map);
			 bs.setStateName("HTTP Status 200");
             return bs;
		} catch (Exception e) {
			 bs.setStateName("HTTP Status 500");
			 System.out.println("失败");
             return bs;
		}

	}
}
