package com.nsc.backend.service;

import java.util.List;

import com.nsc.backend.entity.OrderBase;
import com.nsc.backend.entity.OrderGoods;
import com.nsc.backend.entity.OrderSub;
import com.nsc.backend.entity.OrderSup;

public interface IOrderGoodsService {
	
	//添加order_goods
	int saveOrderGoods(OrderGoods ordergoods);
    //更改订单状态
    void updateOrderState(String OrderNumber);
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
}
