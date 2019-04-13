package com.nsc.backend.service;

import java.util.List;
import java.util.Map;

import com.nsc.backend.entity.Cart;
import com.nsc.backend.entity.User;
import com.nsc.web.util.backstate.BackState;

//处理购物车信息接口
public interface ICartService {
	//判断购物车是否有此商品
	Cart getCartByBookId(Integer bookId, String openId);
	
	
	//将更新的购物车信息，在数据库进行更新
	void updateCart(Cart cart);
	//保存订单信息到数据库
	void saveCart(Cart cart);
	
	//将list传向持久层，删除购物车信息
	void deleteCart(List<Integer> list);
	//根据cartId的list集合，将List<Cart>查询出来 
	List<Cart> findCartByList(List<Integer> list);

	/**
	 * 修改购物车记录中商品的数量
	 * @param cart 购物车记录实例
	 * @return true/false (成功/失败)
	 */
	Boolean updateBookCount(Cart cart);
	
	/**
	 * 根据cartId查找cart
	 * @param cartId Cart记录Id
	 * @return Cart实例
	 */
	Cart findCartByCartId(Integer cartId);
	
	//选中购物车中的商品
	void isCheck(List<Integer> cartlist);
	//查找对应商家需要付款的cart
	List<Cart> findPayCartByStoreId(Integer storeId);
	//是否删除
	void updateIsDelete(List<Integer> cartlist);
	void changeStatus(String openId ,Integer bookId);
	
	//BackState updCount(List<Map<String,String>> list);
	BackState updCount(Map<String,Integer> map);
	
	/**
	 * 判断购物车是否有此商品
	 * @param bookId 图书唯一标识
	 * @param unionId 用户唯一标识
	 * @return 购物车实例
	 */
	Cart getCartByBIdAndUId(Integer bookId,String unionId);
	
	
	/**
	 * 根据用户id查找此用户的购物信息
	 * @param unionId 用户的唯一标识
	 * @return 
	 */
	List<Cart> showCart(String unionId);
	
	/**
	 * 添加购物车记录到数据库
	 * @param carts 购物车实例数组
	 * @return false/true(失败/成功)
	 */
	Boolean saveCartItem(Cart...carts);
	
	/**
	 * 更新购物车记录信息
	 * @param carts 购物车实例数组
	 * @return false/true(失败/成功)
	 */
	Boolean updateCartItem(Cart...carts) ;
	
	
}
