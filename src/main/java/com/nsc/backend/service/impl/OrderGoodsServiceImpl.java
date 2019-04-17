package com.nsc.backend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nsc.backend.entity.OrderBase;
import com.nsc.backend.entity.OrderGoods;
import com.nsc.backend.entity.OrderSub;
import com.nsc.backend.entity.OrderSubExample;
import com.nsc.backend.entity.OrderSubExample.Criteria;
import com.nsc.backend.entity.OrderSubGoods;
import com.nsc.backend.entity.OrderSubStatus;
import com.nsc.backend.entity.OrderSup;
import com.nsc.backend.mapper.OrderGoodsMapper;
import com.nsc.backend.mapper.OrderSubMapper;
import com.nsc.backend.mapper.OrderSupMapper;
import com.nsc.backend.mapper.StoreMapper;
import com.nsc.backend.mapper.UserMapper;
import com.nsc.backend.service.IBookService;
import com.nsc.backend.service.IOrderGoodsService;
import com.nsc.web.util.LogUtil;
import com.nsc.web.util.OrderUtil;
import com.nsc.web.util.backstate.OpState;

@Service
@Transactional
public class OrderGoodsServiceImpl implements IOrderGoodsService {

	private static final String classname = "IOrderGoodsService";
	
	@Autowired
	IBookService bookServiceImpl;
	@Autowired
	StoreMapper storeMapper;
	@Autowired
	UserMapper userMapper;
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

	@Override
	public void updateOrderStateToPaid(String orderNumber) {
		//ordergoodsMapper.updateOrderState(orderNumber);
		try {
			int supOrderId = orderSupMapper.selectByNum(orderNumber);
			
			OrderSub orderSub = new OrderSub();
			//已完成支付,等待发货
			orderSub.setOrderState( OrderSubStatus.Delivering.getCode().byteValue() );
			
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
				//1.设置子订单中主订单Id
				sub.setOrderId(orderSup.getOrderId());
				//2.设置子订单编号
				sub.setOrdergoodsNumber(OrderUtil.getOrderNum(orderSup.getUserId()));
				//3.设置子订单状态
				sub.setOrderState( (byte)0 );
				//4.设置商品数量
				//5.设置商品总价
				//6.设置商品Id
				//7.设置店铺Id
				//8.设置未退货
				sub.setOrderReturn_status(0);
				orderSubMapper.insertSelective(orderSubs.get(i));
			}
			return itemCount;
		}catch(Exception e) {
			LogUtil.out(classname, "saveOrderSub", "exception-->"+e.toString());
		}
		return 0;
	}

	@Override
	public List<OrderSub> showOrderGoodsByPending(String unionId) {
		
		List<OrderSub> orderSubs = new ArrayList<>();
		//1.根据unionId查找用户userId
		Integer userId = userMapper.findUserByUnionId(unionId);
		//2.根据userId查找主订单的orderId
		Integer supOrder = null;
	
		OrderSubExample orderSubExample = new OrderSubExample();
		Criteria criteria = orderSubExample.createCriteria();
		
	
	
//		orderSubMapper.selectByExample(example);
//		
//		
//		return orderSubs;
		return null;
	}

	@Override
	public Boolean updateSubOrderForOId(Integer orderSupId, String subOrderNumber) {
		
		OrderSub record = new OrderSub();
		record.setOrderId(orderSupId);
		OrderSubExample example = new OrderSubExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrdergoods_numberEqualTo(subOrderNumber);
		
		
		int res = orderSubMapper.updateByExampleSelective(record, example);
		if(res == 1) {
			return OpState.OK;
		}
		
		return OpState.ERROR;
	}

	@Override
	public List<OrderSubGoods> getPendingPay(String unionId, Integer index) {
		
		List<OrderSubGoods> tmp = orderSubMapper.selectOrderPendingPay(unionId, index);
		
		return tmp;
	}

}
