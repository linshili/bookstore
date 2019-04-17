package com.nsc.backend.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.nsc.backend.entity.OrderBase;
import com.nsc.backend.entity.OrderSup;

/**
 * 
 * @Desc  主订单业务层
 * @author sjg
 * @Date 2019年4月13日
 */
public interface IOrderBaseService {

	//保存主订单
	int saveOrderbase(OrderBase orderbase);
	
	/**
	 * 保存未支付主订单记录
	 * @param orderSup 主订单实例
	 * @return true/false(成功/失败)
	 */
	Boolean saveSupOrderNoPay(OrderSup orderSup);
	
	/**
	 * 保存未支付主订单记录
	 * @param unionId 用户Id
	 * @param moneySum 主订单总金额
	 * @param addrId 收货通讯地址
	 * @return 主订单编号
	 */
	OrderSup saveSupOrderNoPay(String unionId,BigDecimal moneySum,Integer addrId);
	

    /**
     * 保存未支付主订单记录
     * @param orderSup 主订单实例
     * @return 主订单记录Id
     */
    Integer saveSupOrderToGetId(OrderSup orderSup);
	
    /**
     * 根据主订单编号查找主订单Id
     * @param supOrderNumber 主订单编号
     * @return 主订单Id
     */
    Integer getSupOrderId(String supOrderNumber);
    
	
	/**
	 * 通过主订单编号更新主订单
	 * @param orderNumber
	 * @param payTime
	 * @param tMerchantnumber
	 * @param orderNote
	 */
	void updateOrderBaseByWx(String orderNumber,String payTime,String tMerchantnumber,String orderNote);
	
	//通过主订单编号查找订单总金额 
	OrderBase findtotalAcount(String orderNumber);
	
	/**
	 * 判断主订单金额是否正确
	 * @param orderNumber 主订单编号
	 * @param sumOfMoney 预判支付金额（单位:分）
	 * @return true/false(是/否)
	 */
	Boolean isOkTotalAcount(String orderNumber,Integer sumOfMoney);
	
	//设置order_isequal字段为1（相等）
	
	/**
	 * 设置主订单金额无误
	 * @param orderNumber
	 * @return true/false(成功/失败)
	 */
    Boolean setorderIsequal(String orderNumber);
    
    //获取主订单
    OrderBase getOrderBase(String baseNumber);
    

    
    
    //设置该订单为无效
    void setIsValid(String orderNumber);
    //通过openId查找所有主订单
    List<OrderBase> findOrderBaseByOpenId(Integer userId);
    //查找用户支付/未支付订单
    List<OrderBase> findOrderBaseByIspay(Integer userId,Integer state);
}
