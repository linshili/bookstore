package com.nsc.backend.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nsc.backend.entity.OrderBase;
import com.nsc.backend.entity.OrderSup;
import com.nsc.backend.entity.User;
import com.nsc.backend.mapper.OrderBaseMapper;
import com.nsc.backend.mapper.OrderSupMapper;
import com.nsc.backend.mapper.UserMapper;
import com.nsc.backend.service.IOrderBaseService;
import com.nsc.web.util.DateTimeGenerator;
import com.nsc.web.util.LogUtil;
import com.nsc.web.util.OrderUtil;
import com.nsc.web.util.backstate.OpState;

@Transactional
@Service
public class OrderBaseServiceImpl implements IOrderBaseService{

	private final static String classname = "IOrderBaseService";
	
	@Autowired
	private OrderBaseMapper orderbaseMapper;
	@Autowired
	private OrderSupMapper orderSupMapper;
	@Autowired
	private UserMapper userMapper;
	
	
	//保存主订单
	public int saveOrderbase(OrderBase orderbase) {
		
		return orderbaseMapper.saveOrderBase(orderbase);
		
	}
	
	@Override
	public void updateOrderBaseByWx(String orderNumber,String payTime,String tMerchantnumber,String orderNote) {
		LogUtil.out(classname, "updateOrderBase", "orderNumber--"+orderNumber+"--payTime--"+payTime+"--微信支付交易号--"+tMerchantnumber);
		try {
			//orderbaseMapper.updateOrderBase(orderNumber, payTime, tMerchantnumber);
		    orderSupMapper.updateOrderBaseWxPayTime(orderNumber, payTime, tMerchantnumber,orderNote);
			
		}catch(Exception e){
			LogUtil.out(classname, "updateOrderBase", "exception--设置支付完成时间失败--"+e.toString());
			return ;
		}

	}
	//通过主订单编号查找订单总金额 
    public OrderBase findtotalAcount(String orderNumber) {
    	
    	OrderBase i = orderbaseMapper.findtotalAcount(orderNumber);
    	return i;
    }
    
    @Override
	public Boolean isOkTotalAcount(String orderNumber, Integer sumOfMoney) {
    	
    	LogUtil.out(classname, "isOkTotalAcount", "orderNumber--"+orderNumber+"--"+sumOfMoney);
    	BigDecimal sum = BigDecimal.valueOf(1.0);
    	BigDecimal bignum = null; 
    	try {
    		sum = orderSupMapper.getTotalAcount(orderNumber);
    		bignum = sum.multiply(BigDecimal.valueOf(100));
    		if( bignum.intValue() == sumOfMoney ) {
    			return OpState.OK;
    		}
    		
    	}catch(Exception e) {
    		LogUtil.out(classname, "isOkTotalAcount", "exception-->"+e.toString());
    	}
		return OpState.ERROR;
	}
    
    
    //设置order_isequal字段为1（相等）
    public Boolean setorderIsequal(String orderNumber) {
    	try {
    		int res = orderSupMapper.setorderIsequal(orderNumber);
    		if(res == 1) {
    			return OpState.OK;
    		}
    	}catch(Exception e) {
    		LogUtil.out(classname, "setorderIsequal", "Exception-->"+e.toString());
    	}
    	//orderbaseMapper.setorderIsequal(orderNumber);
    	return OpState.ERROR;
    }
    
    //设置该订单为无效
    public void setIsValid(String orderNumber) {
    	orderbaseMapper.setIsValid(orderNumber);
    	
    }
    
    //获取主订单
    public OrderBase getOrderBase(String baseNumber) {
    	
    	OrderBase orderbase;
    	orderbase = orderbaseMapper.getOrderBase(baseNumber);
    	return orderbase;
    }
    
    @Override
	public Integer getSupOrderId(String supOrderNumber) {
		
		Integer id =  orderSupMapper.selectByNum(supOrderNumber);
		if(id != null) {
			return id;
		}
		return null;
	}
    
    
    //通过openId查找所有主订单
    public List<OrderBase> findOrderBaseByOpenId(Integer userId) {
    	List<OrderBase> list = orderbaseMapper.findOrderBaseByOpenId(userId);
    	return list;
    }
    //查找用户支付/未支付订单
    public List<OrderBase> findOrderBaseByIspay(Integer userId,Integer state){
    	List<OrderBase> list = orderbaseMapper.findOrderBaseByIspay(userId,state);
    	return list;
    }
    
	@Override
	public Boolean saveSupOrderNoPay(OrderSup orderSup) {
		
		Integer res = orderSupMapper.insertSelective(orderSup);
		if(res != null ) {
			return OpState.OK;
		}
		
		return OpState.ERROR;
	}
	
	@Override
	public OrderSup saveSupOrderNoPay(String unionId, BigDecimal moneySum, Integer addrId) {
		
		OrderSup orderSup = null;
		try {
			orderSup = new OrderSup();
			Integer userId = userMapper.findUserByUnionId(unionId);
			orderSup.setUserId(userId);
			orderSup.setOrderTotalAcount( moneySum );
			orderSup.setAddId(addrId);
			
			//1.主订单编号
			orderSup.setOrderNumber(OrderUtil.getOrderNum(userId));
			//2.订单生成时间
			orderSup.setOrderTime(DateTimeGenerator.getDateTime());
			//3.订单未支付
			orderSup.setOrderIspay(0);
			//4.主订单无效(只有一次性完成支付时才视作有效)
			orderSup.setOrderIsvalid(0);
			//5.String unionId 用户Id
			//6.BigDecimal moneySum 主订单总金额
			//7.Integer addrId 收货地址Id
			
			int res = orderSupMapper.insertSelective(orderSup);
			if(res == 1) {
				Integer id = orderSupMapper.selectByNum(orderSup.getOrderNumber());
				orderSup.setOrderId(id);
				return orderSup;
			}
		}catch(Exception e){
			LogUtil.out(classname, "saveSupOrderNoPay", "exception-->"+e.toString());
		}
		return null;
	}

	@Override
	public Integer saveSupOrderToGetId(OrderSup orderSup) {
		
		try {
			Integer supOrderId = orderSupMapper.insertSelective(orderSup);
			if(supOrderId != null) {
				return orderSup.getOrderId();
			}
		}catch(Exception e) {
			LogUtil.out(classname, "saveSupOrderToGetId", "生成主订单失败--exception-->"+e.toString());
		}
		return null;
	}
	
	


	
}
