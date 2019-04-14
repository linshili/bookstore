package com.nsc.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nsc.backend.entity.Book;
import com.nsc.backend.entity.OrderBase;
import com.nsc.backend.entity.OrderGoods;
import com.nsc.backend.entity.OrderSub;
import com.nsc.backend.entity.OrderSubExample;
import com.nsc.backend.entity.OrderSubExample.Criteria;
import com.nsc.backend.entity.OrderSubStatus;
import com.nsc.backend.entity.OrderSup;
import com.nsc.backend.entity.Store;
import com.nsc.backend.mapper.OrderGoodsMapper;
import com.nsc.backend.mapper.OrderSubMapper;
import com.nsc.backend.mapper.OrderSupMapper;
import com.nsc.backend.mapper.StoreMapper;
import com.nsc.backend.service.IBookService;
import com.nsc.backend.service.IOrderGoodsService;
import com.nsc.web.util.LogUtil;
import com.nsc.web.util.OrderUtil;
import com.nsc.web.util.backstate.BackState;

@Service
@Transactional
public class OrderGoodsServiceImpl implements IOrderGoodsService {

	private static final String classname = "IOrderGoodsService";
	
	@Autowired
	IBookService bookServiceImpl;
	@Autowired
	StoreMapper storeMapper;
	@Autowired
	OrderGoodsMapper ordergoodsMapper;
	@Autowired
	OrderSubMapper orderSubMapper;
	@Autowired
	OrderSupMapper orderSupMapper;

	/**
	 * 添加ordergoods信息
	 * 
	 * @return
	 */
	public int saveOrderGoods(OrderGoods ordergoods) {
		return ordergoodsMapper.saveOrderGoods(ordergoods);
	}

	// 更改订单状态
	public void updateOrderState(String orderNumber) {
		//ordergoodsMapper.updateOrderState(orderNumber);
		try {
			int supOrderId = orderSupMapper.selectByNum(orderNumber);
			
			OrderSub orderSub = new OrderSub();
			//已完成支付
			orderSub.setOrderState( OrderSubStatus.Paid.getCode().byteValue() );
			
			OrderSubExample orderSubExample = new OrderSubExample();
			Criteria criteria = orderSubExample.createCriteria();
			criteria.andOrder_idEqualTo(supOrderId);
			
			int result = orderSubMapper.updateByExampleSelective(orderSub, orderSubExample);
			if(result == 1) {
				LogUtil.out(classname, "updateOrderState", "更新子订单成功--");
			}
			
		}catch(Exception e) {
			LogUtil.out(classname, "updateOrderState", "更新子订单失败--"+e.toString());
		}
	
	}

	// 子订单对应新的主订单
	public void updateOrderNumberId(String goodsNumber, Integer orderId, String orderNumber) {
		ordergoodsMapper.updateOrderNumberId(goodsNumber, orderId, orderNumber);
	}

	// 查找用户的所有订单
	public List<OrderGoods> showOrderGoods(List<OrderBase> listb) {
		List<OrderGoods> list = ordergoodsMapper.showOrderGoods(listb);
		return list;
	}

	// 查找用户支付/未支付订单
	public List<OrderGoods> showOrderGoodsByIspay(List<OrderBase> listb, Integer state) {
		List<OrderGoods> list = ordergoodsMapper.showOrderGoods(listb);
		return list;
	}

	// 逻辑删除子订单
	public void updateOGoodsState(String ordergoodsnumber, Integer state) {
		ordergoodsMapper.updateOGoodsState(ordergoodsnumber, state);
	}

	@Override
	public int saveOrderSub(List<OrderSub> orderSubs,OrderSup orderSup) {
		
		Integer supOrderId = null;
		int itemCount = orderSubs.size();
		try {
			for(int i = 0; i < itemCount; i++) {
				OrderSub sub = orderSubs.get(i);
				//设置子订单中主订单编号
				sub.setOrderId(orderSup.getOrderId());
				//设置子订单编号
				sub.setOrdergoodsNumber(OrderUtil.getOrderNum(orderSup.getUserId()));
				//设置子订单状态
				sub.setOrderState( (byte)0 );
				//设置商品数量
				//设置商品总价
				//设置商品Id
				//设置店铺Id
				//设置未退货
				sub.setOrderReturn_status(0);
				orderSubMapper.insertSelective(orderSubs.get(i));
			}
			return itemCount;
		}catch(Exception e) {
			LogUtil.out(classname, "saveOrderSub", "exception-->"+e.toString());
		}
		return 0;
	}

}
