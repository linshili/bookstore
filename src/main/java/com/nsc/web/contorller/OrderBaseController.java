package com.nsc.web.contorller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.nsc.backend.entity.Address;
import com.nsc.backend.entity.Book;
import com.nsc.backend.entity.OrderBase;
import com.nsc.backend.entity.OrderSub;
import com.nsc.backend.entity.OrderSup;
import com.nsc.backend.entity.User;
import com.nsc.backend.service.IAddressService;
import com.nsc.backend.service.IOrderBaseService;
import com.nsc.backend.service.IOrderGoodsService;
import com.nsc.backend.service.IUserService;
import com.nsc.backend.service.impl.AddressServiceImpl;
import com.nsc.web.util.LogUtil;
import com.nsc.web.util.OrderUtil;
import com.nsc.web.util.backstate.BackState;
import com.nsc.web.util.backstate.OpState;
import com.nsc.web.util.weixin.PayUtil;
import com.nsc.web.vo.Json;

@RequestMapping("OrderBase")
@Controller
public class OrderBaseController {
	
	private static final String classname = "OrderBaseController";
	
	@Autowired
	private IOrderBaseService orderBaseServiceImpl;
	@Autowired
	private IOrderGoodsService orderGoodsServiceImpl;
	@Autowired
	private IUserService 	userServiceImpl;
	@Autowired
	private IAddressService addressServiceImpl;
	
	
	
	/** 保存主订单 测
	 *  @param order_totalAcount 支付总金额
	 *  @param tradeTable_method 支付方式
	 *  @param openId  
	 */
	@RequestMapping("/addToOrderBase")
	@ResponseBody
	public BackState addToOrderBase(@RequestBody String orderparam) {
		/*String param_1 ="{\"openId\":\"o_1QS0TEoGebWrlHCxz-bzokvyj0\","
				+"\"order_totalAcount\":\"600\","
				+"\"tradeTable_method\":\"1\"}";
		JSONObject json = JSONObject.parseObject(orderparam);
		
		String openId = json.getString("openId");
		Double order_totalAcount = json.getDouble("order_totalAcount");
		Integer tradeTable_method = json.getInteger("tradeTable_method");*/
		
		BackState state = new BackState();
		OrderBase orderbase= new OrderBase();
		//主订单Id  ——自动增长
		//订单编号
		String order_number = OrderUtil.getOrderNum(0);
		//订单生成时间
		Date order_time = null;
		try {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat();
			String formate = sdf.format(date);
			order_time = sdf.parse(formate);
		} catch (ParseException e) {
			System.out.println("当前日期初始化 错误");
			e.printStackTrace();
		}
		//用户 (买家) Id
		User user = userServiceImpl.findUserByopenId("o_1QS0TEoGebWrlHCxz-bzokvyj0");
		try {
			orderbase.setOrderNumber(order_number);
			orderbase.setOrderTime(order_time);
			orderbase.setOrderTotalacount(10);
			orderbase.setUserId(user);
			orderbase.setTradetableMethod(1);
			System.out.println(orderbase.toString());
			
			orderBaseServiceImpl.saveOrderbase(orderbase);
			state.setStateName("HTTP Status 200");
			return  state;
		}catch (Exception e) {
			state.setStateName("主订单异常，请重新下单！");
			return state;
		
		}
	}
	
	//更新订单信息 测
	@RequestMapping("/upDate")
	@ResponseBody
	public void upDate() {
		
		String orderNumber="154042657201330972";
		String tMerchantnumber="1*********8";
		
		/*Date order_payTime = null;
		try {
			
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
			String formate = sdf.format(date);
			order_payTime = sdf.parse(formate);
			System.out.println(order_payTime);
			
		} catch (ParseException e) {
			System.out.println("当前日期初始化 错误");
			e.printStackTrace();
		}*/
		String date = "20151101095440";

		String reg = "(\\d{4})(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{2})";
		date = date.replaceAll(reg, "$1-$2-$3 $4:$5:$6");
		System.out.println(date);
		
		System.out.println("orderBaseServiceImpl====="+orderBaseServiceImpl);
		orderBaseServiceImpl.updateOrderBase(orderNumber, date, tMerchantnumber,"");
		
		
	}
	
	
	//测试
	@RequestMapping("/findtotalAcount")
	@ResponseBody
	public OrderBase findtotalAcount() {
		
		/*Date order_time = null;
		try {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat();
			String formate = sdf.format(date);
			order_time = sdf.parse(formate);
			System.out.println(order_time);
		} catch (ParseException e) {
			System.out.println("当前日期初始化 错误");
			e.printStackTrace();
		}
		
		String datetime =  "20140212111012";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime ldt = LocalDateTime.parse(datetime,dtf);
        System.out.println(ldt);*/

		
		String orderNumber="154042657201330972";
		System.out.println(orderBaseServiceImpl);
		OrderBase o = orderBaseServiceImpl.findtotalAcount(orderNumber);
		orderBaseServiceImpl.setorderIsequal(orderNumber);
		System.out.println(o);
		return o;
		
	}
	
	@RequestMapping("commitOrderByWx" )//N
	@ResponseBody
	public Object commitOrderByWx(@RequestBody String orderInfo) {
		
		try {
			JSONObject jsonObj = JSONObject.parseObject(orderInfo);
			System.out.println(jsonObj);
			//1.获取用户唯一Id
			String unionId = jsonObj.getString("unionId");
			//2.获取微信用户的openId，用作微信支付接口的参数
			String openId = jsonObj.getString("openId");
			BigDecimal moneySum = jsonObj.getBigDecimal("moneySum");
			//3.获取收货地址
			JSONObject addrJson = jsonObj.getJSONObject("addr");
			Address address = JSON.parseObject(addrJson.toJSONString(), new TypeReference<Address>() {});
			Integer addrId = address.getAddId();
			//4.获取商品列表
			JSONArray list = jsonObj.getJSONArray("orderGoodsList");
			List<OrderSub> orderSubs = JSON.parseObject(list.toJSONString(), new TypeReference< List<OrderSub> >(){} );
			
			if( addrId == null) {
				//保存用户的收货通讯地址
				boolean isOk = addressServiceImpl.saveWeiAdd(address);
				if(isOk == false) {
					LogUtil.out(classname, "coommitOrder", "保存地址失败-->boolean isOk = addressServiceImpl.saveWeiAdd(address);");
					return OpState.ERROR;
				}
			}
			//生成未支付主订单
			OrderSup orderSup = orderBaseServiceImpl.saveSupOrderNoPay(unionId, moneySum, addrId);
			if(orderSup == null) {
				LogUtil.out(classname, "coommitOrder", "保存未支付主订单失败-->orderBaseServiceImpl.saveSupOrderNoPay(unionId, moneySum, addrId);");
				return OpState.ERROR;
			}
			//生成未支付主订单下的子订单
			int numOrderGoods = orderGoodsServiceImpl.saveOrderSub(orderSubs, orderSup);
			if(numOrderGoods != orderSubs.size()) {
				LogUtil.out(classname, "coommitOrder", "保存未支付子订单失败-->int numOrderGoods = orderGoodsServiceImpl.saveOrderSub(orderSubs, orderSup);");
				return OpState.ERROR;
			}
			//调用微信支付接口,发起微信支付统一下单
			Json result = PayUtil.wxPay(openId, orderSup.getOrderNumber(), moneySum);
			if(result.isSuccess()==false) {
				return OpState.ERROR;
			}
			return result;
			
		}catch(Exception e) {
			LogUtil.out(classname, "coommitOrder", "exception-->"+e.toString());
			return OpState.ERROR;
		}
	}
	
}
