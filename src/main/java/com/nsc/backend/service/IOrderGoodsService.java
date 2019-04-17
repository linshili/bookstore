package com.nsc.backend.service;

import java.util.List;

import com.nsc.backend.entity.OrderBase;
import com.nsc.backend.entity.OrderGoods;
import com.nsc.backend.entity.OrderSub;
import com.nsc.backend.entity.OrderSubGoods;
import com.nsc.backend.entity.OrderSup;

public interface IOrderGoodsService {
	
	//添加order_goods
	int saveOrderGoods(OrderGoods ordergoods);

	/**
	 * 根据主订单编号更新子订单状态
	 * @param OrderNumber 主订单编号
	 */
    void updateOrderStateToPaid(String OrderNumber);
    
    // 子订单对应新的主订单
    void updateOrderNumberId(String goodsNumber,Integer orderId,String orderNumber);
    //查找用户的所有订单
    List<OrderGoods> showOrderGoods(List<OrderBase> listb); 
    //查找用户支付/未支付订单
    List<OrderGoods> showOrderGoodsByIspay(List<OrderBase> listb,Integer state);
    //逻辑删除子订单
    void updateOGoodsState(String ordergoodsnumber,Integer state);
    
    /**
     * 保存子订单实例
     * @param orderSubs 子订单实例数组
     * @param orderSupNum 主订单实例
     * @return 成功保存子订单记录数
     */
    int saveOrderSub(List<OrderSub> orderSubs,OrderSup orderSup);
    
    /**
     * 查找用户的未支付订单
     * @param unionId 用户的uinonId
     * @return 子订单实实例数组
     */
    List<OrderSub> showOrderGoodsByPending(String unionId);
    
    /**
     * 根据子订单编号跟新子订单关联的主订单Id
     * @param subOrderNumber
     * @return true/false (成功/失败)
     */
	Boolean updateSubOrderForOId(Integer orderSupId, String subOrderNumber);
	
	/**
	 * 获取用户的未支付订单
	 * @param uninoId用户唯一标识unionId
	 * @param index 获取数据的索引
	 * @return 未支付订单实例数组
	 */
	List<OrderSubGoods> getPendingPay(String unionId,Integer index);
    
    
}
